<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Modernize Free</title>
  <link rel="shortcut icon" type="image/png" href="../images/logos/favicon.png" />
  <link rel="stylesheet" href="../css/styles.min.css" />
  <!-- bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>

<body>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="text-center" style="margin-bottom: 30px">
              <strong>
                <a style="font-size: 40px" href="/" class="link-dark text-decoration-none">
                  <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-map" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M15.817.113A.5.5 0 0 1 16 .5v14a.5.5 0 0 1-.402.49l-5 1a.502.502 0 0 1-.196 0L5.5 15.01l-4.902.98A.5.5 0 0 1 0 15.5v-14a.5.5 0 0 1 .402-.49l5-1a.5.5 0 0 1 .196 0L10.5.99l4.902-.98a.5.5 0 0 1 .415.103zM10 1.91l-4-.8v12.98l4 .8V1.91zm1 12.98 4-.8V1.11l-4 .8v12.98zm-6-.8V1.11l-4 .8v12.98l4-.8z"/>
                  </svg>
                  착한업소
                </a>
              </strong>
            </div>
            <div class="card mb-0">
              <div class="card-body">
                <p ><H1 class="text-center">회원가입</H1></p>
                  <div class="mb-3">
                    <label for="loginId" class="form-label">Id</label>
                    <input type="text" name="loginId" class="form-control" id="loginId" aria-describedby="textHelp">
                    <p style="margin-top: 5px; color: red; display: block;">영문자로 이루어진 로그인아이디, 4글자이상, 12글자 이하</p>
                  </div>
                  <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="password" aria-describedby="textHelp">
                    <p style="margin-top: 5px; color: red; display: block;">문자+숫자, 8자이상, 특수문자는 선택</p>
                  </div>
                  <div class="mb-3">
                    <label for="passwordC" class="form-label">Password Confirm</label>
                    <input type="password" name="passwordC" class="form-control" id="passwordC">
                  </div>
                  <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp">
                    <p style="margin-top: 5px; color: red; display: block;">이름 한글만 가능</p>
                  </div>
                  <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-3">
                    <label for="birth" class="form-label">Birth</label>
                    <input type="text" name="birth" class="form-control" id="birth"  aria-describedby="emailHelp">
                    <p style="margin-top: 5px; color: red; display: block;">생년월일 (ex. 19950128)</p>
                  </div>
                  <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="text" name="phone" class="form-control" id="phone"  aria-describedby="emailHelp">
                    <p style="margin-top: 5px; color: red; display: block;">핸드폰번호 (ex. 01012345678)</p>
                  </div>
                  <div class="mb-3" style="display: inline-block; margin-right: 10px;">
                    <input type="radio" name="gender" class="form-check-input gender" id="genderM" value="남" aria-describedby="emailHelp">
                    <label class="form-check-label" for="genderM">남</label>
                  </div>
                  <div class="mb-3" style="display: inline-block;">
                    <input type="radio" name="gender" class="form-check-input gender" id="genderW" value="여" aria-describedby="emailHelp">
                    <label class="form-check-label" for="genderW">여</label>
                  </div>
                  <button id="signUpBtn" type="submit" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Sign Up</button>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">이미 회원이십니까??</p>
                    <a class="text-primary fw-bold ms-2" href="/sign-in">로그인 하러가기</a>
                  </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
    $(document).ready(function (){

      $('#signUpBtn').click(function (){
        if(formCheck() == true){
          submit();
        }
      });


    });
    function formCheck() {
      let loginId = $('#loginId').val();
      let password = $('#password').val();
      let passwordC = $('#passwordC').val();
      let name = $('#name').val();
      let email = $('#email').val();
      let birth = $('#birth').val();
      let phone = $('#phone').val();
      let gender = $("input[name='gender']:checked").val();

      let regId = /^[a-zA-Z]{4,12}$/;   // 영문자로 이루어진 로그인아이디, 4글자이상, 12글자 이하
      let regPwd = /^(?=.*[A-Za-z])(?=.*\d).{8,15}$/;    //문자+숫자, 8자이상, 특수문자는 선택
      let regName = /^[가-힣]{2,4}$/;  //이름 한글만 가능
      let regEmail = /^[_a-z0-9-]+(.[_a-z0-9-]+)@(?:\w+\.)+\w+$/; //이메일형식 ..@...com
      let regBirth = /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/; // 생년월일 (ex. 19950128)
      let regPhone = /01[016789]\d{8}$/; // 핸드폰번호 (ex. 01012345678)

      if (loginId == null || loginId.trim() === "") {
        alert("아이디를 입력해주세요");
        return false;
      }
      if (!regId.test(loginId)) {
        alert("아이디를 형식에 맞게 작성해주세요");
        return false;
      }
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
      if (birth == null || birth.trim() === "") {
        alert("생년월일을 입력해주세요");
        return false;
      }
      if (!regBirth.test(birth)) {
        alert("생년월일을 형식에 맞게 입력해주세요");
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
      if (gender == null || gender.trim() === "") {
        alert("성별을 클릭해주세요");
        return false;
      }
      return true;
    }
    function submit(){
      let loginId = $('#loginId').val();
      let password = $('#password').val();
      let passwordC = $('#passwordC').val();
      let name = $('#name').val();
      let email = $('#email').val();
      let birth = $('#birth').val();
      let phone = $('#phone').val();
      let gender = $("input[name='gender']:checked").val();
      $.ajax({
        url: "/sign-up",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify({"loginId" : loginId, "password" : password,"passwordC" : passwordC, "name":name,"email":email,"birth":birth,"phone":phone,"gender" : gender}),
        success(data){
          console.log("data : ",data);
          alert("회원가입이 완료되었습니다.");
          location.href = "/sign-in";
        },
        error(error){
          console.error(error);
          alert("입력된 정보가 올바르지 않습니다.");
        }
      })
    }

  </script>
</body>
</html>
