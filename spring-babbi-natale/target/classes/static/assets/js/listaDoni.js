import{cardNameValue} from "../js/homePage";

const cardTitle = document.querySelector('.card-title');
const row = document.querySelector('#dono-info');
const url = "http://localhost:9013/api/test";

cardNameValue(cardTitle);

()=>{
    fetch(url)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            console.log(element);
        });

    })
}