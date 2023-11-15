<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Body Wrapper -->
<html>
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
                <th scope="col">번호</th>
                <th scope="col">업종</th>
                <th scope="col">업소명</th>
                <th scope="col">주요품목</th>
                <th scope="col">가격</th>
                <th scope="col">연락처</th>
                <th scope="col">주소</th>
            </tr>
            </thead>
            <tbody id="list" class="table-group-divider">
            </tbody>
        </table>
        <div id="pageNav">
        </div>
    </div>
</div>
</html>
<script src="/js/paging.js"></script>
<script type="text/javascript" src="/js/views/store.js"></script>

