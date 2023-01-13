<%@ page import="com.db.ConnectDB" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ConnectDB connectdb = ConnectDB.getInstance();
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String check = connectdb.loginDB(id, pw);
	
	out.println(check);
%>
