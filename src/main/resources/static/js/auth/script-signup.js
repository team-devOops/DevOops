/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-signup.js
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

signup = function() {
	return {
		save : function(formObj) {
			
			
			requstAjax("/auth/signUp", formObj, "post", true, function(result) {
				console.log("result : " + result);
				console.log("result userId : " + result.userId);
			});
		}
	}
}();