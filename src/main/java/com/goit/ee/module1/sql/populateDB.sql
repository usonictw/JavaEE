CREATE TABLE dev_skills (id SERIAL NOT NULL,
 id_dev INT NOT NULL, 
 id_skills INT NOT NULL, 
 CONSTRAINT "dev_scills_pk" PRIMARY KEY (id), 
 CONSTRAINT devs_devs_skills FOREIGN KEY (id_dev) REFERENCES developers (id), 
 CONSTRAINT devs_skills_skills FOREIGN KEY (id_skills) REFERENCES skills (id));