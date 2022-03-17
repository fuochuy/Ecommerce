CREATE TABLE IF NOT EXISTS categories(
	 id   			BIGINT,
	 name			VARCHAR(50) NOT NULL UNIQUE,
	 code  			VARCHAR(50) NOT NULL,
	 primary key(id)
);

CREATE TABLE IF NOT EXISTS products(
	 id   			BIGINT,
	 category_id	BIGINT,
	 name			VARCHAR(50) NOT NULL UNIQUE,
	 description	VARCHAR(2000) NOT NULL,
	 image1			VARCHAR(255),
	 image2			VARCHAR(255),
	 image3			VARCHAR(255),
	 size			VARCHAR(50),
	 color			VARCHAR(50),
	 brand			VARCHAR(50),
	 price			FLOAT,
	 discount		FLOAT,
	 quantity		INT,
	 quantity_sold	INT,

	 primary key(id)
);

CREATE sequence hibernate_sequence start 1 increment 1;
ALTER TABLE products
ADD CONSTRAINT fk_products_categories FOREIGN KEY(category_id) REFERENCES categories(id);


