// function validateForm()
// {
//     const name=document.getElementById("name").value;
//     const address=document.getElementById("address").value;
//     const email=document.getElementById("email").value;
//     const password=document.getElementById("password").value;
//     const subject=document.getElementById("subject").value;
//     const agree=document.getElementById("agree").ariaChecked;


//     const nameError=document.getElementById("name-Error");
//     const addressError=document.getElementById("address-Error");
//     const emailError=document.getElementById("email-Error");
//     const passwordError=document.getElementById("password-Error");
//     const subjectError=document.getElementById("subject-Error");
//     const agreeError=document.getElementById("agree-Error");

//     nameError.textContent="";
//     addressError.textContent="";
//     emailError.textContent="";
//     passwordError.textContent="";
//     subjectError.textContent="";
//     agreeError.textContent="";


//     let isvalid=true;

//     if(name === "" || /\d/.test(name) )
//     {
//         nameError.textContent="please enter your name properly";
//         isvalid=false;
//     }

//     if(address === "")
//     {
//         address.textContent="please enter your address";
//         isvalid=false;
//     }

//     if(email === "" || !email.includes("@"))
//     {
//         emailError.textContent="please enter a valid email id";
//         isvalid=false;
//     }

//     if(password === "" || password.lenght < 0)
//     {
//         passwordError.textContent="please enter a valid email id with atleast8 character";
//         isvalid=false;
//     }

//     if(subject === "" || password.lenght < 0 )
//     {
//         subjectError.textContent="please enter your course.";
//         isvalid=false;
//     }

//     if(!agree)
//     {
//         agreeError.textContent="please agree to the above information";
//         isvalid=false;
//     }

//     return isvalid;



    

// }

function validateForm() {
    const name = document.getElementById("name").value;
    const address = document.getElementById("address").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const subject = document.getElementById("subject").value;
    const agree = document.getElementById("agree").checked; // Use .checked instead of .ariaChecked

    const nameError = document.getElementById("name-error"); // Corrected ID case
    const addressError = document.getElementById("address-error"); // Corrected ID case
    const emailError = document.getElementById("email-error"); // Corrected ID case
    const passwordError = document.getElementById("password-error"); // Corrected ID case
    const subjectError = document.getElementById("subject-error"); // Corrected ID case
    const agreeError = document.getElementById("agree-error"); // Corrected ID case

    // Clear previous error messages
    nameError.textContent = "";
    addressError.textContent = "";
    emailError.textContent = "";
    passwordError.textContent = "";
    subjectError.textContent = "";
    agreeError.textContent = "";

    let isValid = true;

    // Name validation
    if (name === "" || /\d/.test(name)) {
        nameError.textContent = "Please enter your name properly (no numbers allowed).";
        isValid = false;
    }

    // Address validation
    if (address === "") {
        addressError.textContent = "Please enter your address.";
        isValid = false;
    }

    // Email validation
    if (email === "" || !email.includes("@")) {
        emailError.textContent = "Please enter a valid email address.";
        isValid = false;
    }

    // Password validation
    if (password === "" || password.length < 8) { // Corrected length check
        passwordError.textContent = "Please enter a valid password with at least 8 characters.";
        isValid = false;
    }

    // Subject validation
    if (subject === "") {
        subjectError.textContent = "Please select your course.";
        isValid = false;
    }

    // Agreement validation
    if (!agree) {
        agreeError.textContent = "Please agree to the above information.";
        isValid = false;
    }

    return isValid; // Return the validation result
}