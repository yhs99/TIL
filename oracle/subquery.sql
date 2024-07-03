-- 서브쿼리

-- 100번 사원이 소속되어 있는 부서의 부서명을 알아보자.
SELECT EMPLOYEE_ID, DEPARTMENT_ID, (SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_ID = 90) AS DEPARTMENT_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100;

SELECT EMPLOYEES.EMPLOYEE_ID, EMPLOYEES.DEPARTMENT_ID, DEPARTMENTS.DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS
WHERE employees.employee_id = 100 AND DEPARTMENTS.DEPARTMENT_ID = 90;

-- 사원들이 소속되어 있는 부서의 사번, 이름, 소속 부서명을 출력하자
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS
WHERE EMPLOYEES.DEPARTMENT_ID = departments.department_id;

-- executive부서의 국가코드, 주, 시, 도로명 주소를 출력해 보자.
SELECT COUNTRY_ID, CITY, STATE_PROVINCE, STREET_ADDRESS
FROM LOCATIONS
WHERE LOCATION_ID = (SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = initcap('executive'));

-- 'diana'와 같은 부서에 다니는 동료들의 모든 정보를 출력하시오
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LOWER(FIRST_NAME) = 'diana');

-- 사원들의 평균 급여보다 더 많은 급여를 받는 사원의 사번, 이름 ,급여를 출력하세요.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES);

-- 다중행 서브쿼리
-- 서브쿼리에서 반환되는 행이 2개 이상일 때
-- 다중행 연산자
-- 1) in : 메인 쿼리으 비교조건이 서브쿼리의 결과 중에서 하나라도 일치하면 참
-- 2) any : 메인 쿼리의 비교조건이 서브쿼리의 결과와 하나 이상이 일치하면 참
-- 3) all : 메인 쿼리의 비교조건이 서브쿼리의 결과와 모든 값이 일치하면 참

-- 급여를 7000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보를 출력하세요
SELECT * 
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY >= 7000);

-- ALL 연산자
-- 문제) 30번 부서에 소속된 사원 중에서 급여를 가장 많이 받는 사원보다
-- 더 많이 받는 사원의 이름 급여를 출력
-- A
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT MAX(SALARY) FROM EMPLOYEES WHERE DEPARTMENT_ID = 30);
-- B
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ALL(SELECT SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = 30);
-- 1) < any()
select first_name, salary from employees where salary < any(4000, 6000, 9000, 12000);
-- 2) > any()
select first_name, salary from employees where salary > any(4000, 6000, 9000, 12000);
-- 3) = any()
select first_name, salary from employees where salary = any(4000, 6000, 9000, 12000);

-- 문제) 30번 부서에 소속된 사원 중에서 급여를 가장 적게받는 사원보다 더 많이 받는 사원들의 이름, 급여를 출력
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ANY(SELECT SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = 30);

