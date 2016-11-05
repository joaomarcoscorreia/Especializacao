function doClick(e) {
  var x = $.email.value;
  $.alert.message = x;
   //$.alert.show();
  
   var ctrl = Alloy.createController(
   	"telalogin", x
   );
   ctrl.getView().open();
   
  
}

$.index.open();
