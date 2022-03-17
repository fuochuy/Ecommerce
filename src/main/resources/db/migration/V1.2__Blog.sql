CREATE TABLE IF NOT EXISTS blog(
	 id   			BIGINT,
	 name			VARCHAR(50) NOT NULL UNIQUE,
	 image  		VARCHAR(50) NOT NULL,
	 summary		VARCHAR(100),
	 author			VARCHAR(50),
	 content		VARCHAR(2000),
	 primary key(id)
);