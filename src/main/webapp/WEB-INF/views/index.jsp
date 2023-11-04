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
    <button id="current" type="button" class="text-decoration-none btn btn-Secondary">현재 위치</button>
    <!-- 화면에 네이버지도를 출력 -->
    <div id="map" style="width:100%;height:100vh;"></div>
</div>
</html>
<script>
    // map 변수를 초기화 할 때 쓸 mapOptions 변수 만들기
    var mapOptions = {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        zoom: 10
    };

    // id가 map인 지도를 mapOptions에 내용으로 초기화하여 보여줍니다.
    var map = new naver.maps.Map('map', mapOptions);
    $(document).ready(function () {

    });
</script>