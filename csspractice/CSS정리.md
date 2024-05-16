<style>
.markdown-body .callout.callout_warn {
  --text: #6a737d;  // theme text color default
  --title: inherit; // theme title color (falls back to text color by default)
  --background: #f8f8f9;
  --border: #8b939c;
}
</style>
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

<img src="./images/DOM.png">

# 4. CSS 복합 선택자
```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>복합 선택자</title>
    <style>
        span.carrot {
            color: orange;
        }
        
        /* div.carrot {
            color: red;
        } */

        
    </style>
</head>
<body>
    <div>
        <ul>
            <li>사과</li>
            <li>블루베리</li>
            <li class="carrot">오렌지</li>
        </ul>
        <div>수박</div>
        <p>토마토</p>
        <span class="carrot">당근</span>
    </div>
</body>
</html>
```

## (2) 자손 (하위)선택자
:부모 요소에 포함된 자손(하위) 요소를 모두 선택한다.
```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>자손 선택자</title>
  <style>
    .secondDiv p {
      background-color: pink;
    }
    
    div p {
      background-color: pink;
     }
     
    div p {
      background-color: blue;
      color: white;
    }
  </style>
</head>
<body>
  <h1>자손 선택자</h1>
  <p>자손 선택자로 스타일을 꾸미면 어떻게 될까요?</p>
  <div>
    <p>div 내부 p태그</p>
    <p>div 내부 p태그</p>
    <p>div 내부 p태그</p>
  </div>
  <p>div 외부 p태그</p>
  <div class="secondDiv">
    <p>2번째 div 내부 p태그</p>
    <p>2번째 div 내부 p태그</p>
    <p>2번째 div 내부 p태그</p>
  </div>

</body>
</html>
```

# (3) 자식 선택자 (Child Selector)
: 자식 요소에만 스타일을 적용하는 선택자
'>' 기호를 이용해 자식요소를 구분한다.
```html
부모요소>자식요소
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>자식 선택자</title>
  <style>
    /* 자손 선택자 */
    div p {
      background-color: red;
    }
    
    /* 자식 선택자 */
    div>p {
      background-color: aqua;;
    }

    h3>p {
      background-color: blue;
    }
  </style>
</head>
<body>
  <h1>자식 선택자</h1>
  <p>자식 선택자로 스타일을 꾸미면 어떻게 될까요?</p>
  <div>
    <p>div 내부 p태그(div의 자식)</p>
    <p>div 내부 p태그(div의 자식)</p>
    <p>div 내부 p태그(div의 자식)</p>
  <h2>
    <p>div 내부의 내부 p태그(h2의 자식, div의 자손)</p>
  </h2>
  <h3>
    <p>div 내부의 내부 p태그 (h3의 자식, div의 자손)</p>
  </h3>
</div>
<p>
  div 외부의 p태그
</p>
</body>
</html>
```
# (4) 형제 Sibling (동위 또는 이웃) 선택자
Sibling Selector는 선택한 태그 이후에 나오는 모든 형제 (동위) 요소 선택
```html
요소1 ~ 요소2
```

# (5) 인접 형제 선택자 (adjacent sibling selector)
```
형제1 + 형제2 {
  ...
}
```
```html
<style>
    h1 + p {
      background-color: violet;
    }
  </style>
</head>
<body>
  <h1>Adjacent Sibling 선택자</h1>
    <p>Adjacent Sibling 선택자로 스타일을 꾸미면 어떻게 될까요?</p>
    <div>
      <p>div 내부 p태그 (div의 자식)</p>
      <p>div 내부 p태그 (div의 자식)</p>
      <p>div 내부 p태그 (div의 자식)</p>
    </div>
    <p>div 외부 p태그1</p>
    <p>div 외부 p태그2</p>
    <p>div 외부 p태그3</p>
```

**_정리:_**<br>
* 자손 선택자 : 부모 자손
* 자식 선택자 : 부모 > 자식
* 형제 선택자 : 형제1 ~ 형제2
* 인접 형제 선택자 : 형제1 + 형제2</i>