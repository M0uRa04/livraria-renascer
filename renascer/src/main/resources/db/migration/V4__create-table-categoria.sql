CREATE TABLE categoria (

    id bigint unique not null auto_increment,

    nome varchar (30) not null unique,

    descricao varchar (1000) not null,

    ativo boolean not null,

    primary key (id)
);