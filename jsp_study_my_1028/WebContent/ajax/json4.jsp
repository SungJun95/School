<%@page import="com.google.gson.Gson"%>
<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>			

<%
//DAO 객체 준비
MemberDao memberDao = MemberDao.getInstance();

//전체 회원정보 가져오기
List<MemberVo> memberList = memberDao.getAllMembers();

// (mvn)Gson 라이브러리 사용해서 memberList객체를 JSON 객체가아닌 문자열로 변환

// Gson 객체 준비
Gson gson = new Gson();

String strJson = gson.toJson(memberList);  // memberList 안에 있는 모든 Vo들을 중괄호단위로 표현하여 Json문자열로 변환해준다

// 웹서버 콘솔에 출력
System.out.println(strJson);

// 웹브라우저로 출력
out.println(strJson);

%>
<%-- 웹브라우저로 출력 --%>



