<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
                  착한가격매장찾기
                </a>
              </strong>
            </div>
            <div class="card mb-0">
              <div class="card-body">
                <p><H1 class="text-center">로그인</H1></p>
                  <div class="mb-3">
                    <label for="loginId" class="form-label">Id</label>
                    <input type="text" name="loginId" class="form-control" id="loginId" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="password">
                  </div>
                  <button id="loginBtn" type="submit" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Sign In</button>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">회원가입을 하시겠습니까?</p>
                    <a class="text-primary fw-bold ms-2" href="/sign-up">회원가입하기</a>
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

      $('#loginBtn').click(function (){
        if(formCheck() == true){
          submit();
        }
      });


    });
    function formCheck() {
      let loginId = $('#loginId').val();
      let password = $('#password').val();
      if (loginId == null || loginId.trim() === "") {
        alert("Id cannot be empty");
        return false;
      }
      if (password == null || password.trim() === "") {
        alert("Password cannot be empty");
        return false;
      }
      return true;
    }
    function submit(){
      let loginId = $('#loginId').val();
      let password = $('#password').val();
      $.ajax({
        url: "/sign-in",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify({"loginId" : loginId, "password" : password}),
        success(data){
          console.log(data);
          alert("로그인이 완료되었습니다.");
          location.href = "/";
        },
        error(error){
          console.error(error);
          alert("아이디 또는 패스워드가 일치하지 않습니다.");
        }
      })
    }

  </script>
</body>
</html>

