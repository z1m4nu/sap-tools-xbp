

CREATE TABLE migration_journal (
	"key" bigserial NOT NULL,
	sid varchar(3) NOT NULL,
	client varchar(3) NOT NULL,
	"document" varchar(6) NOT NULL,
	archiv_key varchar(20) NOT NULL,
	msg text NULL,
	posted timestamp NOT NULL,
	severity varchar(10) NOT NULL,
	CONSTRAINT migration_journal_pkey PRIMARY KEY (key)
);