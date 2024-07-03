drop table emp01;
CREATE TABLE EMP01(
    empno number(4),
    ename varchar2(10)
);
insert into emp01 values(1000, '둘리');
insert into emp01 values(null, '도우너');

-- (1) not null
create table emp01 (
    empno number(4) not null,
    ename varchar2(10) not null
);
create table emp02 (
    empno number(4),
    ename varchar2(10),
    constraint emp02_empno_ not null, constraint emp02_ename_nn not null
);

drop table emp01;
-- 2) unique
---
create table emp01 (
    empno number(4) not null,
    ename varchar2(10) unique
);
insert into emp01 values(1000, '둘리');
insert into emp01 values(1001, '둘리');

-- 3) primary key (기본키) : not null이고 unique
drop table emp01;
create table emp01 (
    empno number(4) primary key,
    ename varchar2(10) not null
);

insert into emp01 values(null, '둘리');
insert into emp01(ename) values('둘리');

-- 4) foreign key : 참조되는 테이블의 컬럼에 해당되는 값이 존재해야 함.


--
update employees
set department_id = 210
where department_id = 60;
delete from job_history
where department_id = 60;
delete from departments where department_id = 60;
drop table emp01;
rollback;

-- 사원, 부서 테이블 만들어보기
--부모 테이블인 부서 먼저 생성
create table dept01 (
    deptno number(2) primary key,
    dname varchar2(10) unique
);

create table emp01 (
    empno number(4) primary key,
    ename varchar2(10) not null,
    deptno number(2) references dept01(deptno) not null
);
desc dept01;
desc emp01;

create table jhistory01(
    empno number(4),
    start_date date not null,
    end_date date not null,
    deptno number(2),
    constraint jhisotry01_pk_combo primary key(empno, start_date),
    constraint jhistory01_deptno_fk foreign key(deptno) references dept01(deptno)
);

insert into dept01 values (10, '총무부');
insert into dept01 values (20, 'IT');
insert into emp01 values(1000, '둘리', 10);
insert into emp01 values(1001, '고길동', 20);
insert into jhistory01 values(1000,'21-10-01', '24-10-31', 10);
insert into jhistory01 values(1001, '20-10-01', '24-10-31',20);

insert into dept01 values(30, '기획부');
update emp01 set deptno=30 where deptno=10;
select * from emp01;

delete dept01 where deptno = 10;
delete jhistory01 where deptno = 10;
delete dept01 where deptno = 10;

drop table emp01;
drop table jhistory01;
drop table dept01;

-- 5) check
create table emp01 (
    empno number(4) primary key,
    ename varchar2(10) not null,
    gender char(1) check (gender in ('M', 'F'))
);
insert into emp01 values(1000, '홍길동', 'M');
insert into emp01 values(1001, '홍길순', 'F');
drop table emp01;

create table member(
    userid varchar2(10) primary key,
    passwd varchar2(20) not null,
    age number(3) check (age between 14 and 150)
);
insert into member values('abcd', '1234', 20);

-- 6) default
create table dept01 (
    deptno number(3) primary key,
    dname varchar2(10),
    loc varchar2(16) default '서울'
);

insert into dept01(deptno, dname) values(10, 'IT'); -- LOC = 서울
insert into dept01 values(20, '총무부', null); -- LOC = NULL
insert into dept01 values(30, '개발', ''); -- LOC = NULL

drop table member;
create table member (
    email varchar2(40),
    passwd varchar2(15) constraint member_passwd_nn not null,
    name nvarchar2(12) constraint member_name_nn not null,
    mobile char(13),
    addr nvarchar2(50),
    constraint member_combo_pk primary key(email, mobile)
);

-- 회원가입
insert into member values('a@abc.com', '1234', '홍길동', '010-3322-1141', null);
insert into member values('b@bbc.com', '1234', '홍길순', '010-2211-4515', null);

alter table member
add gender char(3);

-- add constraint
alter table member
add constraint member_gender_ck check(gender in ('남', '여'));
-- disable constraint
alter table member
disable constraint member_gender_ck;
-- enable constraint
alter table member
enable constraint member_gender_ck;


-- 컬럼 단위 제약조건
create table emp01 (
    empno number(4) primary key,
    ename varchar2(10) not null,
    job varchar2(9) unique,
    deptno number(4) references dept01(deptno)
);
-- 테이블 단위 제약조건
create table emp02 (
    empno number(4),
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(4),
    primary key(empno),
    unique(job),
    foreign key(deptno) references dept01(deptno)
);
drop table member;
create table member(
    userid varchar2(12),
    pwd varchar2(15) constraint member_pwd_nn not null,
    constraint member_userid_pk primary key(userid)
);

insert into member values('dooly', '1234');
insert into member values('ddochi', '1234');

create table board(
    boardno number(38),
    writer varchar2(12),
    title varchar2(40),
    constraint board_boardno_pk primary key(boardno),
    constraint board_writer_fk foreign key(writer) references member(userid) on delete cascade
);

insert into board values(1, 'dooly', '아싸1빠');
insert into board values(2, 'ddochi', '2빠');

create table board(
    boardno number(38),
    writer varchar2(12),
    title varchar2(40),
    constraint board_boardno_pk primary key(boardno),
    constraint board_writer_fk foreign key(writer) references member(userid) on delete set null
);

select * from board;
delete member where userid = 'dooly';