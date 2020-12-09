insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (1, 0, current_timestamp, current_timestamp, 'Horacio', 'Correia', 'rmcorre@gmail.com', '91 421 3861');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (2, 0, current_timestamp, current_timestamp, 'Ross', 'Correia', 'rmcorre@gmail.com', '91 421 3861');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (3, 0, current_timestamp, current_timestamp, 'Fabio', 'Barbosa', 'fabio@gmail.com', '91 999 9999');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (4, 0, current_timestamp, current_timestamp, 'Jorge', 'Almeida', 'jorge@gmail.com', '91 888 8888');

insert into education (id, version, creation_time, update_time, institution, course, start_date, end_date)
values (1, 0, current_timestamp, current_timestamp, 'Concordia College University', 'Bachelor of Arts', 'Sep 1992', 'May 1995');

insert into education (id, version, creation_time, update_time, institution, course, start_date, end_date)
values (2, 0, current_timestamp, current_timestamp, 'Academia De Codigo', 'Full Stack Developer', 'May 2019', 'Aug 2019');

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

insert into portfolio (id, version, creation_time, update_time, category, specialization)
values (1, 0, current_timestamp, current_timestamp, 'Development', 'Full Stack Developer');

insert into portfolio (id, version, creation_time, update_time, category, specialization)
values (2, 0, current_timestamp, current_timestamp, 'Development', 'Front End Developer');

insert into portfolio (id, version, creation_time, update_time, category, specialization)
values (3, 0, current_timestamp, current_timestamp, 'Development', 'Back End Developer');

insert into portfolio_identity (portfolio_id, identity_id) values (1, 1);
insert into portfolio_identity (portfolio_id, identity_id) values (1, 2);
insert into portfolio_identity (portfolio_id, identity_id) values (2, 3);
insert into portfolio_identity (portfolio_id, identity_id) values (3, 4);