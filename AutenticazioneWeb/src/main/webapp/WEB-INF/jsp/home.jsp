<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <%@ include file="includes.jsp" %>
</head>
<body>
 <div class="title-container">
        <h1 class = "permanent-marker-regular">Pippo Adventures <img src = "./resources/img/pippo.png" width = "100"> </h1>
 </div>
 <div id="messaggioBenvenuto">
    <p class="montserrat" id="typewriter"></p>
 </div>
 <div id="world" style="position: absolute;top: 100px; z-index: 2;">
 <svg id="map-icon" xmlns="http://www.w3.org/2000/svg" width="64" height="64" fill="#665687" class="bi bi-cursor-fill" viewBox="0 0 16 16">
      <path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103z"/>
 </svg>
 </div>
 <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel" data-pause="false" data-interval="4000" style="position: relative; z-index: 0;">
    <div class="carousel-inner"></div>
 </div>
 <div id="accediMex" class="montserrat"> Devi registrarti o accedere prima di giocare! </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/three.js/r128/three.min.js"></script>
<script>
    let scene, camera, renderer, raycaster, mouse, segments = [];
    let isUserLogged = <%= (session.getAttribute("utente") != null) %>

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
        const texture1 = textureLoader.load('./resources/img/1.png');
        const texture2 = textureLoader.load('./resources/img/2.png');
        const texture3 = textureLoader.load('./resources/img/3.png');

        // Creazione dei segmenti della Terra
        createSegment(texture1, 0, 'indovina_bandiera', 0xFFFFFF, 0.9); // Bianco
        createSegment(texture2, 2 * Math.PI / 3, 'indovina_capitale', 0xFFFFFF, 0.9); // Bianco
        createSegment(texture3, 4 * Math.PI / 3, 'indovina_nazione', 0xFFFFFF, 0.9); // Bianco

        // Creazione del raycaster e del mouse
        raycaster = new THREE.Raycaster();
        mouse = new THREE.Vector2();

        // Aggiungere eventi di clic per i segmenti
        window.addEventListener('click', onGlobeClick);
        window.addEventListener('mousemove', onDocumentMouseMove);

        // Aggiungere l'evento di resize
        window.addEventListener('resize', onWindowResize);

        animate();
        typewriterEffect();
    }

    function createSegment(texture, rotationY, url, color, opacity, utente) {
        // Creazione della geometria per il segmento della sfera
        const geometry = new THREE.SphereGeometry(1.5, 64, 64, rotationY, 2 * Math.PI / 3);

        // Applicazione della texture
        const material = new THREE.MeshBasicMaterial({ map: texture, side: THREE.DoubleSide, color: color, transparent: true, opacity: opacity });

        var u = (isUserLogged) ? url : 'home';

        // Creazione del segmento
        const segment = new THREE.Mesh(geometry, material);
        segment.rotation.y = rotationY;
        segment.userData.url = u;
        scene.add(segment);
        segments.push(segment);
    }

    function animate() {
        requestAnimationFrame(animate);

        // Rotazione della sfera
        segments.forEach(segment => {
            segment.rotation.y += 0.006;
        });

        renderer.render(scene, camera);
    }

    function onGlobeClick(event) {
        mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
        mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;

        raycaster.setFromCamera(mouse, camera);
        const intersects = raycaster.intersectObjects(segments);

        if (intersects.length > 0) {
                const clickedSegment = intersects[0].object;
                const url = clickedSegment.userData.url;

                if (url !== 'home') {
                    window.location.href = url;
                } else {
                    document.getElementById('accediMex').style.display = "inline";

                    setTimeout(function() {
                       document.getElementById('accediMex').style.display = "none";
                    }, 5000);
                }
            }
    }

    function onDocumentMouseMove(event) {
        mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
        mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;

        raycaster.setFromCamera(mouse, camera);
        const intersects = raycaster.intersectObjects(segments);

        if (intersects.length > 0) {
            if (intersects[0].distance < camera.position.z) {
                segments.forEach(segment => {
                    segment.material.opacity = 0.6;
                });
                intersects[0].object.material.opacity = 1;
            }
        } else {
            segments.forEach(segment => {
                segment.material.opacity = 0.8;
            });
        }
    }

    function onWindowResize() {
        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(window.innerWidth, window.innerHeight);
    }

    function typewriterEffect() {
                const text = "Benvenuto su PippoAdventures! Registrati o effettua il login per iniziare una nuova avventura! Poi clicca sul mappamondo per scoprire i tre giochi disponibili! Buon divertimento!";
                let i = 0;
                const speed = 30; // Velocità della macchina da scrivere in millisecondi

                function typeWriter() {
                    if (i < text.length) {
                        document.getElementById("typewriter").innerHTML += text.charAt(i);
                        i++;
                        setTimeout(typeWriter, speed);
                    }
                }

                typeWriter();
            }


    window.onload = init;

    </script>

</body>
</html>
