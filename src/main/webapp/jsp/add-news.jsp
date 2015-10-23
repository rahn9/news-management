<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <bean:message key="newsManagement.title"/>
    </title>
</head>

<html:form action="/addNews.do" method="POST">
    <div class="title">
        <bean:message key="news.label.title"/>
        <html:text property="title" size="40" maxlength="20"/>
    </div>
    <div class="date-picker-popup">
        <bean:message key="news.label.date"/>
        <html:textarea property="creationDate" cols="50" rows="10"/>
    </div>

    <bean:message key="news.label.brief"/>
    <html:textarea property="brief" cols="50" rows="10"/>

    <bean:message key="news.label.content"/>
    <html:textarea property="content" cols="50" rows="10"/>

    <html:submit>
        <bean:message key="newsEdit.label.button.save"/>
    </html:submit>
    <html:reset>
        <bean:message key="newsEdit.label.button.cancel"/>
    </html:reset>
</html:form>

</body>
</html>
