ALTER TABLE projects ADD COLUMN cost REAL;
UPDATE projects SET cost = '80000' WHERE id='1';
UPDATE projects SET cost = '50000' WHERE id='2';
UPDATE projects SET cost = '60000' WHERE id='3';
UPDATE projects SET cost = '100000' WHERE id='4';
UPDATE projects SET cost = '75000' WHERE id='5';
UPDATE projects SET cost = '40000' WHERE id='6';