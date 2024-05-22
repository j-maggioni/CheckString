// Funzione per ottenere e inserire le immagini dall'API
function getImagesFromAPI() {
    // Effettua la chiamata all'API per ottenere i dati sui paesi
    fetch('https://restcountries.com/v3.1/all')
    .then(response => response.json())
    .then(data => {

        data.sort(() => Math.random() - 0.5);
        // Ottieni la div del carousel-inner
        const carouselInner = document.querySelector('.carousel-inner');
        
        // Itera attraverso i dati dei paesi
        data.forEach((country, index) => {
            // Controlla se l'URL dell'immagine della bandiera è disponibile nell'oggetto paese corrente
            if (country.flags && country.flags.svg) {
                // Crea un elemento div per ogni immagine
                const carouselItem = document.createElement('div');
                carouselItem.classList.add('carousel-item');
                // Imposta la classe active solo per il primo elemento
                if (index === 0) {
                    carouselItem.classList.add('active');
                }

                // Crea un elemento img e imposta i suoi attributi
                const img = document.createElement('img');
                img.src = country.flags.svg; // Ottieni l'URL dell'immagine della bandiera del paese corrente
                img.classList.add('d-block', 'w-100');
                img.alt = `Bandiera di ${country.name.common}`;

                // Aggiungi l'elemento img al carousel-item
                carouselItem.appendChild(img);

                // Aggiungi il carousel-item al carousel-inner
                carouselInner.appendChild(carouselItem);
            }
        });
})
.catch(error => console.error('Errore durante il recupero dei dati dei paesi dall\'API:', error));
}

// Chiama la funzione per ottenere e inserire le immagini dall'API
getImagesFromAPI();
