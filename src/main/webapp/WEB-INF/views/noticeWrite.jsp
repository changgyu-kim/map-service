<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<!--  Body Wrapper -->
<div>
  <form action="/create-notice" method="post">
    <div class="form-group">
      <label for="title1">제목</label>
      <input type="text" name="title" class="form-control" id="title1" placeholder="name@example.com">
    </div>
    <div class="form-group" >
      <label for="exampleFormControlTextarea1">본문</label>
      <textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="3" ></textarea>
    </div>
    <button type="submit" class="btn btn-primary m-1">저장</button>
  </form>

</div>
</html>
<script>
</script>

