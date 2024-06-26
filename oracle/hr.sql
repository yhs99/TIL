-- SELECT 문으로 특정 데이터를 추출하자.
-- ex) SELECT 컬럼명1,컬럼명2 or * 
--     FROM 테이블;
-- countries 테이블의 모든 컬럼 조회
SELECT * FROM countries;

-- 부서 테이블의 모든 컬럼 조회
SELECT * FROM departments;

-- 사원 테이블의 모든 컬럼 조회
SELECT * FROM  EMPLOYEES;

--사원 테이블의 사원 이름만 조회
SELECT FIRST_NAME, last_name FROM EMPLOYEES;

-- 부서 테이블에서 부서명만 조회
SELECT DEPARTMENT_NAME FROM departments;

-- 지역(LOCATIONS) 테이블에서 도로명 주소만 조회
SELECT STREET_ADDRESS FROM LOCATIONS;

-- 사원 테이블에서 사원명과 급여를 조회
SELECT FIRST_NAME, SALARY FROM EMPLOYEES;

-- 사원 테이블에서 사번, 이름, 입사일을 조회
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE FROM EMPLOYEES;

-- 부서 테이블에서 부서명, 부서번호를 조회
SELECT DEPARTMENT_NAME, DEPARTMENT_ID FROM DEPARTMENTS;

-- 2. 컬럼명에 별칭 부여하기
--  1) 컬럼명에 별칭을 지으려면 컬럼명 뒤에 as 키워드를 사용한다.
--  2) as 키워드는 생략 가능하다.
SELECT FIRST_NAME AS 이름 FROM EMPLOYEES;
SELECT EMPLOYEE_ID 사번, FIRST_NAME 이름 FROM EMPLOYEES;

--  3) 별칭에 공백이나 특수문자를 포함하는 경우에는 "별칭" (큰따옴표)로 묶어준다.
SELECT FIRST_NAME "이 름" FROM EMPLOYEES;

-- 3. distinct 키워드는 중복된 데이터를 한번씩만 출력한다.
SELECT DISTINCT JOB_ID FROM EMPLOYEES;

-- 4. WHERE 절을 사용하여 조건절을 사용할 수 있다.
SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID >=150;

-- 조건식에 사용되는 연산자(>, <, >=, <=, = , != 등)
-- 사원테이블에서 이름이 adam인 사원의 사번, 이름, 입사일을 조회
-- SQL에서 문자열이나 날짜를 표현할 때는 '' (작은 따옴표)를 이용하며, 대소문자를 구분한다.
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'Adam';

-- 사원 테이블에서 급여가 5000이상인 사원들의 사번, 이름, 급여를 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 5000
ORDER BY SALARY DESC;

-- 지역테이블 (LOCATIONS)에서 지역번호(LOCATION_ID)가 1800번 이하인 지역의 모든 컬럼을 조회
SELECT *
FROM LOCATIONS
WHERE location_id <= 1800;

-- 사원테이블에서 입사일이 2002년 이전에 입사한 사원들의 사번, 이름, 급여, 입사일 조회
-- 날짜 연산은 문자열을 입력해도 연산을 내부적으로 자동으로 처리한다.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE < '02/01/01';

-- 조건연산자를 연결할 때 논리연산자(and or, not)로 결합할 수 있다.
-- 사번이 130번보다 작거나 급여가 5000보다 큰 사원들의 사번, 급여를 출력
SELECT EMPLOYEE_ID, SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID < 130 OR SALARY > 5000;

-- 급여가 5000이상 이고 부서번호가 30번보다 작은 사원들의 사번, 급여, 부서번호를 출력
SELECT EMPLOYEE_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY >= 5000 AND DEPARTMENT_ID < 30;

-- 부서번호가 100번이 아닌 모든 사원들의 모든 컬럼을 조회
SELECT *
FROM EMPLOYEES WHERE 
DEPARTMENT_ID != 100 AND
DEPARTMENT_ID <> 100 AND
DEPARTMENT_ID ^= 100;

-- 3) between A and B : A이상이고 B이하
-- 급여가 5000이상이고 급여가 7000이하인 사원들의 이름, 급여 출력
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 7000;

-- 입사년도가 2003년에서 2005년인 사원들의 모든 정보출력
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '03/01/01' AND '05/12/31';

-- 4) IN (A, B, C)연산자 : A 또는 B 또는 C중에서 해당하는 것을 고른다.
-- 부서번호가 10번 또는 50번, 100번인 사원들의 모든 정보 출력
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (10, 50, 100);

-- 5) 패턴을 이용하여 검색하는 LIKE 연산자
-- -- 컬럼명 LIKE 패턴
-- -- -- 패턴은 아래의 2가지를 이용할 수 있다.
-- -- -- --'%' : 문자가 없거나 하나 이상의 어떤 값이든 검색한다.
-- -- -- --'_' : 하나의 문자가 어떤 값이 오든 상관없이 검색한다.

-- 이름이 s로 시작하는 모든 사원들의 정보를 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'S%';

-- 이름이 n으로 끝나는 모든 사원들의 정보를 출력
SELECT *
FROM employees
WHERE first_name LIKE '%n';

-- 직무(job_id)가 AN으로 끝나는 모든 사원들의 정보를 출력
SELECT *
FROM EMPLOYEES
WHERE job_id LIKE '%AN';

-- 이름의 끝에서 두번째 글자가 a인 사원들의 모든 정보를 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%a_';

-- 이름의 세번째 글자가 r인 사원들의 모든 정보 출력
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '__r%';

-- 직무 (job_id)에 _가 포함된 사원들의 모든 정보를 출력
SELECT *
FROM EMPLOYEES
WHERE JOB_ID LIKE '%_%';

-- 6) NULL을 위한 연산자
-- IS NULL (NULL인 데이터), IS NOT NULL (NULL이 아닌 데이터)
-- 커미션 (commission_pct)을 받는 모든 사원의 정보를 출력
SELECT *
FROM EMPLOYEES
WHERE commission_pct IS NOT NULL;

-- 7) 정렬을 하기 위해서는 ORDER BY 절을 사용한다.
-- 사원들의 급여 내림차순으로 모든 사원들의 정보를 출력
SELECT *
FROM EMPLOYEES
ORDER BY SALARY DESC;

-- 정렬은 , (콤마)로 구분하여 여러개를 사용할 수 있다.
-- 부서번호가 50번인 사원들의 모든 정보를 출력하되,
-- 급여 오름차순으로 정렬하고, 급여가 같을 경우 이름 내림차순으로 정렬한다.
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50
ORDER BY SALARY ASC, FIRST_NAME DESC;