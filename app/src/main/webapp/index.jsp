<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
  Hello, ${session.user}.<s:property value="user" />
  </body>
</html>