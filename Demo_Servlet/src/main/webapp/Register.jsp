<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body style="margin: 0; padding: 0; font-family: 'Arial', sans-serif; background-color: #f8f8f8; display: flex; flex-direction: column; align-items: center;">

<!-- Header Section -->
<div style="display: flex; justify-content: space-between; align-items: center; padding: 15px 50px; background-color: #ffffff; color: black; width: 96%; position: fixed; top: 0; left: 0; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);">
    <div style="display: flex; align-items: center;">
        <i class="fa-solid fa-building-columns" style="font-size: 40px; color: black; margin-right: 10px;"></i>
        <span style="font-size: 24px; font-weight: bold;">MY BANK</span>
    </div>
    <div>
        <button onclick="window.location.href='home.jsp'" style="background-color: #2b8a3e; color: white; border: none; padding: 10px 20px; border-radius: 15px; cursor: pointer; font-size: 14px; margin-right: 10px; transition: background-color 0.3s;">Home</button>
        <button onclick="window.location.href='help.jsp'" style="background-color: #2b8a3e; color: white; border: none; padding: 10px 20px; border-radius: 15px; cursor: pointer; font-size: 14px; transition: background-color 0.3s;">Help</button>
    </div>
</div>

<!-- Registration Form -->
<div style="display: flex; justify-content: center; align-items: center; height: calc(100vh - 60px); width: 100%; margin-top: 60px;">
    <form action="RegisterServlet" method="post" onsubmit="return validateForm()" style="background-color: white; border-radius: 8px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); padding: 40px; width: 100%; max-width: 400px;">
        <h2 style="text-align: center; color: #2b8a3e; font-size: 24px; margin-bottom: 30px;">Register for My Bank</h2>

        <div style="margin-bottom: 20px;">
            <label for="accNo" style="display: block; font-size: 14px; color: #333; margin-bottom: 8px;">Account Number</label>
            <input type="text" id="accNo" name="accNo" placeholder="Enter your Account Number" required style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 20px;">
            <label for="name" style="display: block; font-size: 14px; color: #333; margin-bottom: 8px;">Name</label>
            <input type="text" id="name" name="name" placeholder="Enter your Name" required style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 20px;">
            <label for="mobile" style="display: block; font-size: 14px; color: #333; margin-bottom: 8px;">Mobile</label>
            <input type="text" id="mobile" name="mobile" placeholder="Enter your Mobile Number (10 digits)" required pattern="\d{10}" style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 20px;">
            <label for="ifsc" style="display: block; font-size: 14px; color: #333; margin-bottom: 8px;">IFSC Code</label>
            <input type="text" id="ifsc" name="ifsc" placeholder="Enter your IFSC Code" required pattern="^[A-Z]{4}0[0-9]{6}$" style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 20px;">
            <label for="email" style="display: block; font-size: 14px; color: #333; margin-bottom: 8px;">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter your Email (e.g., abc123@gmail.com)" required pattern="^[a-z]+[0-9]+@gmail\.com$" style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 20px;">
            <label for="password" style="display: block; font-size: 14px; color: #333; margin-bottom: 8px;">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your Password" required style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box;">
        </div>

        <button type="submit" style="background-color: #2b8a3e; color: white; width: 100%; padding: 10px; border: none; border-radius: 4px; font-size: 16px; cursor: pointer; transition: background-color 0.3s;">Register</button>

        <div style="text-align: center; margin-top: 15px;">
            <a href="login.jsp" style="color: #0056b3; text-decoration: none;">Already have an account? Login here</a>
        </div>
    </form>
</div>

<script>
    function validateForm() {
    	const accNo = document.getElementById("accNo").value;
    	const mobile = document.getElementById("mobile").value;
        const email = document.getElementById("email").value;
        const ifsc = document.getElementById("ifsc").value;

        const emailRegex = /^[a-z]+[0-9]+@gmail\.com$/;
        const ifscRegex = /^[A-Z]{4}0[0-9]{6}$/;

        if (accNo.length !== 10 ) {
            alert("Account number must be exactly 12 alphanumeric characters.");
            return false;
        }
        
        if (mobile.length !== 10) {
            alert("Mobile number must be exactly 10 digits.");
            return false;
        }

        if (!ifscRegex.test(ifsc)) {
            alert("Invalid IFSC code! It must follow the format: 4 letters, '0', and 6 digits (e.g., SBIN0001234).");
            return false;
        }

        if (!emailRegex.test(email)) {
            alert("Email must follow the pattern: letters + numbers + '@gmail.com'.");
            return false;
        }

        return true;
    }
</script>

</body>
</html>
