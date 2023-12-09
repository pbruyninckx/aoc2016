(defproject aoc2016 "0.1.0-SNAPSHOT"
  :author "Pieter Bruyninckx"
  :description "Advent of Code 2016 Solutions"
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot aoc2016.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
