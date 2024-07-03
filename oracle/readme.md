- [DB 01. 설치](#db-01-install-oracle)
- [DB 02. database-개요](#db-02-database-개요)
- [DB 03. JOIN문](#db-03-join)
- [DB 04. sql문의 종류](#db-04-sql문의-종류)
- [DB 05. 제약조건](#db-05-제약조건-constraints)
# DB 01. install Oracle

```
개발환경 세팅
version : oracle 11g
workbench : sql developer (JDK11)
```

## 1. oracle installation
<a href="https://www.oracle.com/database/technologies/xe-prior-release-downloads.html"> oracle 11g 버전 다운로드 링크</a><br>
<a href="https://download.oracle.com/otn/java/sqldeveloper/sqldeveloper-23.1.1.345.2114-x64.zip"> SQL Developer 다운로드 링크 (JDK11 포함버전) </a>


## 2. 실습용 HR, scott 계정 언락 및 비밀번호 설정
```SQL
-- hr 계정 잠금 해제
alter user hr account unlock;
-- hr 사용자의 비밀번호를 1234로 설정한다.
alter user hr IDENTIFIED by 1234;

-- 설치된 db 파일내의 scott.sql 파일을 실행 한 후
-- scott 계정의 잠금을 해제해준후 비밀번호를 1234로 설정해준다.
alter user scott account unlock;
alter user scott IDENTIFIED by 1234;
```

# DB 02. Database 개요
## 데이터베이스의 개요
- Database : 유요아게 사용되어질 구조화된 데이터의 집합
- Database Management System (DBMS) <br>
: 방대한 양의 데이터가 있는 데이터베이스를 편리하게 저장하고 효율적으로 관리하며 검색할 수 있도록 하여, 유저가 편하게 데이터베이스를 이용할 수 있도록 하는 환경을 제공해주는 프로그램.<br>
ex. 오라클, MySQL, MSSQL, MariaDB 등
- SQL(Structed query language)<br>
: 데이터베이스를 관리 (<strong>Create(생성), Read(조회), Update(수정), Delte(삭제) , CRUD</strong>)하기 위해서 만들어진 구조화된 질의 언어.

## 왜 데이터를 관리할 때 데이터베이스를 사용할까?
파일로 데이터를 관리하게 될 때 단점
- 특정 데이터를 검색하기 힘듦.
- 공유가 힘듦.
- 보안이 취약하다.
- 응용 프로그래머가 파일에 관한 프로그램을 만들 때, 물리적 구조를 알아야 프로그래밍 할 수 있어 프로그래밍 하기 어렵다.

# DBMS의 장점
- 데이터의 공유가 편리하다.
- 데이터의 중복성이 감소된다.
- 데이터의 불일치가 감소된다.
- 데이터의 무결성을 유지할 수 있다.
- 데이터의 보안을 유지할 수 있다.
- 표준화가 가능하다.

# 데이터베이스의 종류
1. 관계형 데이터베이스 (RDBMS : Realtional Database Management System) <br>
: 테이블(행과 열로 이루어진) 구조로 데이터를 관리하는 데이터베이스.
2. 트리형 데이터베이스
3. 네트워크형 데이터베이스

# 관계형 데이터의 릴레이션 구조
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F9PZHv%2Fbtq2lAE2xpY%2FHfgOTfyyYlhGDH0bLt4IIk%2Fimg.png">
튜플(Tuple)
튜플은 릴레이션을 구성하는 각각의 행을 말하며 속성의 모임으로 구성된다. 파일 구조에서 레코드와 같은 의미이다. 튜플의 수를 카디널리티(Cardinality) 또는 기수, 대응수라고 한다.

 

 

속성(Attribute)
속성은 데이터베이스를 구성하는 가장 작은 논리적 단위이며 개체의 특성을 기술한다. 파일 구조상의 데이터 항목 또는 데이터 필드에 해당한다. 속성의 수를 디그리(Degree) 또는 차수라고 한다.

 

 

도메인(Domain)
도메인은 하나의 속성(attribute)이 취할 수 있는 같은 타입의 원자값들의 집합이다. 도메인은 실제 속성 값이 나타날 때 그 값의 합법 여부를 시스템이 검사하는데에도 이용된다.

 

 

릴레이션의 특징
 - 한 릴레이션에는 똑같은 튜플이 포함될 수 없음

 - 한 릴레이션에 포함된 튜플 사이에는 순서가 없음

 - 튜플들의 삽입, 삭제 등의 작업으로 인해 릴레이션은 시간에 따라 변함

 - 릴레이션 스키마를 구성하는 속성들 간의 순서는 중요하지 않음

 - 속성의 유일한 식별을 위해 속성의 명칭은 유일해야 함

 - 하지만, 속성을 구성하는 값은 동일한 값이 있을 수 있음

 - 릴레이션을 구성하는 튜플을 유일하게 식별하기 위해 속성들의 부분집합을 키로 설정

 - 속성의 값은 논리적으로 더 이상 쪼갤 수 없는 원자값만을 저장

 
 ```SQL
SELECT 연습문제

1. 중복되는 컬럼을 한번씩만 출력하는 키워드는 ( ) 이다.
1-1. 사원테이블의 직무가 한번씩만 출력되도록 sql을 작성하세요

2. 사원테이블의 모든 정보를 출력
3. 사원의 이름, 급여, 입사일 만을 출력
4. 사원들이 어떤 부서에 소속되어 있는지 소속 부서번호를 출력하되
   중복되지 않고 한번씩만 출력
5. emp 테이블 중 부서번호가 10번인 사원의 모든 정보 출력
6. 사원 테이블 중 급여가 2000 미만인 사원의 정보 중에서 사번, 이름, 급여를 출력하세요.
7. 이름이 'miller'인 사람의 사번, 이름, 직급을 출력하세요
8. 커미션이 300 또는 500 또는 1400인 사원의 사번, 이름, 커미션을 출력하세요
   (1) or 연산자 이용
   (2) in 이용
9. 급여가 1500과 2500사이인 사원의 사번, 이름, 급여를 출력하세요
   (1) and 이용
   (2) between 이용
10. 이름에 A를 포함하지 않는 사원의 사번, 이름을 출력하세요.
11. 자신의 직속상관이 없는 사원의 이름, 직급, 직속상관의 사번을 출력
12. 사번, 이름, 급여를 급여가 높은 순으로 출력하세요
13. 입사일이 가장 최근 순으로 사번, 이름, 입사일을 출력하세요
 ```

 # DB 03. JOIN 
 ## 조인의 종류
   1. 조인의 종류
      - Cross Join(교차조인) : 의미없는 조인 단순하게 두개 이상의 테이블을 곱연산 결과를 냄
      - Equi Join(동등 조인) : 조인 대상이 되는 테이블에서 공통적으로 존재하는 컬럼을 연결("=")하여 결과를 생성하는 조인
      - Non-Equi Join(비동등 조인) : 조인할 테이블 사이의 컬럼값이 직접적으로 일치하지 않을 때 사용하는 조인("=" 연산자를 제외한 연산자를 사용한다)
      - Outer Join(외부 조인) : 조인 조건에 만족하지 않는 행들도 나타내기 위해 사용하는 조인
      - Self Join : 하나의 테이블에서 조인을 하여 원하는 데이터를 얻는 조인인
 ## 조인의 조건
   1. primary key (기본키)와 foreign key(외래키)컬럼을 통해 서로 다른 테이블을 연결한다.
   2. where 절을 사용하여 조인조건을 기술한다. 조인조건 갯수 = 테이블의 수-1
   3. 명확성을 위해 컬럼명 앞에 테이블 명 또는 별칭을 기술한다.

## ANSI Join
   - Cross Join
   - Inner Join : Equi join과 동일
      - Join 조건을 where절이 아닌 on 절에 기술한다. (일반 조건은 where절에 기술)
      - using (조인할컬럼명) : 조인이 되는 컬럼명이 동일해야 하고, 조인할 컬럼에 대해서 테이블 별칭을 사용할 수 없음
      - natural join : 조인이 되는 컬럼명은 동일해야 한다. DBMS가알아서 테이블을 살펴보고 동일한 컬럼으로 inner join 진행.
      동일한 컬럼이 2개 이상일 경우 and 연산을 이용해 join한다.
   - Outer Join
      - left outer join, right outer join, full outer join

 ## ERD (Entity Relationship Diagram)
 :Entity(개체 : DB에서 데이터화 하려는 개념 ex. 테이블)


 ### 1) 개념적 ERD
<img src="https://velog.velcdn.com/images/mong9_s/post/89758ac3-c523-483b-90a6-ccee89801be8/image.PNG"/>
<img src="https://velog.velcdn.com/images/mong9_s/post/230a59fb-2293-46f3-8832-1df0c3ae9d26/image.PNG">

 ### 2) 공학적 ERD
 <img src="image.png">




# DB 04. SQL문의 종류
   - DDL (Data Definition Language) : 데이터베이스 객체(테이블, 인덱스, 뷰, 시퀀스, 동의어 등)를 생성, 수정, 삭제하는 명령문들
   <br> ex) create, alter, drop, truncate, renameto

   - DCL(Data Control Language) : 데이터베이스를 제어하기 위한 명령문들<br>
   ex) commit (영구히 보존), rollback (되돌리기), savepoint

   - DML (Data Manipulate Language) : 데이터베이스의 데이터를 추가, 수정, 삭제하는 명령문들<br>
   ex) insert into, update set, delete from

## 1. DDL문
   1. Create table로 테이블의 구조를 정의
      ```SQL
         CREATE TABLE 테이블명(
            컬럼명1 데이터타입,
            컬럼명2 데이터타입,
            ...
         )
      ```
   2. alter table 테이블명
      1) add 컬럼명 데이터타입
      2) modify 컬럼명 데이터타입
      3) drop 컬럼명
      4) rename 컬럼명 to 새컬럼명
   3. truncate table
   4. rename 테이블명 to 새테이블명
   5. drop table

