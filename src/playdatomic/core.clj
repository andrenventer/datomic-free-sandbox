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
