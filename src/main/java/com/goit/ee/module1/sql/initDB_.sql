CREATE TABLE developers (id SERIAL PRIMARY KEY NOT NULL, first_name VARCHAR(15) NOT NULL, last_name VARCHAR(20) NOT NULL, age INT NOT NULL);
CREATE TABLE skills (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(15) NOT NULL);
CREATE TABLE projects (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL);
CREATE TABLE companies (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE customers (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
