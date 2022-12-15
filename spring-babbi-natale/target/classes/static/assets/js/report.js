const cardTitle = document.querySelector('.card-title');

const body = document.querySelector('#report-info');

const url = "http://localhost:9013/api/sacchi";




function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

cardNameValue();


    fetch(url)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            if (element.utenti.length != 0) {
                
                var row = document.createElement('tr');
                var td = document.createElement('td');
                // td.textContent = element.babbi;
                // console.log(element);
                element.utenti.forEach(element => {
                    td.textContent += " -" + element.nome
                });
                var td2 = document.createElement('td');
                td2.textContent = element.nome;
                var td3 = document.createElement('td');
                td3.textContent = element.consegnatoOra;
            
                row.appendChild(td);
                row.appendChild(td2);
                row.appendChild(td3);
            
                body.appendChild(row);
            }

        });

})