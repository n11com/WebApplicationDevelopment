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
                    <td>Age:</td>
                    <td><input type="text" name="age" /></td>
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
                <caption>All Employees</caption>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Age</td>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.age}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${not empty oldEmployees}">
            <table border="1">
                <caption>Old Employees</caption>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Age</td>
                </tr>
                <c:forEach var="employee" items="${oldEmployees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.age}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
