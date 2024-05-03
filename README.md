![multiplier-app](https://github.com/amarg236/multiplier/blob/master/multiplier-app.png)
#Overview:
- Explore a user-friendly web application designed for number operations. Simply input a number, and witness its journey: it gets doubled, and then its doubled value is squared.

**Prerequisites**
- Java 17
- Maven
- Git

**How to to run the application?**

1. Clone the repository:

- ` git clone https://github.com/amarg236/multiplier.git`
- ` cd multiplier`

2. Build the project:
mvn clean package

3. Run the application
 `java -jar target/multiplier-0.0.1-SNAPSHOT.jar`


4. Access the application in your web browser at http://localhost:8080/api/v1/multiply


**Steps to access h2 database :**

- Once application running, access the h2 db using following url:
  http://localhost:8080/h2-console/
- Need make sure that dburl is: `jdbc:h2:mem:multiplier` and click connect with default value.


once backend is running, frontend could be cloned from another github repo:
https://github.com/amarg236/multiplier-front

**Steps to run the frontend app:**
url : https://github.com/amarg236/multiplier-front
1. `git clone: git@github.com:amarg236/multiplier-front.git`
2. `cd multiplier-front`
3. run commmand : `npm install`
4. `npm start`
5. Access the frontend react app in: http://localhost:3000/ 

  

