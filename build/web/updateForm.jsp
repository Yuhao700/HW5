
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
                <td><input type="text" name="MemberID" value="<%= member.getMember_ID() %>"  /></td>
            <tr>
                <td>Whole Name:</td>
                <td><input type="text" name="OfficialName" value="<%= member.getOfficial_Name() %>"  /></td>
            <tr>
                <td>Prefer Name:</td>
                <td><input type="text" name="PreferName" value="<%= member.getPrefer_Name() %>"  /></td>
            <tr>
                <td>Email Address:</td>
                <td><input type="text" name="Email" value ="<%= member.getEmail() %>"  /></td>
            <tr>
                <td>Phone Number(example: 3333333333):</td>
                <td><input type="text" name="PhoneNumber" value = "<%= member.getPhone_Number() %>" /></td>
            <tr>
                <td><input type="submit" name="submit" value="Update" /></td>
            </table>
        </form>
    </body>
</html>
