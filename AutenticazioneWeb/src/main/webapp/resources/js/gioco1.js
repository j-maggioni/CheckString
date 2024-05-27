document.addEventListener("DOMContentLoaded", () => {
    // elementi del DOM da manipolare
    var imgBandieraHTML = document.getElementById("imgBandiera");
    let scoreHTML = document.getElementById("score");
    let scelta1 = document.getElementById("scelta1");
    let scelta2 = document.getElementById("scelta2");
    let scelta3 = document.getElementById("scelta3");
    let scelta4 = document.getElementById("scelta4");
    let nextQuestionBtn = document.getElementById("nextQuestion");
    let timerHTML = document.getElementById("timer"); 


    // variabili
    let arrayPaesi = [];
    let arraySoloNomi = [];
    let arrayDomande = [];
    let domandaAttuale = {};
    let score = 0;
    let timer ;
    // Controllo la risposta
    const checkAnswer = (htmlelement,sceltaText) => {
        let rispostaCorretta = domandaAttuale.rispostaCorretta;
        if (rispostaCorretta === sceltaText) {
            score += 10;
            scoreHTML.textContent = score;
            htmlelement.style.backgroundColor = 'lightblue';
        } else {
            alert("Risposta Sbagliata");
          
        }
        getNextQuestion()
    };

    // EventListeners da aggiungere
    scelta1.addEventListener('click', () => checkAnswer(scelta1,scelta1.textContent));
    scelta2.addEventListener('click', () => checkAnswer(scelta2,scelta2.textContent));
    scelta3.addEventListener('click', () => checkAnswer(scelta3,scelta3.textContent));
    scelta4.addEventListener('click', () => checkAnswer(scelta4,scelta4.textContent));

    // Recupero dati dal API
    const recuperaPaesi = async () => {
        try {
            let response = await fetch('../json/all.json');
            let responseJson = await response.json();
            responseJson.forEach((element) => {
                let paese = {
                    bandiera: element.flags.png,
                    nome: element.name.common,
                    capitale: element.capital ? element.capital[0] : 'No capital' // se dovesse servire per gioco 2
                };
                arraySoloNomi.push(paese.nome);
                arrayPaesi.push(paese);
            }// } element
        ); // for each
            return arrayPaesi;
        } catch (error) {
            console.log("Error while fetching data from backend, msg: " + error);
        }
    };

    // Preparo arrayDomande
    const prepareQuestions = () => {
        let arrayDomandeToReturn = [];
        // to exclude : "United States Minor Outlying Islands" / "Similar to norway"
        arrayPaesi.forEach((paese) => {
            let questionObj = {};
            let arrayFinal = [];
            let arrayPaesiDiversi = arraySoloNomi.filter(nome => nome !== paese.nome);
            let arra3Anwsers = [...arrayPaesiDiversi].sort(() => Math.random() - 0.5).slice(0, 3);
            arrayFinal.push(paese.nome, arra3Anwsers[0], arra3Anwsers[1], arra3Anwsers[2]);
            questionObj.imgBandiera = paese.bandiera;
            questionObj.rispostaCorretta = paese.nome;
            questionObj.answers = [...arrayFinal].sort(() => Math.random() - 0.5);
            arrayDomandeToReturn.push(questionObj);
            arrayDomande.push(questionObj);
        });
        return arrayDomandeToReturn;
    };

    // Metodo per prendere la domanda successiva
    const getNextQuestion = async (imgurl) => {
        let img = "";
        if (imgurl) {
            img = imgurl;
        }
        if (arrayDomande.length === 0) {
            arrayDomande = await prepareQuestions();
        }
        let DomandeEsclusaPreced = arrayDomande.filter(dom => dom.imgBandiera !== img.src);
        let randomIndex = Math.floor(Math.random() * DomandeEsclusaPreced.length);
        let DomandaNonRipetuta = DomandeEsclusaPreced[randomIndex];
        domandaAttuale = DomandaNonRipetuta;

        imgBandieraHTML.setAttribute('src', DomandaNonRipetuta.imgBandiera);
        scelta1.textContent = DomandaNonRipetuta.answers[0];
        scelta2.textContent = DomandaNonRipetuta.answers[1];
        scelta3.textContent = DomandaNonRipetuta.answers[2];
        scelta4.textContent = DomandaNonRipetuta.answers[3];
    };

    // Prima pagina del gioco
    const initializeGame = async () => {
        arrayPaesi = await recuperaPaesi();
        arrayDomande = await prepareQuestions();
        if (arrayDomande.length > 0) {
            let randomIndex = Math.floor(Math.random() * arrayDomande.length);
            let firstQuestion = arrayDomande[randomIndex];
            domandaAttuale = firstQuestion;
            imgBandieraHTML.setAttribute('src', firstQuestion.imgBandiera);
            scelta1.textContent = firstQuestion.answers[0];
            scelta2.textContent = firstQuestion.answers[1];
            scelta3.textContent = firstQuestion.answers[2];
            scelta4.textContent = firstQuestion.answers[3];
            startTimer(120, timerHTML);
        }
    };
    initializeGame();

    // Add event listener to the next question button
    nextQuestionBtn.addEventListener('click',() => getNextQuestion() );

    // Post Score al Backend a fine lavoro
    const postScore = (score) => {
        try {
            fetch("/indovina_bandiera/salvaScore", {
                method: 'POST', 
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ score })
            })
            .then(response => response.json()) 
            .then(data => {
                console.log('Success:', data); 
                // faccio vedere il popup
            })
        } catch (error) {
            console.error('Error while posting score to the server, msg :', error); 
        }
        
    }
        // Funzione per avviare il timer
        const startTimer = (duration, display) => {
            let timer = duration, minutes, seconds;
            let interval = setInterval(() => {
                minutes = parseInt(timer / 60, 10);
                seconds = parseInt(timer % 60, 10);
    
                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;
    
                display.textContent = minutes + ":" + seconds;
    
                if (--timer < 0) {
                    clearInterval(interval);
                    postScore(score); // chiama la funzione postScore quando il timer scade
                }
            }, 1000);
        };
});