-- Table: merchantschema.shop

-- DROP TABLE IF EXISTS merchantschema.shop;

CREATE TABLE IF NOT EXISTS merchantschema.shop
(
    id bigint NOT NULL,
    banner character varying(255)[] COLLATE pg_catalog."default" NOT NULL,
    address character varying(255)[] COLLATE pg_catalog."default",
    created timestamp with time zone NOT NULL,
    updated timestamp with time zone[] NOT NULL,
    merchantid bigint NOT NULL,
    CONSTRAINT merchant_ref FOREIGN KEY (merchantid)
        REFERENCES merchantschema.merchant (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS merchantschema.shop
    OWNER to merchant_owner;

COMMENT ON TABLE merchantschema.shop
    IS 'merchant''s shops ';