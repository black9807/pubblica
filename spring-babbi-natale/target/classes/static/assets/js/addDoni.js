var row = document.createElement('tr');
var select = document.createElement('select');
select.classList.add('form-select','w-50');
select.setAttribute('name','saccoId');

var td1 = document.createElement('td');
var td2 = document.createElement('td');
var td3 = document.createElement('td');
td3.classList.add('d-flex','justify-content-between');

var button = document.createElement('button');
button.setAttribute('type','submit');
button.classList.add('btn','btn-light');
button.textContent='Apply Changes';


const cardTitle = document.querySelector('.card-title');

const body = document.querySelector('#infos');

const urlBimbo = "http://localhost:9013/api/bimbi";

const urlSacchi = "http://localhost:9013/api/sacchi";


function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}


function fillTable() {
    fetch(urlBimbo)
    .then(data => { return data.json(); })
    .then(resp => {
        resp.forEach(element => {
            
            td1.textContent = element.nome;
            var id = document.createElement('input');
            id.setAttribute('value',element.id);
            id.setAttribute('type','hidden');
            id.setAttribute('name','bimboId')
            td1.appendChild(id);
            
            element.doni.forEach(element => {
                var nomeDono = element.nome;
                td2.textContent = nomeDono;
            });
            
            
            
        });
        
        
        
        fetch(urlSacchi)
        .then(data => { return data.json(); })
        .then(resp => {
                resp.forEach(element => {

                    var option = document.createElement('option');
                    
                    var nome = element.nome;
                    var id = element.id;
                    
                    option.textContent = nome + "-" + id;
                    option.setAttribute('value',id);
                    
                    select.appendChild(option);
                    
                    td3.appendChild(select);
                    td3.appendChild(button);
                    
                    
                });
                
                
            });
            
            row.appendChild(td1);
            row.appendChild(td2);
            row.appendChild(td3);
            
            body.appendChild(row);
            
            
        });
}
    
fillTable();
cardNameValue();