alter table champ add column percent tinyint;

update champ set percent = 0;

alter table champ
modify column percent tinyint not null;