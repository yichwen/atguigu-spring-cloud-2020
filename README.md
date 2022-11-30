Microservices Modules
1. create module
2. change pom
3. write yaml
4. startup
5. business logic
    5.1. SQL
    5.2. entities
    5.3. dao
    5.4. service
    5.5. controller

-----------------------------------------------------------------

MySQL Database Setup
Schema: cloud2020

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--------------------------------------------------------------------

Hot Reload
- adding devtools to your project

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

- adding plugin to your pom.xml

<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <fork>true</fork>
        <addResources>true</addResources>
    </configuration>
</plugin>

- enabling automatic build
- update the value of
- restart IDEA