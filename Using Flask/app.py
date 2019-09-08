from flask import Flask, render_template, request

app = Flask(__name__)

@app.route("/")
def index():
    return render_template("signuppage.html")

usr_log = {}

@app.route("/sign", methods=["GET", "POST"])
def sign():
    if request.method == "POST":
        usrname = request.form.get("new_usrname")
        password = request.form.get("new_pass")
        usr_log[usrname] = password
        return render_template("loginpage.html")

@app.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        login_id = request.form.get("login_id")
        passw = request.form.get("password")
        if usr_log[login_id] == passw:
            return render_template("hello.html", name=str('hello' + str(login_id)))
        else:
            return render_template("hello.html", name="sorry wrong credentials")

