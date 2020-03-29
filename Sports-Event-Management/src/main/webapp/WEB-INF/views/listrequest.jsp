<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	
	@import "compass/css3";

$backgroundColor: #2E2633;
$fontColor: #EFFFCD;
$initalGapSize: 250;
$animationTime: 8s;

.stroke {
  stroke: lighten($fontColor, 20%);
  stroke-width: .5px;
  stroke-dasharray: 0 $initalGapSize;
  stroke-opacity: 1;
  fill: none;
  animation: stroke_offset $animationTime infinite; 
  animation-timing-function: cubic-bezier(0.250, 0.460, 0.450, 0.940); 
}

@keyframes stroke_offset {
  25% {stroke-dasharray: 0 $initalGapSize;  stroke-opacity: 1; }
  50% {stroke-dasharray: $initalGapSize 0;  stroke-opacity: .75; }
  55% {stroke-dasharray: $initalGapSize 0;  stroke-opacity: 0; }
  70% {stroke-dasharray: $initalGapSize 0;  stroke-opacity: 0; }
  75% {stroke-dasharray: $initalGapSize 0;  stroke-opacity: .75; }
  100% {stroke-dasharray: 0 $initalGapSize; stroke-opacity: 1; }
}

.fill {
  fill: $fontColor;
  fill-opacity: 0;
  animation: fill_offset $animationTime infinite; 
  animation-timing-function: cubic-bezier(0.250, 0.460, 0.450, 0.940); 
}


@keyframes fill_offset {
  25% {fill-opacity: 0;}
  35% {fill-opacity: 0;}
  50% {fill-opacity: 1;}
  70% {fill-opacity: 1;}
  90% {fill-opacity: 0;}
  100% {fill-opacity: 0;}
}


#fade-text {
  font-family: 'Slabo 27px', Helvetica, Arial, sans-serif;
  font-size: .5em;
}


svg {
  position: absolute;
  width: 100%;
  height: 100%;
}

body {
  background: $backgroundColor;
  font: 16em Arial;
}

html, body {
  height: 100%;
}


#fadeout {
  opacity: 1;
  transition: 1s opacity;
  text-align: center;
  font-size:32px;
}



</style>


<script type="text/javascript">

window.onload = function() {
	  window.setTimeout(fadeout, 2000); //8 seconds
	}

	function fadeout() {
	  document.getElementById('fadeout').style.opacity = '0';
	}
</script>




</head>
<body>
	<%@include file="header.html"%>




	<center>
	
	<div  style="margin-top:50px;" id="fadeout">${req}</div>

		<form:form style="margin-top:140px;" action="hello" method="post">

			<table class="tabletable-stripedtable-borderedtable-hover">

				<thead>
					<tr>
						<th>Event</th>
						<th></th>
						<th>Sponsor</th>
						<th></th>
						<th>Coach</th>
						<th></th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="listrequests" items="${li}">
						<tr>
							<td>${listrequests.getEventName()}</td>
							<td></td>
							<td>${listrequests.getSponsorName()}</td>
							<td></td>
							<td>${listrequests.getCoachName()}</td>
							<td></td>




							<td><button type="submit" name="action" value="approve">Approve</button></td>
							<td></td>

							<td><input type="hidden" id="EventRegistration"
								name="EventRegistration" value="${listrequests}" /></td>
								
								
							<td><button type="submit" formaction="/deletehello" name="action" value="reject">reject</button></td>


						</tr>
					</c:forEach>

				</tbody>

			</table>

		</form:form>

	</center>
	
	<script type="text/javascript">
		
	function
	</script>


</body>
</html>