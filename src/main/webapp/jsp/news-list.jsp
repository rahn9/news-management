<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <bean:message key="newsManagement.title"/>
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
    <logic:notEmpty name="newsList">
        <logic:iterate id="id" name="newsList" type="com.epam.vakhidat.news_management.entities.News">
            <div class="news-view">
                <table>
                    <tr>
                        <td class="wide">
                            <a href="/edit.do"><bean:write name="id" property="title"/></a>
                        </td>
                        <td>
                            <bean:write name="id" property="creationDate"/>
                        </td>
                    </tr>
                    <tr>у
                        <td colspan="8">
                            <bean:write name="id" property="brief"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="wide"></td>
                        <td>

                            <!--TODO: view, edit, checkbox -->
                        </td>
                    </tr>
                </table>
            </div>
        </logic:iterate>
    </logic:notEmpty>
</div>
</body>
</html>
