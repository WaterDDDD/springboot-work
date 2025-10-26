<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>查詢商品</title>
</head>
<body>
<h1>請輸入商品名稱或分類：</h1>

<form action="getProducts" method="get">
    <input type="text" name="name" placeholder="輸入商品名稱或分類"
           value="${param.name}">
    <button type="submit">查詢</button>
</form>

<hr>
<p>你搜尋的商品是：${keyword}</p>
<h3>搜尋結果：</h3>

<c:choose>
    <c:when test="${not empty products}">
        <ul>
            <c:forEach var="p" items="${products}">
                <li>
                    <h4>${p.productName} - 種類: ${p.category} - $${p.price} - 庫存: ${p.stock}</h4>
                </li>
            </c:forEach>
        </ul>
    </c:when>
    <c:when test="${param.name != null}">
        <p>沒有符合的商品</p>
    </c:when>
</c:choose>

</body>
</html>
