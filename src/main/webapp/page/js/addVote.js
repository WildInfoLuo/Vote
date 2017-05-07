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

$(document).ready(function() {
    var MaxInputs = 8; // maximum input boxes allowed
    var InputsWrapper = $("#voteoptions"); // Input
    var AddButton = $("#AddMoreFileBox"); // Add button ID
    var x = InputsWrapper.length; // initlal text box
    var FieldCount = 1; // to keep track of text box added
    $(AddButton).click(function(e) // on add input button click
    {
        if (x <= MaxInputs) // max input box
        {
            FieldCount++; // text box
            $(InputsWrapper).append('<div><input type="text" class="input-text" name="mytext[]" id="field_' + FieldCount + '" value=""/><a href="#" class="removeclass">删除</a></div>');
            x++; // text box increment
        }
        return false;
    });

    $("body").on("click", ".removeclass",
    function(e) { // user
        if (x > 1) {
            $(this).parent('div').remove(); // remove text
            x--; // decrement textbox
        }
        return false;
    })

});