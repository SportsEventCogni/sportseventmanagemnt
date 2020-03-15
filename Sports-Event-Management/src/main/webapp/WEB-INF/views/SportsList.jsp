<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="updateSport" method="get" modelAttribute="sports">
 
<form:select path="sportsId">  
   <c:forEach var="list" items="${li}">
       <option id="${list.getSportsName()}" value="${list.getSportsName()}">${list.getSportsName()}</option>   
   </c:forEach>
</form:select>


<input type="submit" value="submit">
</form:form>
</body>
</html>