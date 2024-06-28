CREATE TABLE autor (

    id bigint unique not null auto_increment,

    nome varchar (100) not null unique,

    biografia varchar (1000) not null,

    primary key (id)
)