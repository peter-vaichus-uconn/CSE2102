from flask import Flask, request

app = Flask(_name_)

@app.route("/")
def hello():
    return "you called \n"

#curl
@app.route("/echo",methods=['POST'])
def echo():
    return "You said: " +request.form['text']

if __name__=="__main__":
    app.run(host='0.0.0.0')