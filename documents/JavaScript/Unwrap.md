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
</html>
<script>
  $('#target').unwrap();
</script>
```
* result
``` HTML
<html>
  <body>
    <span id="target"></span>
  </body>
</html>
<script>
  $('#target').unwrap();
</script>
```

# Contents
