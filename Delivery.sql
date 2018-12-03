CREATE TABLE Consumidor
(idConsumidor      INTEGER,
 nome              VARCHAR(200) NOT NULL,
 CONSTRAINT pk_consumidor PRIMARY KEY (idConsumidor));

CREATE TABLE Mercado 
(idMercado   INTEGER,
 nome        VARCHAR(200) NOT NULL,
 CONSTRAINT pk_mercado   PRIMARY KEY (idMercado));
 
CREATE TABLE Funcionario 
(idFuncionario INTEGER,
 nome   	   VARCHAR(200) NOT NULL auto_increment,
 idMercado     INTEGER,
 CONSTRAINT pk_funcionario PRIMARY KEY (idFuncionario),
 CONSTRAINT fk_mercado     FOREIGN KEY (idMercado) references Mercado(idMercado));

CREATE TABLE Produto
(idProduto  INTEGER,
 nome       VARCHAR (200) NOT NULL,
 marca      VARCHAR(200) NOT NULL,
 CONSTRAINT pk_Produto PRIMARY KEY (idProduto));

CREATE TABLE Categoria
(idCategoria INTEGER,
 nome       VARCHAR(200) NOT NULL,
 CONSTRAINT pk_Categoria PRIMARY KEY (idCategoria));

CREATE TABLE Categoria_Produto
(idProduto    INTEGER,
 idCategoria  INTEGER,
 CONSTRAINT fk_Produto FOREIGN KEY (idProduto) references Produto(idProduto),
 CONSTRAINT fk_Categoria FOREIGN KEY  (idCategoria) references Categoria(idCategoria));

CREATE TABLE Carrinho
(idCarrinho   INTEGER,
valorTotal    FLOAT,
status        FLOAT,
idConsumidor  INTEGER,
CONSTRAINT id_carrinho PRIMARY KEY (idCarrinho),
CONSTRAINT id_consumidor FOREIGN KEY (idConsumidor)references Consumidor (idConsumidor));

CREATE TABLE ItemCarrinho
(idItemCarrinho    INTEGER,
quantidade         INTEGER,
valorFinal	   	   FLOAT,
idCarrinho         INTEGER,
idProduto  	   	   INTEGER,
CONSTRAINT id_itemCarrinho  PRIMARY KEY (idItemCarrinho),
CONSTRAINT id_carrinho  FOREIGN KEY  (idCarrinho) references Carrinho (idCarrinho),
CONSTRAINT id_produto   FOREIGN KEY  (idProduto) references Produto (idProduto));













