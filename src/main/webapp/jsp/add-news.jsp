<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        <bean:message key="newsManagement.title"/>
    </title>
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
            <html:form action="/addNews.do" method="POST">
                <html:hidden property="id"/>
            <div class="action-form">
                <table width=100%>
                    <tr>
                        <td width="20%"><bean:message key="news.label.title"/></td>
                        <td width="80%"><html:text property="title" size="50"/></td>
                    </tr>
                    <tr>
                        <td width="20%"><bean:message key="news.label.date"/></td>
                        <td width="80%"><html:text property="creationDate" size="15"/></td>
                    </tr>
                    <tr>
                        <td width="20%"><bean:message key="news.label.brief"/></td>
                        <td width="80%"><html:textarea property="brief" cols="55" rows="5"/></td>
                    </tr>
                    <tr>
                        <td width="20%"><bean:message key="news.label.content"/></td>
                        <td width="80%"><html:textarea property="content" cols="55" rows="10"/></td>
                    </tr>
                </table>
            <div class="action-form__button">
                <html:submit>
                    <bean:message key="newsEdit.label.button.save"/>
                </html:submit>
                <html:reset>
                    <bean:message key="newsEdit.label.button.cancel"/>
                </html:reset>
            </div>
            </div>
        </div>
        </html:form>
    </div>
</div>
</div>
</body>
</html>


