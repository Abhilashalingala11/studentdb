function addStudent() {

    let student = {
        name: document.getElementById("name").value,
        course: document.getElementById("course").value
    };

    fetch("/addStudent", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
        .then(res => res.json())
        .then(() => {
            alert("Student Added!");
            getStudents();
        });
}

function getStudents() {

    fetch("/students")
        .then(res => res.json())
        .then(data => {

            let table = document.getElementById("table");

            table.innerHTML = `
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Actions</th>
            </tr>
        `;

            data.forEach(s => {
                table.innerHTML += `
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.course}</td>
                    <td>
                        <button onclick="editStudent(${s.id}, '${s.name}', '${s.course}')">Edit</button>
                        <button onclick="deleteStudent(${s.id})">Delete</button>
                    </td>
                </tr>
            `;
            });

        });
}

function deleteStudent(id) {

    fetch("/students/" + id, {
        method: "DELETE"
    })
        .then(() => {
            alert("Deleted successfully!");
            getStudents();
        });
}

function editStudent(id) {

    fetch("/students")
        .then(res => res.json())
        .then(data => {

            let student = data.find(s => s.id === id);

            let newName = prompt("Enter new name", student.name);
            let newCourse = prompt("Enter new course", student.course);

            if (!newName || !newCourse) return;

            let updatedStudent = {
                name: newName,
                course: newCourse
            };

            fetch("/students/" + id, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(updatedStudent)
            })
                .then(() => {
                    alert("Updated successfully!");
                    getStudents();
                });
        });

}