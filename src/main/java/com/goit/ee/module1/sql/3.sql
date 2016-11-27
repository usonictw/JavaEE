SELECT sum(salary) sum_salary,
  skills.name skill_name_of_devs
FROM developers
  JOIN dev_skills ON developers.id = dev_skills.id_dev
  JOIN skills ON dev_skills.id_skills = skills.id
WHERE skills.name = 'Java'
GROUP BY  skills.name, skills.id;