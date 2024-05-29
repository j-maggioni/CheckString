/*document.addEventListener("DOMContentLoaded", () => {
    // elementi del DOM da manipolare
    var nazioneHTML = document.getElementById("nazione");
    let scoreHTML = document.getElementById("score");
    let capitale1 = document.getElementById("capitale1");
    let capitale2 = document.getElementById("capitale2");
    let capitale3 = document.getElementById("capitale3");
    let capitale4 = document.getElementById("capitale4");
    let nextQuestionBtn = document.getElementById("nextQuestion");
    let timerHTML = document.getElementById("timer");

    // variabili
    let arrayCapitali = [];
    let arraySoloNomi = [];
    let arrayDomande = [];
    let domandaAttuale = {};
    let score = 0;
    let timer;

    // Controllo la risposta
    const checkAnswer = (htmlelement, capitaleText) => {
        let rispostaCorretta = domandaAttuale.rispostaCorretta;
        if (rispostaCorretta === capitaleText) {
            score += 10;
            scoreHTML.textContent = score;
            htmlelement.style.backgroundColor = 'lightblue';
        } else {
            let mesg = document.getElementById("rispostaSbagliata") ;
            mesg.style.display = "block" ;
            // Nascondi l'elemento dopo un secondo
            setTimeout(() => {
                mesg.style.display = "none";
            }, 1000); // 1000 millisecondi corrispondono a 1 secondo
        }
        getNextQuestion();
    };

    // EventListeners da aggiungere
    capitale1.addEventListener('click', () => checkAnswer(capitale1, capitale1.textContent));
    capitale2.addEventListener('click', () => checkAnswer(capitale2, capitale2.textContent));
    capitale3.addEventListener('click', () => checkAnswer(capitale3, capitale3.textContent));
    capitale4.addEventListener('click', () => checkAnswer(capitale4, capitale4.textContent));

    // Recupero dati dal Json
    const recuperaPaesi = async () => {
        try {
            let response = await fetch('./resources/json/all.json');
            let responseJson = await response.json();
            responseJson.forEach((element) => {
                let paese = {
                    nome: element.name.common,
                    capitale: element.capital ? element.capital[0] : 'No capital'
                };
                arraySoloNomi.push(paese.capitale);
                arrayCapitali.push(paese);
            });
            return arrayCapitali;
        } catch (error) {
            console.log("Error while fetching data from backend, msg: " + error);
        }
    };

    // Preparo arrayDomande
    const prepareQuestions = () => {
        let arrayDomandeToReturn = [];
        arrayCapitali.forEach((paese) => {
            let questionObj = {};
            let arrayFinal = [];
            let arrayCapitaliDiverse = arraySoloNomi.filter(capitale => capitale !== paese.capitale);
            let arra3Anwsers = [...arrayCapitaliDiverse].sort(() => Math.random() - 0.5).slice(0, 3);
            arrayFinal.push(paese.capitale, arra3Anwsers[0], arra3Anwsers[1], arra3Anwsers[2]);
            questionObj.nazione = paese.nome;
            questionObj.rispostaCorretta = paese.capitale;
            questionObj.answers = [...arrayFinal].sort(() => Math.random() - 0.5);
            arrayDomandeToReturn.push(questionObj);
            arrayDomande.push(questionObj);
        });
        return arrayDomandeToReturn;
    };

    // Metodo per prendere la domanda successiva
    const getNextQuestion = async (capitale) => {
        if (arrayDomande.length === 0) {
            arrayDomande = prepareQuestions();
        }

        let DomandeEsclusaPreced = arrayDomande.filter(c => c.nazione !== capitale);
        let randomIndex = Math.floor(Math.random() * DomandeEsclusaPreced.length);
        let DomandaNonRipetuta = DomandeEsclusaPreced[randomIndex];
        domandaAttuale = DomandaNonRipetuta;

        nazioneHTML.innerHTML = DomandaNonRipetuta.nazione;
        capitale1.textContent = DomandaNonRipetuta.answers[0];
        capitale2.textContent = DomandaNonRipetuta.answers[1];
        capitale3.textContent = DomandaNonRipetuta.answers[2];
        capitale4.textContent = DomandaNonRipetuta.answers[3];

    };

    // Prima pagina del gioco
    const initializeGame = async () => {
        arrayPaesi = await recuperaPaesi();
        arrayDomande = await prepareQuestions();
        if (arrayDomande.length > 0) {
            let randomIndex = Math.floor(Math.random() * arrayDomande.length);
            let firstQuestion = arrayDomande[randomIndex];
            domandaAttuale = firstQuestion;
            nazioneHTML.innerHTML = firstQuestion.nazione;
            capitale1.textContent = firstQuestion.answers[0];
            capitale2.textContent = firstQuestion.answers[1];
            capitale3.textContent = firstQuestion.answers[2];
            capitale4.textContent = firstQuestion.answers[3];
            startTimer(120, timerHTML);
        }
    };
    initializeGame();

    // Add event listener to the next question button
    nextQuestionBtn.addEventListener('click',() => getNextQuestion() );

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
                let modal = document.getElementById("gameOverModal_gioco3")
                modal.style.display = "contents"
                document.getElementById("contenutoGioco").style.display = "none"

                var scoreField = document.getElementById("punti");
                scoreField.value = score;
            }
        }, 1000);
    };
});*/

document.getElementById('viewLeaderboardButton_gioco3').addEventListener('click', function(event) {
    event.preventDefault();

    var form = document.getElementById("giocoVO_gioco3");
    form.submit();

});