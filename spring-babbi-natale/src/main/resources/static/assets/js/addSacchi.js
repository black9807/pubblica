const cardTitle = document.querySelector('.card-title');
const body = document.querySelector('#infos');
const urlSacchi = "http://localhost:9013/api/sacchi"
const urlBabbi = "http://localhost:9013/api/utentiByTipo/utente"


var td2= document.createElement('td');
var td3 = document.createElement('td');

function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

function fillTable(){
    
    fetch(urlBabbi)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            var row = document.createElement('tr');
            var td1 = document.createElement('td');
            var nome = element.nome;
            td1.textContent = nome;
            row.appendChild(td1);
            body.appendChild(row)
        });
    })

   

}

fillTable()
cardNameValue()