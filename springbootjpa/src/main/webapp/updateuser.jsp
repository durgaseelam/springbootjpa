<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<form method="post" action="deleteupdate">

			<table cellpadding="0" cellspacing="0" width="50%"">
				
				<tr>

					<td bgcolor="#FAFAF9" style="padding-left: 10px;">User Id</td>

					<td><input type="text" name="userId" maxlength="12"
						value=${user.userId} /></td>

				</tr>

				<tr>

					<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>

					<td><input type="text" name="firstName" maxlength="12"
						value=${user.firstName} /></td>

				</tr>
				<tr>
				
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>

					<td><input type="text" name="middleName" maxlength="12"
						value=${user.middleName} /></td>

				</tr>
				<tr>
				
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>

					<td><input type="text" name="lastName" maxlength="12"
						value=${user.lastName} /></td>

				</tr>
				<table  width="30%">
				<tr>
					<td><input type="submit" name="save" value="Update"/></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
			</table>
			</td>

</body>
</html>