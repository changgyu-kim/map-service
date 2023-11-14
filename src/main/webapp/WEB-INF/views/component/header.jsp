<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<header data-bs-theme="dark">
    <div class="p-3 border-bottom" >
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 link-light text-decoration-none">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-map" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M15.817.113A.5.5 0 0 1 16 .5v14a.5.5 0 0 1-.402.49l-5 1a.502.502 0 0 1-.196 0L5.5 15.01l-4.902.98A.5.5 0 0 1 0 15.5v-14a.5.5 0 0 1 .402-.49l5-1a.5.5 0 0 1 .196 0L10.5.99l4.902-.98a.5.5 0 0 1 .415.103zM10 1.91l-4-.8v12.98l4 .8V1.91zm1 12.98 4-.8V1.11l-4 .8v12.98zm-6-.8V1.11l-4 .8v12.98l4-.8z"/>
                    </svg>
                </a>
                <strong><a style="margin-left: 10px" href="/" class="link-light text-decoration-none">착한가격매장찾기서비스</a></strong>
                <ul style="margin-left: 100px" class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-2 link-light">매장리스트</a></li>
                    <li><a href="/notice" class="nav-link px-2 link-light">공지사항</a></li>
                </ul>

<%--                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                    <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                </form>--%>

                <div class="dropdown text-end">
                    <a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                    </a>
                    <c:if test="${sessionScope.user != null}">
                    <ul class="dropdown-menu text-small">
                        <li><a class="dropdown-item" href="/mypage">Profile</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/sign-out">Sign out</a></li>
                    </ul>
                    </c:if>
                    <c:if test="${sessionScope.user == null}">
                        <ul class="dropdown-menu text-small">
                            <li><a class="dropdown-item" href="/sign-in">Sign in</a></li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</header>
</html>
