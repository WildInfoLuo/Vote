$(".input-button").click(function() {
	var epwd = $('#password').val();
	var userName = $('#userId').val();
	/*
	 * $.post("vuser/login", { epwd : epwd, userName : userName },
	 * function(data) {
	 * 
	 * }); $("#login").submit();
	 */

	/*
	 * $.post("../../vuser/login",{ epwd : epwd, userName : userName },
	 * function(data) { alert(data.desc); },"json");
	 */
});

// 注销用户
function quitUser() {
	$.post("../Vote/vuser/Userquit", function(data) {
		if (data > 0) {
			alert("注销成功！");
		}
	});
}