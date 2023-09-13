create table atendimento(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cargo varchar(20) not null,
    setor varchar(20) not null,
    requisicao varchar(100) not null,
    nivel varchar(20) not null,

     primary key(id)

);