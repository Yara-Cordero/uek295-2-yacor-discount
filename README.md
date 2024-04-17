# SETUP GUIDE 
How to run this Project on your local Machine. 

## REQUIRES 

- IDE such as [INTELLIJ](https://www.jetbrains.com/idea/download/?section=windows) or [VSCODE](https://code.visualstudio.com/download)
- [JDK 21](https://jdk.java.net/archive/)
- [GRADLE](https://spring.io/guides/gs/gradle)
- [DOCKER](https://www.docker.com/products/docker-desktop/)
- [POSTMAN](https://www.postman.com/downloads/)


-> The project supports JDK 17 aswell, although settings must be changed in `build.gradle` file.

<br>


## INSTALLATION 

### 1. ***CLONE REPOSITORY***

To use my project the files must be stored local on your device. The easiest way is to clone it via **GitBash** or **GitHub Desktop**.

```
git clone https://github.com/Yara-Cordero/uek295-2-yacor-discount
```

After cloning, *open the project* in your choosen IDE.

<br>

### 2. ***CREATE DOCKER CONTAINER***

Open up **CMD** and enter this command. 

```
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres
```

Check if the container was created. Using this command. 

```
docker ps
```

The return text should look something like this.

![image](https://github.com/Yara-Cordero/uek295-2-yacor-discount/assets/145566014/c3cffdbd-511d-42f1-bdeb-27a0634d5729)

<br>

### 3. ***STARTING THE PROJECT***

Start the project as shown by the arrow, this will run the `bootRun`.

![boot-run](https://github.com/Yara-Cordero/uek295-2-yacor-discount/assets/145566014/6479b802-7f6d-4b9d-a2c3-e91fb70c59fa)

<br>

### 4. ***USING ENDPOINTS***

To help you understand what endpoints do what, refer to my [Swagger Documentation](http://localhost:8080/swagger-ui/index.html#/).

The endpoints can be tested using Postman. 

<br>

***IMPORTANT NOTICE***

The Swagger Documentation can only be looked at if the project is running.


<br>

### 5. ***USERS***

You must authenticate yourself to use certain endpoints. 

***Admin-User***

username = `cooldude22`

password = `123`

<br>

***Normal-User***

username = `tubularperson10`

password = `123`

<br>

### 6. ***USEFUL INFORMATION***

- After setting up the docker, it can be stopped and started in the Docker application. 
- All changes made to the data in the database won't be saved after stopping the application.
- When updating data, send the entire body of the data which you're updating (to avoid empty data rows).




