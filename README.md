# playdatomic

A Clojure app to ... well, that part is up to you.

## Get datomic

https://my.datomic.com/downloads/free

Copy the unzipped folder into this project folder as /datomic

## Mbrainz

https://github.com/Datomic/mbrainz-sample

```
wget http://s3.amazonaws.com/mbrainz/datomic-mbrainz-1968-1973-backup-2015-02-11.tar -O mbrainz.tar
tar -xvf mbrainz.tar
```

## Usage

From the datomic folder run the following

cd Projects/datomic-free-sandbox/datomic/

bin/transactor config/samples/free-transactor-template.properties

Create a new console tab in the same dir

;; restore-db

bin/datomic restore-db file:mbrainz-1968-1973 datomic:free://localhost:4334/mbrainz-1968-1973

;; backup-db

bin/datomic -Xmx4g -Xms4g backup-db datomic:free://localhost:4334/mbrainz-1968-1973

file:/Users/nomad/Projects/datomic-free-sandbox/datomic/backup

;; launch a web console

bin/console -p 8080 mbrainz datomic:free://localhost:4334/

bin/rest -p 8888 mbrainz datomic:free://localhost:4334/

## Queries

https://github.com/Datomic/mbrainz-sample/wiki/Queries

## console

https://my.datomic.com/downloads/console
