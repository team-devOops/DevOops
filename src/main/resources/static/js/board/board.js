
const manuGetQuery  = (param) => {
    let reParam;

    console.dir(param);

    for(let key in param){
        let value = param[key];

        if(value !== undefined && value ===''){
            reParam += `${key}=${value}&&`;
        }
    }
    reParam = reParam === undefined ? '' : reParam;

    return reParam;
};


const httpFecth = (url,method,body,headers)=>{
    if(headers === undefined) {headers = new Headers();}

    if(method === 'get') {url += manuGetQuery(body); body = undefined;}

    return fetch(url,{method, body, headers

    }).then((res)=> {
        console.log("then   " + url);
        return res.json();}


    ).catch(err => {console.error(err)})

};

const Board = class Board {

    constructor(){

    }

     async boardlist(page){

        let body = {
            "page" : page ,
            "size" : 1
        };



        let board = await httpFecth(`/board/list/1`,"get",body);
        if(board !== undefined || board !== '') {
           await this.drawBoard(board);
        }

    }


    drawBoard(json){

        json.forEach((data)=>{

            let el = document.createElement('div');


            let template = document.querySelector('#card');
            template.content.querySelector('.header').text = data.title;
            let clone = document.importNode(template.content,true);

            let targetDom = document.getElementById("contents");targetDom.appendChild(clone);

        });

    }

};
