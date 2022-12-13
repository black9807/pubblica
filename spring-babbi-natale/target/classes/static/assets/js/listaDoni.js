import{cardNameValue} from "../js/homePage";

const cardTitle = document.querySelector('.card-title');
<<<<<<< HEAD

cardNameValue(cardTitle);
=======
const row = document.querySelector('#dono-info');
const url = "http://localhost:9013/api/test";

cardNameValue(cardTitle);

()=>{
<<<<<<< HEAD
    fetch(url)
    .then(data=>{return data.json()})
    .then(resp=>{
        resp.forEach(element => {
            console.log(element);
        });

    })
}
=======
    fetch
}
>>>>>>> 2d10c554b7558ce23706f598531fb0f78a666033
>>>>>>> c481abd85673f7bfabf44581165b53e40c69464d
