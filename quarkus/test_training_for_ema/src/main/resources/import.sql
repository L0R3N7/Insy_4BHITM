insert into vendingmachine (type)
values ('FOOD'),
       ('DRINKS'),
       ('DRINKS');

insert into product (type, productcode, name, price, volume, isvegetarian, vendingmachine_id)
values ('DrinkItem', 1000, 'Desinfektion', 3.99, 0.5, NULL, 2),
        ('DrinkItem', 1001, 'KinderWodka', 4.49, 0.75, NULL, 2),
       ('FoodItem', 30310, 'Obsttiegal', 2.5, NULL, true, 1),
       ('FoodItem', 30311, 'Laugenstangal', .78, NULL, true, 1),
       ('FoodItem', 30312, 'Schnitzalsemmal', 2.8, NULL, false, 1);