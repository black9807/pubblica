const cardTitle = document.querySelector('.card-title');

const row = document.querySelector('#infos');

const urlBimbo = "http://localhost:9013/api/bimbi";




function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

cardNameValue();


    fetch(urlBimbo)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            console.log(element);
        //     var td = document.createElement('td');
        //     td.textContent = element.nome;
        //     var td2 = document.createElement('td');
        //     td2.textContent = element.disponibilita;

        //     row.appendChild(td);
        //     row.appendChild(td2);
         });

})
