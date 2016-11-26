SELECT sum(salary) as sum_devs_salary, projects.name as proj_name, projects.id FROM developers JOIN proj_devs ON developers.id = proj_devs.id_dev
JOIN projects ON proj_devs.id_proj = projects.id
WHERE proj_devs.id_proj = projects.id AND proj_devs.id_dev = developers.id
GROUP BY projects.name, projects.id LIMIT 1;