/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-utils.js
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

/**
 * 값이 NULL인지 CHECK
 */
function isNull(obj) {
	if(obj.value == null || obj.value == "") {
		return true;
	}
	else return false;
}

/**
 * 숫자값에 콤마 출력
 */
function numberWithComma(obj) {
	return obj.toString().replace(/\B(?=(\d{3})+(?!\d)/g, ",");
}

/**
 * 페이지 이동
 */
function goPageMove(url) {
	location.href = url;
}

/**
 * form Submit
 */
function formSubmit(action, formObj, method) {
	formObj.method = method;
	formObj.action = action;
	
	formObj.submit();
}