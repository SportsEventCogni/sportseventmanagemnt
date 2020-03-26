<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{background-image: url("drawable/eventAdd.jpg");
	background-repeat: no-repeat;
	background-size: cover;}
</style>
</head>
<body>
<%@include file="header.html" %>
<form:form action="updateEvent" method="get" modelAttribute="event">
 
<form:select path="eventId">  
   <c:forEach var="list" items="${li}">
       <option id="id" value="${list.getEventId()}">${list.getEventName()}</option> 
      
   </c:forEach>
</form:select>
 

<input type="submit" value="submit">
</form:form>
</body>
</html>