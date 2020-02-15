package member.model.vo;

public class MemberGrd {
	private int memGradeName;
	private int memGradePoint;
	public MemberGrd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberGrd(int memGradeName, int memGradePoint) {
		super();
		this.memGradeName = memGradeName;
		this.memGradePoint = memGradePoint;
	}
	public int getMemGradeName() {
		return memGradeName;
	}
	public void setMemGradeName(int memGradeName) {
		this.memGradeName = memGradeName;
	}
	public int getMemGradePoint() {
		return memGradePoint;
	}
	public void setMemGradePoint(int memGradePoint) {
		this.memGradePoint = memGradePoint;
	}
	@Override
	public String toString() {
		return "MemberGrd [memGradeName=" + memGradeName + ", memGradePoint=" + memGradePoint + "]";
	}

}
