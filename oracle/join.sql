--추가 연습문제
--1. 전체 사원 중 ALLEN과 같은 직무(JOB)인 사원들의 
--직무, 사원번호, 사원이름, 월급, 부서번호, 부서이름을 출력하세요.
SELECT E.JOB, E.EMPNO, E.ENAME, E.SAL, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D
WHERE JOB IN (SELECT JOB FROM EMP WHERE ENAME = 'ALLEN') AND E.DEPTNO = D.DEPTNO;
--2. 전체 사원의 평균 급여보다 높은 급여를 받는 사원들의 
--사원 정보, 부서정보, 급여 등급 정보(SALGRADE 테이블참고)를 출력하세요. 
--단, 출력할 때 급여가 많은 순으로 정렬하되 급여가 같을 경우 사원번호를 기준으로 오름차순 정렬하세요
SELECT E.EMPNO, E.ENAME, E.SAL, E.JOB, D.DNAME, S.GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND
E.SAL > (SELECT AVG(SAL) FROM EMP) AND
E.SAL BETWEEN S.LOSAL AND S.HISAL
ORDER BY SAL DESC, EMPNO;

--3. 10번 부서에 근무하는 사원 중 30번 부서에는 존재하지 않는 직무(JOB)을 가진 사원들의
--사원 번호, 이름, 직무, 부서번호호, 부서이름, LOC를 출력하세요.
SELECT E.EMPNO, E.ENAME, E.JOB, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO=10 AND
E.JOB NOT IN (SELECT JOB FROM EMP WHERE DEPTNO=30);
--4. 직무가 salesman인 사람들의 최고 급여보다 높은 급여를 받는 사원들의
--사원번호, 이름, 월급, GRADE(SALGRADE 테이블 참고)를 출력하세.
SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE
FROM EMP E, SALGRADE S
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB=UPPER('salesman')) AND
E.SAL BETWEEN S.LOSAL AND S.HISAL;