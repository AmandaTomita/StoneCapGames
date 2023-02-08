BEGIN TRANSACTION;

--Add users
INSERT INTO users (username,password_hash,role,image) VALUES ('user1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/8138/avatar.svg');
INSERT INTO users (username,password_hash,role,image)VALUES ('user2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/106359/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('user3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/7225/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('user4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','https://www.svgrepo.com/show/35097/avatar.svg');
INSERT INTO users (username,password_hash,role,image) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN','https://www.svgrepo.com/show/29895/avatar.svg');

--Fill Boardgames with played, wishlist and owned
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'TAAifFP590', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'yqR4PtpO8X', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', '3IPVIROfvl', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'OIXt3DmJU0', 'wishlist');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', '5H5JS0KLzK', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('1', 'M7r9tO1GbX', 'owned');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'RLlDWHh7hR', 'played');
INSERT INTO boardgames (user_id, board_game_id, save_type) VALUES ('2', 'fDn9rQjH9O', 'played');

--Create friends entry
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','2');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('2','1');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','3');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','4');
INSERT INTO friends (user_id_one, user_id_two) VALUES ('1','5');
--Create a posts
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('1','https://cf.geekdo-images.com/hyqVOyVvyUAVu3PmlP9scg__imagepage/img/-UKJcRC6XhCjZ7JzC6u7m9JRq88=/fit-in/900x600/filters:no_upscale():strip_icc()/pic2977400.jpg', 'Scythe Test', 'Test Comment', 'test, testtest', '4', true);
INSERT INTO posts (user_id, image, title, comments, tags, rating, public_private) VALUES ('1','https://cf.geekdo-images.com/hyqVOyVvyUAVu3PmlP9scg__imagepage/img/-UKJcRC6XhCjZ7JzC6u7m9JRq88=/fit-in/900x600/filters:no_upscale():strip_icc()/pic2977400.jpg', 'Sythe Private Test', 'Test Comment Private', 'test, testtest', '4', false);


COMMIT TRANSACTION;
