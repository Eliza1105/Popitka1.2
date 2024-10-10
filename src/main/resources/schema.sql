DROP TABLE IF EXISTS foods;
CREATE TABLE foods (
                       id_food int NOT NULL AUTO_INCREMENT,
                       food_name varchar(100) NOT NULL,
                       food_description text (2000) NOT NULL ,
                       food_unit double NOT NULL,
                       food_image varchar (100) NOT NULL,
                       PRIMARY KEY (id_food)
);