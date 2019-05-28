UPDATE clinics
    SET clinic_type = 'government' 100 WHERE number_of_doctors > 50;

UPDATE clinics
    SET medical_procedures = 100 WHERE ID = 2;

DELETE FROM clinics WHERE ID = 1;

DELETE FROM medical_procedures WHERE id = 11;

SELECT * FROM clinics;

SELECT * FROM medical_procedures;

SELECT * FROM clinics WHERE clinic_type = 'government';

SELECT * FROM medical_procedures WHERE insurance_coverage < 50;
