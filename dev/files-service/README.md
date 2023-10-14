This is a files service :)

## How to build and test
./gradlew clean build test

## How to run and test manually

Run file-service

### memory store
```
./gradlew bootRun
```
or
```
./gradlew bootRun --args='mem'
```

### Postgres db store
Require to set up Postgres DB first.

```
./gradlew bootRun --args='db'
```

### Test endpoints:

#### Status
```
% curl http://localhost:8080/status

{"status":"ok","count":3}
```
#### Upload file
```
% curl -F 'file=@/Users/kelly/temp/foo.txt' 'http://localhost:8080/files?labels=name:kelly,location:portland'

{"size":6,"labels":["name:kelly","location:portland"],"id":"2f1117e5-d75f-474c-aa62-d76dab6b1faf"}            

```

#### Get file by Id
```
curl http://localhost:8080/files/2f1117e5-d75f-474c-aa62-d76dab6b1faf
{"size":6,"labels":["name:kelly","location:portland"],"id":"2f1117e5-d75f-474c-aa62-d76dab6b1faf"}

```
#### Search files by labels
```
% curl 'http://localhost:8080/files?labels=name:kelly,location:portland'

[{"size":6,"labels":["name:kelly","location:portland"],"id":"2f1117e5-d75f-474c-aa62-d76dab6b1faf"}]
```

### Setup Postgres DB

```
cd docker
docker-compose up
```
Then create db table using the sql script src/main/resources/db/postgres.sql
For example, use the tool https://www.pgadmin.org/

The Postgres DB data is stored in directory ~/apps/postgres.

### Tear down Postgres DB

```
cd docker
docker-compose down
```

