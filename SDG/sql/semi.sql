--========================
--관리자계정
--========================
--semi계정 생성
create user semi identified by semi
default tablespace users;
grant connect, resource to semi;
--========================
--semi계정
--========================
--======================================================
DROP TABLE membership cascade constraints;
DROP TABLE member_grd cascade constraints;
DROP TABLE member_blk cascade constraints;
DROP TABLE review cascade constraints;
DROP TABLE review_cmnt cascade constraints;
DROP TABLE review_rpt cascade constraints;
DROP TABLE cmmt_rpt cascade constraints;
DROP TABLE spc cascade constraints;
DROP TABLE spc_res cascade constraints;
DROP TABLE spc_img cascade constraints;
DROP TABLE spc_dtl cascade constraints;
DROP TABLE spc_type cascade constraints;
DROP TABLE member_busi cascade constraints;
DROP TABLE spc_res_grp cascade constraints;
DROP TABLE spc_price cascade constraints;
DROP TABLE spc_timetable cascade constraints;
DROP TABLE spc_time_exp cascade constraints;
DROP TABLE spc_opt_lst cascade constraints;
DROP TABLE spc_opt cascade constraints;
DROP TABLE spc_loc cascade constraints;
DROP TABLE spc_ctt_img cascade constraints;

--======================================================
-- 시퀀스 모음
--======================================================

create SEQUENCE seq_review_no;
create SEQUENCE seq_review_report_no;
create SEQUENCE seq_comment_no;
create SEQUENCE seq_comment_report_no;

create SEQUENCE seq_res_no;
create SEQUENCE seq_res_group_no;

create SEQUENCE seq_spc_no;
create SEQUENCE seq_spc_detail_no;
create SEQUENCE seq_spc_price_no;
create SEQUENCE seq_memberbusi_report_no;

--======================================================
-- 여기서부터 테이블
--======================================================

CREATE TABLE membership (
	mem_id	varchar2(100)		NOT NULL,
	mem_pass	varchar2(4000)		NOT NULL,
	mem_name	varchar2(100)		NOT NULL,
	mem_role	char(1)	DEFAULT 0	NOT NULL,
	mem_admin	char(1)	DEFAULT 0	NOT NULL,
	mem_point	number	DEFAULT 0	NOT NULL,
	mem_grade_name	number		NOT NULL,
	mem_gender	number		NOT NULL,
	mem_birth	Date		NULL,
	mem_email	varchar2(255)		NOT NULL,
	mem_phone	varchar2(100)		NULL,
	mem_addr	varchar2(255)		NULL,
	mem_date	timestamp	DEFAULT SYSTIMESTAMP	NOT NULL,
	mem_rest	Date		NULL,
	mem_lastLogin	Date		NULL
);

CREATE TABLE member_grd (
	mem_grade_name	number		NOT NULL,
	mem_grade_point	number		NOT NULL
);

CREATE TABLE member_blk (
	mem_id	varchar2(100)		NOT NULL,
	block_write	timestamp	DEFAULT SYSTIMESTAMP	NULL,
	block_comment	timestamp	DEFAULT SYSTIMESTAMP	NULL,
	block_memo	varchar2(4000)		NULL
);

CREATE TABLE review (
	review_no	number		NOT NULL,
	spc_no	number		NOT NULL,
	mem_id	varchar2(20)		NOT NULL,
	review_ori_no	number		NULL,
	review_star	number	DEFAULT 3	NOT NULL,
	review_type	varchar2(100)		NULL,
	review_title	varchar2(100)		NOT NULL,
	review_content	long		NULL,
	review_file	varchar2(40)		NULL,
	review_upfile	varchar2(40)		NULL,
	review_date	timestamp	DEFAULT SYSTIMESTAMP	NOT NULL,
	review_readcnt	number	DEFAULT 0	NULL,
	review_recommend	number	DEFAULT 0	NULL,
	review_delete	char(1)	DEFAULT 0	NULL
);

CREATE TABLE review_cmnt (
	comment_no	number		NOT NULL,
	mem_id	varchar2(100)		NOT NULL,
	review_no	number		NOT NULL,
	comment_type	number		NOT NULL,
	comment_content	varchar2(4000)		NULL,
	comment_date	timestamp	DEFAULT SYSTIMESTAMP	NULL,
	comment_recommend	number	DEFAULT 0	NULL,
	comment_delete	char(1)	DEFAULT 0	NULL
);

