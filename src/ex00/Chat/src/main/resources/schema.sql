CREATE SCHEMA IF NOT EXISTS chat_database;
 CREATE TABLE chat_database.Users(
    id serial PRIMARY KEY,
    user_login varchar (40) UNIQUE,
    user_password varchar (40) UNIQUE,
    list_of_created_rooms_id INT,
    list_of_chatrooms_where_a_user_socializes_id INT,
    FOREIGN KEY (list_of_created_rooms_id) REFERENCES chat_database.list_of_created_rooms(id),
    FOREIGN KEY (list_of_chatrooms_where_a_user_socializes_id) REFERENCES chat_database.list_of_chatrooms_where_a_user_socializes(id)
                                 );

CREATE TABLE chat_database.Chatroom
(
    id                             serial PRIMARY KEY,
    chatroom_name                  varchar(40) UNIQUE,
    chatroom_owner_id                 INTEGER,
    list_of_messages_in_a_chatroom_id INTEGER,
    FOREIGN KEY (list_of_messages_in_a_chatroom_id) REFERENCES chat_database.list_of_messages_in_a_chatroom(id),
    CONSTRAINT fk_owner FOREIGN KEY (chatroom_owner_id) REFERENCES chat_database.Users (id)
);

CREATE TABLE chat_database.Message
(
    id           serial PRIMARY KEY,
    author_id       INTEGER,
    room_id         INTEGER,
    message_text varchar(255),
    data_time    timestamp with time zone,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES chat_database.Users (id),
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES chat_database.Chatroom (id)
);

CREATE TABLE chat_database.list_of_created_rooms (
    id SERIAL PRIMARY KEY,
    chatroom_owner_id INT,
    chatroom_id INT,
    chatroom_name varchar(40)
);

CREATE TABLE chat_database.list_of_chatrooms_where_a_user_socializes(
    id SERIAL PRIMARY KEY,
    chatroom_user_id INT,
    chatroom_room_id INT
);

CREATE TABLE chat_database.list_of_messages_in_a_chatroom(
    id INT PRIMARY KEY,
    chatroom_id INT,
    message_text varchar(255)
);
