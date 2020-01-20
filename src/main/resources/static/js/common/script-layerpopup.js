/*-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-layerpopup.js
* REPORTING DATE : 2020.01.19
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

common.layerpopup = { };

/**
 * Alert창 open
 * @param Alert Title, Alert 내용
 */
common.layerpopup.openAlert = function(modalHeader, modalContent) {
	
	getElementId("modalAlertHeader").innerHTML = modalHeader;
	getElementId("modalAlertContent").innerHTML = modalContent;
	
	$('.ui.modal').modal('show');
	
	getElementId("modalAlertBtn").addEventListener('click', function(event) {
		$('.ui.modal').modal('hide');
	});
};