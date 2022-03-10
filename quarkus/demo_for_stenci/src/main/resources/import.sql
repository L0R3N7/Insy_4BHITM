insert into person (dateofbirth, firstname, gender, isAwesome, lastname)
values ('2002-12-02', 'Philipp', 'Male', true, 'MeisterEder'),
       ('2003-12-02', 'Ana', 'Female', true, 'Suppaanna');
insert into hobby (description, outdoor)
values ('moped fahren', true),
       ('häkeln', false );
insert into interest(person_id, hobby_id, amateur)
values (1,1,false ),
    (1,2, true),
    (2,2, true);
insert into address (city, post, street, streetnr)
    values ('Leonding', 4060, 'Limesstraße', 8),
           ('Manhatten', 59741, 'Nicholas Ave', 40);

--insert into address (post, street, streetnr, city)
   -- values (4060, 'Hammerlweg', 9, 'Leonding');
