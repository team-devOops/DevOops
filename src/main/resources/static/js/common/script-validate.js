/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-validate.js
* REPORTING DATE : 2020.01.21
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

function checkForm(formObj) {
	if(formObj === undefined) {
		return false;
	}
	else return true;
}

function checkInputText(objName, obj) {
	if(isNull(obj)) {
		obj.focus();
		
		common.layerpopup.openAlert('입력오류', objName + '을 입력해주세요.');
		
		return false;
	}
	else return true;
}