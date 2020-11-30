<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="db.beans.*,java.sql.*,java.util.*,java.io.*" %>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<%
   //캐쉬 제거
   response.setHeader("Cache-Control", "no-store");
   response.setHeader("Pragma", "no-cache");
   response.setDateHeader("Expires", 0);
   
   request.setCharacterEncoding("UTF-8");
   
   String number = request.getParameter("number") == null ? "1" : request.getParameter("number").trim();
   
   System.out.println("number : " + number);
   
   QueryBean.getConnection();
   
   ArrayList resArr = new ArrayList();
   
   try
   {
      resArr = QueryBean.getPlistInfoByNumber(number);
   }
   catch(SQLException e)
   {
      out.print(e.toString());
   }
   finally
   {
      QueryBean.closeConnection();
   }
   
   out.println("{");
   out.println("\"datas\":[");
   
   if(resArr.size() == 0)
	{
		out.println("]");
		out.println("}");
	}
	else
	{
		out.print("{ ");
		out.print("\"TITLE\": \""				+ (String)resArr.get(0) + "\", ");
		out.print("\"CONTENT\": \""				+ (String)resArr.get(1) + "\", ");
		out.print("\"JOB\": \""				+ (String)resArr.get(2) + "\", ");
		out.print("\"AREA\": \""				+ (String)resArr.get(3) + "\", ");
		out.print("\"C_NAME\": \""				+ (String)resArr.get(4) + "\", ");
		out.print("\"C_EMAIL\": \""				+ (String)resArr.get(5) + "\", ");
		out.print("\"C_TEL\": \""				+ (String)resArr.get(6) + "\", ");
		out.print("\"NUMBER\": \""				+ (String)resArr.get(7) + "\" ");
		out.print("} ");
		
		for(int i = 8; i < resArr.size(); i+=8)
		{
			out.print(",");
			out.print("{ ");
			out.print("\"TITLE\": \""				+ (String)resArr.get(i) + "\", ");
			out.print("\"CONTENT\": \""				+ (String)resArr.get(i+1) + "\", ");
			out.print("\"JOB\": \""				+ (String)resArr.get(i+2) + "\", ");
			out.print("\"AREA\": \""				+ (String)resArr.get(i+3) + "\", ");
			out.print("\"C_NAME\": \""				+ (String)resArr.get(i+4) + "\", ");
			out.print("\"C_EMAIL\": \""				+ (String)resArr.get(i+5) + "\", ");
			out.print("\"C_TEL\": \""				+ (String)resArr.get(i+6) + "\", ");
			out.print("\"NUMBER\": \""				+ (String)resArr.get(i+7) + "\" ");
			out.print("} ");
		}
		out.print("] ");
		out.print("} ");
	}
%>