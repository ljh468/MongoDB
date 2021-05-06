<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"src="/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(window).on("load", function(){
		
		// 페이지 로딩 완료 후, 멜론 순위 가져오기 함수 실행함
		getRank();
	});
	
	function getRank() {
		
		//Ajax 호출
		$.ajax({
			url : "/melon/getRankForSinger.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json){
				
				var melon_rank = "";
				
				for (var i = 0; i < json.length; i++){
					melon_rank += (json[i].rank + "위| ")
					melon_rank += (json[i].singer + " | ")
					melon_rank += (json[i].song_cnt + " 곡 <br>")
				}
				
				$('#melon_rank').html(melon_rank);
			}
		})
	}
</script>
<meta charset="UTF-8">
<title>멜론 데이터 가져오기</title>
</head>
<body>
	<h1>멜론 가수별 노래 링크가 많이된 순위</h1>
	<hr />
	<div id="melon_rank"></div>
	<br />
	<hr />
</body>
</html>