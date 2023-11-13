<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Body Wrapper -->
<html>
<div>
    <input id="search" class="form-control mr-sm-2" name="keyword" type="search" placeholder="Search" aria-label="Search">
    <button id="searchBtn" class="btn btn-outline-success my-2 my-sm-0" type="button">Search</button>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
        </tr>
        </thead>
        <tbody id="list" class="table-group-divider">
        </tbody>
    </table>
    <div id="pageNav">

    </div>
    <div>
        <c:if test="${sessionScope.user != null}">
        <a href="/notice-write" class="btn btn-outline-success my-2 my-sm-0"  type="button">Write</a>
        </c:if>
    </div>
</div>
</html>
<script src="/js/paging.js"></script>
<script type="text/javascript" src="/js/views/notice.js"></script>