CREATE TABLE review_rpt (
	review_report_no	number		NOT NULL,
	review_no	number		NOT NULL,
	review_report_reason	varchar2(4000)		NULL,
	review_report_date	timestamp	DEFAULT SYSTIMESTAMP	NULL
);

CREATE TABLE cmmt_rpt (
	comment_report_no	number		NOT NULL,
	comment_no	number		NOT NULL,
	comment_report_reason	varchar2(4000)		NULL,
	comment_report_date	timestamp	DEFAULT SYSTIMESTAMP	NULL
);

CREATE TABLE spc (
	spc_no	number		NOT NULL,
	mem_id	varchar2(100)		NOT NULL,
	spc_name	varchar2(100)		NULL,
	spc_addr	varchar2(255)		NULL,
	spc_content	long		NULL,
	spc_avail	char(1)	DEFAULT 1	NULL,
	spc_date	timestamp	DEFAULT SYSTIMESTAMP	NULL
);

CREATE TABLE spc_res (
	res_group_no	number		NOT NULL,
	mem_id	varchar2(100)		NOT NULL,
	spc_no	number		NOT NULL,
	res_many	number		NULL,
	res_name	varchar2(100)		NULL,
	res_phone	varchar2(100)		NULL,
	res_email	varchar2(255)		NULL,
	res_content	varchar2(4000)		NULL,
	res_apply	timestamp	DEFAULT SYSTIMESTAMP	NOT NULL
);


CREATE TABLE spc_img (
	spc_detail_no	number		NOT NULL,
	spc_img_title	varchar2(100)		NOT NULL,
	spc_img_text	varchar2(4000)		NULL,
	spc_img_route	varchar2(100)		NOT NULL,
	spc_no	number		NOT NULL
);

CREATE TABLE spc_dtl (
	spc_detail_no	number		NOT NULL,
	spc_no	number		NOT NULL,
	spc_type_no	number		NOT NULL,
	spc_location_no	number		NOT NULL,
	spc_detail_avail	char(1)	DEFAULT 0	NOT NULL,
	spc_detail_content	long		NULL,
	spc_detail_sharing	char(1)	DEFAULT 0	NOT NULL,
	spc_detail_holiday	char(1)	DEFAULT 0	NOT NULL,
	spc_detail_size	number		NOT NULL,
	spc_detail_storable	number		NOT NULL,
	spc_man_min	number	DEFAULT 1	NOT NULL,
	spc_man_max	number	DEFAULT 30	NOT NULL,
	spc_time_min	number	DEFAULT 1	NOT NULL,
	spc_time_max	number		NOT NULL,
	spc_date_start	Date		NOT NULL,
	spc_date_end	Date		NOT NULL,
	spc_detail_date	timestamp	DEFAULT SYSTIMESTAMP	NOT NULL
);

CREATE TABLE spc_type (
	spc_type_no	number		NOT NULL,
	spc_type_name	varchar2(100)		NULL
);

CREATE TABLE member_busi (
	mem_id	varchar2(100)		NOT NULL,
	mem_buis_no	varchar2(100)		NOT NULL,
	mem_buis_addr	varchar2(255)		NOT NULL,
	mem_buis_phone	varchar2(100)		NOT NULL,
	mem_buis_allow	char(1)	DEFAULT 0	NOT NULL
);

CREATE TABLE spc_res_grp (
	res_no	number		NOT NULL,
	res_group_no	number		NOT NULL,
	res_cancle	char(1)	DEFAULT 0	NOT NULL,
	res_time	timestamp		NOT NULL,
	res_prior	number	DEFAULT 0	NOT NULL,
	res_time_apply	timestamp	DEFAULT SYSTIMESTAMP	NULL
);


CREATE TABLE spc_price (
	spc_price_no	number		NOT NULL,
	spc_detail_no	number		NOT NULL,
	spc_detail_name	varchar2(100)		NOT NULL,
	spc_price_day	varchar2(1000)		NULL,
	spc_price_start	number		NOT NULL,
	spc_price_end	number		NOT NULL,
	spc_price_peak	char(1)	DEFAULT 0	NOT NULL,
	spc_price_perman	char(1)	DEFAULT 0	NOT NULL,
	spc_price_day_bool	char(1)	DEFAULT 0	NOT NULL,
	spc_price_price	number	DEFAULT 0	NULL
);

