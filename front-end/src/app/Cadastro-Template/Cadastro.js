async function tryLogin(user, password) {
    const response = await fetch(`${baseURL}/es-security/authenticate/biker`, {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',

        },
        body: JSON.stringify({
            user: user,
            password: password
        })
    });
    const jsonResponse = await response.json();
    return jsonResponse;
}