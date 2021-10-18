-- Table: public.task

-- DROP TABLE public.task;

CREATE TABLE IF NOT EXISTS public.task
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    subject character varying(200) COLLATE pg_catalog."default" NOT NULL,
    "dueDate" date NOT NULL,
    "userId" integer NOT NULL,
    CONSTRAINT tasks_pkey PRIMARY KEY (id),
    CONSTRAINT "uf_userId" FOREIGN KEY ("userId")
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.task
    OWNER to postgres;
-- Index: fki_uf_userId

-- DROP INDEX public."fki_uf_userId";

CREATE INDEX "fki_uf_userId"
    ON public.task USING btree
    ("userId" ASC NULLS LAST)
    TABLESPACE pg_default;