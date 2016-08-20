CREATE TABLE `PESSOA_TB` (
  `ID_PESSOA`     int(11)      NOT NULL AUTO_INCREMENT,
  `NOME`          varchar(100) NOT NULL,
  `CGCCPF`        varchar(14),
  `TIPOPESSOA`    varchar(10),
  `SENHA`         varchar(100),
  `EMAIL`         varchar(50),
  `LEMBRETE`      varchar(100),
  `RESPOSTA`      varchar(100),
  `DATACADASTRO`  Datetime DEFAULT NULL,
  `DATAALTERACAO` Datetime DEFAULT NULL,

  PRIMARY KEY (`ID_PESSOA`)
  
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

