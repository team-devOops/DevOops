/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-validate.js
* REPORTING DATE : 2020.01.21
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

common.validate = { };

/**
 * Form 여부 확인
 * @param formObj
 */
common.validate.checkForm = function(formObj) {
	if(formObj === undefined) {
		return false;
	}
	else return true;
};

/**
 * input null check 
 * @param obj : 검사할 object, textId : message 출력할 input text, message : 출력할 message	
 */
common.validate.checkInputText = function(obj, textId, message) {
	if(isNull(obj)) {
		obj.focus();
		getElementId(textId).innerHTML = message;
		
		return false;
	}
	else return true;
};

/**
 * input check 
 * @param obj : 검사할 object, textId : message 출력할 input text, message : 출력할 message	
 */
common.validate.checkInput = function(obj, textId, message) {
	obj.focus();
	getElementId(textId).innerHTML = message;
	
	return false;
};

/**
 * input length check
 * @param formObj
 */
common.validate.checkInputRegEx = function(obj, regEx, textId, message) {
	if((obj.value).search(regEx) != 0) {
		obj.focus();
		getElementId(textId).innerHTML = message;
		
		return false;
	}
	else return true;
};

