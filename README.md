# Challenge talent4gig

Request: Transform java app https://github.com/hansonhsc/loan-quote
 to java web app

**The app has been ported as a spring boot web application.** For usage a simple client application was written in vanilla JavaScript to demonstrate the point.
## Usage
- Use maven to produce `jar` package of the app:
```
mvn install
```
- Open `http://localhost:8080/index.html` to access the client.

## Improvements
- Secure the app. To secure the app we can simply use the spring security module. The simplest way is to use basic authentication, where the client needs to send the user e password when calls authenticated apis. The requirement in this case is to use **https** comunication because otherwise we would be exposing credentials in plain text. Authorization can be handled by assciaating paths to roles which the user must have to access a particular path.
- Implement unit tests
