(ns playdatomic.core
  (:require [datomic.api :as d :refer [db q]]
            [plumbing.core :refer :all]
            [criterium.core :as crit]))

(def uri "datomic:free://localhost:4334/mbrainz-1968-1973")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Connect to Datomic

(def DB (d/db (d/connect uri)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Datomic Query DQL

(into [] (d/q '[:find ?title
      :in $ ?artist-name
      :where
      [?a :artist/name ?artist-name]
      [?t :track/artists ?a]
      [?t :track/name ?title]]
    DB
    "John Lennon"))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Pretty Print

(clojure.pprint/pp)

(print (d/connect uri))

(def t1 0)
(def t2 130223)

(d/q '[:find (count ?tx)
       :in ?log ?t1 ?t2
       :where [(tx-ids ?log ?t1 ?t2) [?tx ...]]]
     (d/log (d/connect uri)) t1 t2)

(->> (d/q '[:find ?tx
      :in ?log ?t1 ?t2
      :where [(tx-ids ?log ?t1 ?t2) [?tx ...]]]
    (d/log (d/connect uri)) t1 t2)
    count)

; (d/q '[:find ?e
;        :in ?log ?t1 ?t2
;        :where [(tx-ids ?log ?t1 ?t2) [?tx ...]]
;               [(tx-data ?log ?tx) [[?e ?a ?v _ ?added]]]]
;      (d/log (d/connect uri)) #inst "2014-11-18T03:41:56.328-00:00" #inst "2014-11-18T03:41:56.328-00:00")
