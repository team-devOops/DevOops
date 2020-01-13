<<<<<<< HEAD
/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-main.js
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

main = function() {
	return {
		submit : function(formObj) {
			formSubmit("/auth/signUp", formObj, "get");
=======
main = function() {
	return {
		submit : function(formObj) {
			formSubmit("/test", formObj, "post");
>>>>>>> refs/remotes/origin/master
		}
	}
}();