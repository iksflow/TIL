# Unwrap (상위태그 제거)
선택한 요소의 상위 태그를 지운다
* example
``` HTML
<html>
  <body>
    <div>
      <span id="target"></span>
    <div>
  </body>
  <script>
    $('#target').unwrap();
  </script>
</html>
```
* result
``` HTML
<html>
  <body>
    <span id="target"></span>
  </body>
  <script>
    $('#target').unwrap();
  </script>
</html>
```

# Contents
contents() 를 활용하면 자식요소는 남겨두고 타겟만 삭제할 수 있다.  

* example
``` HTML
<html>
  <body>
    <div>
      <span id="target">
        <span>Child</span>
      </span>
    <div>
  </body>
  <script>
    $('#target').unwrap();
  </script>
</html>
```
* result
``` HTML
<html>
  <body>
    <span>Child</span>
  </body>
  <script>
    $('#target').unwrap();
  </script>
</html>
```
