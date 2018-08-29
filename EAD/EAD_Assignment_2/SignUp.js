function firstNameValidation(){
	var firstName=document.getElementById('txt_f_name');
	if(firstName.value.length<5 || /[^a-zA-Z]/.test(firstName.value)){
		firstName.style.borderColor="red";
		return false;
	}
	else{
		firstName.style.borderColor="green";
		firstName.focus();
		return true;
	}
}

function lastNameValidation(){
	var lastName=document.getElementById('txt_l_name');
	if(lastName.value.length<5 || /[^a-zA-Z]/.test(lastName.value)){
		lastName.style.borderColor="red";
		return false;
	}
	else{
		lastName.style.borderColor="green";
		lastName.focus();
		return true;
	}
	
}
function emailValidation(){
	var email=document.getElementById('txt_email');
	if(/[a-z][A-Za-z.0-9_]{4,}[@][a-z]+[.][a-z]{2,5}/.test(email.value)){
		email.style.borderColor="green";
		return true;
	}
	else{
		email.style.borderColor="red";
		return false;
	}
}
function passwordValidation(){
	var password=document.getElementById('txt_password');
	if(/[A-Z][a-z0-9]+[0-9]/.test(password.value) && (password.value.length>8)){
		password.style.borderColor="green";
		return true;
	}
	else{
		password.style.borderColor="red";
		return false;
	}
}

function confirmPasswordValidation(){
	var confirmPassword=document.getElementById('txt_c_password');
	var password=document.getElementById('txt_password');
	if(confirmPassword.value == password.value){
		confirmPassword.style.borderColor="green";
		return true;
	}
	else{
		confirmPassword.style.borderColor="red";
		return false;
	}
}
function contactNumberValidation(){
	var contactNumber=document.getElementById('txt_c_number');
	if(contactNumber.value.length<8|| /[^0-9]/.test(contactNumber.value)){
		contactNumber.style.borderColor="red";
		return false;
	}
	else{
		contactNumber.style.borderColor="green";
		return true;
	}
}
function signUpFormValidation(){
		if(firstNameValidation() && lastNameValidation() && emailValidation() && contactNumberValidation() && confirmPasswordValidation() && passwordValidation()){
			
			return true;
		}
		else{
			alert('Fill All Required Fields');
			return false;
		}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	