$(function() {
	$.post("../Vote/vote/selectAllVote", function(data) {
	}, "json");
});

function viewVote(voteId) {
	$.post("../Vote/vote/selectVote", {
		voteId:voteId
	}, function(data) {
	}, "json");
	location.href = "page/view.jsp"
}