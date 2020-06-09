#### Jsp 모델2 블로그 프로젝트

![blog](https://blogfiles.pstatic.net/MjAyMDA2MDlfMTI4/MDAxNTkxNjkxMTQ0OTc1.ZudQ-BusaNf8ZMhcNaOF7h0mgvE3omcEvsQAMgs3d5sg.zL0kT_Qc0oLLe2jlPi1BmOFlpTJU1cLCevEeHlBPLpcg.PNG.getinthere/Screenshot_19.png)

## 오라클 12C 사용자 생성
```sql
alter session set "_ORACLE_SCRIPT"=true;  
CREATE USER cos IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO cos;
GRANT CREATE TABLESPACE TO cos;
GRANT CREATE TABLE TO cos;
GRANT CREATE SEQUENCE TO cos;
alter user cos default tablespace users quota unlimited on users;
```

## 테이블
```sql
CREATE TABLE users(
	id number primary key,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    email varchar2(100) not null,
    address varchar2(100) not null,
    userProfile varchar2(200),
    userRole varchar2(20),
    createDate timestamp
) ;

CREATE TABLE board(
	id number primary key,
    userId number,
    title varchar2(100) not null,
    content clob,
    readCount number default 0,
    createDate timestamp,
    foreign key (userId) references users (id)
);

CREATE TABLE reply(
	id number primary key,
    userId number,
    boardId number,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
);
```

## 시퀀스
```sql
CREATE SEQUENCE USERS_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE BOARD_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE REPLY_SEQ
  START WITH 1
  INCREMENT BY 1;
```

## 페이징 쿼리
```sql
SELECT /*+ INDEX_DESC(BOARD SYS_C007969)*/id,
userId, title, content, readCount, createDate
FROM board
OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY;
```