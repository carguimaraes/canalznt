CREATE TABLE `UF_TB` (
  `ID_UF`      int(11)     NOT NULL AUTO_INCREMENT,
  `UF`         char(2)     NOT NULL,
  `DESCRICAO`  varchar(50) NOT NULL,
  `CEPINICIAL` varchar(8)  NOT NULL,
  `CEPFINAL`   varchar(8)  NOT NULL,
  
  
  PRIMARY KEY (`ID_UF`),
  UF_IDX1 INDEX (`UF`),
  UF_IDX2 INDEX (`DESCRICAO`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;