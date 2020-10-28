<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
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

// (mvn)json-simple 라이브러리 사용해서 memberList객체를 JsonArray(List) OR JsonObject(HashMap) 객체로 변환

// 전체 내용을 담을 JSONArray 객체 준비
JSONArray jsonArray = new JSONArray();

for(MemberVo memberVo : memberList){
	// JsonOB는 일종의 맵컬렉션으로 구현됨
	JSONObject jsonObject = new JSONObject();  // memberVo 같은 친구
	// memberVo 내용을 jsonOB에 복사하기
	jsonObject.put("id", memberVo.getId());
	jsonObject.put("name", memberVo.getName());
	jsonObject.put("age", memberVo.getAge());
	// JsonOB를 JsonArray에 추가
	jsonArray.add(jsonObject);
}

// 웹서버 콘솔에 출력
System.out.println(jsonArray); // jsonArray 안에 내부적으로 toString 같은 메소드가있기때문에 쉽게 출력이가능

// 웹브라우저에 출력
// out.println(jsonArray);
%>
<%-- 웹브라우저로 출력 --%>
<%=jsonArray %>


