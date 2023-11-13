<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!--  Body Wrapper -->
    <input type="hidden" id="id" value="${id}">
    <div id="info"></div>
    <div>
        <c:if test="${sessionScope.user.loginId == notice.writer}">
        <a id="updateBtn" href="/notice-update/${id}" class="btn btn-primary m-1" >Update</a>
        <button id="deleteBtn" class="btn btn-primary m-1" >Delete</button>
        </c:if>
        <button id="backBtn" class="btn btn-primary m-1" type="button">Back</button>
    </div>

</html>
<script type="text/javascript" src="/js/views/noticeDetail.js"></script>


