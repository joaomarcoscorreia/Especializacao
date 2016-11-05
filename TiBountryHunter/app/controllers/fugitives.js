// Arguments passed into this controller can be accessed via the `$.args` object directly or:
var args = $.args;

function showDetails(e){
	var ctrl = Alloy.createController('fugitiveDetails', e.rowData);
	ctrl.getView().open();
}
