drop table T_comp_hierarch;
drop table T_TGT_TAG;
drop table T_HASHTAG;
drop table T_TAG;
drop table T_reply;
drop table T_party;
drop table T_bulitine_board;

-- 	id, name, descrip, post_cnt
create table T_bulitine_board(
	id       	char(4) primary key,
	name	 	varchar(255) not null,
	descrip  	varchar(255),
	post_cnt	long default 0 comment '총 게시물 개수'
);

insert into T_bulitine_board(id, name, descrip) values(NEXT_PK('s_bulitine_board'), '자유게시판', '자유롭죠');

-- 	T_party(id, descrim, name, sex, reg_dt, upt_dt)
create table T_party(
	id       char(4) primary key,
	descrim  varchar(255) not null DEFAULT 'Member', -- 'Manager', 'Member' 
	name     varchar(255) not null,
	sex      boolean comment '1 F, 0 M',
	reg_dt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	upt_dt	 TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
);
	
/* 코드 유형 정의 */
create table T_CODE(
	Code_type  varchar(255) not null,
	code_val   varchar(255)
);
insert into T_CODE values('contect point type', 'hand phone number');
insert into T_CODE values('contect point type', 'home address');

insert into T_CODE values('rel target tag', 'post');
insert into T_CODE values('rel target tag', 'party');

-- T_contact_Point(owner_id, cp_type, cp_val)
create table T_contact_Point(
	owner_id     char(4),
	cp_type		 varchar(255),
	cp_val       varchar(255),
	primary key(owner_id, cp_type)
);

-- id, descrim, writer_id, content, reg_dt, upt_dt, bb_id, TITLE, read_cnt, like_cnt, dis_cnt	
create table T_reply(
	id          char(4) primary key,
	descrim  varchar(255) not null, /* 'reply', 'post' */
	writer_id   char(4) not null,
	content 	TEXT(65000),
	reg_dt   	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	upt_dt	 	TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	/* 아래 속성은 게시글 일때만 활용되는 */
	bb_id 		char(4),
	TITLE 		varchar(255),
	read_cnt    int default 0,
	like_cnt	   int default 0,
	dis_cnt        int default 0
);

-- id, word, desription, df
-- 통합 검색 체계
create table T_TAG(
	id          char(4) primary key,
	word 		varchar(255),
	desription 	TEXT(65000),
	df			long comment 'document frequency'
);

-- 	tgt_name, tgt_id, tag_id, tf
create table T_TGT_TAG(
	tgt_name	varchar(255),  /* post, party */
	tgt_id		char(4),
	tag_id		char(4),
	tf			int,
	primary key(tgt_name, tag_id, tgt_id) /* post */
);
/* party */
create index idx_tgt_tag on T_TGT_TAG(tgt_name, tgt_id, tag_id);


/* top2bottom bottom2top */
create table T_comp_hierarch(
	id          char(4)	primary key,
	comp_hierarch	varchar(255),
	kind			char(3)    /* t2b, b2t */
);

create index idx_comp_hierar on T_comp_hierarch(comp_hierarch); 
	
T_reply(
      ukjy, 'post'
      r000, 'post'
      op09, 'reply'
      iiii,      'reply'
      kkkk,      'reply'

      ukjy, ukjy
      r000, r000
      op09 ukjyop09
       iiii    ukjyop09iiii 
      kkkk   ukjyop09kkkk
