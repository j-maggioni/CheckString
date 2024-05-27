/*document.addEventListener("DOMContentLoaded", () => {
    // elementi del DOM da manipolare
    var nazioneHTML = document.getElementById("nazione");
    let scoreHTML = document.querySelector(".score");
    let capitale1 = document.getElementById("capitale1");
    let capitale2 = document.getElementById("capitale2");
    let capitale3 = document.getElementById("capitale3");
    let capitale4 = document.getElementById("capitale4");
    let nextQuestionBtn = document.getElementById("nextQuestion");

    // variabili
    let arrayCapitali = [];
    let arraySoloNomi = [];
    let arrayDomande = [];
    let domandaAttuale = {};
    let score = 0;

    // Controllo la risposta
    const checkAnswer = (htmlelement, capitaleText) => {
        let rispostaCorretta = domandaAttuale.rispostaCorretta;
        if (rispostaCorretta === capitaleText) {
            score += 10;
            scoreHTML.textContent = score;
        } else {
            alert("Risposta Sbagliata");
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
            let response = await fetch('../json/all.json');
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
        });
        return arrayDomandeToReturn;
    };

    // Metodo per prendere la domanda successiva
    const getNextQuestion = () => {
        if (arrayDomande.length === 0) {
            arrayDomande = prepareQuestions();
        }
        if (arrayDomande.length > 0) {
            let randomIndex = Math.floor(Math.random() * arrayDomande.length);
            let nextQuestion = arrayDomande.splice(randomIndex, 1)[0];
            domandaAttuale = nextQuestion;
            nazioneHTML.innerHTML = nextQuestion.nazione;
            capitale1.textContent = nextQuestion.answers[0];
            capitale2.textContent = nextQuestion.answers[1];
            capitale3.textContent = nextQuestion.answers[2];
            capitale4.textContent = nextQuestion.answers[3];
        } else {
            alert('Gioco finito! Il tuo punteggio è: ' + score);
            score = 0;
            scoreHTML.textContent = score;
            initializeGame();
        }
    };

    // Prima pagina del gioco
    const initializeGame = async () => {
        arrayCapitali = await recuperaPaesi();
        arrayDomande = prepareQuestions();
        getNextQuestion();
    };

    initializeGame();

    // Add event listener to the next question button
    nextQuestionBtn.addEventListener('click', () => getNextQuestion());
});*/
    document.addEventListener("DOMContentLoaded", () => {
        // elementi del DOM da manipolare
        var nazioneHTML = document.getElementById("nazione");
        let scoreHTML = document.querySelector(".score");
        let capitale1 = document.getElementById("capitale1");
        let capitale2 = document.getElementById("capitale2");
        let capitale3 = document.getElementById("capitale3");
        let capitale4 = document.getElementById("capitale4");
        let nextQuestionBtn = document.getElementById("nextQuestion");

        // variabili
        let arrayCapitali = [];
        let arraySoloNomi = [];
        let arrayDomande = [];
        let domandaAttuale = {};
        let score = 0;

        // Controllo la risposta
        const checkAnswer = (htmlelement, capitaleText) => {
            let rispostaCorretta = domandaAttuale.rispostaCorretta;
            if (rispostaCorretta === capitaleText) {
                score += 10;
                scoreHTML.textContent = score;
            } else {
                alert("Risposta Sbagliata");
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
                console.log("json resolt" + JSON.stringify(responseJson))
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
            if (arrayCapitali === undefined || arrayCapitali === null) {
            arrayCapitali = recuperaPaesi()
            }
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
            });
            return arrayDomandeToReturn;
        };

        // Metodo per prendere la domanda successiva
        const getNextQuestion = () => {
            if (arrayDomande.length === 0) {
                arrayDomande = prepareQuestions();
            }
            if (arrayDomande.length > 0) {
                let randomIndex = Math.floor(Math.random() * arrayDomande.length);
                let nextQuestion = arrayDomande.splice(randomIndex, 1)[0];
                domandaAttuale = nextQuestion;
                nazioneHTML.innerHTML = nextQuestion.nazione;
                capitale1.textContent = nextQuestion.answers[0];
                capitale2.textContent = nextQuestion.answers[1];
                capitale3.textContent = nextQuestion.answers[2];
                capitale4.textContent = nextQuestion.answers[3];
            } else {
                alert('Gioco finito! Il tuo punteggio è: ' + score);
                score = 0;
                scoreHTML.textContent = score;
                initializeGame();
            }
        };

        // Prima pagina del gioco
        const initializeGame = async () => {
            arrayCapitali = await recuperaPaesi();
            arrayDomande = prepareQuestions();
            getNextQuestion();
        };

        initializeGame();

        // Add event listener to the next question button
        nextQuestionBtn.addEventListener('click', () => getNextQuestion());
    });