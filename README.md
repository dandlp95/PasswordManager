# Overview

This is a simple Java program to store your passwords. The Password Handling class will get a string word, which will use the Java cipher class to encrypt it. The cipher will also use an instance of the SecreteKeySpec Java class to use an array that can be used to encrypt and decrypt the password. The FileHandler class will be in charge of creating the file and store it the encrypted password there. It will also retrieve the password for this file. 

In this digital time, a lot of us have dozens of accounts in different websites. This program is supposed to provide a means to store different passwords so you dont have to memorize them. The passwords will be encrypted as well. 

[Software Demo Video](https://youtu.be/59SxmJKTvRQ)

# Development Environment

The only tool external to Java I used was the IntelliJ IDE which proved to be very helpful, especially if you are beggining to learn Java. 

Java and the packages I used were: 
* Crypto
* io
* Security

# Useful Websites

* [W3 Schools](https://www.w3schools.com/java/)
* [Java official documentation](https://docs.oracle.com/en/java/)
* [StackOverflow](https://stackoverflow.com/)

# Future Work

* Ask user for master password to access his account passwords
* Instead of saving in a file, saving it in a SQL db or mongoDB
