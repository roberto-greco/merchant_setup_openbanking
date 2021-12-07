-- SEQUENCE: merchantschema.merchant_sequence

-- DROP SEQUENCE merchantschema.merchant_sequence;

CREATE SEQUENCE merchantschema.merchant_sequence
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE merchantschema.merchant_sequence
    OWNER TO merchant_owner;