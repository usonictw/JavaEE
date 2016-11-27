SELECT
  avg(salary)   avarage_sal,
  projects.name pro_name,
  projects.cost proj_cost
FROM developers
  JOIN proj_dev ON developers.id = proj_dev.id_dev
  JOIN projects ON proj_dev.id_proj = projects.id
GROUP BY pro_name, projects.cost
ORDER BY cost LIMIT 1;