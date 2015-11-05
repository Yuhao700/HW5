
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Badminton"%>
<% Badminton member = (Badminton) request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Update A Member Information</title>
        <link rel="stylesheet" type="text/css" href="Styling.css"/>
    </head>
    <body>
        <h1>Update A Member Information</h1>
        
        <form name="updateForm" action ="updateMember" method="get">
            
            <table class="update">    
            <tr>
                <td>Member ID:</td>
                <td><input type="text" name="memberid" value="<%= member.getMember_ID() %>"  /></td>
            </tr>
            
            <tr>
                <td>Whole Name:</td>
                <td><input type="text" name="officialname" value="<%= member.getOfficial_Name() %>"  /></td>
            </tr>
                
            <tr>
                <td>Prefer Name:</td>
                <td><input type="text" name="prefername" value="<%= member.getPrefer_Name() %>"  /></td>
            </tr>
                
            <tr>
                <td>Email Address:</td>
                <td><input type="text" name="email" value ="<%= member.getEmail() %>"  /></td>
            </tr>
            
            <tr>
                <td>Phone Number(example: 3333333333):</td>
                <td><input type="text" name="phonenumber" value = "<%= member.getPhone_Number() %>" /></td>
            </tr>
            </table>
            <input type="submit" name="submit" value="Update" />
        </form>
    </body>
</html>
