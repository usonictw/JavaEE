SELECT
  customers.name AS cust_name,
  companies.name AS comp_name,
  projects.cost,
  projects.name AS proj_name
FROM projects
  JOIN cust_proj ON projects.id = cust_proj.id_proj
  JOIN customers ON cust_proj.id_cust = customers.id
  JOIN comp_proj ON projects.id = comp_proj.id_proj
  JOIN companies ON comp_proj.id_comp = companies.id
ORDER BY cost
LIMIT 1;