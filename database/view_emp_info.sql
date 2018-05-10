CREATE ALGORITHM = MERGE VIEW `view_emp_info` AS
SELECT emp_info.id AS emp_id, emp_info.name AS emp_name, com_post.name AS post_name, com_department.name AS dep_name, emp_title.name AS title_name, emp_info.email, emp_info.phone_number, emp_info.birthday, emp_info.time_register, dict_info_1.value AS political_value, dict_info_2.value AS health_value
FROM emp_info, com_department, com_post, emp_title, com_posting, dict_info AS dict_info_1, dict_info AS dict_info_2
WHERE emp_info.id = com_posting.emp_id AND emp_info.dep_id=com_department.id AND emp_info.title=emp_title.id AND emp_info.political=dict_info_1.id AND emp_info.health=dict_info_2.id AND com_posting.post_id=com_post.id
WITH CASCADED CHECK OPTION;