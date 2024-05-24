# Javscript
## 자바스크립트란?
: 웹 페이지를 사용자의 액션에 반응하여 페이지를 동적으로 꾸며주는 역할을 하는 프로그래밍 언어.

1) javascript
2) JQuery
3) Ajax
4) (1차 미니 프로젝트)

# 자바스크립트의 특징
  - 객체 지향 프로그래밍 언어
  - 이벤트 관점 프로그래밍
  - 인터프린터 방식의 언어 (컴파일이 아닌 한줄 한줄씩 해석, 실행한다.)
   - C-family 언어이다.

# 1. 기본

# Javascript에서 화면에 출력하는 4가지 방법
<pre>
1. document.write()
2. window.alert()
3. console.log()
4. document.getElement ~
</pre>

## JS 공부법.
 - 문법을 익힌다. (외운다)
 - 알고리즘 (문제해결능력)


# 2. 변수와 상수
- 변수(variable) : 변할 수 있는 데이터를 저장하는 공간.
<br> let 키워드를 이용해서 선언하고, 재할당이 가능하다.<br>
- 상수(constant) : 값이 변하지 않는 데이터를 저장하는 공간.<br>
const 키워드를 이용해서 선언하고, 재할당이 불가능하다.

## 변수 및 상수 명명 규칙
- 첫 글자는 반드시 영문자 | $ | _ 로 시작한다.
- 변수나 상수 이름은 가급적 의미있게 만든다.
- 변수는 소문자로 시작하고 카멜 표기법을 준수한다.
- 상수는 대문자만으로 선언한다. (2단어 이상 결합하는 경우 언더바를 사용하여 선언한다.)
- 영문자는 대소문자를 구분한다.
- 예약어(let, const, var 등)키워드는 변수 또는 상수명으로 사용할 수 없다.

## 프로그래밍 표기법
1. Camel Case(카멜 표기법) : 첫 문자를 소문자로 시작해서, 이후 단어에 첫 글자는 대문자로 표기 phoneNumberAddress 
2. Pascal Case(파스칼) : 첫 문자를 대문자로 시작해서, 이후 단어에 첫 글자는 대문자로 표기.
(java의 class명)

3. Kebab(케밥) : 소문자로 표현하고 단어와 단어 사이에 하이픈(-)으로 표기한다.
4. SnakeCase(스네이크): 소문자나 대문자로 표현하고, 단어와 단어 사이에 언더바 연결하여 표기한다.

# 3. 데이터 타입
```html

```

# 4. 연산자
연산자 우선순위
```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>연산자의 종류</title>
  <script>
    // 산술 연산자 (+, -, *, /, %, **(제곱))
    let a = 3, b = 5;
    console.log(b % a); // (나머지 연산) 5 / 3 = 몫 1, 나머지 2 출력 : 2
    console.log(a * b - a);
    console.log(b ** a); // 5^3 5의3제곱 125
    console.log(b ** (a ** 2)); // 거듭제곱은 우결합성으로, 우측의 연산자부터 계산한다.
    console.log((b ** a) ** 2);
    //증감 연산자
    // 연산자의 위치에 따라서 우선순위가 달라진다.
    // 전치연산 : 선증감 후 대입 (연산자가 변수 앞에 있을 때)
    // 후치연산 : 선대입 후 증감 (연산자가 변수 뒤에 있을 때)
    console.log(a); // a = 3
    console.log(a++); // a = 3
    console.log(a); // a = 4
    console.log(++a); // a = 5
    console.log(a) // a = 5

    console.log(b++ * ++a);
    console.log(a, b);

    // 관계 연산자 : 연산의 결과가 true 또는 false가 나오게 하는 연산
    // > (크다) < (작다) >= (크거나 같다) <= (작거나 같다)
    // == (같다), != (같지 않다)
    console.log(a > b); // 6 > 6 => false
    console.log(a == b); // 6 == 6 true
    console.log(a != b); // 6 != 6 false
    console.log(++a == b); // 7 == 6 false
    console.log(b % 2  == 0); // 6 % 2 == 0 true
    
    // 논리 연산자 : 관계연산자와 관계연산자의 조합을 하는 연산자
    // and (&&) : 수식이 모두 참일 때만 결과가 참이 나온다.
    // or (||) : 수식이 둘중 하나가 참일 때만 참이 나온다.
    console.log(a, b); // 7, 6
    console.log(a > b && b != 3);
    console.log(a == 6 && b == 6);

    console.log(a > 2 || b == 6); // true
    console.log(a < 0 || b > 0);  // true
    console.log(a > 0 || b > 0); // true
    console.log(a < 0 || b < 0); // false

    // ! (not)
    // !true -> false, !false -> true
    console.log(!a); //false
    console.log(!0); //true
    
    console.log(a,b);
    console.log(!b>a);
    console.log("123");
    console.log("A" > "a"); // 문자 비교는 ascii코드를 기준으로 비교한다.
    console.log(!!a>b); // (!(!a) ) > b --> (!(false)) > 6 => false
    
    //우선순위 : 증감(후위 a++) > 논리연산자(NOT) > 산술연산자 > 관계연산자 > 논리 (&&, ||) > 대입연산자

    // 대입연산자
    let result = 0;
    result += 3;
    console.log(result); //3
    result *= 2;
    console.log(result); //6
    result /= 2;
    console.log(result); //3
    result %= 2;
    console.log(result); //1

    //==================================================================
    // 위의 연산자들은 꼭 알아두기..

    // 비트연산자 : 2진수로 바꾸어 비트 단위로 연산한다.
    // 비트 & : 
    // 비트 | : 
    a = 5, b = 3;
    // a = 101 = 1 * (2^2) + 0 * (2^1) + 1 * (2^0)
    // b = 011 = 1 * (2^1) + 1 * (2^0)
    // 100001 = 1 * (2^6) + 0 * (2^5) + 0 * (2^4) + 0 * (2^3) + 0 * (2^2) + 0 * (2^1) + 1 + (2^0);
    console.log(`비트 & ${a&b}`); // 1
    console.log(`비트 | ${a|b}`); // 7
    //XOR (exclusive or : 배타or) : 서로 다른 값이 1 같은 값 0
    console.log(`배타 ^ ${a^b}`); // 6
    // 비트 NOT ~ : 1은 0으로, 0은 1로 바꿔서 연산한다.
    console.log(`비트 NOT ${~a}`); // -6

    //쉬프트 연산자 (자리이동 연산자)
    // a << 2 -> a * 2^2 = 20
     //a << 2
     // 0 0 1 0 1
     // 1 0 1 0 0
    console.log(`쉬프트연산자 a<<2 : ${a<<2}`);

    //a >> 2 -> a * 2 ^(-2)
    // 1 0 1
    // 0 0 1  = 1
    console.log(`쉬프트연산자 a<<2 : ${a>>2}`);
  </script>


</head>
<body>
  
</body>
</html>
```

