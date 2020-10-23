<%@page import="com.exam.vo.BoardVo"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터값 int num, String pageNum 가져오기 num은계산할 용도기때문에 int로 변환해주지만 pageNum은 단순값만 필요하기때문에 변환하지않아도 된다.
	int num = Integer.parseInt(request.getParameter("num")); 
	String pageNum = request.getParameter("pageNum");

	// DAO 객체 준비
	BoardDao boardDao = BoardDao.getInstance();
	
	// 조회수 1 증가하기
	boardDao.updateReadcount(num);
	
	// 글번호에 해당하는 글 한개 가져오기
	BoardVo boardVo = boardDao.getBoardByNum(num); // new 를 하지않는 이유는 getBoardByNum 이라는 메소드안에서 이미 BoardVo를 생성해줬기때문.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글내용 보기</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th><td><%=boardVo.getNum() %></td>
			<th>조회수</th><td><%=boardVo.getReadcount() %></td>
		</tr>
		<tr>
			<th>작성자</th><td><%=boardVo.getName() %></td>
			<th>작성일</th><td><%=boardVo.getRegDate() %></td>  <!-- sql 가입날짜 타입이 TIMESTAMP 이고, 디폴트값에 UPDATE TIMESTAMP 가있으면 가입날짜가 계속 현재시간으로 수정된다 -->
		</tr> <!-- TIMESTAMP = 옛날거 DATE TIME = 최신 , 최신으로 권장한다. -->
		<tr>
			<th>글제목</th><td colspan="3"><%=boardVo.getSubject() %></td>
		</tr>
		<tr>
			<th>파일</th>
			<td colspan="3">
				<%
				if(boardVo.getFile() != null){
					String filename = boardVo.getFile();
					%>
					<a href="../upload/<%=filename %>"><%=filename %></a> 
					<%
					if(filename.endsWith(".jpg") || filename.endsWith(".jpeg")|| filename.endsWith(".gif") || filename.endsWith(".png")){
						%>
							<br>
							<img src="../upload/<%=filename %>" width="100" height="100">
						<%
					}
				}
				%>
			</td>
		</tr>
		<tr>
			<th>글내용</th><td colspan="3"><pre><%=boardVo.getContent() %></pre></td> <!-- pre태그로 감싼문장은 입력한그대로 브라우저에 나타낼수있다 enter tab spacebar -->
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="글수정" onclick="location.href='updateForm.jsp?num=<%=num %>&pageNum=<%=pageNum %>'">
				<input type="button" value="글삭제" onclick="location.href='deleteForm.jsp?num=<%=num %>&pageNum=<%=pageNum %>'">
				<input type="button" value="답글쓰기" onclick="location.href='reWriteForm.jsp?reRef=<%=boardVo.getReRef() %>&reLev=<%=boardVo.getReLev() %>&reSeq=<%=boardVo.getReSeq() %>&pageNum=<%=pageNum %>'">
				<input type="button" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum %>'">
															<!-- 위 제이쿼리문에 pageNum에 값이없으면 빈문자열이 나타나고, null값이면 null이 나타난다. -->
			</td>
		</tr>
	</table>

</body>
</html>



