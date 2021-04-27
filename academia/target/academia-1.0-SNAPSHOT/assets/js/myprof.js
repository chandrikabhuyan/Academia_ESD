
idx = sessionStorage.getItem('emp_id');
fetch_employee();
async function fetch_employee() {
    if (!idx) {
        location.href = "index.html";
        return;
    }
    let response = await fetch("api/academia/"+idx+"/fetch", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: idx
        })
    });
    try {
        let employee = await response.json();
        console.log(employee);
        document.getElementById("empid").innerHTML = employee.employee_id;
        document.getElementById("fname").innerHTML = employee.first_name;
        document.getElementById("lname").innerHTML = employee.last_name;
        document.getElementById("email").innerHTML = employee.email;
        document.getElementById("dept").innerHTML = employee.dept_id.name;
        document.getElementById("title").innerHTML = employee.title;
        document.getElementById("name").innerHTML = employee.first_name + " " + employee.last_name;

    } catch(err){
        console.log(err);
    }

}