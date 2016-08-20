CREATE TABLE `PESSOA_TB` (
  `ID_PESSOA`     int(11)      NOT NULL AUTO_INCREMENT,
  `NOME`          varchar(100) NOT NULL,
  `CGCCPF`        varchar(14),
  `TIPOPESSOA`    varchar(10),
  `SENHA`         varchar(100),
  `EMAIL`         varchar(50),
  `LEMBRETE`      varchar(100),
  `RESPOSTA`      varchar(100),
  `DATACADASTRO`  Calendar DEFAULT NULL,
  `DATAALTERACAO` Calendar DEFAULT NULL,

  PRIMARY KEY (`ID_PESSOA`),
  PESSOA_IDX1 INDEX (`CGCCPF`),
  PESSOA_IDX2 INDEX (`EMAIL`),
  PESSOA_IDX3 INDEX (`NOME`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;