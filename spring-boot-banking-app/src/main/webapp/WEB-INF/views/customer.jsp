<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customers</title>
    <style>
        .container {
            max-width: 1000px;
            margin-left: auto;
            margin-right: auto; 
            padding-left: 10px;
            padding-right: 10px;
            height: 20rem;
            overflow: auto;
        }

        li {
            border-radius: 3px;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            margin-bottom: 25px;
        }




        .table-header {
            background-color: #95A5A6;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.03em;
        }

        .table-row {
            background-color: #ffffff;
            box-shadow: 0px 0px 9px 0px rgba(0, 0, 0, 0.1);
        }

        .col-1 {
            flex-basis: 20%;
        }

        .col-2 {
            flex-basis: 40%;
        }

        .col-3 {
            flex-basis: 25%;
        }

        .col-4 {
            flex-basis: 25%;
        }
    </style>
</head>

<body>
    <center>
        <h1 style="color: #95A5A6;">YAMAHA BANK OF INDIA</h1>
    </center>
    <div class="container">
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-1">Customer Id</div>
                <div class="col col-2">Name</div>
                <div class="col col-3">Balance</div>
                <div class="col col-4">Address</div>
                <div class="col col-4"></div>
                <div class="col col-4"></div>
            </li>

            <c:forEach items="${customerList}" var="cust">
                <li class="table-row">
                    <div class="col col-1">${cust.cusId}</div>
                    <div class="col col-2">${cust.name}</div>
                    <div class="col col-3">${cust.balance}</div>
                    <div class="col col-4">${cust.address}</div>
                    <div class="col col-4"><a href="${pageContext.request.contextPath}/employee/update/${cust.cusId}" >${cust.update}</a></div>
                    <div class="col col-4"><a href="${pageContext.request.contextPath}/employee/delete/${cust.cusId}" >${cust.delete}</a></div>
                </li>
            </c:forEach>

        </ul>
    </div>



</body>

</html>