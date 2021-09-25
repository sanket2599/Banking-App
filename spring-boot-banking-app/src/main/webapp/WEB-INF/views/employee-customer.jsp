<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Manager View</title>
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

            .navbar {
                overflow: hidden;
                background-color: #95A5A6;
                font-family: Arial;
            }

            .navbar_cust{
                overflow: hidden;
                background-color: #95A5A6;
                font-family: Arial;
                width: 90%;
            }

            .navbar_cust a {
                float: left;
                font-size: 16px;
                color: black;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            /* Links inside the navbar */

            .navbar a {
                float: left;
                font-size: 16px;
                color: black;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
        </style>
        <script>
            function myHome() {
                document.getElementById("home").setAttribute("style", "display:block;")
                document.getElementById("clerk").setAttribute("style", "display:none;")
                document.getElementById("customer").setAttribute("style", "display:none;")
            }

            function myClerks() {
                document.getElementById("home").setAttribute("style", "display:none;")
                document.getElementById("clerk").setAttribute("style", "display:block;")
                document.getElementById("customer").setAttribute("style", "display:none;")
            }

            function myCustomer() {
                document.getElementById("home").setAttribute("style", "display:none;")
                document.getElementById("clerk").setAttribute("style", "display:none;")
                document.getElementById("customer").setAttribute("style", "display:block;")
            }
        </script>
    </head>

    <body>
        <hr style="height:2px;border-width:0;color:gray;background-color:gray">
        <center>
            <h1 style="color: #95A5A6;">YAMAHA BANK OF INDIA</h1>
        </center>
        <hr style="height:2px;border-width:0;color:gray;background-color:gray">
        <div class="navbar">
            <a href="#home" onclick="myHome()">Home</a>
            <a href="#clerk" onclick="myClerks()">View Clerks</a>
            <a href="#customer" onclick="myCustomer()">View Customers</a>
            <a href="" style="padding-left: 55rem;">Log Out</a>
        </div>

        <div id="home" style="display: block;">
            <br>
            <!-- <img src="bankImg.jpg" height="100" /> -->
        </div>

        <div id="clerk">
            <div class="container " style="display: block; ">
                <ul class=" responsive-table ">
                    <li class="table-header ">
                        <div class="col col-1 ">Clerk Id</div>
                        <div class="col col-2 ">Name</div>
                        <div class="col col-3 ">Username</div>
                        <div class="col col-3 ">Address</div>
                        <div class="col col-4 ">Designation</div>
                        <div class="col col-4 "></div>
                        <div class="col col-4 "></div>
                    </li>

                    <c:forEach items="${employeeList}" var="emp">
                        <li class="table-row ">
                            <div class="col col-1 ">${emp.empId}</div>
                            <div class="col col-2 ">${emp.name}</div>
                            <div class="col col-3 ">${emp.username}</div>
                            <div class="col col-3 ">${emp.address}</div>
                            <div class="col col-4 ">${emp.designation}</div>
                            <div class="col col-4 "><a
                                    href="${pageContext.request.contextPath}/employee/clerk/update/${emp.empId} ">Update</a>
                            </div>
                            <div class="col col-4 "><a
                                    href="${pageContext.request.contextPath}/employee/clerk/delete/${emp.empId} ">Delete</a>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </div>
        </div>

        <div id="customer">
            <br>
            <center>
                <div class="navbar_cust">
                    <a href="/employee/manager/transfer">Transfer</a>
                    <a href="/employee/manager/deposit">Deposit</a>
                    <a href="/employee/manager/withdraw">Withdraw</a>
                    <a href="/employee/manager/addCustomer">Add Customer</a>
                </div>
            </center>
            <div class="container" style="display: block;">
                <ul class=" responsive-table ">
                    <li class="table-header ">
                        <div class="col col-1 ">Customer Id</div>
                        <div class="col col-2 ">Name</div>
                        <div class="col col-3 ">Balance</div>
                        <div class="col col-4 ">Address</div>
                        <div class="col col-4 "></div>
                        <div class="col col-4 "></div>
                    </li>

                    <c:forEach items="${customerList}" var="cust">
                        <li class="table-row ">
                            <div class="col col-1 ">${cust.cusId}</div>
                            <div class="col col-2 ">${cust.name}</div>
                            <div class="col col-3 ">${cust.balance}</div>
                            <div class="col col-4 ">${cust.address}</div>
                            <div class="col col-4 "><a
                                    href="${pageContext.request.contextPath}/employee/customer/update/${cust.cusId} ">Update</a>
                            </div>
                            <div class="col col-4 "><a
                                    href="${pageContext.request.contextPath}/employee/customer/delete/${cust.cusId} ">Delete</a>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </div>
        </div>


    </body>

    </html>