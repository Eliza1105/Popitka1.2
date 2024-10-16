DROP TABLE IF EXISTS foods;
/*DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

 */
CREATE TABLE foods (
                       id_food int NOT NULL AUTO_INCREMENT,
                       food_name varchar(100) NOT NULL,
                       food_description text (2000) NOT NULL ,
                       food_unit double NOT NULL,
                       food_image varchar (100) NOT NULL,
                       PRIMARY KEY (id_food)
);
/*CREATE TABLE users(
    user_id int not null AUTO_INCREMENT,
    username varchar(255) not null ,
    password varchar(255) not null ,
    enabled int DEFAULT NULL,
    PRIMARY KEY (user_id)
);
CREATE TABLE roles (
                       role_id int NOT NULL AUTO_INCREMENT,
                       name varchar(45) NOT NULL,
                       PRIMARY KEY (role_id)
);
CREATE TABLE users_roles (
                             user_id int NOT NULL,
                             role_id int NOT NULL,
                             PRIMARY KEY (user_id,role_id),
                             CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
                             CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

 */