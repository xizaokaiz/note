<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>



    <%
        System.out.println("hello jsp");
        i = 5;

        String contextPath = request.getContextPath();
        out.print(contextPath);
    %>

    <%!
        int i = 3;
    %>

    <%= i %>

    <h1>hi ~ jsp!</h1>

    <%
        response.getWriter().write("response...");
    %>

</body>
</html>