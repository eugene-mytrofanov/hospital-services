INSERT INTO clinics (name, address, phone, is_insurance_supported, clinic_type, number_of_doctors)
    VALUES ('Evviva', '90 Sumska str', '057-700-33-03', 'true', 'private', 110);

INSERT INTO clinics (name, address, phone, is_insurance_supported, clinic_type, number_of_doctors)
    VALUES ('La Vita Nova Surrogacy', '22B Kultury str', '067-577-79-45', 'true', 'private', 45);

INSERT INTO clinics (name, address, phone, is_insurance_supported, clinic_type, number_of_doctors)
    VALUES ('Oblasna Travmatolohichna Likarnya', '266В Saltivske Hwy', '057-711-79-45', 'false', 'government', 250);

INSERT INTO clinics (name, address, phone, is_insurance_supported, clinic_type, number_of_doctors)
    VALUES ('Regional Children Hospital', '5 Ozerianska Str', '057-372-75-21', 'false', 'government', 185);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('General blood analysis', 110.00, 100, 1);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('Ultrasound: Heart', 320.00, 75, 1);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('X-ray of the spine', 280.00, 75, 1);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('General blood analysis', 95.00, 50, 2);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('X-ray of the skull', 180.00, 50, 2);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('Electroencephalogram', 350.00, 50, 2);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('X-ray of the pelvis', 200.00, 0, 3);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('CT scan', 650.00, 0, 3);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('Electrocardiogram', 165.00, 0, 3);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('Magnetic resonance imaging', 850.00, 25, 4);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('Ultrasound: Kidneys', 220.00, 25, 4);

INSERT INTO medical_procedures (title, price, insurance_coverage, clinic_id)
    VALUES ('Electrocardiogram', 140.00, 25, 4);