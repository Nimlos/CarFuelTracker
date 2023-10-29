create sequence currency_seq start with 1 increment by 50;
create sequence distance_unit_seq start with 1 increment by 50;
create sequence volume_unit_seq start with 1 increment by 50;
create table car (id uuid not null, primary key (id));
create table currency (id integer not null, unit varchar(255) check (unit in ('DKK','USD')), primary key (id));
create table distance_unit (id integer not null, unit varchar(255) check (unit in ('MILES','KILOMETER')), primary key (id));
create table fuel (currency_id integer unique, distance float(53), distance_unit_id integer unique, price float(53), volume float(53), volume_unit_id integer unique, created_at timestamp(6) with time zone, car_id uuid not null, id uuid not null, primary key (id));
create table volume_unit (id integer not null, unit varchar(255) check (unit in ('LITER','GALLONS')), primary key (id));
alter table if exists fuel add constraint FKjpgtc145iarrlniwkn0my6vh0 foreign key (car_id) references car;
alter table if exists fuel add constraint FK294crwq2w3tkackygf4s2yj8k foreign key (currency_id) references currency;
alter table if exists fuel add constraint FKdbi6g1rt2pucxuktu2bwco6ps foreign key (distance_unit_id) references distance_unit;
alter table if exists fuel add constraint FK43w2jyg1rtjnvlw58qnptval9 foreign key (volume_unit_id) references volume_unit;
create sequence currency_seq start with 1 increment by 50;
create sequence distance_unit_seq start with 1 increment by 50;
create sequence volume_unit_seq start with 1 increment by 50;
create table car (id uuid not null, primary key (id));
create table currency (id integer not null, unit varchar(255) check (unit in ('DKK','USD')), primary key (id));
create table distance_unit (id integer not null, unit varchar(255) check (unit in ('MILES','KILOMETER')), primary key (id));
create table fuel (currency_id integer unique, distance float(53), distance_unit_id integer unique, price float(53), volume float(53), volume_unit_id integer unique, created_at timestamp(6) with time zone, car_id uuid not null, id uuid not null, primary key (id));
create table volume_unit (id integer not null, unit varchar(255) check (unit in ('LITER','GALLONS')), primary key (id));
alter table if exists fuel add constraint FKjpgtc145iarrlniwkn0my6vh0 foreign key (car_id) references car;
alter table if exists fuel add constraint FK294crwq2w3tkackygf4s2yj8k foreign key (currency_id) references currency;
alter table if exists fuel add constraint FKdbi6g1rt2pucxuktu2bwco6ps foreign key (distance_unit_id) references distance_unit;
alter table if exists fuel add constraint FK43w2jyg1rtjnvlw58qnptval9 foreign key (volume_unit_id) references volume_unit;