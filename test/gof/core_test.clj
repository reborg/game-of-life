(ns gof.core-test
  (:use midje.sweet)
  (:use [gof.core]))

(facts "gof"
       (fact "next gen of empty grid is empty grid"
             (next-gen {:w 2 :h 2 :cells #{}}) => {:w 2 :h 2 :cells #{}})
       (fact "only one cell alive will die"
             (next-gen {:w 2 :h 2 :cells #{[0 0]}}) => {:w 2 :h 2 :cells #{}})
       (fact "case 3 with two alive neighbours"
             (next-gen {:w 2 :h 2 :cells #{[0 0] [0 1] [1 0]}}) => {:w 2 :h 2 :cells #{[0 0] [0 1] [1 0] [1 1]}})
       (fact "blinker!"
             (next-gen {:w 3 :h 3 :cells #{[0 1] [1 1] [2 1]}}) => {:w 3 :h 3 :cells #{[1 0] [1 1] [1 2] }}))
