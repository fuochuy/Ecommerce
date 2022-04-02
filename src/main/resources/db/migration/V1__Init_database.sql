CREATE TABLE IF NOT EXISTS category(
	 id   			BIGINT,
	 name			VARCHAR(50) NOT NULL,
	 code  			VARCHAR(50) NOT NULL,
	 primary key(id)
);

CREATE TABLE IF NOT EXISTS product(
	 id   			BIGINT,
	 category_id	BIGINT,
	 name			VARCHAR(50) NOT NULL,
	 description	VARCHAR(2000) NOT NULL,
	 image1			VARCHAR(255),
	 image2			VARCHAR(255),
	 image3			VARCHAR(255),
	 brand			VARCHAR(50),
	 price			FLOAT,
	 discount		FLOAT,

	 primary key(id)
);
CREATE TABLE IF NOT EXISTS size(
	 id   			BIGINT,
	 size			VARCHAR(3),

	 primary key(id)
);
CREATE TABLE IF NOT EXISTS color(
	 id   			BIGINT,
	 color			VARCHAR(10),

	 primary key(id)
);

CREATE TABLE IF NOT EXISTS stock(
	 id   			BIGINT,
	 product_id		BIGINT,
	 color_id		BIGINT,
	 size_id		BIGINT,
	 stock			INT,

	 primary key(id)
);
CREATE sequence hibernate_sequence start 1 increment 1;

ALTER TABLE product
ADD CONSTRAINT fk_product_category FOREIGN KEY(category_id) REFERENCES category(id);

ALTER TABLE stock ADD CONSTRAINT fk_stock_product FOREIGN KEY(product_id) REFERENCES product(id);
ALTER TABLE stock ADD CONSTRAINT fk_stock_size FOREIGN KEY(size_id) REFERENCES size(id);
ALTER TABLE stock ADD CONSTRAINT fk_stock_color FOREIGN KEY(color_id) REFERENCES color(id);