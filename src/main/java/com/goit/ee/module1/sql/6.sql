SELECT *
FROM developers
JOIN proj_dev ON developers.id = proj_dev.id_dev
JOIN projects ON proj_dev.id_proj = projects.id
WHERE (SELECT )