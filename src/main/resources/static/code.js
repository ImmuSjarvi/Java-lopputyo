let list = document.querySelector("ul")

//Getting list of students when opening the webpage
getStudents()

//Form button action.
document.querySelector("button")
.addEventListener("click", e =>{
    e.preventDefault()

    //Creating student object from the form information
    let student = {
        fname: document.getElementById("fname").value,
        lname: document.getElementById("lname").value,
        age: document.getElementById("age").value
    }

    //Posting the object as JSON to server
    //After posting getting the updated list of students from the server
    fetch("http://localhost:8080/addstudent",
        {
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(student)
        })
        .then(resp => getStudents())
})


//Function for getting all the students
function getStudents()
{
    //Empty the list in webpage
    list.innerHTML = ""

    //Fetch all the students from the server
    fetch("http://localhost:8080/students")
    .then(response => response.json())
    .then( data =>
    {
        //Create list item of each student object
        data.forEach(i => {
            let li = document.createElement("li")
            li.innerText = i.fname + " " + i.lname + ", Age: " + i.age
            list.appendChild(li)
        })
    })
}