CREATE TABLE IF NOT EXISTS ADDRESS (
    ID_ADDRESS BIGINT PRIMARY KEY NOT NULL,
    DS_STATE VARCHAR NOT NULL,
    DS_CITY VARCHAR NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS sequence_address
INCREMENT 1
START 1
OWNED BY ADDRESS.ID_ADDRESS;

ALTER TABLE ADDRESS
ADD CONSTRAINT ABBREVIATION_STATE
CHECK (DS_STATE IN (
    'AC',
    'AL',
    'AP',
    'AM',
    'BA',
    'CE',
    'DF',
    'ES',
    'GO',
    'MA',
    'MS',
    'MT',
    'MG',
    'PA',
    'PB',
    'PR',
    'PE',
    'PI',
    'RJ',
    'RN',
    'RS',
    'RO',
    'RR',
    'SC',
    'SP',
    'SE',
    'TO'
));