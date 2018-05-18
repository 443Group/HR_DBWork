CREATE VIEW `view_dep_info` AS
SELECT dep1.id AS dep_id, dep1.name AS dep_name, emp_info.name AS mgr_name, dep1.addr, dep1.info, dep2.name AS parent_dep_name
FROM com_department AS dep1, com_department AS dep2, emp_info
WHERE dep1.parent_dep=dep2.id AND dep1.mgr=emp_info.id
WITH CASCADED CHECK OPTION;