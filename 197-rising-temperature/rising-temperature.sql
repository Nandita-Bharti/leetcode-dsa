# Write your MySQL query statement below
select w1.id 
from weather as w1
left join weather as w2 
on DATEDIFF(w1.recordDate, w2.recordDate) = 1
where w1.temperature > w2.temperature
-- SELECT w1.id
-- FROM Weather w1
-- JOIN Weather w2
-- WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1 
-- AND w2.temperature < w1.temperature;