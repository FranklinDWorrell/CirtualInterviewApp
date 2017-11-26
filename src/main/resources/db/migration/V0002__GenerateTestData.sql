INSERT INTO users (user_name) VALUES
    ('IAmTheWalrus'),
    ('YouAreTheEggMan'),
    ('Sophia'),
    ('Blanche'),
    ('Rose'),
    ('Dorothy');

INSERT INTO user_profiles (user_name, first_name, last_name, gender, birthday, city, state, country, quote) VALUES
    ('Dorothy', 'Bea', 'Arthur', 'F', '1922-05-13', 'Jackson', 'MS', 'USA', 'April is the cruelest month, breeding lilacs out of the dead ground, mixing memory and desire.'),
    ('IAmTheWalrus', 'Jack', 'Jackson', 'm', '1992-11-05', 'Athens', 'GA', 'US', 'Reach for the Sky(lar)!');

INSERT INTO messages (sender, time_sent, message_text) VALUES
    ('Dorothy', '2016-12-30 13:42:07', 'Thank you for being a friend...'),
    ('Rose', '2016-12-30 12:43:45', '...you travel down the road and back again.'),
    ('Dorothy', '2016-12-31 16:38:05', 'Maaaaaa!'),
    ('Sophia', '2017-01-01 00:01:11', 'Picture it! Sicily, 1922!'),
    ('IAmTheWalrus', '2017-04-05 03:21:19', 'I get by with a little help from my friends.'),
    ('YouAreTheEggMan', '2017-04-15 06:17:25', 'Words are flowing out like endless rain into a paper cup.'),
    ('Rose', '2017-05-01 00:05:31', 'I should get a bit part in Hot in Cleveland, right?'),
    ('IAmTheWalrus', '2017-09-16 11:42:23', 'He slams his fists against the post and still insists he sees the ghost.');

INSERT INTO message_recipients (message_id, recipient) VALUES
    (1, 'Rose'),
    (1, 'Blanche'),
    (1, 'Sophia'),
    (2, 'Dorothy'),
    (2, 'Blanche'),
    (2, 'Sophia'),
    (4, 'Dorothy'),
    (3, 'Sophia'),
    (7, 'Blanche'),
    (5, 'YouAreTheEggMan'),
    (6, 'IAmTheWalrus'),
    (8, 'YouAreTheEggMan');