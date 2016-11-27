SELECT sum(developers.salary)
FROM developers
  JOIN skills ON developers.id =
WHERE skills.name = 'Java';