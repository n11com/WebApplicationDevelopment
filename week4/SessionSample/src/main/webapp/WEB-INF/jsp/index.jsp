<html>
    <body>
        <h2>Please Login</h2>

        <form action="login" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Login!</button>
                    </td>
                </tr>
            </table>
        </form>

        <p>${message}</p>

        <a href="secure">Access the secure page</a>

    </body>
</html>
