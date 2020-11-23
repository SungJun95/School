<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*" %>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id") == null ? "test3" : request.getParameter("id").trim();
	String password = request.getParameter("password") == null ? "1234" : request.getParameter("password").trim();
	String name = request.getParameter("name") == null ? "testtest3" : request.getParameter("name").trim();
	String birth = request.getParameter("birth") == null ? "123456" : request.getParameter("birth").trim();
	String sex = request.getParameter("sex") == null ? "남자" : request.getParameter("sex").trim();
	String email = request.getParameter("email") == null ? "test3@test.com" : request.getParameter("email").trim();
	String tel = request.getParameter("tel") == null ? "010-1234-4567" : request.getParameter("tel").trim();
	
	System.out.println("id: " + id);
	System.out.println("password: " + password);
	System.out.println("name: " + name);
	System.out.println("birth: " + birth);
	System.out.println("sex: " + sex);
	System.out.println("email: " + email);
	System.out.println("tel: " + tel);
	
	QueryBean.getConnection();
	
	int res=0;
	
	try
	{
		res = QueryBean.insertPerson(id, password, name, birth, sex, email, tel);
	}
	catch(Exception e)
	{
		out.print(e.toString());
	}
	finally
	{
		QueryBean.closeConnection();
	}
	out.print("[");
	out.print("{");
	out.print("\"RESULT_OK\": \"" + res + "\" ");
	out.print("}");
	out.print("]");
	
	System.out.println("res :" + res);
%>