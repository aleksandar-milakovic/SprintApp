INSERT INTO sprint (id, ime, ukupno_bodova) VALUES (1,'sprint 1', '70');
INSERT INTO sprint (id, ime, ukupno_bodova) VALUES (2, 'sprint 2', '15');

INSERT INTO stanje (id,ime) VALUES (1,'zavrsen');
INSERT INTO stanje (id,ime) VALUES (2,'u toku');
INSERT INTO stanje (id,ime) VALUES (3,'nov');


INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (1, 'program 1', 'Nikola',25,1,2);
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (2, 'program 2', 'Aleksandar',15,2,2);
INSERT INTO zadatak (id, ime, zaduzeni, bodovi, sprint_id, stanje_id) VALUES (3, 'program 3', 'Milos',45,1,3);
