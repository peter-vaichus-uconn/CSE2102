# CSE2102

# Lab 1 instructions
# 
# To compile: run this command
# javac -cp junit-4.13.2.jar:src "./src/c/Hybrid.java" "./src/u/HybridTests.java"
#
# To run tests: run this command
# java -cp "junit-4.13.2.jar:hamcrest-core-1.3.jar:./src/" org.junit.runner.JUnitCore u.# HybridTests

# Lab 2 instructions
# ensure you are in the lab2 directory (FKA consumerBanking)
# To compile: 
# mvn clean compile
#
# To run tests: run this command
# mvn test

# Lab 3 instructions
# ensure you are in the lab3 directory 
# To compile: 
# mvn clean compile
#
# To run tests: run this command
# mvn test
#
# To run main:
# Compile all classes with javac
# Run main.class with java 

# Lab 4 instructions
# run "python3 my_server.py" to get the server up and running
# change the port to public
# open up another terminal
# run "python3 my_calls.py" to make http post calls to the server with the imbedded credentials
# with the current set up, the first three credentials will succeed and the last one will fail
# to test tokens:
# copy the outputed token and enter it as a command line argument in the following manner
# python3 secret.py token
# this will return "valid token" or "invalid token" depending on the token entered