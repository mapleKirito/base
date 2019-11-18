create table user
(
	id int auto_increment,
	account varchar(100) null,
	password varchar(100) null,
	token char(36) null,
	level int null,
	gmt_create bigint null,
	gmt_modified bigint null,
	constraint user_pk
		primary key (id)
);

