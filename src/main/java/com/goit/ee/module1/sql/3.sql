SELECT sum(developers.salary)
FROM developers
  INNER JOIN skills ON developers.id = skills.id
WHERE skills.name = 'Java';