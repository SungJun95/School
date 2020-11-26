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
   
   String title = request.getParameter("title")==null ? "3" : request.getParameter("title").trim();
   
   System.out.println("title : " + title);
   
   QueryBean.getConnection();
   
   ArrayList resArr = new ArrayList();
   
   try
   {
      resArr = QueryBean.getPlistInfo(title);
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
		out.print("\"AREA\": \""				+ (String)resArr.get(3) + "\" ");
		out.print("} ");
		
		for(int i = 4; i < resArr.size(); i+=4)
		{
			out.print(",");
			out.print("{ ");
			out.print("		\"TITLE\": \""						+ (String)resArr.get(i) + "\", ");
			out.print("		\"CONTENT\": \""				+ (String)resArr.get(i+1) + "\", ");
			out.print("		\"JOB\": \""				+ (String)resArr.get(i+2) + "\", ");
			out.print("		\"AREA\": \""				+ (String)resArr.get(i+3) + "\" ");
			out.print("} ");
		}
		out.print("] ");
		out.print("} ");
	}
%>