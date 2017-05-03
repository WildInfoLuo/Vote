// 获取验证码
function sendcheckcode() {
	var tel = $.trim($("#phoneId").val());
	if (tel) {
		$.post("../Vote/vuser/message", {
			tel : tel
		}, function(data) {
			alert(data.desc);
		}, "json");
	} else {
		alert("请确认手机号是否正确!")
	}
}

// 点击注册
function saves() {
	var userName = $('#userName').val();// 用户名
	var phoneId = $('#phoneId').val();// 手机号码
	var messages = $('#messages').val();// 手机验证码
	$.post("../../vuser/produceRas", function(data) {
		if (data) {
			var modulus = data.modulus;// 后台生成密钥对
			var exponent = data.exponent;
			var epwd = $('#password').val().trim();
			if (epwd.length != 256) {
				var publicKey = RSAUtils.getKeyPair(exponent, '', modulus);
				var getMapKey = RSAUtils.encryptedString(publicKey, epwd);// 根据公钥生成密文
				$.post("../../vuser/getKeyMap", {
					getMapKey : getMapKey,
					userName : userName,
					phoneId : phoneId,
					messages : messages
				}, function(data) {
					alert(data);
				}, "json");
				$("#save").submit();
			}
		}
	}, "json");
}