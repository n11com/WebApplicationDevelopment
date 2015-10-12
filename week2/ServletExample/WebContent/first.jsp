<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>

<html>
<head><title>Today's date</title></head>
<body>
<%
    // you can write normal java codes in jsp files. This kind of java codes are called a scriptlet.
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    String s = dateFormat.format(new Date());

    // out is an implicit variable that you can use to print anything to browser
    out.println("Today is " + s);
%>
</body>
</html>