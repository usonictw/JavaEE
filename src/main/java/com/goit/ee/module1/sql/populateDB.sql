INSERT INTO developers (first_name, last_name, age) VALUES ('Leolani', 'Richey', 25), ('Melodi', 'Bennett', 28), ('Manual', 'Halverson', 30), ('Emery', 'Seppala', 28), ('Ambrose', 'Filippini', 33), ('Mohammed', 'Mose', 35), ('Joe', 'Brickhouse', 30), ('Tyler', 'Spainhour', 31), ('Gregg', 'Deak', 28), ('Saul', 'Betters', 30), ('Mckinly', 'Bonnet', 32), ('Lyman', 'Ange', 29), ('Milton', 'Koss', 28), ('Romeo', 'Fordham', 31), ('Calvin', 'Lavave', 30);
INSERT INTO skills (name) VALUES ('Java'), ('SQL'), ('JavaScript'), ('HTML'), ('CSS'), ('C++'), ('C#'), ('Swift'), ('OOP'), ('Linux'), ('Unix'), ('QA'), ('OracleDB'), ('Postgresql'), ('MySQL');
INSERT INTO projects (name) VALUES ('Cluod Based Online Blood Bank'), ('Qr Scan'), ('Fingerprint Voting System Project'), ('Online Law System'), ('Credit Card Fraud Detection'), ('Intelligent Chat Bot');
INSERT INTO companies (name, address) VALUES ('ScienceSoft', 'Finland'), ('OpenXcell', 'India'), ('Code brew labs', 'USA'), ('Oxagile', 'Belarus');
INSERT INTO customers (name, address) VALUES ('Carey Plunk', 'USA'), ('Sydney Mann', 'Canada'), ('Lino Bandick', 'Germany'), ('Alex Nagel', 'China');

INSERT INTO dev_skills (id_dev, id_skills) VALUES (1,10);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (1,11);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (2,1);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (2,3);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (3,1);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (3,3);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (3,9);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (4,8);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (5,2);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (5,4);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (5,5);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (5,3);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (6,1);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (6,2);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (6,9);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (7,12);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (7,11);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (7,10);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (8,7);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (8,9);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (9,2);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (9,13);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (9,14);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (9,15);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (10,6);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (10,10);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (11,3);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (11,4);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (11,5);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (12,12);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (12,7);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (13,11);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (13,10);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (14,1);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (14,9);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (14,2);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (15,1);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (15,3);
INSERT INTO dev_skills (id_dev, id_skills) VALUES (15,2);

INSERT INTO proj_dev (id_proj, id_dev) VALUES (1,1);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (1,2);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (1,3);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (2,9);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (2,10);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (2,5);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (2,2);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (2,13);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (3,13);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (3,4);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (3,15);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (3,1);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (4,2);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (4,5);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (4,6);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (4,14);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (4,6);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (5,6);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (5,7);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (5,8);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (5,9);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (5,10);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (5,15);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,4);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,11);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,14);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,6);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,2);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,3);
INSERT INTO proj_dev (id_proj, id_dev) VALUES (6,13);

INSERT INTO comp_proj (id_comp, id_proj) VALUES (1,1);
INSERT INTO comp_proj (id_comp, id_proj) VALUES (1,2);
INSERT INTO comp_proj (id_comp, id_proj) VALUES (2,3);
INSERT INTO comp_proj (id_comp, id_proj) VALUES (2,4);
INSERT INTO comp_proj (id_comp, id_proj) VALUES (3,5);
INSERT INTO comp_proj (id_comp, id_proj) VALUES (4,6);

INSERT INTO cust_proj (id_cust, id_proj) VALUES (1,1);
INSERT INTO cust_proj (id_cust, id_proj) VALUES (1,2);
INSERT INTO cust_proj (id_cust, id_proj) VALUES (2,3);
INSERT INTO cust_proj (id_cust, id_proj) VALUES (3,4);
INSERT INTO cust_proj (id_cust, id_proj) VALUES (4,5);
INSERT INTO cust_proj (id_cust, id_proj) VALUES (4,6);

