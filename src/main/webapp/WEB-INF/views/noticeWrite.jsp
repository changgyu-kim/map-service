<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<!--  Body Wrapper -->
<div>
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력해주세요">
    </div>
    <div class="form-group" >
      <label for="content">본문</label>
      <textarea class="form-control" name="content" id="content" rows="3" placeholder="내용을 입력해주세요" ></textarea>
    </div>
  <div class="form-group" >
      <input type="checkbox" name="secret" class="form-check-input gender" id="secret">
      <label class="form-check-label" for="secret">비밀글여부</label>
  </div>
    <button id="createBtn" type="submit" class="btn btn-primary m-1">저장</button>
</div>
</html>
<script>
  $(document).ready(function(){
      $('#createBtn').click(function (){
        if(formCheck() == true){
          submit();
        }
      });
  });

  function formCheck(){
    let title = $('#title').val();
    let content = $('#content').val();

    if (title == null || title.trim() === "") {
      alert("제목을 입력해주세요");
      return false;
    }
    if (title.length > 30) {
      alert("제목은 30자를 넘길 수 없습니다.");
      return false;
    }
    if (content == null || content.trim() === "") {
      alert("내용을 입력해주세요");
      return false;
    }
    if (content.length > 1000) {
      alert("내용은 1000자를 넘길 수 없습니다.");
      return false;
    }
    return true;
  }

  function submit(){
    let title = $('#title').val();
    let content = $('#content').val();
    let secret = $('#secret').prop('checked') ? 'Y' : 'N';
    $.ajax({
      url: "/notice-create",
      type: "POST",
      contentType: 'application/json',
      data: JSON.stringify({"title" : title, "content" : content,"secret" : secret}),
      success(data){
        console.log("data : ",data);
        alert("저장되었습니다.");
        location.href = "/notice";
      },
      error(error){
        console.error(error);
        alert("문제가 발생하였습니다.");
      }
    });
  }
</script>


