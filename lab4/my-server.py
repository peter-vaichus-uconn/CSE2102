from flask import Flask, request, make_response
import jwt

app = Flask(__name__)

accounts = {
    "peter":"qwerty",
    "john":"123456",
    "adam":"password",
    "luke":"password123",
}

@app.route("/login", methods=['POST']) #will execute upon adding /login to end of url
def login():
    username = request.form['username']
    password = request.form['password'] 

    if username in accounts and accounts[username] == password:
        encoded_jwt = jwt.encode({"username": username}, "qwerty", algorithm="HS256")
        return encoded_jwt

    return make_response("login failed",401)


if __name__=="__main__":
    app.run(host='0.0.0.0')




