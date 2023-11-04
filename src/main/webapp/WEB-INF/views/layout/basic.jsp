<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta charset="UTF-8">
    <!-- 웹페이지가 가능한 최신버전의 IE로 렌더링되도록 함 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 웹페이지가 모바일장치의 화면 크가와 뷰포트설정에 맞게 렌더링되도록 지정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>Map</title>
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <!-- css -->
    <link rel="stylesheet" href="../css/header.css" />
    <link rel="stylesheet" href="../css/style.css" />
    <!-- NAVER MAPS API를 자바스크립트에서 활용할 수 있도록 함 -->
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=mw8r74c8xu"></script>
    <!-- 카카오 목적지 API를 자바스크립트에서 활용할 수 있도록 함 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5ae6f84e4f5f3abd29cda4b36cf96f4d&libraries=services"></script>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<main>
    <tiles:insertAttribute name="aside"/>
    <tiles:insertAttribute name="body"/>
</main>
<tiles:insertAttribute name="footer"/>
</body>
</html>
