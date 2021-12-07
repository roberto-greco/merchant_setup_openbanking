-- SEQUENCE: merchantschema.shop_sequence

-- DROP SEQUENCE merchantschema.shop_sequence;

CREATE SEQUENCE merchantschema.shop_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE merchantschema.shop_sequence
    OWNER TO merchant_owner;