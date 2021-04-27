let login_form = document.getElementById('login-validation');

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        let response = await fetch('api/academia/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                password: document.getElementById( 'pwd').value,
            })
        });
        try{
            let result = await response.json();
            document.getElementById("submit-button").style.display = "block";
            sessionStorage.setItem('emp_id', result["employee_id"]);
            location.href = "myprof.html";
        }catch (err){
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("login-alert").style.display = "block";
        }
    }
});