const cardTitle = document.querySelector('.card-title');

function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}