<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<!-- Main wrapper -->
<div>
    <!-- 검색바 -->
    <div id="search" class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <form class="d-flex" role="search">
                <input id="search_input" class="form-control me-2" type="search" placeholder="Enter address" aria-label="Search">
                <button id="search_button" class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>

    <!--현재위치 클릭박스 -->
    <button id="current" type="button" class="text-decoration-none btn btn-light">현재위치</button>
    <!-- 화면에 네이버지도를 출력 -->
    <div id="map" style="width:100%;height:100vh;"></div>
</div>
</html>
<script type="text/javascript" src="/js/views/index.js"></script>
