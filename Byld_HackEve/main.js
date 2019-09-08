var count=0;
var instruct = document.getElementById("insBtn");
var pop = document.getElementById("Pg");

var meme1 = document.getElementById("meme1");
var pop1 = document.getElementById("memee");

var meme2 = document.getElementById("meme2");
var pop2 = document.getElementById("memef");

var meme3 = document.getElementById("meme3");
var pop3 = document.getElementById("memeg");

instruct.addEventListener('click', rules);
window.addEventListener('click', outsideClick);

meme1.addEventListener('click', rules1);
meme2.addEventListener('click', rules2);
meme3.addEventListener('click', rules3);

function outsideClick(e){
  if(e.target == Pg){
    pop.style.display = 'none';
  }
}
function outsideClick1(e){
  if(e.target == memee){
    pop1.style.display = 'none';
  }
}
function outsideClick2(e){
  if(e.target == memef){
    pop2.style.display = 'none';
  }
}
function outsideClick3(e){
  if(e.target == memeg){
    pop3.style.display = 'none';
  }
}

function rules(){
        pop.style.display = 'block';
        window.addEventListener('click', outsideClick);
}
function rules1(){
        pop1.style.display = 'block';
        window.addEventListener('click', outsideClick1);
}
function rules2(){
        pop2.style.display = 'block';
        window.addEventListener('click', outsideClick2);
}
function rules3(){
        pop3.style.display = 'block';
        window.addEventListener('click', outsideClick3);
}
var modal = document.getElementById('myModal');
var modala = document.getElementById('myModala');
var modalb = document.getElementById('myModalb');

var btn = document.getElementById("meme1");

var btn1 = document.getElementById("meme2");

var btn2 = document.getElementById("meme3")


var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
    modal.style.display = "block";
}
btn1.onclick = function() {
    modala.style.display = "block";
}

btn2.onclick = function() {
    modalb.style.display = "block";
}


// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var video = document.querySelectorAll('iframe');

var result1 = document.getElementById("opt1");
var dispc = document.getElementById("Resultr");
var dispi = document.getElementById("Resultw");
var result2 = document.getElementById("opt2");

result1.addEventListener('click', out1);
result2.addEventListener('click', out2);

function outsideClick4(e){
  if(e.target == Resultr){
    dispc.style.display = 'none';
  }
}
function outsideClick5(e){
  if(e.target == Resultw){
    dispi.style.display = 'none';
  }
}
var correct =0;
var incorrect =0;
function out1(){
        count = count + 1;
        correct = correct + 1;
        dispc.style.display = 'block';
        window.addEventListener('click', outsideClick4);
        modal.style.display = "none";
        var mytry = video[0].getAttribute('src');
         if(correct === 1) {
         video[0].setAttribute ("src","https://www.youtube.com/embed/xz3PbpPR6DY?autoplay=1");
         }    else if(correct ===2) {
         video[0].setAttribute ('src','https://www.youtube.com/embed/0HgNdPOZyvQ?autoplay=1');
        }
        else
          video[0].setAttribute ('src','https://www.youtube.com/embed/h3uBr0CCm58?autoplay=1');

checkCount();
}
function out2(){
        count = count + 1;
        incorrect = incorrect + 1;
        dispi.style.display = 'block';
        window.addEventListener('click', outsideClick5);
        modal.style.display = "none";
        var mytry = video[1].getAttribute('src');
         if(incorrect === 1) {
         video[1].setAttribute ('src','https://www.youtube.com/embed/cVUbpTFkDdo?autoplay=1');
         }    else if(incorrect ===2) {
         video[1].setAttribute ('src','https://www.youtube.com/embed/eVFd46qABi0?autoplay=1');
        }
        else
          video[1].setAttribute ('src','https://www.youtube.com/embed/t-bq1ScyUGI?autoplay=1');
checkCount();
}

var result3 = document.getElementById("opt3");
var result4 = document.getElementById("opt4");

