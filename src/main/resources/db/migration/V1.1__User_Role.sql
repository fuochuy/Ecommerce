CREATE TABLE IF NOT EXISTS users(
 id   			BIGINT,
 username 		VARCHAR(50) NOT NULL,
 password		VARCHAR(50) NOT NULL,
 email	 		VARCHAR(50) NOT NULL UNIQUE,
 first_name     VARCHAR(50) NOT NULL,
 last_name      VARCHAR(50) NOT NULL,
 phone 			VARCHAR(10) NOT NULL UNIQUE,
 activated		INT,
 primary key(id)
);

CREATE TABLE IF NOT EXISTS role(
 id				BIGINT,
 name			VARCHAR(50) NOT NULL UNIQUE,
 description    VARCHAR(50) NOT NULL,
 code 			VARCHAR(50) NOT NULL UNIQUE,
 primary key(id)
);

CREATE TABLE IF NOT EXISTS role_user(
 user_id  		BIGINT,
 role_id		BIGINT,
 primary key(user_id,role_id)
);

ALTER TABLE role_user
ADD CONSTRAINT fk_role_user FOREIGN KEY(user_id) REFERENCES users(id);

ALTER TABLE role_user
ADD CONSTRAINT fk_user_role FOREIGN KEY(role_id) REFERENCES role(id);