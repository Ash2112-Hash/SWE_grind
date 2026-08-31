
# SpringBoot Tutorial Notes

Vid: https://www.youtube.com/watch?v=UgX5lgv4uVM


# What is Spring and its frameworks

- Spring is a java framework that allows you to create fast, secure web applications.
- Spring is also async and nonblocking allowing for a reactive app style
- Spring allows you to deliver production features with independently developable subunits called microservices

# Why Spring Boot?

Spring boot simplifies spring development through three core features:
- **Spring-boot starters:** In the past, all dependencies had to be manually copied and typed in your pom.xml. Starters are pre-defined dependency bundles that were introduced to solve this issue. They work directly with Spring's BOM to ensure you have all necessary spring deps are already registered in the pom.xml essential for initial dev work.
- **Auto-configuration**: auto-configuration is a built-in mechanism that automatically configures your Spring application based on the JAR dependecies in the classpath. This eliminates the need for boilerplate XML or java config beans for common use cases. Examples include setting up an embedded tomcat server and DispatcherServlet (if spring-boot-starter-web is on classpath) or setting up a in-memory db or datasource connection if a db driver (like mysql or postgres is detected) along the Spring JPA. 
- **Production-ready features**: the springboot Actuator allows you to access many essential production features for the spring application. Examples include endpoints, logging, metrics, health, beans, mappings, distributed tracing, etc. 


# Spring IoC and DI

- Dependency Injection allows for you to inject object/class dependencies within another object. This allows that object to retrieve these dependencies when its instance is being created. 



- In Spring, each object that is instantiated, managed and configured by Spring IoC (inversion of control) is called a Bean. 
- 
