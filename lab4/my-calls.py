import httpx

url = "https://bug-free-system-q7p7wx6j7g629vj7-5000.app.github.dev/"

response = httpx.get(url)
print(response.status_code)
print(response)



response = httpx.get(url)
print(response.status_code)
print(response.text)

mydata = {
    "text": "Hello!",
    "param2": "Making a POST request",
    "body": "my own value"
}

# A POST request to the API
response = httpx.post(url, data=mydata)

# Print the response
print(response.text) 