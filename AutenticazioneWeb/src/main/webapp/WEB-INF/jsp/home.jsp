<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <%@ include file="includes.jsp" %>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
    <style>
        .permanent-marker-regular {
          font-family: "Permanent Marker", cursive;
          font-weight: 400;
          font-style: normal;
        }

    </style>
</head>
<body>
 <div class="title-container">
        <h1 class = "permanent-marker-regular">Pippo Adventures</h1>
    </div>
<div id="world" style="position: absolute; top: 50px; z-index: 2;"></div>
<div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel" data-pause="false" data-interval="4000" style="position: relative; z-index: 0;">
    <div class="carousel-inner"></div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/three.js/r128/three.min.js"></script>
<script>
    let scene, camera, renderer, raycaster, mouse, segments = [];

    function init() {
        // Creazione della scena
        scene = new THREE.Scene();

        // Creazione della camera
        camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
        camera.position.z = 5;

        // Creazione del renderer
        renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true });
        renderer.setSize(window.innerWidth, window.innerHeight);
        renderer.setClearColor(0x000000, 0);
        document.getElementById('world').appendChild(renderer.domElement);

        // Caricamento della texture del mondo
        const textureLoader = new THREE.TextureLoader();
        const texture = textureLoader.load('./resources/img/bandiera.png');

        // Creazione dei segmenti della Terra
        createSegment(texture, 0, 'indovina_bandiera', 0x5F9EA0, 0.9); // Blu
        createSegment(texture, 2 * Math.PI / 3, 'indovina_capitale', 0xCD853F, 0.9); // Marrone
        createSegment(texture, 4 * Math.PI / 3, 'indovina_nazione', 0x32CD32, 0.9); // Verde

        // Creazione del raycaster e del mouse
        raycaster = new THREE.Raycaster();
        mouse = new THREE.Vector2();

        // Aggiungere eventi di clic per i segmenti
        window.addEventListener('click', onGlobeClick);
        window.addEventListener('mousemove', onDocumentMouseMove);

        animate();
    }

    function createSegment(texture, rotationY, url, color, opacity) {
        // Creazione della geometria per il segmento della sfera
        const geometry = new THREE.SphereGeometry(1.5, 64, 64, rotationY, 2 * Math.PI / 3);

        // Applicazione della texture
        const material = new THREE.MeshBasicMaterial({ map: texture, side: THREE.DoubleSide, color: color, transparent: true, opacity: opacity });

        // Creazione del segmento
        const segment = new THREE.Mesh(geometry, material);
        segment.rotation.y = rotationY;
        segment.userData.url = url;

        // Aggiunta degli eventi per l'effetto visivo
        segment.onmouseenter = function () {
            segment.material.opacity = 0.9;
            segment.scale.set(1.1, 1.1, 1.1);
        };

        segment.onmouseleave = function () {
            segment.material.opacity = opacity;
            segment.scale.set(1, 1, 1);
        };

        scene.add(segment);
        segments.push(segment);
    }

    function animate() {
        requestAnimationFrame(animate);

        // Rotazione della sfera
        segments.forEach(segment => {
            segment.rotation.y += 0.006; // Aumenta la velocità di rotazione
        });

        renderer.render(scene, camera);
    }

    function onGlobeClick(event) {
        // Calcolare la posizione del clic
        mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
        mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;

        raycaster.setFromCamera(mouse, camera);
        const intersects = raycaster.intersectObjects(segments);

        if (intersects.length > 0) {
            const clickedSegment = intersects[0].object;
            window.location.href = clickedSegment.userData.url;
        }
    }

    function onDocumentMouseMove(event) {
        // Calcolare la posizione del mouse
        mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
        mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;

        raycaster.setFromCamera(mouse, camera);
        const intersects = raycaster.intersectObjects(segments);

        if (intersects.length > 0) {
            // Evidenzia lo spicchio sopra cui si trova il mouse solo se non si trova sopra l'area del mondo
            if (intersects[0].distance < camera.position.z) {
                segments.forEach(segment => {
                    segment.material.opacity = 0.6;
                });
                intersects[0].object.material.opacity = 1;
            }
        } else {
            // Ripristina l'opacità normale se il mouse non è sopra alcuno spicchio
            segments.forEach(segment => {
                segment.material.opacity = 0.8;
            });
        }
    }

    window.onload = init;
</script>

</body>
</html>
