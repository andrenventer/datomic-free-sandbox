(defproject playdatomic "0.0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.datomic/datomic-free "0.9.5359"]
                 [prismatic/plumbing "0.5.3"]
                 [criterium "0.4.4"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"])
