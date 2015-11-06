<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<html:form action="/edit" method="GET">
<div class="action-form">

    <table width = 60%>
        <tr>
            <td width="20%"><bean:message key="news.label.title"/></td>
            <td width="40%"><html:text property="title" size="40" /></td>
        </tr>
        <tr>
            <td width="20%"><bean:message key="news.label.date"/></td>
            <td width="40%"><html:text property="creationDate" size="10"/></td>
        </tr>
        <tr>
            <td width="20%"><bean:message key="news.label.brief"/></td>
            <td width="40%"><html:textarea property="brief" cols="40" rows="5"/></td>
        </tr>
        <tr>
            <td width="20%"><bean:message key="news.label.content"/></td>
            <td width="40%"><html:textarea property="content" cols="40" rows="10"/></td>
        </tr>
    </table>
</html:form>
</body>
</html>
