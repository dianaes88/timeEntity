--drop existing table for testing purpose only
-- use te_bd;
DROP TABLE IF EXISTS TIME_ENTRIES ;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 10;


CREATE TABLE TIME_ENTRIES
(
    EntryID     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    SourceID    INTEGER    NOT NULL,
    UserID      INTEGER     NOT NULL,
    Date        DATE        NOT NULL,
    Hours       INTEGER,
    Tag         VARCHAR,
    Status      VARCHAR DEFAULT ('new')
);
