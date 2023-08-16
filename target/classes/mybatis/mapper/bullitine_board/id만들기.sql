DROP TABLE T_I1;
DROP TABLE T_I2;
DROP TABLE T_I4;
create table T_I1(id varchar(4));
create table T_I2(id varchar(4));
create table T_I4(id varchar(4));

create table T_IDSEED(
	SEQ integer primary key,
	SEED char(4)
);

create table T_SEQ(
	target_name varchar(255) primary key
	SEQ integer
);


-- 길이가 두줄인 것들을 다 삭제함
delete 
FROM T_ID_SEED
where length(id) = 2;

-- 컨티션 프로덕트
INSERT INTO T_I4(id)
SELECT CONCAT (a.id, b.id)
FROM T_I1 a, T_I2 b
;

INSERT INTO T_IDSEED(SEED, SEQ)
	SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
		FROM T_I4 tid, (SELECT @ROWNUM:=0) AS R
		ORDER BY iid ASC
		
SELECT * 
FROM T_IDSEED
where seq > 1600000;
		

INSERT INTO T_ID_SEED(id) VALUES ('a');
INSERT INTO T_ID_SEED(id) VALUES ('b');
INSERT INTO T_ID_SEED(id) VALUES ('c');
INSERT INTO T_ID_SEED(id) VALUES ('d');
INSERT INTO T_ID_SEED(id) VALUES ('e');
INSERT INTO T_ID_SEED(id) VALUES ('f');
INSERT INTO T_ID_SEED(id) VALUES ('g');
INSERT INTO T_ID_SEED(id) VALUES ('h');
INSERT INTO T_ID_SEED(id) VALUES ('i');
INSERT INTO T_ID_SEED(id) VALUES ('j');
INSERT INTO T_ID_SEED(id) VALUES ('k');
INSERT INTO T_ID_SEED(id) VALUES ('l');
INSERT INTO T_ID_SEED(id) VALUES ('m');
INSERT INTO T_ID_SEED(id) VALUES ('n');
INSERT INTO T_ID_SEED(id) VALUES ('o');
INSERT INTO T_ID_SEED(id) VALUES ('p');
INSERT INTO T_ID_SEED(id) VALUES ('q');
INSERT INTO T_ID_SEED(id) VALUES ('r');
INSERT INTO T_ID_SEED(id) VALUES ('s');
INSERT INTO T_ID_SEED(id) VALUES ('t');
INSERT INTO T_ID_SEED(id) VALUES ('u');
INSERT INTO T_ID_SEED(id) VALUES ('v');
INSERT INTO T_ID_SEED(id) VALUES ('w');
INSERT INTO T_ID_SEED(id) VALUES ('x');
INSERT INTO T_ID_SEED(id) VALUES ('y');
INSERT INTO T_ID_SEED(id) VALUES ('z');
INSERT INTO T_ID_SEED(id) VALUES ('0');
INSERT INTO T_ID_SEED(id) VALUES ('1');
INSERT INTO T_ID_SEED(id) VALUES ('2');
INSERT INTO T_ID_SEED(id) VALUES ('3');
INSERT INTO T_ID_SEED(id) VALUES ('4');
INSERT INTO T_ID_SEED(id) VALUES ('5');
INSERT INTO T_ID_SEED(id) VALUES ('6');
INSERT INTO T_ID_SEED(id) VALUES ('7');
INSERT INTO T_ID_SEED(id) VALUES ('8');
INSERT INTO T_ID_SEED(id) VALUES ('9');