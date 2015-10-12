<%!
    /*
     * Since jsp files are converted into servlets and all scriptlets are put into service method in the servlet,
     * it is not possible to create class instances or new methods as scriptlets.
     *
     * To overcome this, you'll need to use ! character after %. Notice this scriptlet's first three characters
     */
    public java.util.Date getTodaysDate() {
        return new java.util.Date();
    }
%>

<html>
<head><title>Declarations</title></head>
<body>
Today is <%=getTodaysDate()%>
</body>
</html>