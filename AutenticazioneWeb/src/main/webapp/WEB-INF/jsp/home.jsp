<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
    <html lang="it">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
                <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
        <%@ include file="includes.jsp" %>
        </head>
        <body>
        <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
             data-pause="false" data-interval="4000">
            <div class="carousel-inner"></div>
        </div>
        <div id="map">
            <p> Benvenuti su PippoAdventures! <br>
                Il sito più divertente in grado di mettervi alla prova sulla geografia!
                Vi auguro una buona avventura!
            </p>
        </div>
        <script src="./resources/js/MostraMappa.js"></script>
        </body>
</html>
