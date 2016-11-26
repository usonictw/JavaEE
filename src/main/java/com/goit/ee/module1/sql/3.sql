SELECT sum(developers.salar
FROM developers
  INNER JOIN skills ON developers.id = skills.id
WHERE skills.name = 'Java';