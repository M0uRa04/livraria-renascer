CREATE TABLE livro (

    id bigint unique not null auto_increment,

    titulo varchar (50) not null,

    preco decimal(10, 2) not null,

    data_publicacao date not null,

    estoque integer not null,

    primary key (id),

    categoria_id bigint not null,

    autor_id bigint not null,

    constraint fk_livro_categoria_id foreign key(categoria_id) references categoria(id),
    constraint fk_livro_autor_id foreign key(autor_id) references autor(id)

);