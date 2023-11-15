// 생성된 marker 담는 전역변수
const markerList = [];

// 생성된 marker의 info를 담는 전역변수
const infowindowList = [];
$(document).ready(function () {

    // map 초기옵션 설정객체
    const mapOptions = {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        zoom: 10
    };

    // id="map" 인 html에 네이버지도 객체생성
    const map = new naver.maps.Map('map', mapOptions);

    // 비동기로 매장정보를 가져와 지도에 마커를 표시하고 전역변수에 정보저장하는 함수 호출
    getStores(map);

    // 현재위치를 한번만 누르게 하기 위해서 변수 설정
    let currentUse = true;

    // 현재위치버튼 클릭 시 현재위치로 이동하는 함수 호출
    currentPosition(currentUse);

});

// 비동기로 매장정보를 가져와 지도에 마커를 표시하고 전역변수에 정보저장하는 함수
function getStores(map) {
    $.ajax({
        type: "GET",
        url: `/stores`,
        success: function (response) {
            // stores 의 정보를 하나씩 불러옴
            for(let target of response.data){
                // 네이버 맵 위에 위치를 나타낼 마커 객체 생성
                const marker = new naver.maps.Marker({
                    map: map,
                    position: new naver.maps.LatLng(target.lng, target.lat),
                    icon: {
                        content: "<div class='marker'></div>",
                        anchor: new naver.maps.Point(12,12)
                    }
                });
                // marker를 클릭하면 보여줄 content 변수 작성
                const content = `<div class='infowindow_wrap'>
                    <div class='infowindow_name'>매장명 : ${target.name}</div>
                    <div class='infowindow_mainMenu'>주요품목 : ${target.mainMenu}</div>
                    <div class='infowindow_price'>가격 : ${target.price}</div>
                    <div class='infowindow_phone'>연락처 : ${target.phone}</div>
                    <div class='infowindow_address'>주소 : ${target.address}</div>
                   </div>`

                // 각 마커들의 정보를 InfoWindow객체에 담고 infowindow 변수에 저장
                const infowindow = new naver.maps.InfoWindow({
                    content : content, // 
                    backgroundColor : "#00ff0000", 
                    borderColor : "#00ff0000",
                    anchorSize : new naver.maps.Size(0,0)
                });

                // 각 마커에 대한 클릭이벤트
                naver.maps.Event.addListener(marker, 'click', function () {

                    // 현재 열려있는 정보창이 있는경우
                    if(infowindowList.some(infowindow => infowindow.getMap())){
                        closeAllInfoWindows();

                    // 현재 열려있는 정보창이 없는경우
                    } else {
                        closeAllInfoWindows();

                        // 정보창 보여주기
                        infowindow.open(map, marker);
                    }
                });

                // 마커와 정보창을 각각의 전역변수 리스트에 추가
                markerList.push(marker);
                infowindowList.push(infowindow);
            }
        },
        error: function (error) {
            console.error("error : ", error);
        }
    });
};

// 모든 정보창을 닫는 함수
function closeAllInfoWindows() {
    for (let i = 0; i < infowindowList.length; i++) {
        infowindowList[i].close();
    }
}

// 현재위치버튼 클릭 시 현재위치로 이동하는 함수
function currentPosition(currentUse){
    // 현재위치가 클릭되었을때
    $('#current').click(() =>{
        // 만약 브라우저가 HTML5 Geolocation API를 지원한다면(navigator은 js에서 제공되는 객체로 현재 브라우저 환경에 대한 정보를 포함하고 있다)
        if('geolocation' in navigator){
            // getCurrentPosition 메서드는 현재 위치를 비동기적으로 position 에 담아 가져온다
            navigator.geolocation.getCurrentPosition(function(position){
                const lat = position.coords.latitude;
                const lng = position.coords.longitude;
                const latlng = new naver.maps.LatLng(lat,lng);
                if(currentUse) {
                    marker = new naver.maps.Marker({
                        map: map,
                        position: latlng,
                    });
                    // 현재위치를 한번만 누르게 하기 위해서 변수 설정
                    currentUse = false;
                }
                map.setZoom(14, false); // 줌 level 은 14, 이동하는 애니메이션은 주지 않는다는 것
                map.panTo(latlng); // 지정된 경도와 위도로 지도를 이동
            });
        } else {
            // 만약 브라우저가 HTML5 Geolocation API를 지원하지 않는다면
            alert("위치정보 사용 불가능");
        }
    });
}

