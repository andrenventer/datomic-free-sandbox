(ns playdatomic.core
  (:require [datomic.api :as d :refer [db q]]
            [plumbing.core :refer :all]
            [criterium.core :as crit]))

(def uri "datomic:free://localhost:4334/mbrainz-1968-1973")

(def DB (d/db (d/connect uri)))

(into [] (d/q '[:find ?title
      :in $ ?artist-name
      :where
      [?a :artist/name ?artist-name]
      [?t :track/artists ?a]
      [?t :track/name ?title]]
    DB
    "John Lennon"))

(clojure.pprint/pp)



















;; From the datomic folder run the following
;; cd Projects/Sandbox/datomic/
;; bin/transactor config/samples/free-transactor-template.properties
;; Create a new console tab in the same dir
;; restore-db
;; bin/datomic restore-db file:mbrainz-1968-1973 datomic:free://localhost:4334/mbrainz-1968-1973
;; backup-db
;; bin/datomic -Xmx4g -Xms4g backup-db datomic:free://localhost:4334/mbrainz-1968-1973 file:/Users/nomad/Projects/Sandbox/datomic/backup
;; launch a web console
;; bin/console -p 8080 dev datomic:free://localhost:4334/
