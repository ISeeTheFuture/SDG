# Photo Puzzle storage

Cloudflare R2 Standard bucket: `vocab-puzzle-photos`.
Worker: `vocab-puzzle-photos`, using the Workers Free plan.
The original ChatGPT Sites puzzle is unchanged.

Limits: 200 photos, 3 MiB per stored JPEG. The admin converts JPEG/PNG/WebP
locally to JPEG, limits the longest edge to 1600 px, and removes EXIF metadata.
The Worker applies a 60 requests/minute per-IP limit, caches lists for five
minutes, and gives images a one-day browser cache lifetime. These safeguards
reduce usage; they do not constitute a Cloudflare billing hard cap.

Worker secret: `ADMIN_TOKEN`. Render admin environment: `PHOTO_SERVICE_URL`
and `PHOTO_SERVICE_TOKEN` (same secret). Never commit the secret.
Admin has no password, as requested; upload and delete calls proxy through
the admin server. R2 writes require the server secret. Delete needs a UI
confirmation; new puzzles stop using deleted photos after cache refresh.

New puzzles share the existing reward ledger and cost one play. Resuming an
unfinished local puzzle costs no additional play. Photos are random on new
starts, with the original forest picture as fallback for an empty gallery.
No existing vocabulary, XP, or score records are migrated or reset.

Deploy Worker: `wrangler deploy --config photo-service/wrangler.jsonc`.
Render static site publishes `photo-puzzle` from `dennis-yura-vocab-app`.
