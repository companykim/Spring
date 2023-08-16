-- 	id, name, descrip
create table T_bulitine_board(
	id       char(4) primary key,
	name	 varchar(255) not null,
	descrip  varchar(255)
);

CREATE SEQUENCE S_bulitine_board;

insert into T_bulitine_board(id, name, descrip) values(NEXT_PK('s_bulitine_board'), '자유게시판', '자유롭죠');



'T_bulitine_board', 3

CREATE TABLE T_IDSEED(
	SEQ integer primary key,
	SEED CHAR(4)
)

select seed
	from T_IDSEED
   where seq = 1004;