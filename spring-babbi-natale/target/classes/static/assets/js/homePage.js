const cardTitle = document.querySelector('.card-title');
const cardText = document.querySelector('.card-text');
const buttonsAdmin = document.querySelectorAll('#btn-admin');
const buttonSanta = document.querySelector('#btn-santa');
const ul = document.querySelector('#list-btn');

var tipoUtente = document.querySelector('#tipo-utente').getAttribute('value');

/* ---------------------------- END VARs & CONSTs --------------------------- */

function cardNameValue(){
    cardTitle.textContent = sessionStorage.getItem('username');
    // console.log(sessionStorage.getItem('username'));
}

function changeCard(){
    if(tipoUtente == 'admin'){
        cardText.textContent='amministratore';
    }else{
        cardText.textContent='babbo natale';
    }
}

function changeNav(){
    if(tipoUtente == 'utente'){
        buttonsAdmin.forEach(button=>{
            button.setAttribute('hidden','')
        });

        buttonSanta.removeAttribute('hidden');
       
        changeClass();

    }else{
        null
    }
}

function changeClass(){
    ul.classList.remove('justify-content-evenly')
    ul.classList.add('justify-content-center')

    buttonSanta.classList.add('ms-5');
}

/* ------------------------------ END FUNCTIONs ----------------------------- */

window.addEventListener('load',()=>{
    changeCard();
    changeNav();  
    cardNameValue();
})