CREATE TABLE spc_timetable (
	spc_detail_no	number		NOT NULL,
	spc_day	varchar2(1000)		NULL,
	spc_hour_start	number		NOT NULL,
	spc_hour_end	number		NOT NULL,
	spc_avail	char(1)	DEFAULT 0	NOT NULL
);

CREATE TABLE spc_time_exp (
	spc_detail_no	number		NOT NULL,
	spc_excep_date	Date		NOT NULL,
	spc_excep_start	number		NULL,
	spc_excep_end	number		NULL,
	spc_avail	char(1)	DEFAULT 0	NULL
);

CREATE TABLE spc_opt_lst (
	spc_option_no	number		NOT NULL,
	spc_option_name	varchar2(100)		NULL,
	spc_option_icon	varchar2(100)		NULL,
	spc_option_date	timestamp	DEFAULT SYSTIMESTAMP	NOT NULL
);

CREATE TABLE spc_opt (
	spc_detail_no	number		NOT NULL,
	spc_option_no	number		NOT NULL
);

CREATE TABLE spc_loc (
	spc_location_no	number		NOT NULL,
	spc_location_name	varchar2(100)		NULL
);

CREATE TABLE spc_ctt_img (
	spc_detail_no	number		NOT NULL,
	spc_no	number		NOT NULL,
	spc_img_title	varchar2(100)		NOT NULL,
	spc_img_text	varchar2(4000)		NULL,
	spc_img_old	varchar2(100)		NULL
);

--======================================================
-- 여기서부터 제약조건
--======================================================


ALTER TABLE membership ADD CONSTRAINT PK_MEMBERSHIP PRIMARY KEY (
	mem_id
);

ALTER TABLE member_grd ADD CONSTRAINT PK_MEMBER_GRD PRIMARY KEY (
	mem_grade_name
);

ALTER TABLE member_blk ADD CONSTRAINT PK_MEMBER_BLK PRIMARY KEY (
	mem_id
);

ALTER TABLE review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	review_no
);

ALTER TABLE review_cmnt ADD CONSTRAINT PK_REVIEW_CMNT PRIMARY KEY (
	comment_no
);

ALTER TABLE review_rpt ADD CONSTRAINT PK_REVIEW_RPT PRIMARY KEY (
	review_report_no
);

ALTER TABLE cmmt_rpt ADD CONSTRAINT PK_CMMT_RPT PRIMARY KEY (
	comment_report_no
);

ALTER TABLE spc ADD CONSTRAINT PK_SPC PRIMARY KEY (
	spc_no
);

ALTER TABLE spc_res ADD CONSTRAINT PK_SPC_RES PRIMARY KEY (
	res_group_no
);

ALTER TABLE spc_dtl ADD CONSTRAINT PK_SPC_DTL PRIMARY KEY (
	spc_detail_no
);

ALTER TABLE spc_type ADD CONSTRAINT PK_SPC_TYPE PRIMARY KEY (
	spc_type_no
);

ALTER TABLE member_busi ADD CONSTRAINT PK_MEMBER_BUSI PRIMARY KEY (
	mem_id
);

ALTER TABLE spc_res_grp ADD CONSTRAINT PK_SPC_RES_GRP PRIMARY KEY (
	res_no
);

ALTER TABLE spc_price ADD CONSTRAINT PK_SPC_PRICE PRIMARY KEY (
	spc_price_no
);

ALTER TABLE spc_opt_lst ADD CONSTRAINT PK_SPC_OPT_LST PRIMARY KEY (
	spc_option_no
);

ALTER TABLE spc_loc ADD CONSTRAINT PK_SPC_LOC PRIMARY KEY (
	spc_location_no
);

ALTER TABLE membership ADD CONSTRAINT FK_member_grd_TO_membership_1 FOREIGN KEY (
	mem_grade_name
)
REFERENCES member_grd (
	mem_grade_name
);

ALTER TABLE member_blk ADD CONSTRAINT FK_membership_TO_member_blk_1 FOREIGN KEY (
	mem_id
)
REFERENCES membership (
	mem_id
);

ALTER TABLE review ADD CONSTRAINT FK_spc_TO_review_1 FOREIGN KEY (
	spc_no
)
REFERENCES spc (
	spc_no
);

ALTER TABLE review ADD CONSTRAINT FK_membership_TO_review_1 FOREIGN KEY (
	mem_id
)
REFERENCES membership (
	mem_id
);

