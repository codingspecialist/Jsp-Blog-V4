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

## 상세보기 댓글 디자인

![blog](https://postfiles.pstatic.net/MjAyMDA2MTBfMjMw/MDAxNTkxNzcwMTQxMjA0.StpHO77_G9wEHPNxcrVG6VFPX1-GotrDxxIHjJSptWkg.HREIBlxtojTJZqd65Oa46lbpC-1q99pEgYuOlYWOnXAg.PNG.getinthere/Screenshot_24.png?type=w773)

- css/styles.css
```css
.comment-wrapper .media-list {
	max-height: 450px;
	overflow: auto;
}

.comment-wrapper .media-list .media img {
	width: 64px;
	height: 64px;
	border: 2px solid #e5e7e8;
	border-radius: 30px;
	margin-right: 25px;
}

.comment-wrapper .media-list .media {
	border-bottom: 1px dashed #efefef;
	margin-bottom: 25px;
}
```

- include/nav.jsp
```jsp
<link href="/blog/css/styles.css" rel="stylesheet">
```

- board/detail.jsp
```jsp
<hr />
	<!-- 댓글 박스 -->
	<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2"><b>Comment</b></div>
					<div class="panel-body">
						<textarea class="form-control" placeholder="write a comment..." rows="3"></textarea>
						<br>
						<button type="button" class="btn btn-primary pull-right">댓글쓰기</button>
						<div class="clearfix"></div>
						<hr />
						<!-- 댓글 리스트 시작-->
						<ul class="media-list">
						
							<c:forEach begin="1" end="10">
							<!-- 댓글 아이템 -->
							<li class="media">	
								<img src="https://bootdey.com/img/Content/user_1.jpg" alt="" class="img-circle">		
								<div class="media-body">
									<strong class="text-primary">@MartinoMont</strong>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet.
									</p>
								</div>
							</li>
							</c:forEach>
						</ul>
						<!-- 댓글 리스트 끝-->
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- 댓글 박스 끝 -->
```
