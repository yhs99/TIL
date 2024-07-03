-- DML
-- Create(생성), Read(조회), Update(수정), Delete(삭제)
-- 1) insert into : 테이블에 새로운 행을 추가하는 문장
-- insert into table명([컬럼명1, 컬럼명2, 컬럼명4, ...생략시 모든컬럼])
-- values (컬럼값1, 컬럼값2, 컬럼값4, ...);
create table emp01 (
    empno number(4),
    ename varchar2(16),
    job varchar2(12),
    sal number(6)
);

insert into emp01 values(1000, '둘리', '사장', 10000);

desc emp01;
alter table emp01
add hiredate date;

insert into emp01 values('1001', '도우너', '사원', 2000, sysdate);
insert into emp01(empno, ename) values(1002, '또치');
insert into emp01 values(1003, '마이콜', '사원', 2100, sysdate);

create table copyemp
as select * from employees
where 1 = 0;

-- 서브쿼리를 이용하여한번에 데이터 추가하기
insert into copyemp (employee_id, first_name, last_name, email, job_id, hire_date,salary, department_id)
select employee_id, first_name, last_name, email, job_id, hire_date,salary, department_id from employees;

-- (2) update : 테이블의 내용을 수정
-- update 테이블명 set 컬럼명1 = 값, 컬럼명2 = 값, ....
-- where 조건식
-- where 조건식을 주지 않을경우 모든 행의 값이 바뀐다.

update emp01 set sal = 200000
where empno = 1000;

update emp01
set sal = (select sal from emp01 where empno = 1000)
where empno=1002;

update emp01
set sal = 1.5 * (select sal from emp01 where empno=1000)
where empno=1002;


-- (3) delete문
-- delete from 테이블명
-- where 조건식
delete from emp01
where empno=1003;

rollback;








