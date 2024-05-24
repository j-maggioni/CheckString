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
        <div id="world" style="position: absolute; top: 0; left: 0; z-index: 2;"></div>
        <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel" data-pause="false" data-interval="4000" style="position: relative;">
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
                    renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true }); // Imposta alpha su true per renderizzare lo sfondo trasparente
                    renderer.setSize(window.innerWidth, window.innerHeight);
                    renderer.setClearColor(0x000000, 0); // Imposta il colore di sfondo su trasparente
                    document.getElementById('world').appendChild(renderer.domElement);

                    // Caricamento della texture del mondo
                    const textureLoader = new THREE.TextureLoader();
                    const texture = textureLoader.load('https://threejs.org/examples/textures/land_ocean_ice_cloud_2048.jpg');

                    // Creazione dei segmenti della Terra
                    createSegment(texture, 0, 'game1.html', 0x5F9EA0, 0.6); // Blu
                    createSegment(texture, 2 * Math.PI / 3, 'game2.html', 0xCD853F, 0.6); // Marrone
                    createSegment(texture, 4 * Math.PI / 3, 'game3.html', 0x32CD32, 0.6); // Verde

                    // Creazione del raycaster e del mouse
                    raycaster = new THREE.Raycaster();
                    mouse = new THREE.Vector2();

                    // Aggiungere eventi di clic per i segmenti
                    window.addEventListener('click', onGlobeClick);

                    animate();
                }

                function createSegment(texture, rotationY, url, color, opacity) {
                    // Creazione della geometria per il segmento della sfera
                    const geometry = new THREE.SphereGeometry(1, 64, 64, rotationY, 2 * Math.PI / 3);

                    // Applicazione della texture
                    const material = new THREE.MeshBasicMaterial({ map: texture, side: THREE.DoubleSide, color: color, transparent: true, opacity: opacity });

                    // Creazione del segmento
                    const segment = new THREE.Mesh(geometry, material);
                    segment.rotation.y = rotationY;
                    segment.userData.url = url;

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

                window.onload = init;
            </script>
        </body>
</html>
