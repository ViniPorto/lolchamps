create table champ_role (
	id bigint not null auto_increment,
    champ_id bigint not null,
    role_id bigint not null,
    
    primary key(id),
    
    foreign key(champ_id) references champ(id),
    foreign key(role_id) references role(id)
);