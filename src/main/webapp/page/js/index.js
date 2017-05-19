$(function() {
    $.post("../Vote/vote/selectAllVote",
    function(data) {
    	var arr = data.subject;
    	var str = "";
        for (var item = 0; item <= arr.length; item++) {
            var voteId = arr[item].Vsid;
            $.post("../Vote/vote/selectVote", {
                voteId: voteId
            },
            function(dataVote) {
                var arrVote = eval("(" + dataVote + ")");
                $.each(arrVote,
                function(index, content) {
                	str += '<li><h4><a href="page/view.jsp?voteId=' + content.subject.Vsid + '">' + content.subject.Vstitle + '</a></h4><div class="join"><a href="page/vote.jsp">我要参与</a></div><p class="info"><a href="page/view.jsp">' + content.subject.Vstitle + '</a>共有' + content.voteOption + '个选项，已有' + content.itemList.VCONTENT + ' 个网友参与了投票。</p></li>';
                });
            });
            console.info("------------------"+str);
            $(".list").append($(str));
        }
    },
    "json");
});