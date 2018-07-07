DROP TABLE fares CASCADE CONSTRAINTS;

DROP TABLE flight CASCADE CONSTRAINTS;

DROP TABLE inventory CASCADE CONSTRAINTS;

DROP SEQUENCE fare_seq;

DROP SEQUENCE flight_seq;

DROP SEQUENCE inventory_seq;

CREATE SEQUENCE fare_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE flight_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE inventory_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE fares (
    fare_id    NUMBER(19,0) PRIMARY KEY,
    currency   VARCHAR2(255 CHAR),
    fare       VARCHAR2(255 CHAR)
);

CREATE TABLE inventory (
    inv_id   NUMBER(19,0) PRIMARY KEY,
    count    NUMBER(10,0) NOT NULL
);

CREATE TABLE flight (
    id              NUMBER(19,0) PRIMARY KEY,
    destination     VARCHAR2(255 CHAR),
    flight_date     VARCHAR2(255 CHAR),
    flight_number   VARCHAR2(255 CHAR),
    origin          VARCHAR2(255 CHAR),
    fare_id         NUMBER(19,0)
        REFERENCES fares ( fare_id ),
    inv_id          NUMBER(19,0)
        REFERENCES inventory ( inv_id )
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    100,
    fare_seq.NEXTVAL
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    101,
    fare_seq.NEXTVAL
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    102,
    fare_seq.NEXTVAL
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    103,
    fare_seq.NEXTVAL
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    104,
    fare_seq.NEXTVAL
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    105,
    fare_seq.NEXTVAL
);

INSERT INTO fares (
    currency,
    fare,
    fare_id
) VALUES (
    'USD',
    106,
    fare_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO inventory (
    count,
    inv_id
) VALUES (
    100,
    inventory_seq.NEXTVAL
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF100',
    'SEA',
    'SFO',
    '22-JAN-16',
    1,
    1
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF101',
    'NYC',
    'SFO',
    '22-JAN-16',
    2,
    2
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF102',
    'CHI',
    'SFO',
    '22-JAN-16',
    3,
    3
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF103',
    'HOU',
    'SFO',
    '22-JAN-16',
    4,
    4
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF104',
    'LAX',
    'SFO',
    '22-JAN-16',
    5,
    5
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF105',
    'NYC',
    'SFO',
    '22-JAN-16',
    6,
    6
);

INSERT INTO flight (
    id,
    flight_number,
    origin,
    destination,
    flight_date,
    fare_id,
    inv_id
) VALUES (
    flight_seq.NEXTVAL,
    'BF106',
    'NYC',
    'SFO',
    '22-JAN-16',
    7,
    7
);