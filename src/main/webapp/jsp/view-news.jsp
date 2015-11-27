<%--@elvariable id="news" type="com.epam.vakhidat.news_management.form.NewsForm"--%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
            <div class="news-view">
                <div class="news-view__title">
                    <p>
                        <bean:message key="news.label.title"/>
                    </p>

                    <p>
                        <bean:message key="news.label.date"/>
                    </p>

                    <p>
                        <bean:message key="news.label.brief"/>
                    </p>

                    <p>
                        <bean:message key="news.label.content"/>
                    </p>
                </div>

                <div class="news-view__item">
                    <p>
                        ${news.title}
                    </p>

                    <p>
                        ${news.creationDate}
                    </p>

                    <p>
                        ${news.brief}
                    </p>

                    <p>
                        ${news.content}
                    </p>
                </div>
            </div>
            <div class="news-view__links">
                <a href="/editPage.do?id=${news.id}"><bean:message key="newsView.label.button.edit"/></a>
                <a href="/delete.do?id=${news.id}"><bean:message key="newsView.label.button.delete"/> </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>


