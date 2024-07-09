- [JAVA 1. 설치](#java-01-자바-설치)
- [JAVA 2. 자바 언어의 특징](#java-02-자바-언어의-특징)
- [JAVA 3. 자바 언어의 특징](#java-03-변수와-데이터-타입)

# Java 01. 자바 설치
<pre>
  1. JDK1.8 (Java Development Kit) and JVM (Java Virtual Machine) 설치
  <a href="https://www.azul.com/core-post-download/?endpoint=zulu&uuid=957bbb55-37c3-445a-8529-7ca115dfe708">다운로드</a>
  2. 환경 변수 설정 (어느 경로에서나 java.exe가 실행되도록 설정) : zulu jdk는 자동으로 설정해줌.

  3. IDE : Eclipse, JAVA EE Mode
  <a href="https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2024-06/R/eclipse-inst-jre-win64.exe&mirror_id=1248">다운로드</a>
</pre>

- Oracle JDK vs openJDK

# Java 02. 자바 언어의 특징
  자바는 썬 마이크로시스템에서 개발하여 1996년에 발표한 객체지향 프로그래밍 언어이다.

  1) 운영체제에 독립적이다.
  자바 가상 머신(JVM)만 설치되어 있다면, 어느 플랫폼(맥, OS, 리눅스 등)에서나 동작한다.

  2) 객체지향 언어이다. 상속, 캡슐화, 다형성 등 객체지향 언어의 특징이 잘 적용된 프로그래밍 언어로 손꼽힌다.

  3) 배우기 쉽다 - C Fmaily언어

  4) 자동 메모리 관리가 된다. 가비지컬렉터.
  5) 멀티스레드 지원

## 3. 자바 프로그램의 실행 과정
: 자바는 컴파일 방식의 프로그래밍 언어이다.
<pre>소스코드(.java) --<small>컴파일</small>-> 바이트코드파일(.class) -> 실행</pre>

JDK - 자바개발도구 (Java Development Kit)<br>
JRE - 자바 실행환경 (Java Runtime Environment) : 자바로 작성된 응용프로그램이 실행되기 위한 환경<br>
JVM - 자바가상머신 OS에 구애받지않고 독립적으로 자바를 실행할 수 있게 해준다.


# Java 03. 변수와 데이터 타입
  1) 변수 : 하나의 값을 저장할 수 있는 메모리번지에 붙여진 이름.

```java
int score; // 변수  선언
score = 90; // 값 대입(할당)
```


## 변수, 메서드, 클래스등의 이름을 만드는 규칙
  1. 대소문자가 구분되며, 길이 제한은 없다. (True, true)
  2. 예약어를 사용할 수 없다
  3. 숫자로 시작할 수 없다.(첫번째 글자는 문자여야 한다.)
  4. 중간부터는 문자, 숫자, 특수문자(_, $만 가능)을 포함할 수 있다.
  5. 클래스의 첫 글자는 항상 대문자로 한다.
  6. 변수와 메서드의 첫글자는 소문자로 시작한다.
  7. 상수의 이름은 모두 대문자로 한다. 여러 단어로 이루어져있으면 _로 구분한다.
  8. camel 표기법을 따르는 것이 좋고, 변수 또는 메서드 또는 클래스 이름은 목적이 분명하게 이름을 짓는것이 좋다.

## 2) 데이터 타입 (Data Type)
  ### 1) 값타입 | 기본형 (primitive type) - 총 8개
    자바에서 기본으로 만들어놓은 데이터 타입이며, 메모리의 스택(stack)영역에 만들어진다. 크기도 고정되어 있다.


✨✨✨✨✨✨✨✨
|  |1 byte | 2 byte | 4 byte | 8 byte |
|---|-------|--------|--------|--------|
|논리형|boolean(Boolean)|               |        |
|문자형|     |char(Character)    |        |        |
|정수형|byte(Byte) |short(Short)   |int(Integer)    |long(Long)    |
|실수형|     |        |float(Float)   |double(Double)  |
<hr><br>
  - 논리형 : boolean(true | false)
  - 문자형 (char) : 문자를 저장하는데 사용되고, 변수에 하나의 문자만 저장할 수 있다. 문자를 내부적으로 정수(유니코드 - 2byte)로 저장하기 때문에 정수형 또는 실수형과 연산도 가능하다.

  - 위 표에서 괄호안에 있는 문자는 자바 wrapper 클래스이다. java.lang 패키지에 포함되어있다.
```
정수형 타입은 리터럴 접미사(L | l)가 붙지않으면 int타입으로 간주한다. 이때, 왜 기본형 타입을 int로 가질까? 이것은 `JVM의 피연산자 스택(operand stack)`이 `피연산자를 4byte단위로 저장`하기 때문에 4byte보다 작은 자료형(byte,short)로 값을 계산하면 4byte로 변환하여 연산을 수행한다. 즉, int자료형을 사용하면 바로 연산을 하지만 4byte보다 작은 자료형을 사용하면 연산을 위해서 다시한번 int형으로 변환하는 연산이 생기게 된다. 따라서, 연산을 수행할때 int보다 작은 자료형을 사용하면 더 비효율적인것이다. 만약, CPU연산보다 메모리를 더 절약하는게 중요한 프로그램이라면 byte,short를 사용해도 된다.  
```

  ### 2) 참조타입 (reference type)
  : 사용자 정의 타입이라고도 한다. 메모리의 힙(heap)영역에 만들어진다.
  크기가 고정되어 있지 않다. (값 타입이 아닌 것 (String, 객체))