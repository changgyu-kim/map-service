<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Body Wrapper -->
<html>
<link rel="stylesheet" type="text/css" href="/css/views/notice.css">
<div class="container text-center">
    <div class="row">
        <div class="col-3">
            <input id="keywordSearch" class="form-control" name="keyword" type="search" placeholder="검색어를 입력해주세요">
        </div>
        <div class="col-1">
            <button id="searchBtn" class="btn btn-outline-success" type="button">Search</button>
        </div>
    </div>
    <div class="row">
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
</div>
</html>
<script src="/js/paging.js"></script>
<script type="text/javascript" src="/js/views/notice.js"></script>

