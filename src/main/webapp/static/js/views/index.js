// store 리스트를 받아옴
let stores;

// 마커들을 담을 리스트
var markerList = [];

// 마커들의 추가정보를 담을 리스트
var infowindowList = [];
$(document).ready(function () {


    // map 위치 초기화 변수작성
    var mapOptions = {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        zoom: 10
    };

    // id가 map인 지도 출력
    var map = new naver.maps.Map('map', mapOptions);

    // 비동기로 store 리스트 가져오기
    getStores(map);

    // 현재위치를 한번만 누르게 하기 위해서 변수 설정
    let currentUse = true;

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

});

function getStores(map) {
    $.ajax({
        type: "GET",
        url: `/stores`,
        success: function (response) {
            let html = "";
/*            for (const store of response.data) {
            }*/
            stores = response.data;
            for(let target of stores){
                // for문을 돌면서 marker의 리스트를 하나씩 불러옴
                // 각 marker의 위도 경도를 latlng 변수에 담음
                let latlng = new naver.maps.LatLng(target.lng, target.lat);
                // 네이버 맵 위에 마커를 표시함
                marker = new naver.maps.Marker({
                    map: map, // 맵지도에
                    position: latlng, // 위치는 latlng에 있고
                    icon: { // 나타낼 모양은
                        content: "<div class='marker'></div>", // 이걸로 할거다
                        anchor: new naver.maps.Point(12,12)    // 아이콘의 중심은 12,12로 한다
                    }
                });
                // marker를 클릭하면 보여줄 content 변수 작성
                var content = `<div class='infowindow_wrap'>
                    <div class='infowindow_name'>${target.name}</div>
                    <div class='infowindow_mainMenu'>${target.mainMenu}</div>
                    <div class='infowindow_price'>${target.price}</div>
                    <div class='infowindow_phone'>${target.phone}</div>
                    <div class='infowindow_address'>${target.address}</div>
                   </div>`

                // 네이버 맵 위에 정보창을 표시하기위해 마커들의 정보를 infowindow 변수에 저장한다.
                var infowindow = new naver.maps.InfoWindow({
                    content : content, // 내용은 content 변수를 보여주고
                    backgroundColor : "#00ff0000", // 네이버에서 제공된 것들을 투명으로 만들고 내가 지정하기 위해 적는다
                    borderColor : "#00ff0000",
                    anchorSize : new naver.maps.Size(0,0) // infowindow가 띄워졌을 때 말풍선 형태로 꼬리가 달리게 되는 것 (설정 안해주기위해 0,0)
                });
            }
        },
        error: function (error) {
            console.error("error : ", error);
        }
    });
};