result3.addEventListener('click', out3);
result4.addEventListener('click', out4);

function outsideClick6(e){
  if(e.target == Resultr){
    dispc.style.display = 'none';
  }
}
function outsideClick7(e){
  if(e.target == Resultw){
    dispi.style.display = 'none';
  }
}

span.onclick = function() {
    modala.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modala) {
        modala.style.display = "none";
    }
}

function out3(){
         count = count + 1;
         correct = correct + 1;
        dispc.style.display = 'block';
        window.addEventListener('click', outsideClick4);
        modala.style.display = "none";
        var mytry = video[0].getAttribute('src');
         if(correct === 1) {
         video[0].setAttribute ('src','https://www.youtube.com/embed/xz3PbpPR6DY?autoplay=1');
         }    else if(correct ===2) {
         video[0].setAttribute ('src','https://www.youtube.com/embed/0HgNdPOZyvQ?autoplay=1');
        }
        else
          video[0].setAttribute ('src','https://www.youtube.com/embed/h3uBr0CCm58?autoplay=1');
checkCount();
}
function out4(){
        count = count + 1;
        incorrect = incorrect + 1;
        dispi.style.display = 'block';
        window.addEventListener('click', outsideClick5);
        modala.style.display = "none";
        var mytry = video[1].getAttribute('src');
         if(incorrect === 1) {
         video[1].setAttribute ('src','https://www.youtube.com/embed/cVUbpTFkDdo?autoplay=1');
         }    else if(incorrect ===2) {
         video[1].setAttribute ('src','https://www.youtube.com/embed/eVFd46qABi0?autoplay=1');
        }
        else
          video[1].setAttribute ('src','https://www.youtube.com/embed/t-bq1ScyUGI?autoplay=1');
checkCount();
}

var result5 = document.getElementById("opt5");
var result6 = document.getElementById("opt6");

result5.addEventListener('click', out5);
result6.addEventListener('click', out6);

function outsideClick6(e){
  if(e.target == Resultr){
    dispc.style.display = 'none';
  }
}
function outsideClick7(e){
  if(e.target == Resultw){
    dispi.style.display = 'none';
  }
}

span.onclick = function() {
    modalb.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalb) {
        modalb.style.display = "none";
    }
}

function out5(){
        count = count + 1;
        correct = correct + 1;
        dispc.style.display = 'block';
        window.addEventListener('click', outsideClick4);
        modalb.style.display = "none";
        var mytry = video[0].getAttribute('src');
         if(correct === 1) {
         video[0].setAttribute ('src','https://www.youtube.com/embed/xz3PbpPR6DY?autoplay=1');
         }    else if(correct ===2) {
         video[0].setAttribute ('src','https://www.youtube.com/embed/0HgNdPOZyvQ?autoplay=1');
        }
        else
            video[0].setAttribute ('src','https://www.youtube.com/embed/h3uBr0CCm58?autoplay=1');

       checkCount();
}

function out6(){
        count = count + 1;
        incorrect = incorrect + 1;
        dispi.style.display = 'block';
        window.addEventListener('click', outsideClick5);
        modalb.style.display = "none";
        var mytry = video[1].getAttribute('src');
         if(incorrect === 1) {
         video[1].setAttribute ('src','https://www.youtube.com/embed/cVUbpTFkDdo?autoplay=1');
         checkCount();
         }    else if(incorrect ===2) {
         video[1].setAttribute ('src','https://www.youtube.com/embed/eVFd46qABi0?autoplay=1');
         
        }
        else
         video[1].setAttribute ('src','https://www.youtube.com/embed/t-bq1ScyUGI?autoplay=1');
        
      checkCount();
}
var mm = document.getElementById("ch");

function checkCount() {
if(count>=5){
    mm.style.display = 'block';
    dispi.style.display = 'none';
    dispc.style.display = 'none';
}  
}
