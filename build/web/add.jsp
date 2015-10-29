

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Friend</title>
        <link rel="stylesheet" type="text/css" href="Styling.css"/>
    </head>
    <body>
        <h1>Add A New Friend</h1>
        
        <form name="addForm" action ="addMember" method="get">
            <label>Whole Name:</label>
            <input type="text" name="OfficialName" value=""  />
            <br>
            <label>Prefer Name:</label>
            <input type="text" name="PreferName" value=""  />
            <br>
            <label>Email Address:</label>
            <input type="text" name="Email" value =""  />
            <br>
            <label>Phone Number(example: 3333333333):</label>
            <input type="text" name="PhoneNumber" value = "" />
            <br>
            <input type="submit" name="submit" value="Submit" />
            
        </form>
    </body>
</html>
