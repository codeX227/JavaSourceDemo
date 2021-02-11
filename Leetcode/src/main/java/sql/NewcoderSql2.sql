/*
 *
 * 查询入职员工时间排名倒数第3
 */

select * from employees order by hire_date desc limit 2,1;