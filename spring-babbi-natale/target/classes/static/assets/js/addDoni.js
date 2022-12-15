const cardTitle = document.querySelector('.card-title');

const body = document.querySelector('#infos');

const urlBimbo = "http://localhost:9013/api/bimbi";

const urlSacchi = "http://localhost:9013/api/sacchi"




function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

cardNameValue();

    var row = document.createElement('tr');

    fetch(urlBimbo)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            
            var td1 = document.createElement('td');
            var td2 = document.createElement('td');

            td1.textContent = element.nome;
            
            element.doni.forEach(element=>{
                var nomeDono = element.nome;
                td2.textContent = nomeDono;
            })

            row.appendChild(td1);
            row.appendChild(td2);

         });



    fetch(urlSacchi)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element=>{
            var nome = element.nome;
            var id = element.id;

            var td3 = document.createElement('td');
            td3.textContent= nome+"-"+id;
        })


    })

})
