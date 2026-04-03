insert into dict_voices (voices_type)
  values ('easy');
insert into musicians (id, name, family, born, country, voices, sex) values 
  (gen_random_uuid(), 'name1', 'family1', '1985-05-01', 'Russia', 'easy', 'MALE'),
  (gen_random_uuid(), 'name2', 'family2', '1985-07-02', 'Russia', 'easy', 'MALE'),
  (gen_random_uuid(), 'name3', 'family3', '1985-05-05', 'Russia', 'easy', 'MALE');
insert into dict_instruments (name, type, is_hand) values 
  ('guitar', 'ACOUSTIC', true),
  ('flute', 'ACOUSTIC', true); 
insert into owns_instrument (id, man, instrument) values
  (gen_random_uuid(), (select id from musicians where name = 'name1'), 'guitar'),
  (gen_random_uuid(), (select id from musicians where name = 'name1'), 'flute'),
  (gen_random_uuid(), (select id from musicians where name = 'name2'), 'guitar');
insert into groups (id, name, country, created_year, dropped_year, styles) values
  (gen_random_uuid(), 'Utro', 'Russia', 2025, null, '{folk}');
insert into group_members (id, "group", member, main_instruments, joined_year, separated_year) values
  (gen_random_uuid(), (select id from groups where name = 'Utro'), (select id from musicians where name = 'name3'), null, 2025, null),
  (gen_random_uuid(), (select id from groups where name = 'Utro'), (select id from musicians where name = 'name2'), 'guitar', 2025, null),
  (gen_random_uuid(), (select id from groups where name = 'Utro'), (select id from musicians where name = 'name1'), 'flute', 2025, null);
