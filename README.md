# -content_sharing_slatform

Setup and Testing the Content Sharing Platform Application 
 
The Content Sharing Platform is a web application, this platform allows users to create, view, like, update, and delete posts. Developed using the following technologies for its backend, security, database, and user interface.  
 
Backend: 
-	Framework: Spring Boot 
-	Security: Spring Security 
-	Database: MySQL 
 
User Interface: 
-	HTML 
-	Bootstrap 
-	JavaScript 
 
 
To run and test the application, follow these steps. Utilize Postman to test APIs  and A basic UI is also available for simple UI testing. 
 
Prerequisites: 
-	Java 17 and above 
-	MySQL version 8.0.32 
-	Intellij IDEA 
 
Step 1: Clone the Project 
Clone the project from the following URL:  
 
https://github.com/Hemanthkumar432/-content_sharing_slatform 
 
 Step 2: Import Project into Intellij IDEA 
 
1.	Open Intellij IDEA. 
2.	From the main menu, select "File" > "Open" and navigate to the cloned project directory. 
3.	Select the project folder and click "Open." 
 
Step 3: Update MySQL Properties 
 
1.	In the project, locate the `application.properties` file. 
2.	Update the MySQL connection properties with your database information: 
-	`spring.datasource.url`: Set the JDBC URL for your MySQL database. 
-	`spring.datasource.username`: Set your MySQL database username. 
-	`spring.datasource.password`: Set your MySQL database password. 
 
Step 4: Build the Solution 
 
Build the project by clicking the "Build" button in Intellij IDEA or using the command-line tools. 
 
Step 5: Run the Application 
 
1.	Locate the `ContentSharingPlatformApplication.java` file in the project. 
2.	click on the Play button on  ContentSharingPlatformApplication class. 
 
The application will start running on port 9001. 
Step 6: Test the APIs Using Postman 
 
1. Open Postman on your Machine. 
 
API 1: User Signup 
-	Method: POST 
-	URL: http://localhost:9001/api/user/signup 
-	Body: Provide user details for registration (name,email and password) 
 
API 2: Create a New Post 
-	Method: POST 
-	URL: http://localhost:9001/api/post/add 
-	Body: Provide text message for the new post 
 
API 3: Like/Unlike a Post 
-	Method: POST 
-	URL: http://localhost:9001/api/post/like/{postId} 
-	Body: No body needed 
 
API 4: Update a Post 
-	Method: PUT 
-	URL: http://localhost:9001/api/post/update/{postId} 
-	Body: Provide updated text message for the post 
 
 
API 5: Delete a Post 
-	Method: DELETE 
-	URL: http://localhost:9001/api/post/delete/{postId} 
-	Body: No body needed 
 
API 6: Search Posts 
-	Method: POST 
-	URL: http://localhost:9001/api/post/search 
-	Body: Provide search content 
 
Additional APIs: 
-	Get All Posts: 
-	Method: GET 
-	URL: http://localhost:9001/api/post/all 
 
-	Get Current User's Posts: 
-	Method: GET 
-	URL: http://localhost:9001/api/post/myposts 
 
Note : Implemented Spring Security so before testing any Url Register an user and add user credential as Basic Auth in postman: 
 
  
Step 7: Test Using Basic HTML UI 
 
A basic user interface is provided for simple UI testing.  
 
 
 
To access the UI: 
1.	Open a web browser. 
2.	Enter the URL: http://localhost:9001 
 
Use the provided UI elements to test various functionalities. 
 
 
That's it! You have successfully set up, run, and tested the Content Sharing Platform application using the Postman client and the provided basic user interface. 
