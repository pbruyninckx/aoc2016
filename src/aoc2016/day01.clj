(ns aoc2016.day01
  (:require [clojure.string :as str]))

(defn parse-input [f]
  (let [instructions
        (-> f
            slurp
            str/trim
            (str/split #", "))]
    (->> instructions
         (map (fn [[direction & number]]
                {:direction ({\L :left \R :right} direction)
                 :number    (Integer/parseInt (str/join number))})))))

(def step
  {:north [0 1]
   :south [0 -1]
   :west  [-1 0]
   :east  [1 0]})

(defn apply-direction [orientation direction]
  (case direction
    :left ({:north :west :west :south :south :east :east :north} orientation)
    :right ({:north :east :east :south :south :west :west :north} orientation)))

(defn solve [instructions]
  (let [final-state
        (reduce (fn [{:keys [pos orientation]} {:keys [direction number]}]
            (let [orientation (apply-direction orientation direction)
                  pos (mapv + pos (mapv #(* % number) (step orientation)))]
              {:pos pos
               :orientation orientation}))
          {:pos [0 0] :orientation :north}
          instructions)]
    (->> (:pos final-state)
         (map abs)
         (reduce +))))

(defn -main []
  (let [input (parse-input "resources/input01.txt")]
    (println (solve input))))