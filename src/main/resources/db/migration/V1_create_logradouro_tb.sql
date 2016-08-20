CREATE TABLE `LOGRADOURO_TB` (
  `ID_LOGRADOURO`         int(11)     NOT NULL,
  `FK_ID_TIPO_LOGRADOURO` int(11)     NOT NULL,
  `FK_ID_LOCALIDADE`      int(11)     NOT NULL,
  `FK_ID_BAIRRO`          int(11)     NOT NULL,
  `FK_ID_UF`              int(11)     NOT NULL,
  `NUMINICIO`             int(5)      NOT NULL,
  `NUMFINAL`              int(5)      NOT NULL,
  `PAR`                   boolean,
  `IMPAR`                 boolean,
  `CEP`                   varchar(8)  NOT NULL,
  `DESCRICAO`             varchar(50) NOT NULL,
  
  PRIMARY KEY (`ID_LOGRADOURO`),
  LOCALIDADE_IDX1 INDEX (`CEP`),
  
  FOREIGN KEY (`FK_ID_TIPO_LOGRADOURO`) REFERENCES TIPO_LOGRADOURO_TB(`ID_TIPO_LOGRADOURO`)
  FOREIGN KEY (`FK_ID_LOCALIDADE`)      REFERENCES LOCALIDADE_TB(`ID_LOCALIDADE`)
  FOREIGN KEY (`FK_ID_BAIRRO`)          REFERENCES BAIIRO_TB(`ID_BAIRRO`)
  FOREIGN KEY (`FK_ID_UF`)              REFERENCES UF_TB(`ID_UF`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;