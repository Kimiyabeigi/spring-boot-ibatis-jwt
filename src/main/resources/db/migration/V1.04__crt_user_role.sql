-- Table: public.user_role

-- DROP TABLE public.user_role;

CREATE TABLE IF NOT EXISTS public.user_role
(
    "userId" integer NOT NULL,
    "roleId" integer NOT NULL,
    CONSTRAINT "fc_roleId" FOREIGN KEY ("roleId")
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "fc_userId" FOREIGN KEY ("userId")
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.user_role
    OWNER to postgres;
-- Index: fki_fc_roleId

-- DROP INDEX public."fki_fc_roleId";

CREATE INDEX "fki_fc_roleId"
    ON public.user_role USING btree
    ("roleId" ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: fki_fc_userId

-- DROP INDEX public."fki_fc_userId";

CREATE INDEX "fki_fc_userId"
    ON public.user_role USING btree
    ("userId" ASC NULLS LAST)
    TABLESPACE pg_default;