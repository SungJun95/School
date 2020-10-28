<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// POST 전송 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

// 파라미터값 id 가져오기
String id = request.getParameter("id");

//DAO 객체 준비
MemberDao memberDao = MemberDao.getInstance();

// id에 해당하는 행의 갯수 가져오기
int count =  memberDao.getCountMemberById(id);

// 제이슨오브젝트 객체 준비
JSONObject jsonObject = new JSONObject();
// 제이슨오브젝트 객체에 데이터넣기
jsonObject.put("count", count);
%>
<%-- 웹브라우저로 제이슨오브젝트 문자열 출력 --%>
<%=jsonObject %>
<%-- 실제로는 이렇게 출력 <%=jsonObject.toString() %> --%>

<%-- 단순히 count 로만 출력할수있지만 객체로 출력하는것을 권장 (이유: 변경사항이 생길경우를 대비해서) --%>