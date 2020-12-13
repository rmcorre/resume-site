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

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (1, 0, current_timestamp, current_timestamp, 'Horacio', 'Correia', 'rmcorre@gmail.com', '91 421 3861');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (2, 0, current_timestamp, current_timestamp, 'Ross', 'Correia', 'rmcorre@gmail.com', '91 421 3861');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (3, 0, current_timestamp, current_timestamp, 'Fabio', 'Barbosa', 'fabio@gmail.com', '91 999 9999');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (4, 0, current_timestamp, current_timestamp, 'Jorge', 'Almeida', 'jorge@gmail.com', '91 888 8888');

insert into address (
    id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
    island, country_region, postal_code, identity_id)
values (1, 0, current_timestamp, current_timestamp,
        'Identity', '19', 'Rua Eng Hernani Santos', null, 'Vila De Nordeste', 'Nordeste', null, 'Sao Miguel', 'Azores', '9630-202', 1);

insert into address (
    id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
    island, country_region, postal_code, identity_id)
values (2, 0, current_timestamp, current_timestamp,
        'Identity', '67c', 'Rua Teofilo De Braga', 'Sao Jose', 'Ponta Delgada', 'Ponta Delgada', null, 'Sao Miguel', 'Azores', '9500-000', 1);

insert into education (id, version, creation_time, update_time, institution, course, start_date, end_date)
values (1, 0, current_timestamp, current_timestamp, 'Concordia College University', 'Bachelor of Arts', 'Sep 1992', 'May 1995');

insert into education (id, version, creation_time, update_time, institution, course, start_date, end_date)
values (2, 0, current_timestamp, current_timestamp, 'Academia De Codigo', 'Full Stack Developer', 'May 2019', 'Aug 2019');

insert into address (
    id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
    island, country_region, postal_code, identity_id, education_id)
values (3, 0, current_timestamp, current_timestamp,
        'Education', null, '7128 Ada Blvd NW', null, 'Edmonton', null, 'Alberta', null, 'Canada', 'T5B 4E4', null, 1);

insert into address (
    id, version, creation_time, update_time, subject, num, address, parish, town_city, county, state_province,
    island, country_region, postal_code, identity_id, education_id)
values (4, 0, current_timestamp, current_timestamp,
        'Education', null, 'Rua de Jesus', null, 'Praia de Vitoria', null, null, 'Terceira', 'Azores', '9000-000', null, 2);

insert into portfolio (id, version, creation_time, update_time)
values (1, 0, current_timestamp, current_timestamp);

insert into portfolio (id, version, creation_time, update_time)
values (2, 0, current_timestamp, current_timestamp);

insert into portfolio (id, version, creation_time, update_time)
values (3, 0, current_timestamp, current_timestamp);

insert into portfolio_industry (portfolio_id, industry_id) values (1, 1);
insert into portfolio_industry (portfolio_id, industry_id) values (1, 2);

insert into portfolio_role (portfolio_id, role_id) values (1, 1);
insert into portfolio_role (portfolio_id, role_id) values (1, 2);
insert into portfolio_role (portfolio_id, role_id) values (1, 3);

insert into portfolio_identity (portfolio_id, identity_id) values (1, 1);
insert into portfolio_identity (portfolio_id, identity_id) values (1, 2);
insert into portfolio_identity (portfolio_id, identity_id) values (2, 3);
insert into portfolio_identity (portfolio_id, identity_id) values (3, 4);

insert into portfolio_education (portfolio_id, education_id) values (1, 1);
insert into portfolio_education (portfolio_id, education_id) values (1, 2);