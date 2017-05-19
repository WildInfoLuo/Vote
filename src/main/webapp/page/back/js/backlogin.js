//加载验证码
function loadimage() {
	document.getElementById("randImage").src = "page/back/image.jsp?"
			+ Math.random();
}

function pwd() {
	var account = $("#apwd").val();
	if (account.length == 0) {
		$("#pwdspan").css("display", "block");
		return false;
	} else {
		$("#pwdspan").css("display", "none");
		return true;
	}
}

function account() {
	var account = $("#account").val();
	if (account.length == 0) {
		$("#accountspan").css("display", "block");
		return false;
	} else {
		$("#accountspan").css("display", "none");
		return true;
	}
}

function code() {
	var account = $("#yzm").val();
	if (account.length == 0) {
		$("#yzmspan").css("display", "block");
		return false;
	} else {
		$("#yzmspan").css("display", "none");
		return true;
	}
}

// 验证输入账号
function checkAccount() {
	account();
}

// 验证输入账号
function checkPwd() {
	pwd();
}

var codeTest;
// 校验验证码
function checkCode() {
	var code = $("#yzm").val();
	if (code.length == 4) {
		$.post("vuser/checkcode/" + code, function(data) {
			if (data == 1) {
				$("#yzmspan").html("验证码输入正确...")
				$("#yzmspan").css({
					"display" : "block",
					"color" : "green"
				});
				codeTest = true;
			} else {
				$("#yzmspan").html("验证码输入错误...")
				$("#yzmspan").css({
					"display" : "block",
					"color" : "red"
				});
				codeTest = false;
			}
		});
	}
}
// 检查登录
function checkin() {
	var f1 = account();
	var f2 = pwd();
	var f3 = code();
	if (f1 && f2 && f3 && codeTest) {
		return true;
	}
	return false;
}
