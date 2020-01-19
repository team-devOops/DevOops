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
         let board = await HttpFecth("/board/list/1","get");
         console.dir(JSON.stringify(board));
    }

    drawForm(){

    }

    init() {

    }

}

