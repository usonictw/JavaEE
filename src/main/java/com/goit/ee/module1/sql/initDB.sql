CREATE TABLE developers (id SERIAL PRIMARY KEY NOT NULL, first_name VARCHAR(15) NOT NULL, last_name VARCHAR(20) NOT NULL, age INT NOT NULL);
CREATE TABLE skills (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(15) NOT NULL);
CREATE TABLE projects (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL);
CREATE TABLE companies (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE customers (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(30) NOT NULL, address VARCHAR(50));
CREATE TABLE dev_skills (id SERIAL PRIMARY KEY NOT NULL, id_dev INT NOT NULL, id_skills INT NOT NULL);
CREATE TABLE proj_dev (id SERIAL PRIMARY KEY NOT NULL, id_proj INT NOT NULL, id_dev INT NOT NULL);
CREATE TABLE comp_proj (id SERIAL PRIMARY KEY NOT NULL, id_comp INT NOT NULL, id_proj INT NOT NULL);
CREATE TABLE cust_proj (id SERIAL PRIMARY KEY NOT NULL, id_cust INT NOT NULL, id_proj INT NOT NULL);
ALTER TABLE public.dev_skills
  ADD CONSTRAINT dev_sk_devs_fk FOREIGN KEY (id_dev) REFERENCES public.developers (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.dev_skills
  ADD CONSTRAINT dev_skill_sk_fk FOREIGN KEY (id_skills) REFERENCES public.skills (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.proj_dev
  ADD CONSTRAINT proj_dev_to_dev FOREIGN KEY (id_dev) REFERENCES public.developers (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.proj_dev
  ADD CONSTRAINT proj_dev_to_proj FOREIGN KEY (id_proj) REFERENCES public.projects (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.comp_proj
  ADD CONSTRAINT comp_proj_to_proj FOREIGN KEY (id_proj) REFERENCES public.projects (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.comp_proj
  ADD CONSTRAINT comp_proj_to_comp FOREIGN KEY (id_comp) REFERENCES public.companies (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.cust_proj
  ADD CONSTRAINT cust_proj_to_proj FOREIGN KEY (id_proj) REFERENCES public.projects (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE public.cust_proj
  ADD CONSTRAINT cust_proj_to_cust FOREIGN KEY (id_cust) REFERENCES public.customers (id) MATCH FULL
   ON UPDATE NO ACTION ON DELETE NO ACTION;