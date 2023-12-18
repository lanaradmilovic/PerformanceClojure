(ns vezba5.core
  (:gen-class)
  (:require [criterium.core :refer :all] [midje.sweet :refer :all]))
(defn lista [n]
  (range n))
(defn sqr [^double x]
  (* x x))
(defn sqr-1 ^double [^double x]
  (* x x))
(defn sqr-2 [x]
  (* x x))
;(set! *unchecked-math* *warn-on-boxed*)
(with-progress-reporting (quick-bench (sqr 10)))
(with-progress-reporting (quick-bench (sqr-2 10)))


(lista 100000)
(with-progress-reporting (quick-bench (lista 100000)))
(def l1 (lista 100000))
(defn avg [l]
  (let [c (count l) suma (reduce + 0 l)]
    (/ suma c)
    ))
(with-progress-reporting (quick-bench (avg l1)))


(fact "test lista"
      (lista 0) => ())
(fact "test avg")
(fact "test avg function"
      (avg [1 2 3]) => 2
      (avg [4 8 12]) => 8)
;(fact "chech empty list"
;      avg '() => throws ArithmeticException)
(with-progress-reporting (quick-bench (fact "test lista"
                               (lista 0) => ())))


(defn std-dev [l1]
  (let [average (avg l1)
        counter (reduce + 0 (map #(Math/pow (- % average) 2) l1))
        denominator (count l1)]
    (Math/sqrt (/ counter denominator))))

(with-progress-reporting (quick-bench (std-dev l1)))



(def average (avg l1))
(def counter (reduce + 0 (map #(Math/pow (- % average) 2) l1)))
(def denominator (count l1))
(def st (Math/sqrt (/ counter denominator)))
(with-progress-reporting (quick-bench st))


(def data [1 2 3 4 5])
(println (std-dev data))




(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (println "Hello, World!"))
