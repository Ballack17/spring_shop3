CREATE TABLE `shop_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `first_name` VARCHAR(128) NOT NULL,
  `second_name` VARCHAR(128) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE);
-- //юзер стандартный

CREATE TABLE `shop_db`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`));
-- //роли для юзеров

CREATE TABLE `shop_db`.`assign` (
  `id_role` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_role`),
  CONSTRAINT `id_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `shop_db`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
alter table assign add foreign key(id_user) references user(id);
ALTER TABLE `shop_db`.`assign`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id_role`, `id_user`);
-- Назначения дл юзеров - Кей - пара Юзер + Роль

CREATE TABLE `shop_db`.`product_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_group_name` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`, `product_group_name`));
-- // группа товаров для сортировки

CREATE TABLE `shop_db`.`product_brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_brand_name` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`, `product_brand_name`));
-- //брэнд для сортировки

CREATE TABLE `shop_db`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(128) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `product_brand_id` INT NOT NULL,
  `product_group_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_brand_id_idx` (`product_brand_id` ASC) VISIBLE,
  INDEX `product_group_id_idx` (`product_group_id` ASC) VISIBLE,
  CONSTRAINT `product_brand_id`
    FOREIGN KEY (`product_brand_id`)
    REFERENCES `shop_db`.`product_brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_group_id`
    FOREIGN KEY (`product_group_id`)
    REFERENCES `shop_db`.`product_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
ALTER TABLE `shop_db`.`product`
ADD COLUMN `quantity_in_stock` INT NOT NULL AFTER `product_group_id`;
-- //сам товар с сылками на бренд и группу

CREATE TABLE `shop_db`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `total_price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `shop_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
-- //Расходный ордер или чек - ссылка на юзера, дата создания, общая сумма покупок

CREATE TABLE `shop_db`.`sales` (
  `id_order` INT NOT NULL,
  `id_product` INT NOT NULL,
  `quantity` TINYINT NOT NULL,
  PRIMARY KEY (`id_order`, `id_product`),
  INDEX `id_product_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `id_order`
    FOREIGN KEY (`id_order`)
    REFERENCES `shop_db`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_product`
    FOREIGN KEY (`id_product`)
    REFERENCES `shop_db`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
-- // Продажи - ссылка на Ордер и продукты + количество продуктов в ордере Прамари кей - пара Ордер + Продукт,
-- по идее вообще лучше список операци - приход/расход, приход - добавляет кол-во , расход уменьшает


CREATE TABLE `shop_db`.`store_house` (
  `product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `shop_db`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
-- // Склад - товары + их количество

ALTER TABLE `shop_db`.`product`
DROP COLUMN `quantity_in_stock`;
-- // Сперва количество в таблицу продукт занес, потом понял, что логичнее вынести отдельно,
-- так как и самих складов может быть много и на каждом разное количество.
