CREATE TABLE `UF_TB` (
  `ID_UF`      int(11)     NOT NULL AUTO_INCREMENT,
  `UF`         char(2)     NOT NULL,
  `DESCRICAO`  varchar(50) NOT NULL,
  `CEPINICIAL` varchar(8)  NOT NULL,
  `CEPFINAL`   varchar(8)  NOT NULL,
  
  
  PRIMARY KEY (`ID_UF`)
 
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `LOCALIDADE_TB` (
  `ID_LOCALIDADE`    int(11)     NOT NULL,
  `FK_ID_UF`         int(11)     NOT NULL,
  `CEP`              varchar(8)  NOT NULL,
  `DESCRICAO`        varchar(50) NOT NULL,
  
  
  PRIMARY KEY (`ID_LOCALIDADE`)
  
  
   
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `BAIRRO_TB` (
  `ID_BAIRRO`        int(11)     NOT NULL,
  `FK_ID_UF`         int(11)     NOT NULL,
  `FK_ID_LOCALIDADE` int(11)     NOT NULL,
  `CEPINICIAL`       varchar(8)  NOT NULL,
  `CEPFINAL`         varchar(8)  NOT NULL,
  `DESCRICAO`        varchar(50) NOT NULL,
  
  
  PRIMARY KEY (`ID_BAIRRO`)
  
 
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `TIPO_LOGRADOURO_TB` (
  `ID_TIPO_LOGRADOURO` int(11)     NOT NULL,
  `DESCRICAO`          varchar(30) NOT NULL,
  `ABREVIATURA`        varchar(10) NOT NULL,
  
  PRIMARY KEY (`ID_TIPO_LOGRADOURO`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `ENDERECO_TB` (
  `ID_ENDERECO`           int(11)     NOT NULL AUTO_INCREMENT,
  `FK_ID_TIPO_LOGRADOURO` int(11)     NOT NULL,
  `LOGRADOURO`            varchar(80) NOT NULL,
  `NUMERO`                varchar(10),
  `COMPLEMENTO`           varchar(20),
  `CEP`                   varchar(8)  NOT NULL,
  `BAIRRO`                varchar(30) NOT NULL,
  `FK_ID_LOCALIDADE`      int(11)     NOT NULL,
  `FK_ID_UF`              int(11)     NOT NULL,
  `FK_ID_PESSOA`          int(11)     NOT NULL,

  
  
  PRIMARY KEY (`ID_ENDERECO`)
  
   

  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



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
  
  PRIMARY KEY (`ID_LOGRADOURO`)
 
  
 
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;