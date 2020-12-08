insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (1, 0, current_timestamp, current_timestamp, 'Horacio', 'Correia', 'rmcorre@gmail.com', '91 421 3861');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (2, 0, current_timestamp, current_timestamp, 'Fabio', 'Barbosa', 'fabio@gmail.com', '91 999 9999');

insert into identity (id, version, creation_time, update_time, first_name, last_name, email, phone)
values (3, 0, current_timestamp, current_timestamp, 'Jorge', 'Almeida', 'jorge@gmail.com', '91 888 8888');

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