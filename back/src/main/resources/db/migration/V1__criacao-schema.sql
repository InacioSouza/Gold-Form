CREATE TABLE 
	estado (
		id SERIAL PRIMARY KEY,
		nome VARCHAR(255) NOT NULL,
		uf VARCHAR(2) NOT NULL
	);
	
CREATE TABLE 
	cidade(
		id SERIAL PRIMARY KEY,
		nome VARCHAR(255) NOT NULL,
		id_estado INT NOT NULL,
		FOREIGN KEY (id_estado) REFERENCES estado (id)
	);
	
CREATE TABLE 
	endereco(
		id SERIAL PRIMARY KEY,
		cep VARCHAR(8) NOT NULL,
		id_cidade INT NOT NULL,
		bairro VARCHAR(255) NOT NULL,
		rua VARCHAR(255) NOT NULL,
		numero INT NOT NULL,
		complemento VARCHAR(255),
		
		FOREIGN KEY (id_cidade) REFERENCES cidade (id)
	);
	
CREATE TABLE 
	usuario(
		id SERIAL PRIMARY KEY,
		nome VARCHAR(255) NOT NULL,
		idade INT NOT NULL,
		email VARCHAR(255) NOT NULL,
		senha VARCHAR(300) NOT NULL,
		id_endereco INT NOT NULL,
		
		FOREIGN KEY (id_endereco) REFERENCES endereco (id)
	);

	