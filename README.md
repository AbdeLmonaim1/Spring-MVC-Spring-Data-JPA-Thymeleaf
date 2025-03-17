# Spring MVC, Spring Data JPA Thymeleaf
## Overview
The objective of this practical work is to develop a JEE web application using Spring MVC, Thymeleaf, and Spring Data JPA for patient management while applying best practices for collaborative development with Git and GitHub. The project is structured into several stages: first, implementing basic functionalities such as displaying, paginating, searching, and deleting patients; then, enhancing the interface with templates and form validation; and finally, integrating a security layer with Spring Security, exploring different authentication methods (**InMemory**, **JDBCAuthentication**, and **UserDetailsService**).
## Technologies Used

- <img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" width="30" height="30"/> &nbsp;&nbsp;**Java**
- <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/768px-Spring_Boot.svg.png" width="30" height="30"/>   **Spring Boot**
- <img src="https://blog.kakaocdn.net/dn/b5sGlw/btrSI8ZXQDq/NZqsZppkXksKj8BjJEHdhK/img.png" width="30" height="30"/> **Spring Security**
- <img src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg" width="30" height="30"/> &nbsp;&nbsp;**IntelliJ IDEA**
- <img src="https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png" width="30" height="30"/> &nbsp;&nbsp;**Git**
- <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="30" height="30"/> &nbsp;&nbsp;**GitHub**
## Practical Activity
### Dependency required:
- For Thymeleaf
```java
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
 </dependency>
```
  
  ```java
   <dependency>
            <groupId>nz.net.ultraq.thymeleaf</groupId>
            <artifactId>thymeleaf-layout-dialect</artifactId>
            <version>3.3.0</version>
        </dependency>
  ```
- For Bootstrap and bootstrap-icons
```java
<dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>5.3.3</version>
        </dependency>
```
```java
 <dependency>
            <groupId>org.webjars.npm</groupId>
            <artifactId>bootstrap-icons</artifactId>
            <version>1.11.3</version>
        </dependency>
```
- For Spring Security
```java
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
```java
<dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity6</artifactId>
            <version>3.1.0.M1</version>
        </dependency>
```
### HTML pages:
#### Template Page:
In Thymeleaf, a template page serves as a reusable model for multiple pages of the application. It allows centralizing common elements such as the header, menu, footer, and navigation bar to avoid duplicating HTML code in each page.
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head></head>
<body>
<!--common elements-->
<div layout:fragment="content">

</div>
</body>
</html>
```
#### another page for example: patients.html:
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="template"
>
<head></head>
<body>
  <div layout:fragment="content">
<!-- the content that will be displayed with the template page-->
</div>
</body>
</html>
```
### Demonstration:
- patients page
  ![image](https://github.com/user-attachments/assets/9cf96db6-849e-4dec-b33d-4f5d2e60447c)
- save patient
  ![image](https://github.com/user-attachments/assets/a59a62f3-1886-4545-8e0e-e179a762ce08)
- delete patient
  ![image](https://github.com/user-attachments/assets/60997a64-6c38-4c84-b109-8591097db56f)



