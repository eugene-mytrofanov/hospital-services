CREATE TABLE clinics
(
	id SERIAL NOT NULL
	    CONSTRAINT cat_key PRIMARY KEY,
	name VARCHAR(255),
	address VARCHAR(255),
	phone VARCHAR(20),
	is_insurance_supported BOOLEAN,
	clinic_type VARCHAR(20),
	number_of_doctors INTEGER
);

CREATE TABLE medical_procedures
(
    id SERIAL NOT NULL
        CONSTRAINT procedure_key PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    price REAL NOT NULL,
    insurance_coverage DECIMAL,
    procedure_duration INTEGER,
    clinic_id BIGINT NOT NULL,
	CONSTRAINT medical_procedures_clinics_fkey FOREIGN KEY (clinic_id) REFERENCES clinics(id)
);
