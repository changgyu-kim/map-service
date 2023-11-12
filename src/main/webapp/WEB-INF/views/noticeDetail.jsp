<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!--  Body Wrapper -->
<div>
      <div class="form-group">
        <label for="id">번호</label>
        <input type="text"  name="id" class="form-control" id="id"  value="${notice.id}" disabled  >
      </div>
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text"  name="title" class="form-control" id="title" value="${notice.title}" disabled>
      </div>
      <div class="form-group" >
        <label for="content">본문</label>
        <textarea class="form-control"  name="content" id="content" rows="3" disabled>${notice.content}</textarea>
      </div>
    <c:if test="${sessionScope.user.loginId == notice.writer}">
    <a id="updateBtn" href="/notice-update/${notice.id}" class="btn btn-primary m-1" >Update</a>
    <button id="deleteBtn" class="btn btn-primary m-1" >Delete</button>
    </c:if>
    <button id="backBtn" class="btn btn-primary m-1" type="button">Back</button>
</div>
</html>
<script>
  $(document).ready(function (){
    $('#backBtn').click(function (){
      // js에서 지원하는 뒤로가는 함수
      history.back();
    });
      $('#deleteBtn').click(function (){
          // js에서 지원하는 뒤로가는 함수
          deleteNotice();
      });
  });

  function deleteNotice(){
      let id = $('#id').val();
      $.ajax({
          type: "DELETE",
          url: `/notice/${id}`,
          success: function (response) {
              alert("삭제가 완료되었습니다.")
              location.href = "/notice"
          },
          error: function (error) {
              console.error("error : ", error);
              alert("에러입니다.")
          }
      });
  }
</script>

