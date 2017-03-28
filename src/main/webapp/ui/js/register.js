//获取验证码
var id;
var codeid;// 验证码
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
$("#save").click()
{
	$.post("../vuser/produceRas", function(data) {
		if (data) {
			var modulus = data.modulus;
			var exponent = data.exponent;
			var epwd = $('#password').val();
			if (epwd.length != 256) {
				var publicKey = RSAUtils.getKeyPair(exponent, '', modulus);
				$('#password').val(RSAUtils.encryptedString(publicKey, epwd));
				
			}
			
			$("#save").submit();
		}
	}, "json");
}