$(function() {
    hrefId = window.location.href.split("?")[1]; 
    voteId = hrefId.split("=")[1]; 
    console.info(voteId);
    $.post("../Vote/vote/selectVote", {
        voteId: voteId
    },
    function(data) {
        var arr = data.voteOption;
        var arr1 = data.subject;
        console.info(data);
        var str = "";
        str += '<li><h4>'+arr1.Vstitle+'</h4><p class="info">共有'+arr+'个选项，已有  个网友参与了投票。</p><ol>';
        for (var i=0;i<arr;i++) {
            str += '<li><div class="rate"><div class="ratebg"><div class="percent" style="width:10cm;"></div></div><p>21票<span>(21%)</span></p></div></li>';
        }
            str += '</ol><div class="goback"><a href="page/index.jsp">返回投票列表</a></div></li>';
        $(".list").append($(str));
    },
    "json");
});