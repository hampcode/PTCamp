/*Pregrado*/
INSERT INTO studies_modality (name) VALUES ('AC-PREGADO-UPC');
INSERT INTO studies_modality (name) VALUES ('FC-Estudios Profesionales para Ejecutivos');
INSERT INTO studies_modality (name) VALUES ('Working Student');

INSERT INTO campus (name) VALUES ('San Isidro');
INSERT INTO campus (name) VALUES ('San Miguel');


INSERT INTO faculties (name) VALUES('Arquitectura');
INSERT INTO faculties (name) VALUES('Artes Contemporáneas');
INSERT INTO faculties (name) VALUES('Negocios');
INSERT INTO faculties (name) VALUES('Comunicaciones');
INSERT INTO faculties (name) VALUES('Derecho');
INSERT INTO faculties (name) VALUES('Diseño');
INSERT INTO faculties (name) VALUES('Economía');
INSERT INTO faculties (name) VALUES('Ingeniería');
INSERT INTO faculties (name) VALUES('Ciencias y Humanidades');


INSERT INTO careers (name,faculty_id) VALUES('Arquitectura',1);
INSERT INTO careers (name,faculty_id) VALUES('Artes Escénicas',2);
INSERT INTO careers (name,faculty_id) VALUES('Administración y Marketing',3);
INSERT INTO careers (name,faculty_id) VALUES('Administración y Negocios Internacionales',3);
INSERT INTO careers (name,faculty_id) VALUES('Administración y Gerencia de Emprendimiento',3);
INSERT INTO careers (name,faculty_id) VALUES('Administración y Finanzas',3);
INSERT INTO careers (name,faculty_id) VALUES('Contabilidad y Administración',3);
INSERT INTO careers (name,faculty_id) VALUES('Comunicación Audiovisual y Medios Interactivos',4);
INSERT INTO careers (name,faculty_id) VALUES('Comunicación y Marketing',4);
INSERT INTO careers (name,faculty_id) VALUES('Comunicación y Periodismo',4);
INSERT INTO careers (name,faculty_id) VALUES('Comunicación y Publicidad',4);
INSERT INTO careers (name,faculty_id) VALUES('Comunicación e Imagen Empresarial',4);
INSERT INTO careers (name,faculty_id) VALUES('Derecho',5);
INSERT INTO careers (name,faculty_id) VALUES('Diseño Profesional de Interiores',6);
INSERT INTO careers (name,faculty_id) VALUES('Diseño Profesional Gráfico',6);
INSERT INTO careers (name,faculty_id) VALUES('Economía y Finanzas',7);
INSERT INTO careers (name,faculty_id) VALUES('Economía y Negocios Internacionales',7);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería Civil',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Electrónica',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Mecatrónica',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Gestión Empresarial',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Sistemas de Información',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Software',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Industrial',8);
INSERT INTO careers (name,faculty_id) VALUES('Administración y Banca de Finanzas',3);
INSERT INTO careers (name,faculty_id) VALUES('Administración de Empresas',3);
INSERT INTO careers (name,faculty_id) VALUES('Administración de Recursos Humanos',3);
INSERT INTO careers (name,faculty_id) VALUES('Administración y Gerencia del Emprendimiento',3);
INSERT INTO careers (name,faculty_id) VALUES('Marketing',3);
INSERT INTO careers (name,faculty_id) VALUES('Negocios Internacionales',3);
INSERT INTO careers (name,faculty_id) VALUES('Contabilidad',7);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería Civil-EPE',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Redes y Comunicaciones',8);
INSERT INTO careers (name,faculty_id) VALUES('Ingeniería de Sistemas-EPE',8);

INSERT INTO campus_career (campus_id,career_id) VALUES(2,1);
INSERT INTO campus_career (campus_id,career_id) VALUES(2,2);
INSERT INTO campus_career (campus_id,career_id) VALUES(2,22);
INSERT INTO campus_career (campus_id,career_id) VALUES(2,23);
INSERT INTO campus_career (campus_id,career_id) VALUES(2,24);

INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Xavier Antonio','Laos Laura',7472,2,'xavier.laos@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Giovanna','Trillo Rivera',7452,2,'giovanna.trillo@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Rossana Margot', 'Olivera Garcia',7456,2,'rossana.olivera@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('David Gonzalo','Galvez Del Bosque',7473,2,'david.galvez@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Armando Alfredo','Novoa Allagual',7443,2,'armando.novoa@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Percy Armando','Lucich Osorio',7446,2,'percy.lucich@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Renzo','Rojas Ocampo',7440,2,'renzo.rojas@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Melissa Amalia','Vera Guerrero',7451,2,'melissa.vera@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Henry Antonio','Mendoza Puerta',7467,2,'henry.mendoza@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Jaime Gumercindo','Castillejo Espinoza',2128,2,'jaime.castillejo@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Rose Marie','Medina De La Cruz',2521,2,'rose.medine@upc.pe');
INSERT INTO full_time_teachers (first_name,last_name,telephone_annex,campus_id,email) VALUES('Luz Maritza','Herrera Valladarez',7448,2,'luz.herrera@upc.pe');


INSERT INTO full_time_teacher_career (full_time_teacher_id,career_id) VALUES(2,18);
INSERT INTO full_time_teacher_career (full_time_teacher_id,career_id) VALUES(2,32);
INSERT INTO full_time_teacher_career (full_time_teacher_id,career_id) VALUES(10,22);
INSERT INTO full_time_teacher_career (full_time_teacher_id,career_id) VALUES(10,19);
INSERT INTO full_time_teacher_career (full_time_teacher_id,career_id) VALUES(10,20);
INSERT INTO full_time_teacher_career (full_time_teacher_id,career_id) VALUES(10,23);



