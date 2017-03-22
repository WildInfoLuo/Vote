$(".input-button").click(function() {
	var epwd = $('#password').val();
	var userName = $('#userId').val();
	$.post("vuser/login", {
		epwd : epwd,
		userName : userName
	}, function(data) {
		var modulus = data.modulus, exponent = data.exponent;
		if (epwd.length != 256) {
            var publicKey = RSAUtils.getKeyPair(exponent, '', modulus);
            $('#password').val(RSAUtils.encryptedString(publicKey, epwd));
        }
	});
	$("#login").submit();
});