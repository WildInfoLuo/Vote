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

var count;
$(document)
		.ready(
				function() {
					var MaxInputs = 8; // maximum input boxes allowed
					var InputsWrapper = $("#voteoptions"); // Input
					var AddButton = $("#AddMoreFileBox"); // Add button ID
					var x = InputsWrapper.length; // initlal text box
					var FieldCount = 1; // to keep track of text box added
					$(AddButton)
							.click(
									function(e) // on add input button click
									{
										if (x <= MaxInputs) // max input box
										{
											FieldCount++; // text box
											$(InputsWrapper)
													.append(
															'<div><input type="text" class="input-text" name="vote" id="field_'
																	+ FieldCount
																	+ '" value=""/><a href="#" class="removeclass">删除</a></div>');
											x++;
											count = x;
										}
										return false;
									});

					$("body").on("click", ".removeclass", function(e) { // user
						if (x > 1) {
							$(this).parent('div').remove(); // remove text
							x--; // decrement textbox
						}
						return false;
					})

				});

// 发布新的投票
$("#addVoteCount").click(function() {
	var vote = "";
	var titleContent = $("#titleContent").val();
	var subjectType = $("#subjectType").val();
	for (var i = 1; i <= count; i++) {
		var field_ = $("#field_" + i + "").val();
		vote += field_ + "=" + i + ":";
	}
	$("#field_1").val(vote);
	$("#addVoteCount").submit();
	/*if (vote) {
		$.post("../Vote/vote/insertVote", {
			titleContent : titleContent,
			subjectType : subjectType,
			vote : vote
		}, function(data) {
			alert(data);
			//alert(data.desc);
		}, "json");
	} else {
		alert("请完善信息！")
	}*/
});