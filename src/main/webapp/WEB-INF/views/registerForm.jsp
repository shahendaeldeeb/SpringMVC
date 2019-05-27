<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
<%--    <link rel="stylesheet" type="text/css"--%>
<%--    href="<c:url value="/resources/style.css" />" >--%>
    <style>
        span.errors {
            color: red;
        }

        div.errors {
            background-color: #ffcccc;
            border: 2px solid red;
        }

        label.error {
            color: red;
        }

        input.error {
            background-color: #ffcccc;
        }
    </style>
</head>
<body>
<h1>Register</h1>

<sf:form method="POST" modelAttribute="spitter" enctype="multipart/form-data">
    <sf:errors path="*" element="div" cssClass="errors" />

    <sf:label path="profile_picture" cssErrorClass="error">Profile Picture</sf:label>:
    <sf:input path="profile_picture" name="profilePicture" type="file" accept="image/jpeg,image/png,image/gif" /><br>


    <sf:label path="first_name" cssErrorClass="error">First Name</sf:label>:
    <sf:input path="first_name" cssErrorClass="error"/><br>


    <sf:label path="last_name" cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="last_name" cssErrorClass="error"/><br>


    <sf:label path="email" cssErrorClass="error">Email</sf:label>:
    <sf:input path="email" type="email" cssErrorClass="error"/><br>

    <sf:label path="username" cssErrorClass="error">UserName</sf:label>:
    <sf:input path="username" cssErrorClass="error"/><br>

    <sf:label path="password" cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error"/><br>

    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>

