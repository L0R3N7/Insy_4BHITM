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
insert into orderr (orderdate, person_id)
values (CURRENT_DATE, 1),
       (CURRENT_DATE, 2);

insert into orderitem(itemno, pcode, amount, pprice, orderr_orderno)
values (1, 1, 2, 5, 1),
       (2, 1, 6, 7.5, 1),
       (2, 4, 2, 12, 1),
       (1, 4, 2, 5, 2);