main = function() {
	return {
		submit : function(formObj) {
			formSubmit("/test", formObj, "post");
		}
	}
}();