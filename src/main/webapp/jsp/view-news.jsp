<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><bean:message key="newsManagement.title"/></title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
<div class="holy-grail">
    <div class="holy-grail__header">
        <div class="grid__row">
            <div class="grid__header">
                <bean:message key="newsManagement.title"/>
            </div>
            <div class="grid__lan-bar">
                <div class="lan-bar">
                    <html:link page="/locale.do?language=russian">
                        <bean:message key="link.russian"/>
                    </html:link>
                </div>
                <div class="lan-bar">
                    <html:link page="/locale.do?language=english">
                        <bean:message key="link.english"/>
                    </html:link>
                </div>
            </div>
        </div>
    </div>
    <div class="holy-grail__body">
        <div class="holy-grail__menu">
            <div class="grid__menu_header">
                <bean:message key="newsMenu.title"/>
            </div>
            <div class="grid__menu">
                <ul>
                    <li>
                        <a href="/newsList.do">
                            <bean:message key="newsMenu.newsList.link"/>
                        </a>
                    </li>
                    <li>
                        <a href="/addNewsPage.do">
                            <bean:message key="newsMenu.addNews.link"/>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="holy-grail__content">
            <html:form action="/edit.do" method="POST">
                <input type="hidden" name="id" value='<bean:write name="NewsForm" property="id" />' />
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
                </html:form>
        </div>
    </div>
</div>
</body>
</html>


