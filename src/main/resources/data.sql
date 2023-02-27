create table tb_cidade (
  id bigint not null primary key ,
  nome varchar(50) not null,
  qtd_habitantes bigint
);

insert into tb_cidade
             (id,nome,qtd_habitantes)
       values
             (1,'Patos',120000),
             (2,'Campina Grande',450000),
             (3,'João Pessoa',850000),
             (4,'Cajazeiras',70000),
             (5,'Sousa',75000),
             (6,'Cabedelo',105000),
             (7,'Santa Rita',110000),
             (8,'Guarabira',55000),
             (9,'Sao José Espinharas',4500),
             (10,'Quixaba',3100),
             (11,'Sape',55000),
             (12,'Soledade',25000);
