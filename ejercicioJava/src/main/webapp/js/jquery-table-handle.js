(function($) {
	$.fn.customTable = function(options) {

		var defaultOptions = {
			onClick : function() {
			},
			showHand : false,
		};

		if (typeof options === "object") {
			options = $.extend(true, defaultOptions, options);
		}

		$(this).find("th").each(function() {
			$(this).addClass("ui-state-default");
		});
		$(this).find("td").each(function() {
			$(this).addClass("ui-widget-content");

		});
		$(this).find("tr").hover(function() {
			$(this).children("td").addClass("ui-state-hover");
		}, function() {
			$(this).children("td").removeClass("ui-state-hover");
		});
//		$(this).find("tr").click(function() {
//			defaultOptions.onClick();
//			$(this).children("td").toggleClass("ui-state-highlight");
//		});
	}
}(jQuery));