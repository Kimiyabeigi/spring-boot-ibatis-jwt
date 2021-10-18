-- Table: public.user

-- DROP TABLE public."user";

CREATE TABLE IF NOT EXISTS public."user"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "firstName" character varying(200) COLLATE pg_catalog."default" NOT NULL,
    "lastName" character varying(200) COLLATE pg_catalog."default" NOT NULL,
    username character varying(200) COLLATE pg_catalog."default" NOT NULL,
    password character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT uc_username UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;