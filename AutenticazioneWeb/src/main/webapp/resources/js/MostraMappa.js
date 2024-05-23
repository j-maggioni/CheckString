 var map = L.map('map').setView([14.5995, 120.9842], 4);

        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

        // Impostazioni per lo zoom
        var zoomLevel = 4;
        var zoomIncrement = 2;

        // Aggiungi evento mouseover per ingrandire la mappa
        map.on('mouseover', function (e) {
            zoomLevel += zoomIncrement;
            map.setZoom(zoomLevel);
        });

        // Aggiungi evento mouseout per ripristinare lo zoom normale
        map.on('mouseout', function (e) {
            zoomLevel = 4;
            map.setZoom(zoomLevel);
        });

        L.marker([14.5995, 120.9842]).addTo(map)
            .bindPopup('<b>Gioco 1</b><br>Nazioni');

        L.marker([18.000000, 121.000000]).addTo(map)
            .bindPopup('<b>Gioco 2</b><br> Bandiere');

        L.marker([10.193000, 119.204560]).addTo(map)
            .bindPopup('<b>Gioco 3</b><br>Capitali');