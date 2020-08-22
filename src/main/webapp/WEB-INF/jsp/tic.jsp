<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${message}</title>

    <link rel="stylesheet" href="style.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>
    <h1>${message}</h1>
    <h4>Please set table size Row x Column</h4>
    <h1>${result}</h1>
    <form action="http://localhost:8080/" method="GET">
        <input type="number" step="1" name="row" value="3">
        <input type="number" step="1" name="column" value="3">
        <input type="submit">
        <c:forEach items="${tableData}" var="row">
            <div>
                <c:forEach items="${row}" var="column">
                    <span>${column} </span>
                </c:forEach>
            </div>
        </c:forEach>

        <div class="container" style="grid-template-rows: repeat(${row},1fr); grid-template-columns: repeat(${column},1fr); width:calc(100px * ${column});">
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
            <div class="cell"><button type="submit">ABC</button></div>
        </div>


    </form>

</body>

</html>