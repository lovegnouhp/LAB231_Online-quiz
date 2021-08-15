/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkAnswers() {
    var answers = document.getElementsByName("answer");
    var check = 0;
    for (var answer of answers) {
        if (answer.checked) {
            check++;
        }
    }
    if (check === 4) {
        alert("Answers must not all correct.");
        return false;
    }
    if (check === 0) {
        alert("You must choose at least a correct answer.");
        return false;
    }
    return true;
}

function checkNumOfQuest() {
    var total = parseInt(document.getElementById("total-quest").value, 10);
    var numOfQuests = parseInt(document.getElementById("num-of-quest").value, 10);
    if (numOfQuests > 0 && numOfQuests <= total) {
        return true;
    } else {
        alert("Number of questions must from 1 to " + total);
        //console.log(numOfQuests);
        //console.log(total);
        return false;
    }
}

function startTimer() {
    var myTimer = setInterval(function () {
        let now = new Date().getTime();
        let expiredTime = document.getElementById("expired-time").value;
        let distance = expiredTime - now;
        if (distance <= 0) {
            clearInterval(myTimer);
            document.getElementById("question-form").submit();
            return;
        }
//        console.log("exp:" + expiredTime);
//        console.log("now:" + now);
//        console.log("dis:" + distance);

        // time calculations for minutes and seconds
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

        var string = (minutes < 10 ? "0" + minutes : minutes) +
                ":" +
                (seconds < 10 ? "0" + seconds : seconds);
        document.getElementById("timer").innerHTML = string;
    }, 1000);
}
