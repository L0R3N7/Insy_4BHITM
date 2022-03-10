-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');


insert into vendingmachine (type)
values ('FOOD'),
       ('DRINKS'),
       ('DRINKS');

insert into product (type, productcode, name, price, isvegan, volumn, vendingmachine_id)
values ('DrinkItem', 1000, 'Desinfektion', 4.99, null, .75, 2),
       ('DrinkItem', 1001, 'KinderWodka', 5.99, null, 1, 2),
       ('FoodItem', 30033, 'Obsttiegel', 2.5, true, null, 1),
       ('FoodItem', 30034, 'Laugenstangerl', 5.5, true, null, 1),
       ('FoodItem', 30035, 'Schnitzelsemmerl', 4.5, false, null, 1);