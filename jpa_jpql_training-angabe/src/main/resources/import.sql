insert into player (playerno, name, initials, yearOfBirth, sex, yearJoined, street, houseNo, postCode, town, phoneNo, leagueNo)
values
    (6,'Parmenter','R',1964,'M',1977,'Haseltine Lane',
     '80','1234KK','Stratford','070-476537',8467),
    (44,'Baker','E',1963,'M',1980,'Lewis Street',
     '23','4444LJ','Inglewood','070-368753',1124),
    (83,'Hope','PK',1956,'M',1982,'Magdalena Road',
     '16A','1812UP','Stratford','070-353548',1608),
    (2,'Everett','R',1948,'M',1975,'Stoney Road',
     '43','3575NH','Stratford','070-237893',2411),
    (27,'Collins','DD',1964,'F',1983,'Long Drive',
     '804','8457DK','Eltham','079-234857',2513),
    (104,'Moorman','D',1970,'F',1984,'Stout Street',
     '65','9437AO','Eltham','079-987571',7060),
    (7,'Wise','GWS',1963,'M',1981,'Edgecombe Way',
     '39','9758VB','Stratford','070-347689',NULL),
    (57,'Brown','M',1971,'M',1985,'Edgecombe Way',
     '16','4377CB','Stratford','070-473458',6409),
    (39,'Bishop','D',1956,'M',1980,'Eaton Square',
     '78','9629CD','Stratford','070-393435',NULL),
    (112,'Bailey','IP',1963,'F',1984,'Vixen Road',
     '8','6392LK','Plymouth','010-548745',1319),
    (8,'Newcastle','B',1962,'F',1980,'Station Road',
     '4','6584RQ','Inglewood','070-458458',2983),
    (100,'Parmenter','P',1963,'M',1979,'Haseltine Lane',
     '80','1234KK','Stratford','070-494593',6524),
    (28,'Collins','C',1963,'F',1979,'Old Main Road',
     '10','1294QK','Midhurst','071-659599',NULL),
    (95,'Miller','P',1963,'M',1972,'High Street',
     '33A','5746OP','Douglas','070-867564',NULL);

insert into penalty (paymentno, player_playerno, pendate, amount)
values
        (1,6,'1980-12-08',100.0),
        (2,44,'1981-05-05',75.0),
        (3,27,'1983-09-10',100.0),
        (4,104,'1984-12-08',50.0),
        (5,44,'1980-12-08',25.0),
        (6,8,'1980-12-08',25.0),
        (7,44,'1982-12-30',30.0),
        (8,27,'1984-11-12',75.0);