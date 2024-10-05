<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.model.Bird" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ${bird.getId()} - ${bird.getName()}</h1>
<ul>
        <% 
            List<Bird> myList = (List<Bird>) request.getAttribute("birds");
            for (Bird item : myList) {
        %>
            <li><%= item.getId() %> <%= item.getName() %></li>
        <% } %>
    </ul>
</body>
<body>
Welcome 
   ${u.getName()}
<form action="out">
<input type = "submit" name = "logout" value = "logout">
</form>
</body>
</html> --%>