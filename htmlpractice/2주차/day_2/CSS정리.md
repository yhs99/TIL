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