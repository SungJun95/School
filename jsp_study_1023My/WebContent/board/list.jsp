<%@page import="com.exam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//DAO 객체 준비
	BoardDao boardDao = BoardDao.getInstance();
	//전체 글갯수 가져오기
	int count = boardDao.getCount();
	
	//한페이지당 보여줄 글갯수 설정
	int pageSize = 10;
	
	int pageCount = (int) Math.ceil( (double) count / pageSize );
	
	
	

//	String strPageNum = request.getParameter("pageNum");
//	strPageNum = (strPageNum == null) ? "1" : strPageNum;
//	int pageNum = Integer.parseInt(strPageNum);
	int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.parseInt(request.getParameter("pageNum"));
	
	//가져올 첫행번호 구하기
	int startRow = (pageNum -1) * pageSize;
	// 글목록 가져오기
	List<BoardVo> boardList = null;
	if(count > 0){
		boardList = boardDao.getBoards(startRow, pageSize);
	}
	

%>
    
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style>
	table{
		width: 800px;
	}
	a.active {
		font-weight: bold;
	}
	
</style>

</head>

<body>
	<h1>글목록 (전체글갯수: <%=count %>)</h1>	<hr>
	
	<h3><a href="writeForm.jsp?pageNum=<%=pageNum %>">글쓰기</a></h3>
	<h3><a href="fileWriteForm.jsp?pageNum=<%=pageNum %>">파일 글쓰기</a></h3>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회</th><th>IP</th>
			</tr>
		</thead>
		<tbody>
		<%
		if(count > 0) {
			for(BoardVo boardVo : boardList){
				%>
				<tr>
					<td><%=boardVo.getNum() %></td>
					<td>
						<%
						if (boardVo.getReLev() > 0) {// 해당글이 답글이면
							%>
							<img src="../images/level.gif" width="<%=boardVo.getReLev() * 15%>" height="13">
							<img src="../images/re.gif">
							<%
						}
						%>
						<a href="content.jsp?num=<%=boardVo.getNum() %>&pageNum=<%=pageNum %>"><%=boardVo.getSubject() %></a>
					</td>
					<td><%=boardVo.getName() %></td>
					<td><%=boardVo.getRegDate() %></td>
					<td><%=boardVo.getReadcount() %></td>
					<td><%=boardVo.getIp() %></td>
				</tr>
				<%
			}
		} else { // count == 0
			%>
			<tr>
				<td colspan="6">게시판 글 없음</td>
			</tr>
			<%
		} 
		%>
		</tbody>
	</table>
	
	<%
	// 글갯수가 0보다 크면 페이지블록 계산해서 출력하기
	if (count > 0){
		// 필요한 페이지 갯수 구하기, ex) 글50개. 한화면에보여줄글 10개 => 50/10 = 5
							//  ex) 글55개. 한화면에보여줄글 10개 => 55/10 = 5 + 나머지(1페이지) => 6
		// int pageCount = (count / pageSize) + (count % pageSize == 0 ? 0 : 1 ); @방법1@
		// int pageCount = (int) Math.ceil( (double) count / pageSize );	// @방법2@
		
		//한 화면에 보여줄 페이지번호 갯수
		final int pageBlock = 5;
		
		// 화면에 보여줄 시작페이지번호 구하기
		// 1~5 다음> 6~10 다음> 11~15 다음> ...
		// 1~5 => 1		6~10 => 6		11~15 => 11
		int startPage = ( (pageNum / pageBlock) - (pageNum % pageBlock == 0 ? 1 : 0) ) * pageBlock + 1;
		// 화면에 보여줄 끝 페이지번호 구하기
		int endPage = startPage + pageBlock -1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		
		// [이전] 구현
		if(startPage > pageBlock){
			
			%>
			<a href="list.jsp?pageNum=<%=startPage - pageBlock %>">[←이전]</a>
			<%
		}
		
		
		// 1 ~ 5
		for(int i=startPage; i<=endPage; i++){
			if(i == pageNum){
				%>
				<a href="list.jsp?pageNum=<%=i %>" class="active">[<%=i %>]</a>
				<%	
			} else{
				%>
				<a href="list.jsp?pageNum=<%=i %>">[<%=i %>]</a>
				<%
			}
		}
		
		// [다음] 구현
		if(endPage > startPage){
			%>
			<a href="list.jsp?pageNum=<%=startPage + pageBlock %>">[다음→]</a>
			<%
		}
	} 
	%>
	
</body>

</html>