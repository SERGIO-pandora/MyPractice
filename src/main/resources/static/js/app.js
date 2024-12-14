document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username: username, password: password })
    })
        .then(response => {
            if (response.ok) {
                window.location.href = "/admin";
            } else {
                alert('Невірні дані для входу!');
            }
        })
        .catch(error => {
            console.error('Помилка:', error);
        });
});

function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("active");
}

document.getElementById("menu-toggle").addEventListener("click", toggleSidebar);
