<%@include file="Header.jsp" %>
    <%
    	if(session.getAttribute("Auth")==null)
    	{
    		response.sendRedirect("Login.jsp");
    	}
    %>

<body>
<h1>Valid User</h1>
<form action="logout">
<input type="submit" value="logout">

</form>

</body>
</html>