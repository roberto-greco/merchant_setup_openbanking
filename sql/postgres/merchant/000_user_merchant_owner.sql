-- Role: merchant_owner
-- DROP ROLE merchant_owner;

CREATE ROLE merchant_owner WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:cY+isumc2I/KXmdvIBMn5A==$zO/QJrM6APWiN9GaD4VOKMq61BZsmTXtyp4/1QbdNfw=:22Pwpw60BdvEOkeChMevzW6gwcg40goP4obr/j9sHCI=';

COMMENT ON ROLE merchant_owner IS 'merchant db owner';