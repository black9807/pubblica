const formLogin = document.querySelector('#login');

function Utente(username,psw){
    this.username = username;
    this.password = psw;
}

(() => {
    'use strict'
    const forms = document.querySelectorAll('#login')
  
    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
      form.addEventListener('submit', event => {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }
  
        form.classList.add('was-validated')
      }, false)
    })
  })()