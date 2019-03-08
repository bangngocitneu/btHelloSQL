<%--
  Created by IntelliJ IDEA.
  User: ngoc_it_neu
  Date: 07/03/2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Edit Product Form</title>
    <style type="text/css"></style>
</head>
<body>
<h3>Edit Product</h3>
<p style="color: red;">${errorString}</p>
<form method="POST" action="product_edit">
    <input type="hidden" name="id" value="${product.id}"/>
    <table border="0">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${product.name}"/></td>
        </tr>
        <tr>
            <td>Descripion</td>
            <td><input type="text" name="description" value="${product.description}"/></td>
        </tr>
            <td>Price</td>
        <td><input type="text" name="price" value="${product.price}"/></td>
        <tr>
            <td colspan="2">
                <input type="submit" value="Edit"/>
            </td>
        </tr>
    </table>
</form>
</body>
