<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee | Sign in</title>
    <style>
        form {
            border: 3px solid #f1f1f1;
            width: 40%;
        }
        /* Full-width inputs */
        
        input[type=text],
        input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        /* Set a style for all buttons */
        
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
        /* Add a hover effect for buttons */
        
        button:hover {
            opacity: 0.8;
        }
        /* Center the avatar image inside this container */
        
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
            color: green;
            font-size: xx-large;
        }
        /* Avatar image */
        
        img.avatar {
            width: 100%;
            height: auto;
        }
        /* Add padding to containers */
        
        .container {
            padding: 16px;
        }
    </style>



</head>

<body>
	<h2>${errorMsg}</h2>
    <div style="display: flex;justify-content: center;margin-top: 4rem;">
        <form  method="POST" id="login-form">
            <div class="imgcontainer">
                <b>SIGN IN FORM</b>
            </div>

            <div class="container">
                <label path="empId"><b>Username</b></label>
                <input type="text" name="empId placeholder="Enter Username" required />

                <label path="password"><b>Password</b></form:label>
                <input name="password" type="password" placeholder="Enter Password" required />

                <label>
                <input type="checkbox" checked="checked" name="remember" /> Remember me
              </label>
                <button type="submit">Login</button>

            </div>
        </form>

    </div>
</body>

</html>