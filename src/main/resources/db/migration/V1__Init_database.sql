CREATE TABLE IF NOT EXISTS roles(
 id 			INT,
 name 			VARCHAR(255),
 discriminator	VARCHAR(128),
  
 primary key(id)
);

CREATE TABLE IF NOT EXISTS claims(
 claimType		INT,
 claimValue 	VARCHAR(255),
 userId 		INT,
  
 primary key(claimType)
);

CREATE TABLE IF NOT EXISTS userLogins(
 userId			INT,
 loginProvider 	VARCHAR(128),
 providerKey 	VARCHAR(128),
  
 primary key(userId,loginProvider,providerKey)
);

CREATE TABLE IF NOT EXISTS userRoles(
 userId			INT,
 roleId			INT,
  
 primary key(userId,roleId)
);

CREATE TABLE IF NOT EXISTS users(
 id   			INT,
 userName		VARCHAR(128),
 password		VARCHAR(128),
 securityStamp  VARCHAR(128),
 discriminator 	VARCHAR(128),
  
 primary key(id)
);

CREATE TABLE IF NOT EXISTS customers(
 id   			INT,
 password		VARCHAR(50),
 fullname 		VARCHAR(50),
 email  		VARCHAR(50),
 phone 			VARCHAR(10),
 activated		BIT,
 primary key(id)
);

CREATE TABLE IF NOT EXISTS categories(
 id   		INT,
 name		VARCHAR(50),
 image 		VARCHAR(50),
 icon  		VARCHAR(50),
 primary key(id)
);

CREATE TABLE IF NOT EXISTS orderDetails(
 orderId	INT,
 productId  INT,
 unitPrice  FLOAT,
 quantity	INT,
 discount	FLOAT,
 primary key(orderId,productId)
);

CREATE TABLE IF NOT EXISTS orders(
 id   			INT,
 customerId		INT NOT NULL,
 orderDate  	DATE NOT NULL,
 requireDate 	DATE NOT NULL,
 receiver		VARCHAR(50) NOT NULL,
 address		VARCHAR(200) NOT NULL,
 description 	VARCHAR(1000) NOT NULL,
 phone			VARCHAR(10) NOT NULL,
 primary key(id)
);

CREATE TABLE IF NOT EXISTS products(
 id   			INT,
 name			VARCHAR(50),
 unitBrief  	VARCHAR(50),
 unitPrice 		FLOAT,
 image			VARCHAR(50),
 productDate	DATE,
 available 		BIT,
 description	VARCHAR(2000),
 categoryId		INT,
 supplierId		INT,
 quantity		INT,
 discount		FLOAT,
 special		BIT,
 latest			BIT,
 views			INT,
 primary key(id)
);

CREATE TABLE IF NOT EXISTS suppliers(
 id   		INT,
 name		VARCHAR(50),
 logo  		VARCHAR(255),
 email  	VARCHAR(50),
 phone		VARCHAR(10),
 primary key(id)
);

CREATE TABLE IF NOT EXISTS permissions(
 id   			INT,
 webActionId	INT,
 roleId  		INT,
 allowable  	VARCHAR(50),
 primary key(id)
);

CREATE TABLE IF NOT EXISTS webActions(
 id   			INT,
 name			VARCHAR(255),
 controller  	VARCHAR(255),
 primary key(id)
);

ALTER TABLE permissions
ADD CONSTRAINT fk_permissions_roles FOREIGN KEY(roleId) REFERENCES roles(id),
ADD CONSTRAINT fk_permissions_webActions FOREIGN KEY(webActionId) REFERENCES webActions(id);

ALTER TABLE userRoles
ADD CONSTRAINT fk_userRoles_roles FOREIGN KEY(roleId) REFERENCES roles(id),
ADD CONSTRAINT fk_userRoles_users FOREIGN KEY(userId) REFERENCES users(id);

ALTER TABLE userLogins
ADD CONSTRAINT fk_userLogins_users FOREIGN KEY(userId) REFERENCES users(id);

ALTER TABLE claims
ADD CONSTRAINT fk_claims_users FOREIGN KEY(userId) REFERENCES users(id);

ALTER TABLE orderDetails
ADD CONSTRAINT fk_orderDetails_orders FOREIGN KEY(orderId) REFERENCES orders(id),
ADD CONSTRAINT fk_orderDetails_products FOREIGN KEY(productId) REFERENCES products(id);

ALTER TABLE orders
ADD CONSTRAINT fk_order_customers FOREIGN KEY(customerId) REFERENCES customers(id);

ALTER TABLE products
ADD CONSTRAINT fk_products_suppliers FOREIGN KEY(supplierId) REFERENCES suppliers(id),
ADD CONSTRAINT fk_products_categories FOREIGN KEY(categoryId) REFERENCES categories(id);


