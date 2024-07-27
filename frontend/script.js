document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('signupUsername').value;
    const password = document.getElementById('signupPassword').value;
    fetch('http://localhost:3000/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    }).then(response => response.json())
      .then(data => alert(data.message))
      .catch(error => console.error('Error:', error));
});

document.getElementById('signinForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('signinUsername').value;
    const password = document.getElementById('signinPassword').value;
    fetch('http://localhost:3000/signin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    }).then(response => response.json())
      .then(data => alert(data.message))
      .catch(error => console.error('Error:', error));
});
