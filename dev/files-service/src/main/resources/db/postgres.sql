create table files(
    id text not null primary key,
    size int not null,
    content bytea not null,
    labels text ARRAY not null
);