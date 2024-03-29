insert into active (id, version, creation_time, update_time, entity, entity_id)
values (1, 0, current_timestamp, current_timestamp, 'Identity', true);

insert into industry (id, version, creation_time, update_time, industry)
values (1, 0, current_timestamp, current_timestamp, 'Software Development');

insert into industry (id, version, creation_time, update_time, industry)
values (2, 0, current_timestamp, current_timestamp, 'Hospitality');

insert into role (id, version, creation_time, update_time, role)
values (1, 0, current_timestamp, current_timestamp, 'Fullstack Developer');

insert into role (id, version, creation_time, update_time, role)
values (2, 0, current_timestamp, current_timestamp, 'Frontend Developer');

insert into role (id, version, creation_time, update_time, role)
values (3, 0, current_timestamp, current_timestamp, 'Backend Developer');

insert into identity (id, version, creation_time, update_time, first_name, last_name, active)
values (1, 0, current_timestamp, current_timestamp, 'Horacio', 'Correia', true);
-- insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
-- values (2, 0, current_timestamp, current_timestamp, 'Ross', 'Correia', 'rmcorre@gmail.com', '91 421 3861');
--
-- insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
-- values (3, 0, current_timestamp, current_timestamp, 'Fabio', 'Barbosa', 'fabio@gmail.com', '91 999 9999');
--
-- insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
-- values (4, 0, current_timestamp, current_timestamp, 'Jorge', 'Almeida', 'jorge@gmail.com', '91 888 8888');

-- insert into address (
--     id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
--     island, country_region, postal_code)
-- values (1, 0, current_timestamp, current_timestamp,
--         'Identity', '19', 'Rua Eng Hernani Santos', null, 'Vila De Nordeste', 'Nordeste', null, 'Sao Miguel', 'Azores', '9630-202');
--
-- insert into address (
--     id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
--     island, country_region, postal_code)
-- values (2, 0, current_timestamp, current_timestamp,
--         'Identity', '67c', 'Rua Teofilo De Braga', 'Sao Jose', 'Ponta Delgada', 'Ponta Delgada', null, 'Sao Miguel', 'Azores', '9500-000');

insert into education (id, version, creation_time, update_time, institution, course, start_date, end_date)
values (1, 0, current_timestamp, current_timestamp, 'Concordia College University', 'Bachelor of Arts', 'Sep 1992', 'May 1995');

insert into education (id, version, creation_time, update_time, institution, course, start_date, end_date)
values (2, 0, current_timestamp, current_timestamp, 'Academia De Codigo', 'Full Stack Developer', 'May 2019', 'Aug 2019');

insert into address (
    id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
    island, country_region, postal_code, education_id)
values (3, 0, current_timestamp, current_timestamp,
        'Education', null, '7128 Ada Blvd NW', null, 'Edmonton', null, 'Alberta', null, 'Canada', 'T5B 4E4', 1);

insert into address (
    id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
    island, country_region, postal_code, education_id)
values (4, 0, current_timestamp, current_timestamp,
        'Education', null, 'Rua de Jesus', null, 'Praia de Vitoria', null, null, 'Terceira', 'Azores', '9000-000', 2);

insert into education_group (id, version, creation_time, update_time, group_name)
values (1, 0, current_timestamp, current_timestamp, 'All');

insert into education_group (id, version, creation_time, update_time, group_name)
values (2, 0, current_timestamp, current_timestamp, 'Developer');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (1, 0, current_timestamp, current_timestamp, 'Architectural Patterns');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (2, 0, current_timestamp, current_timestamp, 'Design Patterns');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (3, 0, current_timestamp, current_timestamp, 'Domain-Driven Design');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (4, 0, current_timestamp, current_timestamp, 'OOP');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (5, 0, current_timestamp, current_timestamp, 'Food and Beverage');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (6, 0, current_timestamp, current_timestamp, 'Customer Service');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (7, 0, current_timestamp, current_timestamp, 'Shipping');

insert into knowledge (id, version, creation_time, update_time, knowledge_item)
values (8, 0, current_timestamp, current_timestamp, 'Receiving');

insert into skill (id, version, creation_time, update_time, skill_name)
values (1, 0, current_timestamp, current_timestamp, 'JPA');

insert into skill (id, version, creation_time, update_time, skill_name)
values (2, 0, current_timestamp, current_timestamp, 'Hibernate');

