(ns scramblies.solver)

(defn scramble? [source pattern]
  (and  (>= (count source) (count pattern))
        (let [char-map (frequencies pattern)]
          (->> source
               (reduce (fn [acc n] (update acc n (fnil dec 0))) char-map)
               (not-any? (fn [[_ v]] (pos? v)))))))
