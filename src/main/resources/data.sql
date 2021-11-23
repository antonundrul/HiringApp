insert ignore into roles(id, name)
values (1, 'ROLE_ADMIN');
insert ignore into roles(id, name)
values (2, 'ROLE_USER');
insert ignore into roles(id, name)
values (3, 'ROLE_HR');



insert ignore into users(id, email, first_name, last_name, password, username)
VALUES (1, 'admin@gmail.com', 'admin', 'admin', '$2a$10$pZynY40YR6UNrri5ccCg/uRb7T40SxXUN6lNWasel77XW7b8kx6QC', 'admin');


insert ignore into users_roles(role_id, user_id)
VALUES (1, 1);

insert ignore into users_roles(role_id, user_id)
VALUES (2, 1);

insert ignore into users_roles(role_id, user_id)
VALUES (3, 1);