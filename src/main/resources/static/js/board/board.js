
const httpFecth = (url,method,body,headers )=>{

    if(headers === undefined){
        headers = new Headers();
    }
    console.log(url);
    return fetch(url,{
        method  ,
        body ,
        headers

    }).then((res)=> {
        console.log("then   " + url);
        return res.json();}


    ).catch(err => err)

};

const Board = class Board {

    constructor(){

    }

     async boardlist(){

        let board = await httpFecth("/board/list/1","get");
        this.drawBoard(board);

    }

    drawBoard(json){

        json.forEach((data)=>{
            let el = document.createElement('div');
            el.setAttribute("class","column");

            let template = document.querySelector('#card');
            template.content.querySelector('.header').text = data.title;
            let clone = document.importNode(template.content,true);

            let targetDom = document.getElementById("contents");

            targetDom.appendChild(clone);

        });

    }

};
    /*

    board = function() {
        return {
            button : function() {
                console.log("니 똥 꼬");
            }
        }
    }();

    */
