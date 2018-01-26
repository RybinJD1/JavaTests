<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>TopicAndTest</title>

    </head>
    <body>
    <form>
        <p><select size="1">
            <c:forEach items="${listOfTopics}" var="topic">
                <option value ="topic.getName">${topic.getName()}</option>
            </c:forEach>
        </select></p>
    </form>
    <form>
        <p><select size="1">
            <c:forEach items="${listOfTests}" var="test">
                <option value ="test.getName">${test.getName()}</option>
            </c:forEach>
        </select></p>
    </form>



    <p><input type="submit" value="Пройти тестирование"></p>

    </body>
</html>
