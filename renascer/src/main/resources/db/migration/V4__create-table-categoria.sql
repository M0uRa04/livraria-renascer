CREATE TABLE categoria (

    id bigint unique not null auto_increment,

    nome varchar (30) not null,

    descricao varchar (1000) not null,

    primary key (id),
);