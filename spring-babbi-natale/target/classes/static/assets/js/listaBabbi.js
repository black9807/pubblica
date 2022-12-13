const cardTitle = document.querySelector('.card-title');

const row = document.querySelector('#babbo-info');

const url = "http://localhost:9013/api/utentiByTipo/utente";




function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

cardNameValue();


    fetch(url)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            var td = document.createElement('td');
            td.textContent = element.nome;
            var td2 = document.createElement('td');
            td2.textContent = element.mezzoTrasporto;
            var td3 = document.createElement('td');
            td3.textContent = element.zona;

            row.appendChild(td);
            row.appendChild(td2);
            row.appendChild(td3);
            
        });

})
