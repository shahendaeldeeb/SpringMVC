<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <%--<link rel="stylesheet"--%>
    <%--type="text/css"--%>
    <%--href="<c:url value="" />" >--%>
</head>
<body>
<h1><s:message code="spittr.welcome"/></h1>
<a href="<c:url value="/spittles">
            <c:param name="max" value="60"/>
            <c:param name="count" value="20"/>
        </c:url>">Spittles</a> |
<a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>
