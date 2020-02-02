/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-signup.js
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

signup = function() {
	return {
		moveSignIn : function() {
			goPageMove("/auth/signIn");
		},
		
		moveSignUp : function() {
			getElementId("indexDiv").style.display = 'none';
			getElementId("signUpDiv").style.display = 'block';
		},
		
		signUpStepOne : function(formObj) {
			getElementId("validateDiv").style.display = 'block';

			if(!common.validate.checkForm(formObj)) {
				return false;
			}
			if(!common.validate.checkInputText(formObj.userId, "validateLabel", "이메일은 필수에요!")) return false;
			//이메일 형식 확인
			if(!common.validate.checkInputRegEx(formObj.userId, /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/, "validateLabel", "올바른 이메일 형식이 아니에요!")) return false;
			//이메일 중복 확인
			requstAjax("/auth/checkDupliEmail", formObj, "post", true, function(result) {
				if(result == 1) {
					if(!common.validate.checkInput(formObj.userPw, "validateLabel", "이미 가입된 이메일이에요!")) return false;
				}
			});
			if(!common.validate.checkInputText(formObj.userPw, "validateLabel", "비밀번호를 잊지마세요!")) return false;
			// 비밀번호 8자리 이상
			if(!common.validate.checkInputRegEx(formObj.userPw, /^[A-Za-z0-9]{8,32}$/, "validateLabel", "비밀번호는 8자리 이상이에요!")) return false;
			if(!common.validate.checkInputText(formObj.name, "validateLabel", "사용자 이름을 입력해주세요!")) return false;
			
			//모두 완료시 이메일 인증
			requstAjax("/auth/sendAuthEmail", formObj, "post", true, function(result) {
				//이메일 발송 실패
				if(result == 0) {
					//if(!common.validate.checkInput(formObj.userPw, "validateLabel", "이미 가입된 이메일이에요!")) return false;
				}
			});
			
			getElementId("signUpDiv").style.display = 'none';
			getElementId("emailAuthDiv").style.display = 'block';
			//requstAjax("/auth/signUp", formObj, "post", true, function(result) { });
		},
		
		signUpStepTwo : function(formObj) {
			
		}
	}
}();