insert into skill (id, version, creation_time, update_time, skill_name)
values (3, 0, current_timestamp, current_timestamp, 'Spring');

insert into skill (id, version, creation_time, update_time, skill_name)
values (4, 0, current_timestamp, current_timestamp, 'Spring Boot');

insert into skill (id, version, creation_time, update_time, skill_name)
values (5, 0, current_timestamp, current_timestamp, 'Spring MVC');

insert into skill (id, version, creation_time, update_time, skill_name)
values (6, 0, current_timestamp, current_timestamp, 'JDBC');

insert into skill (id, version, creation_time, update_time, skill_name)
values (7, 0, current_timestamp, current_timestamp, 'HTML');

insert into skill (id, version, creation_time, update_time, skill_name)
values (8, 0, current_timestamp, current_timestamp, 'CSS');

insert into skill (id, version, creation_time, update_time, skill_name)
values (9, 0, current_timestamp, current_timestamp, 'JavaScript');

insert into portfolio (id, version, creation_time, update_time)
values (1, 0, current_timestamp, current_timestamp);

insert into portfolio (id, version, creation_time, update_time)
values (2, 0, current_timestamp, current_timestamp);

insert into portfolio (id, version, creation_time, update_time)
values (3, 0, current_timestamp, current_timestamp);

-- insert into portfolio_industry_role (portfolio_id, industry_id, role_id) values (1, 1, 1);
-- insert into portfolio_industry_role (portfolio_id, industry_id, role_id) values (1, 2, 2);

-- insert into portfolio_role (portfolio_id, role_id) values (1, 1);
-- insert into portfolio_role (portfolio_id, role_id) values (1, 2);
-- insert into portfolio_role (portfolio_id, role_id) values (1, 3);

-- insert into portfolio_identity (portfolio_id, identity_id) values (1, 1);
-- insert into portfolio_identity (portfolio_id, identity_id) values (1, 2);
-- insert into portfolio_identity (portfolio_id, identity_id) values (2, 3);
-- insert into portfolio_identity (portfolio_id, identity_id) values (3, 4);

-- insert into portfolio_education (portfolio_id, education_id) values (1, 1);
-- insert into portfolio_education (portfolio_id, education_id) values (1, 2);

-- insert into educationgroup_education (educationgroup_id, education_id) values (1, 1);
-- insert into educationgroup_education (educationgroup_id, education_id) values (1, 2);
-- insert into educationgroup_education (educationgroup_id, education_id) values (2, 1);

-- insert into portfolio_educationgroup (portfolio_id, educationgroup_id) values (1, 1);
-- insert into portfolio_educationgroup (portfolio_id, educationgroup_id) values (2, 2);

insert into industry_knowledge (industry_id, knowledge_id) values (1, 1);
insert into industry_knowledge (industry_id, knowledge_id) values (1, 2);
insert into industry_knowledge (industry_id, knowledge_id) values (1, 3);
insert into industry_knowledge (industry_id, knowledge_id) values (1, 4);
insert into industry_knowledge (industry_id, knowledge_id) values (2, 5);
insert into industry_knowledge (industry_id, knowledge_id) values (2, 6);

insert into role_skill (role_id, skill_id) values (1, 1);
insert into role_skill (role_id, skill_id) values (1, 2);
insert into role_skill (role_id, skill_id) values (1, 3);
insert into role_skill (role_id, skill_id) values (1, 4);
insert into role_skill (role_id, skill_id) values (1, 5);
insert into role_skill (role_id, skill_id) values (1, 6);
insert into role_skill (role_id, skill_id) values (1, 7);
insert into role_skill (role_id, skill_id) values (1, 8);
insert into role_skill (role_id, skill_id) values (1, 9);
insert into role_skill (role_id, skill_id) values (2, 7);
insert into role_skill (role_id, skill_id) values (2, 8);
insert into role_skill (role_id, skill_id) values (2, 9);
insert into role_skill (role_id, skill_id) values (3, 1);
insert into role_skill (role_id, skill_id) values (3, 2);
insert into role_skill (role_id, skill_id) values (3, 3);
insert into role_skill (role_id, skill_id) values (3, 4);
insert into role_skill (role_id, skill_id) values (3, 5);
insert into role_skill (role_id, skill_id) values (3, 6);