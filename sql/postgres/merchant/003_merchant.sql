-- Table: merchantschema.merchant

-- DROP TABLE merchantschema.merchant;

CREATE TABLE IF NOT EXISTS merchantschema.merchant
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    vat character varying(15) COLLATE pg_catalog."default" NOT NULL,
    mobile character varying(15) COLLATE pg_catalog."default" NOT NULL,
    bankcode character varying(5) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT merchant_pkey PRIMARY KEY (id),
    CONSTRAINT "unique" UNIQUE (vat, bankcode)
)

TABLESPACE pg_default;

ALTER TABLE merchantschema.merchant
    OWNER to merchant_owner;

COMMENT ON TABLE merchantschema.merchant
    IS 'tabella merchant';