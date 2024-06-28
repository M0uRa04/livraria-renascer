CREATE TABLE usuario (

        id BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

        email VARCHAR(100) NOT NULL,

        senha VARCHAR(255) NOT NULL,

        primary key(id)

)