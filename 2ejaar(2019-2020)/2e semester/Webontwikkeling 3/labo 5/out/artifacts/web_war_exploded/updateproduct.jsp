<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>Web shop</span>
        </h1>
        <nav>
            <ul>
                <li><a href="Controller">Home</a></li>
                <li><a href="Controller?command=overview">Overview</a></li>
                <li><a href="Controller?command=producten">Products</a></li>
                <li><a href="Controller?command=addproductpage">Add product</a></li>
                <li><a href="Controller?command=signUp">Sign up</a></li>
            </ul>
        </nav>
        <h2>Update Product</h2>

    </header>
    <main>
        <form method="post" action="Controller?command=updateProduct" novalidate>
            <!-- novalidate in order to be able to run tests correctly -->
            <p>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="<c:out value="${nameVorige}"/>" required>
            </p>
            <p>
                <label for="description">Description</label>
                <input type="text" id="description" name="description" value="<c:out value=" ${descriptionVorige}"/>" required>
            </p>
            <p>
                <label for="price">Price</label>
                <input type="number" id="price" name="price" value="<c:out value="${priceVorige}"/>" required>
            </p>
            <p>
                <label for="updateProduct"></label>
                <input type="submit" id="updateProduct" value="Save">
            </p>
            <input type="hidden" name="productId" value="<c:out value="${idVorige}"/>">

        </form>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg</footer>
</div>
</body>
</html>