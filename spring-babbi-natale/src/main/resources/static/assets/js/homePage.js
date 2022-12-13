const cardTitle = document.querySelector('.card-title');
const cardText = document.querySelector('.card-text');

var nomeUtente = document.querySelector('#username-utente');
var tipoUtente = document.querySelector('#tipo-utente').getAttribute('value');

/* ---------------------------- END VARs & CONSTs --------------------------- */

cardTitle.textContent=nomeUtente.getAttribute('value');

window.addEventListener('load',()=>{
    console.log(tipoUtente);
    console.log(typeof tipoUtente);

    if(tipoUtente == 'admin'){
        cardText.textContent='amministratore';
    }else{
        cardText.textContent='babbo natale';
    }
})