(ns scramblies.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [scramblies.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[scramblies started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[scramblies has shut down successfully]=-"))
   :middleware wrap-dev})
