insert into Dictionary (id, comment, name) values (201, 'general', 'general');
insert into Dictionary (id, comment, name) values (200, 'sport', 'sport');
insert into Dictionary (id, comment, name) values (202, 'fruit', 'frukty');
insert into Dictionary (id, comment, name) values (203, 'vegetables', 'ovoschi');

insert into User (id, name, email, password, userType) values (500, 'Ilya', 'Kovchenko', '123', 'dummy');
insert into User (id, name, email, password, userType) values (501, 'Alisa', 'Kurepina', '456', 'dummy');
insert into User (id, name, email, password, userType) values (502, 'q', 'q', 'q', 'dummy');

insert into wordpair(id, semanticUnitOne, semanticUnitTwo, rating, counter, dictionary_id, user_id) values (400, 'apple', 'yabloko', 10, 0, 202, 502);
insert into wordpair(id, semanticUnitOne, semanticUnitTwo, rating, counter, dictionary_id, user_id) values (401, 'peach', 'persik', 15, 0, 202, 502);
insert into wordpair(id, semanticUnitOne, semanticUnitTwo, rating, counter, dictionary_id, user_id) values (402, 'apple', 'bomba', 10, 0, 201, 502);
insert into wordpair(id, semanticUnitOne, semanticUnitTwo, rating, counter, dictionary_id, user_id) values (403, 'apple', 'baseball ball', 10, 0, 200, 502);
