const cardTitle = document.querySelector('.card-title');

const row = document.querySelector('#dono-info');

const url = "http://localhost:9013/api/test";




function cardNameValue(){
    cardTitle.textContent=sessionStorage.getItem('username');
}

cardNameValue();

()=>{
    fetch(url)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            console.log(element);
        });

    })
}