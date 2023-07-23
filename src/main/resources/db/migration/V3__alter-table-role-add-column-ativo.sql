alter table role
add ativo tinyint;

update role set ativo = 1;

alter table role
modify column ativo tinyint not null;