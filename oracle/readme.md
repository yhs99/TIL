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