ALTER TABLE review_cmnt ADD CONSTRAINT FK_membership_TO_review_cmnt_1 FOREIGN KEY (
	mem_id
)
REFERENCES membership (
	mem_id
);

ALTER TABLE review_cmnt ADD CONSTRAINT FK_review_TO_review_cmnt_1 FOREIGN KEY (
	review_no
)
REFERENCES review (
	review_no
);

ALTER TABLE review_rpt ADD CONSTRAINT FK_review_TO_review_rpt_1 FOREIGN KEY (
	review_no
)
REFERENCES review (
	review_no
);

ALTER TABLE cmmt_rpt ADD CONSTRAINT FK_review_cmnt_TO_cmmt_rpt_1 FOREIGN KEY (
	comment_no
)
REFERENCES review_cmnt (
	comment_no
);

ALTER TABLE spc ADD CONSTRAINT FK_membership_TO_spc_1 FOREIGN KEY (
	mem_id
)
REFERENCES membership (
	mem_id
);

ALTER TABLE spc_res ADD CONSTRAINT FK_membership_TO_spc_res_1 FOREIGN KEY (
	mem_id
)
REFERENCES membership (
	mem_id
);

ALTER TABLE spc_res ADD CONSTRAINT FK_spc_TO_spc_res_1 FOREIGN KEY (
	spc_no
)
REFERENCES spc (
	spc_no
);

ALTER TABLE spc_img ADD CONSTRAINT FK_spc_dtl_TO_spc_img_1 FOREIGN KEY (
	spc_detail_no
)
REFERENCES spc_dtl (
	spc_detail_no
);

ALTER TABLE spc_img ADD CONSTRAINT FK_spc_TO_spc_img_1 FOREIGN KEY (
	spc_no
)
REFERENCES spc (
	spc_no
);

ALTER TABLE spc_dtl ADD CONSTRAINT FK_spc_TO_spc_dtl_1 FOREIGN KEY (
	spc_no
)
REFERENCES spc (
	spc_no
);

ALTER TABLE spc_dtl ADD CONSTRAINT FK_spc_type_TO_spc_dtl_1 FOREIGN KEY (
	spc_type_no
)
REFERENCES spc_type (
	spc_type_no
);

ALTER TABLE spc_dtl ADD CONSTRAINT FK_spc_loc_TO_spc_dtl_1 FOREIGN KEY (
	spc_location_no
)
REFERENCES spc_loc (
	spc_location_no
);

ALTER TABLE member_busi ADD CONSTRAINT FK_membership_TO_member_busi_1 FOREIGN KEY (
	mem_id
)
REFERENCES membership (
	mem_id
);

ALTER TABLE spc_res_grp ADD CONSTRAINT FK_spc_res_TO_spc_res_grp_1 FOREIGN KEY (
	res_group_no
)
REFERENCES spc_res (
	res_group_no
);

ALTER TABLE spc_price ADD CONSTRAINT FK_spc_dtl_TO_spc_price_1 FOREIGN KEY (
	spc_detail_no
)
REFERENCES spc_dtl (
	spc_detail_no
);

ALTER TABLE spc_timetable ADD CONSTRAINT FK_spc_dtl_TO_spc_timetable_1 FOREIGN KEY (
	spc_detail_no
)
REFERENCES spc_dtl (
	spc_detail_no
);

ALTER TABLE spc_time_exp ADD CONSTRAINT FK_spc_dtl_TO_spc_time_exp_1 FOREIGN KEY (
	spc_detail_no
)
REFERENCES spc_dtl (
	spc_detail_no
);

ALTER TABLE spc_opt ADD CONSTRAINT FK_spc_dtl_TO_spc_opt_1 FOREIGN KEY (
	spc_detail_no
)
REFERENCES spc_dtl (
	spc_detail_no
);

ALTER TABLE spc_opt ADD CONSTRAINT FK_spc_opt_lst_TO_spc_opt_1 FOREIGN KEY (
	spc_option_no
)
REFERENCES spc_opt_lst (
	spc_option_no
);


ALTER TABLE spc_ctt_img ADD CONSTRAINT PK_SPC_CTT_IMG PRIMARY KEY (
	spc_detail_no,
	spc_no
);

ALTER TABLE spc_ctt_img ADD CONSTRAINT FK_spc_dtl_TO_spc_ctt_img_1 FOREIGN KEY (
	spc_detail_no
)
REFERENCES spc_dtl (
	spc_detail_no
);
ALTER TABLE spc_ctt_img ADD CONSTRAINT FK_spc_TO_spc_ctt_img_1 FOREIGN KEY (
	spc_no
)
REFERENCES spc (
	spc_no
);


