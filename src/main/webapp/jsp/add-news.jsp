<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        <bean:message key="newsManagement.title"/>
    </title>
    <style resource="/css/add-news.css"></style>
</head>

<body>
<html:form action="/addNews.do" method="POST">

    <div class="action-form">

        <table>
            <tr>
                <td><bean:message key="news.label.title"/></td>
                <td><html:text property="title" size="40" /></td>
            </tr>
            <tr>
                <td><bean:message key="news.label.date"/></td>
                <td><html:text property="creationDate" size="10"/></td>
            </tr>
            <tr>
                <td><bean:message key="news.label.brief"/></td>
                <td><html:textarea property="brief" cols="40" rows="5"/></td>
            </tr>
            <tr>
                <td><bean:message key="news.label.content"/></td>
                <td><html:textarea property="content" cols="40" rows="10"/></td>
            </tr>
        </table>
        <html:submit>
            <bean:message key="newsEdit.label.button.save"/>
        </html:submit>
        <html:reset>
            <bean:message key="newsEdit.label.button.cancel"/>
        </html:reset>

    </div>
</html:form>


</body>
</html>
