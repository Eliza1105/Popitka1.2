/*DROP TABLE IF EXISTS foods;

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
    marinade_description TEXT,
    marinade_image VARCHAR(255),
    id_food INT NOT NULL ,
    FOREIGN KEY (id_food) REFERENCES foods(id_food) ON DELETE CASCADE
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

 */



