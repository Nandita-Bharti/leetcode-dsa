# Write your MySQL query statement below
SELECT
    b.product_name,
    a.year,
    a.price
FROM Sales a
INNER JOIN Product b
ON a.product_id = b.product_id;