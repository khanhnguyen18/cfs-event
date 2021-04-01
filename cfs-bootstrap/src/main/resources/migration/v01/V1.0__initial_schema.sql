--------------------------------------------------------
--  DDL for Table CFS_EVENT
--------------------------------------------------------
CREATE TABLE CFS_EVENT
(
    "ID" NUMBER(12,0) NOT NULL,
    "EVENT_ID" RAW(16),
    "EVENT_NUMBER" VARCHAR2(40 CHAR),
    "EVENT_TYPE_CODE" VARCHAR2(40 CHAR),
    "EVENT_TIME" DATE,
    "DISPATCH_TIME" DATE,
    "AGENT_ID" NUMBER(12,0) NOT NULL,
    "RESPONDER_ID" NUMBER(12,0) NOT NULL
);

ALTER TABLE "CFS_EVENT" ADD CONSTRAINT "PK_CFS_EVENT" PRIMARY KEY ("ID");

CREATE SEQUENCE SEQ_CFS_EVENT MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 CACHE 100;

--------------------------------------------------------
--  DDL for Table PRICE
--------------------------------------------------------
CREATE TABLE PRICE
(
    "ID" NUMBER(12,0) NOT NULL,
    "AMOUNT" NUMBER(13,0) NOT NULL,
    "DATE" DATE NOT NULL,
    "PRODUCT_ID" NUMBER(12,0) NOT NULL
);

ALTER TABLE "PRICE" ADD CONSTRAINT "PK_PRICE" PRIMARY KEY ("ID");

CREATE SEQUENCE SEQ_PRICE MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 CACHE 100;


ALTER TABLE "PRICE" ADD CONSTRAINT "FK_PRODUCT_PRICE" FOREIGN KEY ("PRODUCT_ID") REFERENCES "PRODUCT" ("ID");

--------------------------------------------------------
--  DDL for Table T_ORDER
--------------------------------------------------------
CREATE TABLE T_ORDER
(
    "ID" NUMBER(12,0) NOT NULL,
    "DATE_TIME" DATE
);

ALTER TABLE "T_ORDER" ADD CONSTRAINT "PK_ORDER" PRIMARY KEY ("ID");

CREATE SEQUENCE SEQ_ORDER MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 CACHE 100;

--------------------------------------------------------
--  DDL for Table T_ORDER_DETAIL
--------------------------------------------------------
CREATE TABLE T_ORDER_DETAIL
(
    "ID" NUMBER(12,0) NOT NULL,
    "QUANTITY" NUMBER(13,0) NOT NULL,
    "ORDER_ID" NUMBER(12,0) NOT NULL,
    "STATUS" VARCHAR2(30 CHAR),
    "PRODUCT_ID" NUMBER(12,0) NOT NULL
);

ALTER TABLE "T_ORDER_DETAIL" ADD CONSTRAINT "PK_ORDER_DETAIL" PRIMARY KEY ("ID");

CREATE SEQUENCE SEQ_ORDER_DETAIL MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 CACHE 100;

ALTER TABLE "T_ORDER_DETAIL" ADD CONSTRAINT "FK_ORDER_DETAIL_ORDER" FOREIGN KEY ("ORDER_ID") REFERENCES "T_ORDER" ("ID");
ALTER TABLE "T_ORDER_DETAIL" ADD CONSTRAINT "FK_ORDER_DETAIL_PRODUCT" FOREIGN KEY ("PRODUCT_ID") REFERENCES "PRODUCT" ("ID");


