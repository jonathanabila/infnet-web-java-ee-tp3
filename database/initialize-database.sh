#!/bin/bash
set -e

SQL="
create table if not exists users
(
	id serial,
	email varchar,
	name varchar,
	password varchar
);

create unique index users_email_id_uindex
	on users (id);

create unique index users_email_uindex
	on users (email);

alter table users
	add constraint users_pk
		primary key (id);
"

docker exec -it database sh -c "psql -U postgres -d postgres -c \"$SQL\" ";