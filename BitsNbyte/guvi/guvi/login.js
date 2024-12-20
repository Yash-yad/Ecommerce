function loginValidation() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // Simple validation
    if (email === "" || password === "") {
        alert("Please fill in both fields.");
        return false; // Prevent form submission
    }

    // Example of a simple email format check
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return false; // Prevent form submission
    }

    // If validation passes, you can proceed with form submission
    alert("Login successful!"); // Placeholder for actual login logic
    // Here you can add your login logic, e.g., sending data to the server
    return true; // Allow form submission
}