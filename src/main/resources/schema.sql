DROP TABLE IF EXISTS foods;

CREATE TABLE foods (
                       id_food int NOT NULL AUTO_INCREMENT,
                       food_name varchar(100) NOT NULL,
                       food_description text (2000) NOT NULL ,
                       food_unit double NOT NULL,
                       food_image varchar (100) NOT NULL,
                       PRIMARY KEY (id_food)
);
CREATE TABLE marinades(
    id_marinade INT AUTO_INCREMENT PRIMARY KEY,
    marinade_name VARCHAR(255) NOT NULL ,
    marinade_description TEXT(2000),
    marinade_image VARCHAR(255),
    id_food INT NOT NULL ,
    FOREIGN KEY (id_food) REFERENCES foods(id_food) ON DELETE CASCADE
);

CREATE TABLE alcohol(
                        id_alcohol int NOT NULL AUTO_INCREMENT,
                        alcohol_name varchar(30) NOT NULL,
                        alcohol_description text (200) NOT NULL,
                        alcohol_unit double NOT NULL,
                        alcohol_image VARCHAR(255),
                        PRIMARY KEY (id_alcohol)
);

CREATE TABLE alcoholfrees (
                             id_alcoholfree int NOT NULL AUTO_INCREMENT,
                             alcoholfree_name varchar(30) NOT NULL,
                             alcoholfree_description text (200) NOT NULL,
                             alcoholfree_unit double NOT NULL,
                             alcoholfree_image VARCHAR(255),
                             PRIMARY KEY (id_alcoholfree)
);

CREATE TABLE coctails
(
    id_coctail         int         NOT NULL AUTO_INCREMENT,
    coctail_name        varchar(30) NOT NULL,
    coctail_description text   (2000)     NOT NULL,
    coctail_image VARCHAR(255),
    id_alcohol int NOT NULL,
    id_alcoholfree int NOT NULL,

    PRIMARY KEY (id_coctail),
    FOREIGN KEY ( id_alcohol) REFERENCES alcohol(id_alcohol),
    FOREIGN KEY ( id_alcoholfree) REFERENCES alcoholfree(id_alcoholfree)
);

CREATE TABLE roles (
                         role_id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                         name varchar(45) NOT NULL
  );
CREATE TABLE usr(
                      user_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      username varchar(255) NOT NULL ,
                      password varchar(255) NOT NULL ,
                      enable BOOLEAN NOT NULL DEFAULT TRUE,
                role int NOT NULL,
                          FOREIGN KEY (role) REFERENCES roles(role_id)
  );





