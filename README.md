# playdatomic

A Clojure app to ... well, that part is up to you.

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

bin/console -p 8080 dev datomic:free://localhost:4334/
