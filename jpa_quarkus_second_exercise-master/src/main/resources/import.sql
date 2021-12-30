insert into person (dateofbirth, firstname, gender, lastname)
values ('2002-12-02', 'John', 'Male', 'Doe'),
       ('2003-12-02', 'Jane', 'Female', 'Doe');
insert into hobby (description, outdoor)
values ('Hiking', true),
       ('Reading', false);
insert into interest(person_id, hobby_id, amateur)
values (1, 1, false),
       (2, 1, true),
       (1, 2, true);