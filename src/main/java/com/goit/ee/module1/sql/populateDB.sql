INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT, 'Ivan', 'Ivanov', 23);
INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT, 'Sergey', 'Seergeev', 27);
INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT, 'Петр', 'Петров', 29);
INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT,'John', 'Johnson', 32);
INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT, 'Kate', 'Johanson', 34);
INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT, 'Ju', 'Yong', 32);
INSERT INTO developers (id, first_name, last_name, age) VALUES (DEFAULT, 'Michel', 'Svetlov', 43);

INSERT INTO skills (id, name) VALUES (DEFAULT, 'C#');
INSERT INTO skills (id, name) VALUES (DEFAULT, 'C++');
INSERT INTO skills (id, name) VALUES (DEFAULT, 'Java');
INSERT INTO skills (id, name) VALUES (DEFAULT, 'PHP');
INSERT INTO skills (id, name) VALUES (DEFAULT, 'JavaScript');
INSERT INTO skills (id, name) VALUES (DEFAULT, 'Ruby');

INSERT INTO companies (id, name, address) VALUES (DEFAULT, 'GlobalSoft', 'Kiev');
INSERT INTO companies (id, name, address) VALUES (DEFAULT, 'U-Soft', 'Poland');
INSERT INTO companies (id, name, address) VALUES (DEFAULT, 'Ukr-Soft', 'Kiev');
INSERT INTO companies (id, name, address) VALUES (DEFAULT, 'NetSoftAO', 'Dnepr');
INSERT INTO companies (id, name, address) VALUES (DEFAULT, 'HiSoft', 'Kiev');

INSERT INTO customers (id, name, address) VALUES (DEFAULT, 'LLC "E-EQ-NT"', 'Kiev');
INSERT INTO customers (id, name, address) VALUES (DEFAULT, 'KyivgorAdmin', 'Kiev');
INSERT INTO customers (id, name, address) VALUES (DEFAULT, 'Ukrainian Railway', 'Kiev');
INSERT INTO customers (id, name, address) VALUES (DEFAULT, '24Film', 'Kiev');

INSERT INTO projects (id, name) VALUES (DEFAULT, 'e-store');
INSERT INTO projects (id, name) VALUES (DEFAULT, 'Kinonline');
INSERT INTO projects (id, name) VALUES (DEFAULT, 'on-line-gov');
INSERT INTO projects (id, name) VALUES (DEFAULT, 'uz-booking');
INSERT INTO projects (id, name) VALUES (DEFAULT, 'NetApplication#1');
INSERT INTO projects (id, name) VALUES (DEFAULT, 'NetApplication#2');
INSERT INTO projects (id, name) VALUES (DEFAULT, 'WebApplication#3');

INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT, 1, 1);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT, 2, 1);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 3, 1);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 4, 3);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 4, 2);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT, 5, 6);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 6, 5);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 7, 4);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 2, 3);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 2, 4);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 6, 3);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 6, 6);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 7, 3);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 7, 1);
INSERT INTO dev_skills (id, id_dev, id_skills) VALUES (DEFAULT , 7, 2);


INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 1, 2);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 1, 1);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 2, 2);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 3, 3);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 4, 3);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 7, 1);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 5, 1);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 5, 4);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 5, 7);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 4, 5);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 6, 6);
INSERT INTO proj_devs (id, id_proj, id_dev) VALUES (DEFAULT, 6, 4);

INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 1, 2);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 1, 1);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 2, 2);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 3, 3);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 4, 3);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 3, 1);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 5, 1);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 5, 4);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 5, 7);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 4, 5);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 4, 6);
INSERT INTO comp_projs (id, id_comp, id_projs) VALUES (DEFAULT, 2, 4);












