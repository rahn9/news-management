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
<div class="header" style="">
    <table width = 100%>
        <tr>
            <td style="font-size: 45px;" align="left"><bean:message key="newsManagement.title"/></td>
            <td style="font-size: 16px; margin-top: 20px; text-decoration-color: black;" align="right">
                <html:link page="/locale.do?language=russian">
                    <bean:message key="link.russian"/>
        </html:link>
        <html:link page="/locale.do?language=english">
            <bean:message key="link.english"/>
        </html:link>
        </td>
        </tr>
    </table>
</div>

<html:form action="/addNews.do" method="POST">
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
