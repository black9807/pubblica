const cardTitle = document.querySelector('.card-title');
const body = document.querySelector('#infos');
const urlSacchi = "http://localhost:9013/api/sacchi"
const urlBabbi = "http://localhost:9013/api/utentiByTipo/utente"


var td2= document.createElement('td');
var td3 = document.createElement('td');

function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

function newFunction(row,td3){

    var td3 = document.createElement('tr');
    td3.textContent = 'ciao';
    var td2 = document.createElement('tr');
    td2.classList.add('d-flex','justify-content-between')

    var select = document.createElement('select');
    select.classList.add('form-select', 'w-50');
    select.setAttribute('name', 'saccoId');

    var button = document.createElement('button');
    button.setAttribute('type', 'submit');
    button.classList.add('btn', 'btn-light');
    button.textContent = 'Apply Changes';

    fetch(urlSacchi).then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            var option = document.createElement('option');
            var nome = element.nome;
            var id = element.id;

            option.textContent = nome + "-" + id;
            option.setAttribute('value', id);

            select.appendChild(option);

            td2.appendChild(select);
            td2.appendChild(button);
            row.appendChild(td2);
            
        })
    })
    
}

function fillTable(){
    
    fetch(urlBabbi)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            var row = document.createElement('tr');
            var td1 = document.createElement('td');
            var td3 = document.createElement('td');
            var nome = element.nome;
            td1.textContent = nome;
            var id = document.createElement('input');
            id.setAttribute('value', element.id);
            id.setAttribute('type', 'hidden');
            id.setAttribute('name', 'babboId')
            td1.appendChild(id);
            row.appendChild(td1);
            
            
            newFunction(row,td3);
            row.appendChild(td3)
            body.appendChild(row)
        });
        
    })
    
    

}

fillTable()
cardNameValue()