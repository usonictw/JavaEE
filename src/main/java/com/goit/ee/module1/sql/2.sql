SELECT sum(salary) as sum_devs_salary, projects.name as proj_name, projects.id FROM developers JOIN proj_dev ON developers.id = proj_dev.id_dev
  JOIN projects ON proj_dev.id_proj = projects.id
WHERE proj_dev.id_proj = projects.id AND proj_dev.id_dev = developers.id
GROUP BY projects.name, projects.id  ORDER BY sum_devs_salary DESC LIMIT 1;