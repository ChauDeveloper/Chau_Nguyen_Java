use music_store_catalog;

insert into artist(`name`, instagram, twitter)values
    ('Chau', 'chauinstagram', 'chautwitter'),
    ('Randy', 'randyinstagram', 'randytwitter'),
    ('Pam', 'paminstagram', 'pamtwitter');

insert into label(`name`, website) values
    ('Chau label','www.chau.com'),
    ('Randy label','www.randy.com'),
    ('Pam label','www.pam.com');

insert into album(title, artist_id, release_date, label_id, list_price)values
    ('Fairy tale', 1, '2022-08-02', 1, 79.98),
    ('Stone rack', 2, '2022-08-01', 2, 29.99),
    ('twinkle little star', 3, '2022-08-03', 3, 19.99);

insert into track(album_id, title, run_time) values
    (1, 'Mountain Monster', 120),
    (2, 'Freaking drinks', 130),
    (3, 'Wonder island', 150),
    (1, 'Endless ego', 140),
    (2, 'Best scenario', 100),
    (3, 'Long meditation', 120);