--===================================
--테스트 공간
--===================================
insert into member_grd values(0,0);
insert into member_grd values(1,0);
insert into member_grd values(2,0);
insert into member_grd values(3,0);
insert into member_grd values(4,0);
insert into member_grd values(5,0);
INSERT INTO membership VALUES('testid','testpwd','testname',DEFAULT,DEFAULT,DEFAULT,0,1,SYSDATE,'testemail','01000000000','seoul',DEFAULT,NULL,SYSDATE);
INSERT INTO spc VALUES(SEQ_SPC_NO.NEXTVAL,'testid','선동렬', '경기도 광주', '아름다운 살인마들', DEFAULT, DEFAULT);
INSERT INTO SPC_LOC VALUES(1,'서울');
INSERT INTO SPC_LOC VALUES(2,'경기도');
INSERT INTO SPC_LOC VALUES(3,'인천광역시');
INSERT INTO SPC_LOC VALUES(4,'세종특별시');
INSERT INTO SPC_LOC VALUES(5,'충청북도');
INSERT INTO SPC_LOC VALUES(6,'충청남도');
INSERT INTO SPC_LOC VALUES(7,'강원도');
INSERT INTO SPC_LOC VALUES(8,'대전광역시');
INSERT INTO SPC_LOC VALUES(9,'대구광역시');
INSERT INTO SPC_LOC VALUES(10,'경상북도');
INSERT INTO SPC_LOC VALUES(11,'경상남도');
INSERT INTO SPC_LOC VALUES(12,'부산광역시');
INSERT INTO SPC_LOC VALUES(13,'울산광역시');
INSERT INTO SPC_LOC VALUES(14,'전라북도');
INSERT INTO SPC_LOC VALUES(15,'전라남도');
INSERT INTO SPC_LOC VALUES(16,'광주광역시');
INSERT INTO SPC_LOC VALUES(17,'제주도');
INSERT INTO SPC_TYPE VALUES(1,'회의실');
INSERT INTO SPC_TYPE VALUES(2,'다목적홀');
INSERT INTO SPC_TYPE VALUES(3,'레저시설');
INSERT INTO SPC_TYPE VALUES(4,'파티룸');
INSERT INTO SPC_TYPE VALUES(5,'공연장');
INSERT INTO SPC_TYPE VALUES(6,'카페');
INSERT INTO SPC_TYPE VALUES(7,'스터디룸');
INSERT INTO SPC_TYPE VALUES(8,'독립오피스');
INSERT INTO SPC_TYPE VALUES(9,'코워킹오피스');
INSERT INTO SPC_TYPE VALUES(10,'일하기좋은카페');
INSERT INTO spc VALUES(1011,'testid',null, null, null, null, null);

INSERT INTO REVIEW VALUES(3,1,'testid',0,2,null,'WQE','QWE',null,20/02/11,DEFAULT,0,0,0);

INSERT INTO REVIEW_CMNT VALUES(1,'testid',3,0,0,DEFAULT,0,0);

update membership set mem_role = 1 where mem_id='testid';
commit;

select * from review;
select * from review_cmnt;
INSERT INTO REVIEW_CMNT VALUES(SEQ_COMMENT_NO.NEXTVAL,'testid',2,0,'테스트용',DEFAULT,0,0);
commit;
select * from spc_type;
select * from membership;
select * from member_grd;
select * from spc;
select * from spc_dtl;
select * from spc_timetable;
select * from spc_res;
select * from spc_res_grp;
select * from spc_price;
select * from spc_loc;
select * from spc_type;
select * from spc_img;
select * from spc_ctt_img;
select * from spc S join spc_dtl D on S.spc_no=D.spc_no join spc_price P on D.spc_detail_no=P.spc_detail_no join spc_img I on D.spc_detail_no=I.spc_detail_no where spc_name like '%%' and SPC_TYPE_NO is not null and SPC_LOCATION_NO is not null;

select * from spc_res R join spc_res_grp G on R.res_group_no = G.res_group_no ORDER BY res_no;
SELECT * FROM SPC_RES R JOIN SPC_RES_GRP G ON R.RES_GROUP_NO = G.RES_GROUP_NO WHERE R.RES_GROUP_NO = 62 ORDER BY RES_TIME;
