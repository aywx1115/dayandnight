CREATE TABLE menus (
                       id                BIGSERIAL NOT NULL,
                       name              VARCHAR(30) not null unique,
                       description       VARCHAR(150)
);
ALTER TABLE menus ADD CONSTRAINT menu_pk PRIMARY KEY ( id );



CREATE TABLE  categories(
                            id             BIGSERIAL NOT NULL,
                            category_type   VARCHAR(30),
                            items_number        INTEGER,
                            create_date    date default CURRENT_DATE,
                            menu_id    BIGINT NOT NULL
);
ALTER TABLE categories ADD CONSTRAINT category_pk PRIMARY KEY ( id );

CREATE TABLE items (
                       id              BIGSERIAL NOT NULL,
                       name            VARCHAR(30) not null unique,
                       price           DECIMAL,
                       size       VARCHAR(30),
                       taste           VARCHAR(50),
                       sales_status         BOOLEAN,
                       create_date      date default CURRENT_DATE,
                       category_id   BIGINT NOT NULL
);
ALTER TABLE items ADD CONSTRAINT item_pk PRIMARY KEY ( id );


ALTER TABLE items
    ADD CONSTRAINT item_category_fk FOREIGN KEY ( category_id )
        REFERENCES categories ( id );

ALTER TABLE categories
    ADD CONSTRAINT category_menu_fk FOREIGN KEY ( menu_id )
        REFERENCES menus ( id );