<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee-SignUp</title>
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
    <form modelAttribute="employee-sign-up" method="POST" action="/employee/signin" style="border:1px solid #ccc">
        <div class="container">
            <h1>Sign Up</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <label for="name"><b>Name</b></label>
            <input type="text" placeholder="Enter name" name="name" required>
            <label for="username"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="username" required>

            <label for="password"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>

            <label for="psw-repeat"><b>Repeat Password</b></label>
            <input type="text" placeholder="Repeat Password" name="psw-repeat" required>



            <label for="designation"><b>Designation</b></label>
            <input type="text" placeholder="Enter designation" name="designation" required>

            <div class="clearfix">
                <button class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
</body>

</html>