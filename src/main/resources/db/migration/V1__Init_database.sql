CREATE TABLE IF NOT EXISTS categories(
	 id   			BIGINT,
	 name			VARCHAR(50) NOT NULL UNIQUE,
	 image 			VARCHAR(50) NOT NULL,
	 icon  			VARCHAR(50),
	 
	 primary key(id)
);

CREATE TABLE IF NOT EXISTS products(
	 id   			BIGINT,
	 name			VARCHAR(50) NOT NULL UNIQUE,
	 unit_brief  	VARCHAR(50) NOT NULL,
	 unit_price 	FLOAT NOT NULL,
	 image			VARCHAR(50) NOT NULL,
	 product_date	DATE NOT NULL,
	 available 		INT NOT NULL,
	 description	VARCHAR(2000) NOT NULL,
	 category_id	BIGINT NOT NULL,
	 supplier_id	BIGINT NOT NULL,
	 quantity		INT NOT NULL,
	 discount		FLOAT NOT NULL,
	 special		INT NOT NULL,
	 latest			INT NOT NULL,
	 views			INT NOT NULL,
	 
	 primary key(id)
);

CREATE sequence hibernate_sequence start 1 increment 1;
ALTER TABLE products
ADD CONSTRAINT fk_products_categories FOREIGN KEY(category_id) REFERENCES categories(id);


