<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><bean:message key="newsManagement.title"/></title>
    <style resource="/css/style.css"></style>
</head>

<body>
<div class="holy-grail">
    <div class="holy-grail__header">
        <div class="grid__row">
            <div class="grid__header">
                <bean:message key="newsManagement.title"/>
            </div>
            <div class="grid__lan-bar">
                <html:link page="/locale.do?language=russian">
                    <bean:message key="link.russian"/>
                </html:link>
                <html:link page="/locale.do?language=english">
                    <bean:message key="link.english"/>
                </html:link>
            </div>
        </div>
    </div>
    <div class="news-view">
        <table>
            <tr>
                <td><bean:message key="news.label.title"/></td>
                <td class="wide"><bean:write name="NewsForm" property="title"/></td>
            </tr>
            <tr>
                <td><bean:message key="news.label.date"/></td>
                <td class="wide"><bean:write name="NewsForm" property="creationDate"/></td>
            </tr>
            <tr>
                <td><bean:message key="news.label.brief"/></td>
                <td class="wide"><bean:write name="NewsForm" property="brief"/></td>
            </tr>
            <tr>
                <td><bean:message key="news.label.content"/></td>
                <td class="wide"><bean:write name="NewsForm" property="content"/></td>
            </tr>
        </table>
        <html:submit>
            <bean:message key="newsView.label.button.edit"/>
        </html:submit>
        <html:submit>
            <bean:message key="newsList.label.button.delete"/>
        </html:submit>
    </div>
</div>
</body>
</html>


