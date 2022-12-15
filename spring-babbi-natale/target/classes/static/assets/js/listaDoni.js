const cardTitle = document.querySelector('.card-title');

const body = document.querySelector('#dono-info');

const url = "http://localhost:9013/api/doni";




function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

cardNameValue();


    fetch(url)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            var row = document.createElement('tr');
            var td = document.createElement('td');
            td.textContent = element.nome;
            var td2 = document.createElement('td');
            td2.textContent = element.disponibilita;

            row.appendChild(td);
            row.appendChild(td2);

            body.appendChild(row);

            
        });

})
