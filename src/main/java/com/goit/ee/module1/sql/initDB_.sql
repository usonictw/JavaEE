CREATE TABLE developers (id SERIAL PRIMARY KEY NOT NULL, first_name VARCHAR(15) NOT NULL, last_name VARCHAR(20) NOT NULL, age INT NOT NULL);
CREATE TABLE skills (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(15) NOT NULL);
CREATE TABLE projects (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL);
CREATE TABLE companies (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE customers (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE dev_skills (id SERIAL PRIMARY KEY NOT NULL, id_dev INT, id_skills INT);

CREATE TABLE proj_devs (id SERIAL PRIMARY KEY NOT NULL, id_proj INT, id_dev INT);
CREATE TABLE comp_projs (id SERIAL PRIMARY KEY NOT NULL, id_comp INT, id_projs INT);
CREATE TABLE cust_projs (id SERIAL PRIMARY KEY NOT NULL, id_cust INT, id_projs INT);
ALTER TABLE public.dev_skills
  ADD CONSTRAINT skill_dev_dev FOREIGN KEY (id_skills)
      REFERENCES public.skills (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.dev_skills
  ADD CONSTRAINT devs_skill_skill FOREIGN KEY (id_dev)
      REFERENCES public.developers (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.proj_devs
  ADD CONSTRAINT dev_proj_proj FOREIGN KEY (id_dev)
      REFERENCES public.projects (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.proj_devs
  ADD CONSTRAINT proj_dev_dev FOREIGN KEY (id_proj)
      REFERENCES public.developers (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.comp_projs
  ADD CONSTRAINT proj_comp_comp FOREIGN KEY (id_projs)
      REFERENCES public.companies (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.comp_projs
  ADD CONSTRAINT comp_proj_proj FOREIGN KEY (id_comp)
      REFERENCES public.projects (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.cust_projs
  ADD CONSTRAINT proj_cust_cust FOREIGN KEY (id_projs)
      REFERENCES public.customers (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.cust_projs
  ADD CONSTRAINT cust_proj_proj FOREIGN KEY (id_cust)
      REFERENCES public.projects (id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION;