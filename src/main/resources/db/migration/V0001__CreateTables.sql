CREATE TABLE users (
    user_name       VARCHAR(20)                     PRIMARY KEY);

CREATE TABLE user_profiles (
    user_name       VARCHAR(20)                     PRIMARY KEY,
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    gender          CHAR(1),
    birthday        DATE,
    city            VARCHAR(100),
    state           VARCHAR(100),
    country         VARCHAR(100),
    quote           VARCHAR(2500),
    FOREIGN KEY (user_name) REFERENCES users(user_name));

CREATE TABLE messages (
    message_id      BIGINT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    sender          VARCHAR(20),
    time_sent       DATE,
    message_text    VARCHAR(255));

CREATE TABLE message_recipients (
    ms_recip_id     BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    message_id      BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    recipient       VARCHAR(20) NOT NULL,
    FOREIGN KEY (message_id) REFERENCES messages(message_id),
    FOREIGN KEY (recipient) REFERENCES users(username));