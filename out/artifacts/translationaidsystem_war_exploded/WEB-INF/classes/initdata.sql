insert into Dictionary (id, comment, name) values (202, 'fruit', 'frukty');

insert into User (id, name, email, password, userType) values (500, 'Ilya', 'Kovchenko', '123', 'dummy');
insert into User (id, name, email, password, userType) values (501, 'Alisa', 'Kurepina', '456', 'dummy');
insert into User (id, name, email, password, userType) values (502, 'q', 'q', 'q', 'dummy');

insert into wordpair(id, semanticUnitOne, semanticUnitTwo, rating, counter, dictionary_id, user_id) values (400, 'apple', 'yabloko', 10, 0, 202, 502);
insert into wordpair(id, semanticUnitOne, semanticUnitTwo, rating, counter, dictionary_id, user_id) values (401, 'peach', 'persik', 15, 0, 202, 502);
