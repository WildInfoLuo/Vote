//获取验证码
var id;
var codeid;// 验证码
function sendcheckcode() {
	var tel = $.trim($("#phoneId").val());
	if (tel) {
		$.post("../vuser/message", {
			tel : tel
		}, function(data) {
			if (data) {

			}
		}, "json");
	} else {
		alert("请确认手机号是否正确!")
	}
}

$("#save").click()
{
	alert("点击了");
}