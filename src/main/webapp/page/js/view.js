$(function() {
    hrefId = window.location.href.split("?")[1]; //得到id=楼主
    voteId = hrefId.split("=")[1]; //得到楼主
    $.post("../Vote/vote/selectVote", {
        voteId: voteId
    },
    function(data) {
        var arr = data.voteOption;
        var str = "";
        str += '<li><p class="info">共有'+arr+'个选项，已有  个网友参与了投票。</p>';
        //for (var item in arr) {
            str += '<ol><li><div class="rate"><div class="ratebg"><div class="percent" style="width:10cm;"></div></div><p>21票<span>(21%)</span></p></div></li>';
            str += '<li><div class="rate"><div class="ratebg"><div class="percent" style="width:2cm;"></div></div><p>2票<span>(2%)</span></p></div></li></ol>';

        //}
            str += '<div class="goback"><a href="page/index.jsp">返回投票列表</a></div></li>';
        $(".list").append($(str));
    },
    "json");
});