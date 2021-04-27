var table = document.getElementById("table");
var table_header = "<tr class=\"header\">\n" +
    "<th style=\"width:5%;\">Course ID</th>\n" +
    "<th style=\"width:15%;\">Course Code</th>\n" +
    "<th style=\"width:21%;\">Description</th>\n" +
    "<th style=\"width:21%;\">Name</th>\n" +
    "<th style=\"width:10%;\">Credits</th>\n" +
    "<th style=\"width:10%;\">Capacity</th>\n" +
    "<th style=\"width:8%;\">Term</th>\n" +
    "<th style=\"width:10%;\">Year</th>\n" +
    "</tr>";
table.innerHTML=table_header;
window.onload = fetch_courses;
async function fetch_courses() {
    if (!sessionStorage.getItem('emp_id')) {
        location.href = "index.html";
        return;
    }
    let response = await fetch("api/academia/get");
    try {
        let courses = await response.json(); // read response body and parse as JSON
        console.table(courses);
        let courses_option = document.getElementById('courses');
        // courses_option.innerHTML = '<option value=""> Choose...</option>';

        for (let i = 0; i < courses.length; i++) {
            courses_option.innerHTML += '<option value="' + courses[i]['course_id'] + '">' + courses[i]['name'] + '</option>';
        }
        createTable(courses);
    }
    catch(err){
        console.log(err);
    }
}

function createTable(courses)
{
    var val= "";
    for(let i=0;i<courses.length;i++)
    {
        val+= "<tr><td>"+courses[i]['course_id']+"</td><td>"+courses[i]['course_code']+"</td><td>"+courses[i]['description']+"</td><td>"+
            courses[i]['name']+"</td><td>"+courses[i]['credits']+"</td><td>"+courses[i]['capacity']+"</td><td>"+courses[i]['term']+"</td><td>"+courses[i]['year']+"</td></tr>" ;
    }
    table.innerHTML=table_header+val;
}


let employee_register = document.getElementById('register-valid');

idx = sessionStorage.getItem('emp_id');
employee_register.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (employee_register.checkValidity() === true) {
        console.log();
        let response = await fetch('api/academia/enroll', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                employee_id : idx,
                course_id : document.getElementById('courses').value,
            })
        }).then(
            response => {
                if (response['status'] === 203) {
                    document.getElementById("login-success").style.display = "none";
                    document.getElementById("login-alert").style.display = "block";

                } else {
                    document.getElementById("login-alert").style.display = "none";
                    document.getElementById("login-success").style.display = "block";

                }
            }
        );
    }
});