
# URL Shortener Provider

- Given a long URL, return a shortened url. 
- Accessing the shortened url, redirects to the original long URL.


## Tech Stack

**Api:** Java 21, Springboot 3.5.0

**DataBase:** MongoDB

    
## Run Locally
In the command prompt:

1. Clone the project

```bash
  git clone https://github.com/leandropldev/shortener-url
```

2. Go to the project directory

```bash
  cd shortener-url
```

3. Start **mongo-db** docker image (docker installation required)

```bash
  cd docker
  docker compose up
```

4. Start the application (maven installation required)
5. open a new command tab and return to the root of project
6. run mvn run

```bash
    mvn spring-boot:run
```

## Running Tests

1. To run tests **locally**, open your preferred API Software (e.g. Postman)
2. create and access a new endpoint:
   1. POST: localhost:8080/shorten-url
   2. BODY:
      ```bash
      {
        "url": "http://your-long-and-hard-to-remember-full-url.com"
      }
      ```
   3. copy the shortened url in the response, example:
      ```bash
      {
        "url": "http://localhost/YjvU66sMi"
      }
      ```
   4. paste it in your browser
   5. that's it! 😄

## 🚀 About Me
Check my web portfolio: 
https://leandroreis-devstack.vercel.app/
   
