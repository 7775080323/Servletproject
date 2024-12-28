<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login - My Bank</title>
    <link rel="icon" href="images/bank-icon.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body, html {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            height: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 50px;
            background-color: #ffffff;
            color: Black;
            width: 96%;
            position: fixed;
            top: 0;
            left: 0;
           
        }

        .bank-name {
            font-size: 24px;
            font-weight: bold;
        }

        .contact-info {
            font-size: 14px;
        }

        .login-container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
            max-width: 400px;
            width: 100%;
            margin: 100px auto 50px; /* Added margin to avoid overlap with the fixed header */
        }

        .login-container h2 {
            text-align: center;
            color: #2b8a3e;
            font-size: 24px;
            margin-bottom: 30px;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            font-size: 14px;
            color: #333;
            margin-bottom: 8px;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .input-group input:focus {
            border-color: #2b8a3e;
            outline: none;
        }

        .login-button {
            background-color: #2b8a3e;
            color: white;
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-button:hover {
            background-color: #236e29;
        }

        .forgot-password {
            text-align: center;
            margin-top: 15px;
        }

        .forgot-password a {
            color: #0056b3;
            text-decoration: none;
        }

        .forgot-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <!-- Header Section -->
    <div class="header">
        <div class="logo">
            <i class="fa-solid fa-building-columns" style="font-size: 40px; color: Black;"></i>
            <span class="bank-name"> MY BANK</span>
        </div>
        <div class="contact-info">
            <span><i class="fa-solid fa-phone"></i> +0671 1234567</span> |
            <span><i class="fa-solid fa-envelope"></i> help@Mybank.com</span>
        </div>
    </div>

    <div class="login-container">
        <h2>Login to My Bank</h2>

        <!-- Login Form -->
        <form action="UserLoginController" method="post">
            <div class="input-group">
                <label for="username">E-mail</label>
                <input type="text" id="email" name="username" placeholder="Enter your E-Mail Address" required>
            </div>

            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>

            <button type="submit" class="login-button">Login</button>

            <div class="forgot-password">
                <a href="#">Forgot password?</a>
            </div>
        </form>
    </div>

</body>
</html>