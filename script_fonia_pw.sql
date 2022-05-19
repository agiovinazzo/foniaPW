CREATE TABLE IF NOT EXISTS public.customers
(
    customer_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    first_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    address character varying COLLATE pg_catalog."default",
    CONSTRAINT custumers_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customers
    OWNER to postgres;






CREATE TABLE IF NOT EXISTS public.phones
(
    phone_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "number" text COLLATE pg_catalog."default" NOT NULL,
    type character varying(15) COLLATE pg_catalog."default" NOT NULL,
    status character varying(15) COLLATE pg_catalog."default" NOT NULL,
    customer_id integer NOT NULL,
    CONSTRAINT phones_pkey1 PRIMARY KEY (phone_id),
    CONSTRAINT name UNIQUE ("number"),
    CONSTRAINT customer_id FOREIGN KEY (customer_id)
        REFERENCES public.customers (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.phones
    OWNER to postgres;






CREATE TABLE IF NOT EXISTS public.call_tracks
(
    call_tracks_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    starting_time timestamp without time zone NOT NULL,
    ending_time timestamp without time zone NOT NULL,
    called_number text COLLATE pg_catalog."default" NOT NULL,
    call_duration bigint NOT NULL,
    phone_id integer NOT NULL,
    CONSTRAINT call_tracks_pkey PRIMARY KEY (call_tracks_id),
    CONSTRAINT phone_id FOREIGN KEY (phone_id)
        REFERENCES public.phones (phone_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.call_tracks
    OWNER to postgres;



INSERT INTO public.customers(
	 first_name, last_name, birth_date, address)
	VALUES ('Pippo', 'Baudo', '1936-06-07', 'Roma');

INSERT INTO public.customers(
	 first_name, last_name, birth_date, address)
	VALUES ('Elizabeth', 'Windsor', '1926-04-21', 'Londra');




INSERT INTO public.phones(
	"number", type, status, customer_id)
	VALUES ( '00393331112222', 'mobile', 'attivo', 1);

INSERT INTO public.phones(
	"number", type, status, customer_id)
	VALUES ( '00393331112244', 'mobile', 'sospeso', 1);





INSERT INTO public.call_tracks(
	 starting_time, ending_time, called_number, call_duration, phone_id)
	VALUES ( '2022-05-18T11:45:47', '2022-05-18T12:45:47', '003933166335353', '3600', '1');


INSERT INTO public.call_tracks(
	 starting_time, ending_time, called_number, call_duration, phone_id)
	VALUES ( '2022-05-18T15:45:47', '2022-05-18T16:45:47', '003933166335353', '3600', '1');





SELECT customer_id, first_name, last_name, birth_date, address
	FROM public.customers;

SELECT phone_id, "number", type, status, customer_id
	FROM public.phones;

SELECT call_tracks_id, starting_time, ending_time, called_number, call_duration, phone_id
	FROM public.call_tracks;