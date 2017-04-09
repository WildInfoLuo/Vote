// 获取验证码
function sendcheckcode() {
	var tel = $.trim($("#phoneId").val());
	if (tel) {
		$.post("../vuser/message", {
			tel : tel
		}, function(data) {
			if (data) {
				codeid = data;
			}
		}, "json");
	} else {
		alert("请确认手机号是否正确!")
	}
}

// 点击注册
$("#save").click(function() {
	var userName = $('#userName').val();// 用户名
	var phoneId = $('#phoneId').val();// 手机号码
	$.post("../vuser/produceRas", function(data) {
		if (data) {
			var modulus = data.modulus;// 后台生成密钥对
			var exponent = data.exponent;
			var epwd = $('#password').val().trim();
			if (epwd.length != 256) {
				var publicKey = RSAUtils.getKeyPair(exponent, '', modulus);
				var getMapKey = RSAUtils.encryptedString(publicKey, epwd);// 根据公钥生成密文
				// $('#password').val(getMapKey);
				$.post("../vuser/getKeyMap", {
					getMapKey : getMapKey,
					userName : userName,
					phoneId : phoneId
				}, function(data) {
					if (data) {

					}
				}, "json");
			}

			$("#save").submit();
		}
	}, "json")
});
