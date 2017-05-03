$(".input-button").click(function() {
	var epwd = $('#password').val();
	var userName = $('#userId').val();
	/*$.post("vuser/login", {
		epwd : epwd,
		userName : userName
	}, function(data) {
		
	});
	$("#login").submit();*/
	
	/*$.post("../../vuser/login",{
		epwd : epwd,
		userName : userName
	}, function(data) {
		alert(data.desc);
	},"json");*/
});