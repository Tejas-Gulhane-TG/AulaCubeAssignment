User Authentication : The system allows users to create accounts and securely authenticate using their credentials
                      (username and password) with Spring Security, a powerful authentication and access control framework provided by Spring Boot.
                      where User can able to Register, Get, Update, Delete.
                      
Password Storage    : Users can securely store their passwords within the system. Passwords are encrypted using Spring Security's password encoder to
                      protect them from unauthorized access. 
                      
Multi-User Support  : The system supports multiple users with role-based access control implemented using Spring Security's role-based authorization features.


There is some EndPoint Created 
1. Register User   : localhost:8080/user/register
2. Get User        : localhost:8080/user/get/tgulhane28@gmail.com/Tejas@123
3. Update User     : localhost:8080/user/update/tgulhane28@gmail.com/Tejas@123
4. Delete User     : localhost:8080/user/delete/tgulhane28@gmail.com/Tejas@123
5. Add User Role   : localhost:8080/role/add/tejas/ADMIN
6. Get All User by Admin                     : localhost:8080/user/admin/get-all-users/tejas/12345
7. Get User By Admin using user email id     : localhost:8080/user/admin/get-user-by-emailId/tejas/12345/tgulhane28@gmail.com
8. Delete User By Admin using user email id  : localhost:8080/user/admin/delete-by-emailId/tejas/12345/tgulhane28@gmail.com
9. Delete All User By Admin                   : localhost:8080/user/admin/delete-all-user/tejas/12345

For User Register 
localhost:8080/user/register 
{
    "name":"Tejas",
    "mobileNo":9552776482,
    "emailId":"tgulhane28@gmail.com",
    "password":"Tejas@123"
}




