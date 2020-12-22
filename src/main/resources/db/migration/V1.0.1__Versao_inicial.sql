DROP TABLE IF EXISTS orphanage; --INSERIDO APENAS PARA TESTE DESENVOLIVMENTO DROP
CREATE TABLE orphanage (id serial PRIMARY KEY, 	name VARCHAR ( 250 ) UNIQUE NOT NULL);
insert into orphanage(id, name) values (991, 'Casa Lar');
insert into orphanage(id, name) values (992, 'Lar Recanto do Carinho');