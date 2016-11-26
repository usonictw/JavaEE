CREATE TABLE developers (id SERIAL PRIMARY KEY NOT NULL, first_name VARCHAR(15) NOT NULL, last_name VARCHAR(20) NOT NULL, age INT NOT NULL);
CREATE TABLE skills (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(15) NOT NULL);
CREATE TABLE projects (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL);
CREATE TABLE companies (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE customers (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE dev_skills (id SERIAL NOT NULL, id_dev INT NOT NULL, id_skills INT NOT NULL, CONSTRAINT "dev_scills_pk" PRIMARY KEY (id), CONSTRAINT devs_devs_skills FOREIGN KEY (id_dev) REFERENCES developers (id), CONSTRAINT devs_skills_skills FOREIGN KEY (id_skills) REFERENCES skills (id));
CREATE TABLE proj_dev (id SERIAL NOT NULL, id_proj INT NOT NULL, id_dev INT NOT NULL, CONSTRAINT "proj_dev_pk" PRIMARY KEY (id), CONSTRAINT proj_proj_devs FOREIGN KEY (id_proj) REFERENCES projects (id), CONSTRAINT devs_proj_proj FOREIGN KEY (id_dev) REFERENCES developers (id));
CREATE TABLE comp_proj (id SERIAL NOT NULL, id_comp INT NOT NULL, id_proj INT NOT NULL, CONSTRAINT "comp_proj_pk" PRIMARY KEY (id), CONSTRAINT comp_comp_proj FOREIGN KEY (id_comp) REFERENCES companies (id), CONSTRAINT proj_proj_comp FOREIGN KEY (id_proj) REFERENCES projects (id));
CREATE TABLE cust_proj (id SERIAL NOT NULL, id_cust INT NOT NULL, id_proj INT NOT NULL, CONSTRAINT "cust_proj_pk" PRIMARY KEY (id), CONSTRAINT cust_cust_proj FOREIGN KEY (id_cust) REFERENCES customers (id), CONSTRAINT proj_proj_cust FOREIGN KEY (id_proj) REFERENCES projects (id));