create table pessoas(
id_pessoa INT PRIMARY KEY AUTO_INCREMENT,
nome varchar(250) not null,
endereco_id int,
email varchar(250)unique not null,
cpf varchar(20)unique not null,
rg varchar(20)unique not null,
data_de_nascimento date not null,
foreign key (endereco_id) REFERENCES enderecos(id_endereco)
);
create table enderecos(
id_endereco int primary key auto_increment,
rua varchar(250)not null,
logradouro varchar(250) not null,
numero varchar(50)not null
);