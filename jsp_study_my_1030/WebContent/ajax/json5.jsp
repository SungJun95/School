<%@page import="com.google.gson.Gson"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>			

<%
// 혹시나 올지모를 POST 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

//파라미터값 id 가져오기
String id = request.getParameter("id");

//DAO 객체 준비
MemberDao memberDao = MemberDao.getInstance();

//id로 회원정보 가져오기
MemberVo memberVo = memberDao.getMemberById(id);

// (mvn)Gson 라이브러리 사용해서 memberList객체를 JSON 객체가아닌 문자열로 변환

// Gson 객체 준비
Gson gson = new Gson();

String strJson = gson.toJson(memberVo);  // toJson은 모든객체를 JSONObject형식 문자열로 변환해준다



// 웹서버 콘솔에 출력
System.out.println(strJson);

// 웹브라우저로 출력
//out.println(strJson);
%>
<%-- 웹브라우저로 출력 --%>
<%=strJson %>




