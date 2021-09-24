<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Deposit Page</title>
    <style>
        * {
            box-sizing: border-box
        }

        input {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus,
        input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        button:hover {
            opacity: 1;
        }


        
        .signupbtn {
            float: left;
            width: 50%;
        }
        .container {
            padding: 16px;
        }
    </style>
</head>

<body>
    <form modelAttribute="deposit" method="POST"  style="border:1px solid #ccc">
        <div class="container">
            <h1>Deposit Page</h1>
            <hr>
            <label for="toAccId"><b>Deposit To Account Number</b></label>
            <input type="number" name="toAccId" >
            <label for="amount"><b>Amount</b></label>
            <input type="number" name="amount" >


            <div class="clearfix">
                <button class="signupbtn">Deposit</button>
            </div>
        </div>
    </form>
</body>

</html>