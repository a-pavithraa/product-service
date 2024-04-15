## Products Service

Execute the following command to start the KeyCloak and Postgres containers

`docker-compose up -d`

`./mvnw spring-boot:run`

To test the endpoints, import the Postman collection from the Postman folder.Click on Get New Access Token button in Authorization tab of postman collection. KeyCloak sign in page will be displayed.For admin access, enter username as **admin** and password as **admin**. For regular user, enter username as **user1** and password as **user1**. Click on use token and then hit the endpoints

![image-20240415171050754](/Users/pavithra/Library/Application Support/typora-user-images/image-20240415171050754.png)

References:

https://www.sivalabs.in/spring-security-oauth2-tutorial-introduction/