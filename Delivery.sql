CREATE TABLE Consumidor (
	idConsumidor SERIAL,
	nome VARCHAR(200),
	CONSTRAINT pk_concumidor PRIMARY KEY (idConsumidor)
);

CREATE TABLE Mercado(
	idMercado SERIAL,
	nome VARCHAR(200),
	CONSTRAINT pk_mercado PRIMARY KEY (idMercado)
);

CREATE TABLE Funcionario(
	idFuncionario SERIAL,
	nome VARCHAR(200),
	idMercado INTEGER,
	CONSTRAINT pk_funcionario PRIMARY KEY (idFuncionario),
	CONSTRAINT fk_mercado FOREIGN KEY (idMercado) REFERENCES Mercado(idMercado)
);

CREATE TABLE Produto(
	idProduto SERIAL,
	nome VARCHAR(200),
	marca VARCHAR(200),
	preco FLOAT,
	CONSTRAINT pk_produto PRIMARY KEY (idProduto)
);

CREATE TABLE Categoria(
	idCategoria SERIAL,
	nome VARCHAR(200),
	CONSTRAINT pk_categoria PRIMARY KEY (idCategoria)
);

CREATE TABLE CategoriaProtudo(
	idProduto INTEGER,
	idCategoria INTEGER,
	CONSTRAINT fk_produto FOREIGN KEY (idProduto) REFERENCES Produto(idProduto),
	CONSTRAINT fk_categoria FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria)
);

CREATE TABLE Carrinho(
	idCarrinho SERIAL,
	valorTotal FLOAT,
	stat BOOLEAN,
	CONSTRAINT pk_carrinho PRIMARY KEY (idCarrinho)
);

CREATE TABLE ItemCarrinho(
	idItemCarrinho SERIAL,
	quantidade INTEGER,
	valorFinal FLOAT,
	idCarrinho INTEGER,
	idProduto INTEGER,
	CONSTRAINT pk_itemCarrinho PRIMARY KEY (idItemCarrinho),
	CONSTRAINT fk_carrinho FOREIGN KEY (idCarrinho) REFERENCES Carrinho(idCarrinho),
	CONSTRAINT fk_produto FOREIGN KEY (IdProduto) REFERENCES Produto(idProduto)
);
