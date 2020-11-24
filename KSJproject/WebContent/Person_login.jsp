<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*" %>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id") == null ? "ksj" : request.getParameter("id").trim();
	String password = request.getParameter("password") == null ? "1234" : request.getParameter("password").trim();
	
	System.out.println("id: " + id);
	System.out.println("password: " + password);
	
	QueryBean.getConnection();
	
	int res = 0;
	
	try
	{
		res = QueryBean.PersonLogin(id, password);
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