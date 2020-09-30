--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.7

-- Started on 2020-09-30 16:50:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2816 (class 1262 OID 61576)
-- Name: sgff; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE sgff WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE sgff OWNER TO postgres;

\connect sgff

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 69765)
-- Name: funcionarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionarios (
    id bigint NOT NULL,
    cargo integer NOT NULL,
    cpf character varying(255),
    data_admissao date,
    email character varying(255),
    rg character varying(255),
    nome character varying(255)
);


ALTER TABLE public.funcionarios OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 69773)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 2809 (class 0 OID 69765)
-- Dependencies: 196
-- Data for Name: funcionarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.funcionarios (id, cargo, cpf, data_admissao, email, rg, nome) VALUES (59, 1, '000000', '2020-08-28', 'rosenorenan@gmail.com', '98347892', 'Renan Roseno');
INSERT INTO public.funcionarios (id, cargo, cpf, data_admissao, email, rg, nome) VALUES (60, 2, '01001000000', '2020-08-28', 'rosenorenan@gmail.com', '11117892', 'Roberto Nogueira');
INSERT INTO public.funcionarios (id, cargo, cpf, data_admissao, email, rg, nome) VALUES (62, 1, '23424', '2002-03-03', 'sdfsf@gmail.com', 'asdasd', 'asdasd');


--
-- TOC entry 2817 (class 0 OID 0)
-- Dependencies: 197
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 62, true);


--
-- TOC entry 2687 (class 2606 OID 69772)
-- Name: funcionarios funcionarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (id);


-- Completed on 2020-09-30 16:50:10

--
-- PostgreSQL database dump complete
--

