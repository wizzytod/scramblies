(ns scramblies.solver)

(defn scrumble? [source pattern]
  (and  (>= (count source) (count pattern))
        (let [char-map (reduce (fn [acc n] (update acc n (fnil inc 0) )) {} pattern)]
          (->> source
               (reduce (fn [acc n] (update acc n (fnil dec 0))) char-map)
               (not-any? (fn [[_ v]] (pos? v)))))))
