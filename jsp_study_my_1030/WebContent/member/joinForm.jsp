<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 - 회원가입</title>
<style>
span.positive {
	color: green;
	background-color: aqua;
	font-style: italic;
}

span.negative {
	color: red;
	background-color: yellow;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="joinProcess.jsp" method="post">
		아이디: <input type="text" name="id">
			  <span id="msgIdDup"></span>
		<br>
		패스워드: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age" min="0" max="200"><br>
		성별: <input type="radio" name="gender" value="남"> 남성
		      <input type="radio" name="gender" value="여"> 여성<br>
		이메일: <input type="email" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
	
	<script src="../js/jquery-3.5.1.js"></script>
	
	<script>

		function process(item){
			// let spanMsg = document.getElementById('msgIdDup'); 자바스크립트로 찾기
			let $spanMsg = $('#msgIdDup');  // 변수앞에 $기호를 붙이면 제이쿼리객체임을 암시
			
			if (item.count == 0) { // 아이디 사용가능
				// $spanMsg.html('사용가능한 아이디 입니다.').css('color', 'green');

				// 코드가많을때는 아래방식으로
				$spanMsg.html('사용가능한 아이디 입니다.').addClass('positive').romoveClass('negative');
			} else { // item.count == 1 아이디 중복 초복 말복
				// $spanMsg.html('이미 사용중인 아이디 입니다.').css('color', 'red');
				 $spanMsg.html('이미 사용중인 아이디 입니다.').addClass('negative').romoveClass('positive');

			}
		}	
	
		// 키 이벤트 연결 
		// 키보드 버튼이 눌렀다 떼어졌을때
		$('input[name="id"]').keyup(function () {
			
			let id = $(this).val().trim();

			$.ajax({
				url: 'ajaxIdDupCheck.jsp',
				data: 'id='+id,
				success: function (data) {
					process(data);
				}	
			});
				
		});
	</script>
</body>
</html>