## 2. DML
   - insert into 테이블명([컬럼명]) values(. . .);
   - update 테이블명 set 컬럼명 = 값, . . . [where 조건식];
   - delete from 테이블명 [where 조건식];

truncate vs delete
: truncate는 DDL(데이터 정의어)이기 때문에 rollback이 되지않고
delete는 DML문으로 rollback이 가능하다.

## ORACLE 데이터 베이스의 자료형(DATATYPE)
| 이름  | 설명  |
|---|---|
|char(size) |고정길이 문자데이터. 입력된 자료 길이와 상관없이 정해진 길이만큼 저장영역을 차지함. |
|varchar2(size)|최대 4096byte. 가변길이 유니코드 문자(국가별 문자세트) 데이터.|
|date|날짜형식을 저장하기 위해 사용하는 자료형<br>(BC4712 1월1일 ~ AD 4712년 12월31일 까지)|
|nvarchar2(size)|4096byte. 가변길이 유니코드 문자(국가별 문자세트) 데이터|
|number (w,d)|w는 전체길이, d는 소숫점 이하 자릿수. 최대길이 w=38자리|
|blob|최대 크기 4GB의 대용량 이진 데이터를 저장. binary|
|clob|최대 크기 4GB의 대용량 텍스트 데이터를 저장.|


# DB 05. 제약조건 (constraints)
: 데이터가 추가, 수정, 삭제될 때, 데이터의 무결성을 지키기 위해 컬럼 단위로 주어지는 조건

## 제약조건의 종류
종류         |설명 
------------|---------------------------------------------
not null    | null을 허용하지 않는다.
unique      | 중복된 값을 허용하지 않는다. 항상 유일한 값을 가져야 한다.
primary key | not null + unique
foreign key | 참조되는 테이블의 컬럼값이 존재해야 입력할 수 있다.


## 제약조건과 cascade | set null 옵션
: 두 테이블을 연결해서 부모테이블의 행(pk를 가지고 있는 쪽)을 삭제할 때, 그 부모테이블을 참조하는 다른 테이블의 행을 동시에 삭제되도록 하거나 (on delete cascade), 다른 테이블의 행의컬럼을 null로 변경 (on delete set null) 하는 것이다.

```SQL
CREATE TABLE 테이블명(
   컬럼1 데이터타입 1,
   .... ,
   제약조건 on delete cascade | on delete set null
);
```

### 제약조건 연습문제
<img src="./1.png">
<img src="./2.png">
<img src="./3.png">