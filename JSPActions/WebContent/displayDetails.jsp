<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<jsp:useBean id="Product" class="com.Anusuya.training.jsp.Product"> 
<jsp:setProperty name="Product" property ="*"/>
</jsp:useBean>

Product Details:
<br />ID:<jsp:getProperty property ="id" name ="Product" />
<br />Name:<jsp:getProperty property ="name" name ="Product" />
<br />Description:<jsp:getProperty property ="description" name ="Product" />
 <br />Price:<jsp:getProperty property ="price" name ="Product" />

</body>
</html>