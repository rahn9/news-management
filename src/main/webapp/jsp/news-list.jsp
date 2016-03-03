<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
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
            <logic:notEmpty name="newsList">
                <html:form action="/deleteFromList" method="POST">
                    <logic:iterate id="newsList" name="newsList" property="newsList">
                        <div class="news-list">
                            <div class="news-list__item">
                                <div class="news-list__title">
                                    <bean:write name="newsList" property="title"/>
                                </div>
                                <div>
                                    <bean:write name="newsList" property="creationDate"/>
                                </div>
                            </div>
                            <div class="news-list__item">
                                <bean:write name="newsList" property="brief"/>
                            </div>

                            <div class="news-list__links">
                                <a href="/viewNews.do?id=<bean:write name="newsList" property="id" />">
                                    <bean:message key="newsList.label.link.view"/>
                                </a>
                                <a href="/editPage.do?id=<bean:write name="newsList" property="id" />">
                                    <bean:message key="newsList.label.link.edit"/>
                                </a>
                                <html:checkbox name="newsList" property="deleted" value="true" indexed="true"/>
                            </div>
                        </div>
                    </logic:iterate>
                    <button id="delete" type="submit"><bean:message key='newsList.label.button.delete'/></button>
                </html:form>
            </logic:notEmpty>
        </div>
    </div>
</div>
</body>
</html>
