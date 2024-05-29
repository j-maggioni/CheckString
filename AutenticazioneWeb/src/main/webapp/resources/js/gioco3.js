document.addEventListener("DOMContentLoaded", () => {

    // elementi del DOM da manipolare
    let scoreHTML = document.getElementById("score");
    let nazione1HTML = document.getElementById("nazione1");
    let nazione2HTML = document.getElementById("nazione2");
    let nazione3HTML = document.getElementById("nazione3");
    let nazione4HTML = document.getElementById("nazione4");
    let timerHTML = document.getElementById("timer");
    let bottone_next = document.getElementById("btn_next");

    // variabili
    let arrayPaesiInMappa = [];  // code + name 
    let arraySoloNomi = [];
    let arrayDomande = [];
    let arrayDomandeGiaFatte = [];
    let domandaAttuale = {};
    let score = 0;
    let timer;

    // extract from html --> array of countries
    const extractPaesiFromHtml = () => {
        const paths = document.querySelectorAll('.ag-canvas_svg path');
        paths.forEach((path) => {
            let nazione = {};
            const code = path.getAttribute('id').toString();
            const nome = path.getAttribute('title').toString();
            nazione.code = code;
            nazione.nome = nome;
            arraySoloNomi.push(nome);
            arrayPaesiInMappa.push(nazione);
        });
    }
    extractPaesiFromHtml();

    // Preparo arrayDomande
    const prepareQuestions = () => {
        let arrayDomandeToReturn = [];
        arrayPaesiInMappa.forEach(nazione => {
            let questionObj = {};
            let arrayFinal = [];
            let arrayPaesiSbagliati = arraySoloNomi.filter(nome => nome !== nazione.nome);
            let arra3Anwsers = [...arrayPaesiSbagliati].sort(() => Math.random() - 0.5).slice(0, 3);
            arrayFinal.push(nazione.nome, arra3Anwsers[0], arra3Anwsers[1], arra3Anwsers[2]);
            questionObj.paeseDaFillare = nazione.code; // id dell path
            questionObj.rispostaCorretta = nazione.nome; // tag Title
            questionObj.answers = [...arrayFinal].sort(() => Math.random() - 0.5);
            arrayDomandeToReturn.push(questionObj);
            arrayDomande.push(questionObj);
        });
        return arrayDomandeToReturn;
    };
    prepareQuestions();

    const getNextQuestion = () => {
        if (arrayDomande.length === 0) {
            arrayDomande = prepareQuestions();
        }
        document.getElementById(domandaAttuale.paeseDaFillare).style.fill = "#59616e"; // #383d46  F00
        let arrayX = arrayDomande.filter(domanda => {
            return !arrayDomandeGiaFatte.some(domandaFatta => domanda.paeseDaFillare === domandaFatta.paeseDaFillare);
        });
        if (arrayX.length === 0) return;
        let randomIndex = Math.floor(Math.random() * arrayX.length);
        let domandaDaFare = arrayX[randomIndex];
        document.getElementById(domandaDaFare.paeseDaFillare).style.fill = "#F00"; // #383d46  F00
        nazione1HTML.textContent = domandaDaFare.answers[0];
        nazione2HTML.textContent = domandaDaFare.answers[1];
        nazione3HTML.textContent = domandaDaFare.answers[2];
        nazione4HTML.textContent = domandaDaFare.answers[3];
        domandaAttuale = domandaDaFare;
        arrayDomandeGiaFatte.push(domandaDaFare);
    };

    // Prima pagina del gioco
    const initializeGame = async () => {
        if (arrayDomande.length > 0) {
            let randomIndex = Math.floor(Math.random() * arrayDomande.length);
            let firstQuestion = arrayDomande[randomIndex];
            document.getElementById(firstQuestion.paeseDaFillare).style.fill = "#F00"; // #383d46  F00
            nazione1HTML.textContent = firstQuestion.answers[0];
            nazione2HTML.textContent = firstQuestion.answers[1];
            nazione3HTML.textContent = firstQuestion.answers[2];
            nazione4HTML.textContent = firstQuestion.answers[3];
            domandaAttuale = firstQuestion;
            arrayDomandeGiaFatte.push(firstQuestion);
            startTimer(5, timerHTML);
        }
    };

    // Add event listener to the next question button
    bottone_next.addEventListener('click', getNextQuestion);
    // Funzione per avviare il timer
    const startTimer = (duration, display) => {
        let timer = duration, minutes, seconds;
        let interval = setInterval(() => {
            minutes = parseInt(timer / 60, 10);
            seconds = parseInt(timer % 60, 10);
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
            display.textContent = minutes + ":" + seconds;

            if (--timer < 0) { // quando scade il timer
                clearInterval(interval);
                document.getElementById("contenutoGioco").classList.add('hidden'); 
                document.getElementById("nextQuestion").classList.add('hidden');
                let modal = document.getElementById("gameOverModal_gioco3");
                modal.style.display = "contents";
                var scoreField = document.getElementById("punti");
                scoreField.value = score;
            }
        }, 1000);
    };

    initializeGame();

    // Controllo la risposta
    const checkAnswer = (sceltaText) => {
        let rispostaCorretta = domandaAttuale.rispostaCorretta;
        if (rispostaCorretta === sceltaText) {
            score += 10;
            scoreHTML.textContent = score;
        } else { // se la risposta è sbagliata
            let messaggioErrore = document.getElementById("rispostaSbagliata");
            messaggioErrore.style.display = "block";
            // Nascondi l'elemento dopo un secondo
            setTimeout(() => {
                messaggioErrore.style.display = "none";
            }, 1000);
        }
        getNextQuestion();
    };
    // EventListeners da aggiungere
    nazione1HTML.addEventListener('click', () => checkAnswer(nazione1HTML.textContent));
    nazione2HTML.addEventListener('click', () => checkAnswer(nazione2HTML.textContent));
    nazione3HTML.addEventListener('click', () => checkAnswer(nazione3HTML.textContent));
    nazione4HTML.addEventListener('click', () => checkAnswer(nazione4HTML.textContent));
});
