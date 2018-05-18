CREATE 
    ALGORITHM = MERGE 
    DEFINER = `root`@`%` 
    SQL SECURITY DEFINER
VIEW `HRAS`.`view_emp_salary` AS
    SELECT 
        `HRAS`.`emp_info`.`id` AS `emp_id`,
        `HRAS`.`emp_info`.`name` AS `emp_name`,
        `HRAS`.`com_post`.`name` AS `post_name`,
        `HRAS`.`com_post`.`post_salary` AS `post_salary_month`,
        `HRAS`.`emp_info`.`bonus` AS `year_bonus`
    FROM
        ((`HRAS`.`com_posting`
        JOIN `HRAS`.`com_post`)
        LEFT JOIN `HRAS`.`emp_info` ON ((`HRAS`.`com_posting`.`emp_id` = `HRAS`.`emp_info`.`id`)))
    WHERE
        (`HRAS`.`com_posting`.`post_id` = `HRAS`.`com_post`.`id`)