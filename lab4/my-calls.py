import httpx

url = "https://organic-waddle-pjgv96qpxwrgc7v6r-5000.app.github.dev/"


def test_auth(loginData):
    for credentials in loginData:
        response = httpx.post(url + "login", data=credentials)
        if response.status_code == 200:
            print("successful login")
            print(response.text + "\n")
        else:
            print("failed login")
            print(response.status_code)
    

loginData = [
    {"username": "peter", "password": "qwerty"},
    {"username": "john", "password": "123456"},
    {"username": "adam", "password": "passwor"},
    {"username": "luke", "password": "password12"}
]


test_auth(loginData)

