# CSS (Cascading Style Sheets)

: 웹 문서에서 스타일 (크기, 색상, 모양, 위치 등)을 꾸며주는 언어.

## css syntax (css의 구성)

<image src="./args/css_syntax.png">

```css
ex) 
선택자 {
  속성1: 속성1의 값;
  속성2: 속성2의 값;
}
```
# css를 적용하는 3가지 방법
```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Hello, CSS!</title>
    <link rel="stylesheet" href="../../css/main.css" />
    <style>
      p {
        color: blueviolet;
        font-size: 32px;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <h1>CSS를 기술하는 3가지 방법</h1>
    <p>Hello, CSS!</p>
    <p>1. 외부 스타일(css) 파일을 링크하여 사용한다.</p>
    <p>2. 내부 style태그를 이용하여 적용</p>
    <p style="color: red;">3. inline 방식을 이용하여 적용</p>
    <div>div태그</div>
  </body>
</html>
```

- main.css
```css
@import url(mycss.css);
p {
  border: 1px dotted blue;
}

```
- mycss.css
```css
div {
  background-color: aqua;
}
```

## (4) class 선택자 <br>
- 태그 내부에 class속성을 이용합니다.
- 동일한 값으로 여러 태그를 선택할 수 있는 선택자
- 가장 많이 사용하는 선택자이다.

```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>class 선택자</title>
  <style>
    .bg {
      background-color: salmon;
    }
    .accent {
      border: 1px dashed #000;
      padding: 5px;
      color: white;
    }
  </style>
</head>
<body>
  <h1 class="bg accent">class 선택자</h1>
  <p class="">태그의 내부에 class속성을 이용합니다.</p>
  <p class="bg">동일한 값으로 여러 태그를 선택할 수 있는 선택자</p>
  <p class="">가장 많이 사용되는 선택이다.</p>
</body>
</html>
```

## (5) 그룹 선택자

```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>그룹 선택자</title>
  <style>
    h1, p {
      text-align: center;
    }

    p {
      color: blue;
    }
  </style>
</head>
<body>
  <h1>group 선택자</h1>
  <p>선택자를 이용해 같은 스타일을 여러태그에 적용가능하다.</p>
</body>
</html>
```

# DOM (Document Object Management) 구조

<img src="../../../csspractice/images/DOM.png">