-- Write your query below

select * from (select  a.customer_id,a.customer_name from (select DISTINCT c.customer_id,c.customer_name from customers c  inner join orders o on c.customer_id=o.customer_id where o.product_name='A') as a inner join
(select  DISTINCT c.customer_id,c.customer_name from customers c  inner join orders o on c.customer_id=o.customer_id where o.product_name='B') as b on a.customer_id=b.customer_id) as r 
where r.customer_id not in (select distinct(c.customer_id) from customers c  inner join orders o on c.customer_id=o.customer_id where o.product_name='C') order by r.customer_name

--select distinct(c.customer_id) from customers c  inner join orders o on c.customer_id=o.customer_id where o.product_name in ('A','B');