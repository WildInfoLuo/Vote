$(function() {
	$.post("../Vote/vote/selectAllVote",
		function(data) {
			var arr = data.subject;
			var str = "";
			for ( var item in arr) {
				str += '<li><h4><a href="page/view.jsp?voteId='
						+ data.subject[item].Vsid
						+ '">'
						+ data.subject[item].Vstitle
						+ '</a></h4><div class="join"><a href="page/vote.jsp">我要参与</a></div><p class="info"><a href="page/view.jsp">'
						+ data.subject[item].Vstitle
						+ '</a>共有'
						+ data.subject[item].Vs_Type
						+ '个选项，已有 ${item.vstitle } 个网友参与了投票。</p></li>';
			}
			$(".list").append($(str));
		}, "json");
});
