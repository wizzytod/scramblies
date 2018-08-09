(ns user
  (:require [scramblies.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [scramblies.figwheel :refer [start-fw stop-fw cljs]]
            [scramblies.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'scramblies.core/repl-server))

(defn stop []
  (mount/stop-except #'scramblies.core/repl-server))

(defn restart []
  (stop)
  (start))


