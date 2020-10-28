<%@page import="java.util.List"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- contentType="text/html; 을 contentType="text/xml; 로 바꾸면 xml 페이지가 된다. --%>
    <%-- 콘텐트타입이 html 인데 내용이 xml 이더라도 표시는 된다. --%>
    
<%
// DAO 객체 준비
MemberDao memberDao = MemberDao.getInstance();

// 전체 회원정보 가져오기
List<MemberVo> memberList = memberDao.getAllMembers();
%>

<memberList>
	<%
		for(MemberVo membVo : memberList){
			%>
			<member>
				<id><%=membVo.getId() %></id>
				<name><%=membVo.getName() %></name>
				<age><%=membVo.getAge() %></age>
			</member>
			<%
		}
	%>
</memberList>
