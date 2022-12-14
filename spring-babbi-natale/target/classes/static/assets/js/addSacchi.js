const cardTitle = document.querySelector('.card-title');
const body = document.querySelector('#infos');
const urlSacchi = "http://localhost:9013/api/sacchi"
const urlBabbi = "http://localhost:9013/api/utentiByTipo/utente"


var td2 = document.createElement('td');
var td3 = document.createElement('td');

function cardNameValue() {
    cardTitle.textContent = sessionStorage.getItem('username');
}

function newFunction(row,p) {

    var td3 = document.createElement('td');
    var ul = document.createElement('ul');
    var li = document.createElement('li');

    var td2 = document.createElement('tr');
    td2.classList.add('d-flex', 'justify-content-between')

    var select = document.createElement('select');
    select.classList.add('form-select', 'w-50');
    select.setAttribute('name', 'saccoId');

    var button = document.createElement('button');
    button.setAttribute('type', 'submit');
    button.classList.add('btn', 'btn-light');
    button.textContent = 'Apply Changes';



    fetch(urlSacchi).then(data => {
            return data.json()
        })
        .then(resp => {
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
    
    li.textContent=p;
    ul.appendChild(li);
    td3.appendChild(ul);
    row.appendChild(td3);
}

function fillTable() {
    
    var p;

    var select = document.createElement('select');
    select.classList.add('form-select', 'w-50');
    select.setAttribute('name', 'saccoId');

    var button = document.createElement('button');
    button.setAttribute('type', 'submit');
    button.classList.add('btn', 'btn-light');
    button.textContent = 'Apply Changes';


    fetch(urlBabbi)
        .then(data => {
            return data.json()
        })
        .then(resp => {
            resp.forEach(element => {
                
                element.sacchi.forEach(element=>{
                   var ora = element.assegnatoOra
                   var id = element.id;

                  p = ora + " sacco-" +id
                })

                var row = document.createElement('tr');
                var td1 = document.createElement('td');
                var nome = element.nome;
                td1.textContent = nome;
                var id = document.createElement('input');
                id.setAttribute('value', element.id);
                id.setAttribute('type', 'hidden');
                id.setAttribute('name', 'babboId')
                td1.appendChild(id);
                row.appendChild(td1);

                newFunction(row,p);

                body.appendChild(row)
            });

        })



}

fillTable()
cardNameValue()