# 우선순위

: 우선순위 : 증감(후위 a++) > 논리연산자(NOT) > 산술연산자 > 관계연산자 > 논리 (&&, ||)

# if문

## 1) 단순 if 블럭
```javascript
if (조건식) {
  참일경우  동작
}
```

## 2) if ~ else 문
```javascript
if(조건식) {
  조건이 참 일경우 수행할 문장
} else {
  조건이 거짓일 때 수행할 문장;
}
```

## 3) if ~ else if ~ else if ~ else 문
```javascript
if(조건식1) {
  조건1이참일때수행;
}else if(조건식2) {
  조건2가참일때수행
}else if(조건식3) {
  조건3이참일때수행
} ... {

} else {
  어떤 조건식 도 참이 아닐경우 수행
}
```

# switch ~ case 문
```javascript
switch(변수) {
  case 값1 :
    // 변수가 값1 일 때 수행할 문장
    break;
  case 값2 :
    // 변수가 값2 일 때 수행할 문장
    break;

    . . .
  case 값n :
    // 변수가 값n일 때 수행할 문장
    break;
  default :
    // 변수가 위의 어느 값도 아닐 때 수행할 문장
    break;
}
```

예제)<br>
1. 오늘 뭐 먹지 코드의 if문을 switch case로 바꿔보세요.
2. 가위바위보 게임 만들기.

## 전역(Global) 변수, 지역(Local) 변수
 - <b>전역변수</b> : <script></script> 태그 내에 어떤 중괄호{} 코드 블럭에도 포함되지 않은 영역에서 선언된 변수이다. 변수가 선언된 위치 이하의 모든 동일한 웹 페이지 내에서 살아 있으며, 유저가 다른 페이지로 이동하거나, 웹 브라우저를 닫을 때까지 메모리에 남아 있게 된다.

  - <b>지역변수</b> : 중괄호{} 코드블럭 안에서 생성된 변수이다. 생성된 코드 블럭 안에서만 생존하며, 중괄호 코드 블럭을 나온 순간 그 변수는 메모리에서 소멸하게 된다.
  - 연습문제)
   사용자에게 키와 몸무게를 입력받아 계산하여 출력하고,
   기준표에 맞춰서 bmi를 분류하여 출력한다.
   - 연습문제2) 유저에게 숫자를 입력받아 홀수이면 홀수 , 짝수이면 짝수라고 출력하는 프로그램을 작성하되 switch~case문을 활용하여 만드세요.

  # 3. 반복문
  : 프로그램에서 정해진 횟수만큼 어떤 명령문을 반복 수행시키던지, 조건식에 따라서 반복 수행 시키던 할 때 사용하는 구문.
  
  ## (1) for문
  ```javascript
for(ⓐ반복인덱스 변수에 초기값 할당; ⓑ조건식; ⓒ증감식) {
  ⓓ// 조건식이 참일 동안 반복수행할 문장
  ...
}

1. 최초 for 블럭에 진입하면 ⓐ 부분이 단 1회 수행된다.
2. ⓑ조건식을 비교하여 참이면 ⓓ가 수행된다.
3. ⓒ증감식을 수행한다.
4. 2번으로 돌아간다.

ex)
for(let i=0; i<=5; i++) {
    5회 반복할 문장
}
  ```