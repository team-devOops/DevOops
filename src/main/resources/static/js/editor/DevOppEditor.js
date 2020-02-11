const DevOppEditor  = class Editor {

    bindDom;
    static _TAB_KEY_CODE = 9;
    static _SPACE_KEY = 32;
    static _ENTER_KEY = 13;

    constructor(name,bindDom){
        this.name = name;
        this.bindDom = bindDom;
        this.baseEdiorControll(this.bindDom);


    }

    get bindDome(){
        return this.bindDom;
    }

    baseEdiorControll(dom) {
        dom.addEventListener('keydown',(e) => this.keydown(e));
        dom.addEventListener('keypress',(e) => this.keypress(e));
    }

    keydown(e) {
        let code = e.which || e.keyCode || e.key;

        switch (code) {
            //Tab Key 구
            case Editor._TAB_KEY_CODE :
                e.preventDefault();
                this.spanDivTextAdd('\t');
                break;

            case Editor._ENTER_KEY :
                this.spanDivHtmlAdd('\n');
                //this.spanDivHtmlAdd('');
                break;

        }

    }

    keypress(e){
        let code = e.which || e.keyCode || e.key;
        console.log(`keypree : ${code}`  );
        switch (code) {
            //스페이스 구
            //case Editor._SPACE_KEY :
            //    this.spanDivTextAdd(' ');
             //   break;



        }

    }

    bindDomEventAdd (eventName,action) {
        this.bindDom.addEventListener(eventName,action);

    }

    spanDivTextAdd(data) {
        if (!window.getSelection) return;
        const sel = window.getSelection();
        if (!sel.rangeCount) return;
        const range = sel.getRangeAt(0);
        range.collapse(true);
        const span = document.createElement('span');
        span.appendChild(document.createTextNode(data));
        span.style.whiteSpace = 'pre';

        range.insertNode(span);
        range.setStartAfter(span);
        range.collapse(true);
        sel.removeAllRanges();
        sel.addRange(range);

    }

    spanDivHtmlAdd(tag) {
        if (!window.getSelection) return;
        const sel = window.getSelection();
        if (!sel.rangeCount) return;
        const range = sel.getRangeAt(0);
        range.collapse(true);
        const span = document.createElement('span');
        span.appendChild(document.createTextNode('  '));
        //span.innerText = "\n";
        //span.appendChild(br);
        span.style.whiteSpace = 'pre';
        /* 잘모르겠다 ...*/

        range.insertNode(span);
        range.setStartAfter(span);
        range.collapse(true);
        sel.removeAllRanges();
        sel.addRange(range);



    }

}




