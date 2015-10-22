<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <body>
        <h2>Add Employee</h2>

        <form action="add" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Add!</button>
                    </td>
                </tr>
            </table>
        </form>

        <c:if test="${not empty employees}">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                    </tr>
                </c:forEach>
            </table>

        </c:if>

    </body>
</html>
