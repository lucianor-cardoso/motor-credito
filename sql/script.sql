-- Database: credito

-- DROP DATABASE IF EXISTS credito;

CREATE DATABASE credito
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8 -E UTF8'
    LC_CTYPE = 'pt_BR.UTF-8 -E UTF8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE credito
    IS 'Motor de Crédito DB';

--/////////////////////////////////////////////////////////////////////////
-- Role: creditousr

-- DROP ROLE IF EXISTS creditousr;

CREATE ROLE creditousr WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  NOBYPASSRLS
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:6FPxi3qXegsr7bVJ4oOtZQ==$lKS0ed/0+IEum7BlH8/bZyPzOTrHoluQRqQ5z0mHIOU=:paZJK7xyKJgjXByIQEYEpgbRXd1SfnYbcNhct+MuoA4=';

COMMENT ON ROLE creditousr IS 'credito user for creditodb';

--/////////////////////////////////////////////////////////////////////////
-- Table: public.client

--DROP TABLE IF EXISTS public.client;

CREATE TABLE IF NOT EXISTS public.client
(
    client_id serial NOT NULL,
    client_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cpf character varying(11) COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    CONSTRAINT pk_client_client_id PRIMARY KEY (client_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.client
    OWNER to postgres;

--/////////////////////////////////////////////////////////////////////////
-- Table: public.score

-- DROP TABLE IF EXISTS public.score;

CREATE TABLE IF NOT EXISTS public.score
(
    score_id serial NOT NULL,
    client_id integer NOT NULL,
    score_points smallint NOT NULL,
    actual_income numeric(11,2),
    is_restrict "char" NOT NULL,
    seach_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_score_score_id PRIMARY KEY (score_id),
    CONSTRAINT fk_score_client FOREIGN KEY (client_id)
        REFERENCES public.client (client_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.score
    OWNER to postgres;

COMMENT ON TABLE public.score
    IS 'Score table maintains client''s searches to Serasa service.';

--/////////////////////////////////////////////////////////////////////////
-- grants to creditousr

grant SELECT, UPDATE, DELETE, INSERT ON public.client TO creditousr;
grant SELECT, UPDATE, DELETE, INSERT ON public.score TO creditousr;

--/////////////////////////////////////////////////////////////////////////
