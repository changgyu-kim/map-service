<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!--  Body Wrapper -->
<div>
    <c:forEach var="n" items="${notice}">
      <div class="form-group">
        <label for="id">번호</label>
        <input type="text"  name="id" class="form-control" id="id"  value="${n.id}"  >
      </div>
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text"  name="title" class="form-control" id="title" value="${n.title}">
      </div>
      <div class="form-group" >
        <label for="content">본문</label>
        <textarea class="form-control"  name="content" id="content" rows="3" value="${n.content}" ></textarea>
      </div>
    </c:forEach>
    <button id="updateBtn" type="submit" class="btn btn-primary m-1" >Update</button>
    <button id="deleteBtn" class="btn btn-primary m-1" >Delete</button>
    <button id="backBtn" class="btn btn-primary m-1" type="button">Back</button>
</div>
</html>
<script>
  $(document).ready(function (){
    $('#backBtn').click(function (){
      // js에서 지원하는 뒤로가는 함수
      history.back();
    });
  });
</script>

