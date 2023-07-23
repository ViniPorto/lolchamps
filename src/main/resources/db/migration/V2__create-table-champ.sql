create table champ(
    id bigint not null auto_increment,
    name varchar(50) not null,
    role_id bigint not null,
    rpPrice smallint not null,
    eaPrice smallint not null,
    releaseDate date not null,
    sale tinyint not null,
    image varchar(510) not null,

    primary key (id),
    foreign key (role_id) references role (id)
)