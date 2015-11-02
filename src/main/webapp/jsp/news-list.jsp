<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <bean:message key="newsManagement.title"/>
    </title>
    <style resource="/css/news-list.css"></style>
</head>
<body>
<logic:iterate id="news" name="news-list">
    <div class="news-view">
        <table>
            <tr>
                <td class="wide">
                    <a href="news-list.jsp"><bean:write name="news" property="title"/></a>
                </td>
                <td>
                    <bean:write name="news" property="creationDate"/>
                </td>
            </tr>
            <tr>
                <td colspan="8">
                    <bean:write name="news" property="brief"/>
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
</body>
</html>
