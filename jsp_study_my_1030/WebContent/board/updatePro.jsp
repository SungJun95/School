<%@page import="com.exam.dao.BoardDao"%>
<%@page import="com.exam.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 
 // 파라미터값 pageNum
 String pageNum = request.getParameter("pageNum");
 // post 파라미터값 한글처리
 request.setCharacterEncoding("utf-8");
 // VO객체 준비
 //BoardVo boardVo = new BoardVo();
 %><jsp:useBean id="boardVo" class="com.exam.vo.BoardVo" ></jsp:useBean> <% 

 
 // 파라미터값 찾아서 VO에 저장
 //boardVo.setNum(Integer.parseInt(request.getParameter("num")));
 //boardVo.setName(request.getParameter("name"));
 //boardVo.setPasswd(request.getParameter("passwd")); // 검증용
 //boardVo.setSubject(request.getParameter("subject"));
 //boardVo.setContent(request.getParameter("content"));
%>
<jsp:setProperty property="*" name="boardVo"/>
<%

 // DAO 준비
 BoardDao boardDao = BoardDao.getInstance();
 // 수정하려는글 작성자 본인인지 검증하기
 boolean pwdCheck = boardDao.pwdCheck(boardVo.getNum(), boardVo.getPasswd());
 if(pwdCheck){
	 // 글정보 수정하기
	 boardDao.updateBoard(boardVo);
	 
	 // 수정한내용을 확인하기위해 content.jsp로 이동
	 response.sendRedirect("content.jsp?num=" + boardVo.getNum() + "&pageNum=" + pageNum);
 } else {
	 %>
	 <script>
	 	alert('글 비밀번호가 틀립니다.');	
	 	history.back();
	 </script>
	 <%
 }
 %>