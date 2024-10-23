import jwt
import sys

def get_token(username):
    encoded_jwt = jwt.encode({"username": username}, "qwerty", algorithm="HS256")
    return encoded_jwt


def get_payload(token):
    try:
        decoded_jwt = jwt.decode(token, "qwerty", algorithms=["HS256"])
        return (f"valid token\nusername: {decoded_jwt['username']}")
    except jwt.ExpiredSignatureError:
        return "invalid token"  # Handle expired token
    except jwt.InvalidTokenError:
        return "invalid token"  # Handle any other invalid token

token = sys.argv[1]
print(get_payload(token))