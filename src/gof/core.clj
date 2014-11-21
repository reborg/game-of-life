(ns gof.core)

(defn neighbours [h w x y]
  (for [dx [-1 0 1]
        dy [-1 0 1]
        :let [x' (+ x dx)
              y' (+ y dy)]
        :when (and (not (= dx dy 0))
                   (<= 0 x' (dec w))
                   (<= 0 y' (dec h)))]
    [x' y']))

(defn alive? [h w x y cells]
  (let [n (count (filter cells (neighbours h w x y)))]
    (case n
      2 (contains? cells [x y])
      3 true
      false)))

(defn next-gen [{:keys [h w cells]}]
  {:h h :w w :cells (into #{}
                          (for [x (range 0 w)
                                y (range 0 h)
                                :when (alive? h w x y cells)] [x y]))})
