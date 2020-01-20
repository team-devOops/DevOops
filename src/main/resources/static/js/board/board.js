const HttpFecth = (url,method,body,headers )=>{

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

class Board {

    constructor(){
        this.init();
    }

    async boardlist(){
        console.log(call);
        let board = await HttpFecth("/board/list/1","get");
        await this.drawBoard(board);

    }

    drawBoard(json){

        json.forEach((data)=>{
            let el = document.createElement('div');
            el.setAttribute("class","column");

            let template = document.querySelector('#card');
            template.content.querySelector('.header').text = data.title;
            let clone = document.importNode(template.content,true);

            let targetDom = document.getElementById("row");

            targetDom.appendChild(clone);

        });

    }

    init() {

    }

}

