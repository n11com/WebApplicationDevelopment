<!DOCTYPE html>
<html>
    <head>
        <title>Employee Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <style type="text/css">
            * {
                margin: 0;
                padding: 0;
            }

            body {
                font-size: 62.5%;
                font-family: Helvetica, sans-serif;
                text-align: center;
            }

            p {
                font-size: 1.3em;
                margin-bottom: 15px;
            }

            #form-area {
                width: 600px;
                margin-top: 25px;
            }

            #form-area input {
                padding: 5px;
                width: 471px;
                font-family: Helvetica, sans-serif;
                font-size: 1.4em;
                margin: 0px 0px 10px 0px;
                border: 2px solid #ccc;
            }

            #form-area input.submit-button {
                width: 100px;
                float: right;
            }

            label {
                float: left;
                text-align: right;
                margin-right: 15px;
                width: 100px;
                padding-top: 5px;
                font-size: 1.4em;
            }
        </style>
    </head>
    <body>
        <div id="form-area">
            <form method="post" action="/add">
                <label for="employeeId">Employee Id:</label>
                <input type="text" name="employeeId" id="employeeId" />

                <label for="employeeName">Employee Name:</label>
                <input type="text" name="employeeName" id="employeeName" />

                <label for="employeeCity">Employee City:</label>
                <input type="text" name="employeeCity" id="employeeCity" />

                <input type="submit" name="submit" value="Submit" class="submit-button" />
            </form>

            <div style="clear: both;"></div>

            <p>Get the <a href="/employees" target="_blank">Employee List</a></p>
        </div>
    </body>
</html>