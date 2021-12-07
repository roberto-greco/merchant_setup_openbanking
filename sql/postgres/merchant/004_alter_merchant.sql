ALTER TABLE IF EXISTS merchantschema.merchant
    ADD COLUMN created timestamp with time zone;

ALTER TABLE IF EXISTS merchantschema.merchant
    ADD COLUMN updated timestamp with time zone;