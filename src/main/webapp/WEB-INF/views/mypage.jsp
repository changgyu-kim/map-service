<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<!--  Main wrapper -->
<div>
  <div class="container-fluid">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title fw-semibold mb-4">회원정보</h5>
        <div class="card">
          <div class="card-body">
              <input type="hidden" id="id" value="${sessionScope.user.id}">
              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password">
                <p style="margin-top: 5px; color: red; display: block;">문자+숫자, 8자이상, 특수문자는 선택</p>
              </div>
              <div class="mb-3">
                <label for="passwordC" class="form-label">Password Confirm</label>
                <input type="password" name="passwordC" class="form-control" id="passwordC">
              </div>
              <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" name="name" class="form-control" id="name" value="${sessionScope.user.name}">
                <p style="margin-top: 5px; color: red; display: block;">이름 한글만 가능</p>
              </div>
              <div class="mb-3">
                <label for="email" class="form-label">Email Address</label>
                <input type="email" name="email" class="form-control" id="email" value="${sessionScope.user.email}" >
              </div>
              <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" name="phone" class="form-control" id="phone" value="${sessionScope.user.phone}" >
                <p style="margin-top: 5px; color: red; display: block;">핸드폰번호 (ex. 01012345678)</p>
              </div>
              <button id="updateBtn" class="btn btn-primary">정보수정</button>
              <button id="deleateBtn" class="btn btn-danger">회원탈퇴</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</html>
<script>
  $(document).ready(function () {

      $('#deleateBtn').click(function (){
         withdraw();
      });

    $('#updateBtn').click(function () {
      if (formCheck() == true) {
        submit();
      }
    });

  });

    function formCheck() {
      let password = $('#password').val();
      let passwordC = $('#passwordC').val();
      let name = $('#name').val();
      let email = $('#email').val();
      let phone = $('#phone').val();

      let regPwd = /^(?=.*[A-Za-z])(?=.*\d).{8,15}$/;    //문자+숫자, 8자이상, 특수문자는 선택
      let regName = /^[가-힣]{2,4}$/;  //이름 한글만 가능
      let regEmail = /^[_a-z0-9-]+(.[_a-z0-9-]+)@(?:\w+\.)+\w+$/; //이메일형식 ..@...com
      let regPhone = /01[016789]\d{8}$/; // 핸드폰번호 (ex. 01012345678)

      if (password == null || password.trim() === "") {
        alert("패스워드를 입력해주세요");
        return false;
      }
      if (passwordC == null || passwordC.trim() === "") {
        alert("패스워드를 입력해주세요");
        return false;
      }
      if (!password ==  passwordC) {
        alert("두 패스워드가 일치하지 않습니다.");
        return false;
      }
      if (!regPwd.test(password)) {
        alert("패스워드를 형식에 맞게 작성해주세요");
        return false;
      }
      if (name == null || name.trim() === "") {
        alert("이름을 입력해주세요");
        return false;
      }
      if (!regName.test(name)) {
        alert("이름을 형식에 맞게 작성해주세요");
        return false;
      }
      if (email == null || email.trim() === "") {
        alert("이메일을 입력해주세요");
        return false;
      }
      if (!regEmail.test(email)) {
        alert("이메일을 형식에 맞게 작성해주세요");
        return false;
      }
      if (phone == null || phone.trim() === "") {
        alert("휴대전화번호를 입력해주세요");
        return false;
      }
      if (!regPhone.test(phone)) {
        alert("휴대전화번호를 형식에 맞게 입력해주세요");
        return false;
      }
      return true;
    }

  function submit(){
    let id = $('#id').val();
    let password = $('#password').val();
    let name = $('#name').val();
    let email = $('#email').val();
    let phone = $('#phone').val();
    $.ajax({
      url: "/user/"+id,
      type: "PATCH",
      contentType: 'application/json',
      data: JSON.stringify({"password" : password,"name":name,"email":email,"phone":phone}),
      success(data){
        console.log("data : ",data);
        alert("정보수정이 완료되었습니다.");
        location.href = "/";
      },
      error(error){
        console.error(error);
        alert("정보수정에 실패했습니다.");
      }
    })
  }

  function withdraw(){
    let id = $('#id').val();
      $.ajax({
          url: "/user/"+id,
          type: "DELETE",
          success(data){
              console.log("data : ",data);
              alert("회원탈퇴가 완료되었습니다.");
              location.href = "/";
          },
          error(error){
              console.error(error);
              alert("삭제에 실패했습니다.");
          }
      })
  }
</script>