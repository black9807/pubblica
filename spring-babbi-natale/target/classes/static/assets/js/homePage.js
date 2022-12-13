const cardTitle = document.querySelector('.card-title');

var nomeUtente = document.querySelector('#username-utente');
var tipoUtente = document.querySelector('#tipo-utente').getAttribute('value');

cardTitle.textContent=nomeUtente.getAttribute('value');