/**
 * 
 */
$.fn.green = function() {
	$(this).css("background-color","green");
}

$.fn.setBgColor = function(color) {
	$(this).css("background-color",color);
}

$.fn.hideTest = function() {
	$(this).addClass("hideTest");
}