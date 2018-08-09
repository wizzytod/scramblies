(ns scramblies.routes.services
  (:require [muuntaja.middleware :as muuntaja]
            [reitit.ring.coercion :as rrc]
            [spec-tools.data-spec :as ds]
            [reitit.coercion.spec]
            [reitit.swagger :as swagger]
            [ring.util.http-response :refer :all]
            [scramblies.solver :as solver]
            [ring.middleware.params :as params]))


(defn service-routes []
  ["/api"
   {:middleware [params/wrap-params
                 muuntaja/wrap-format
                 swagger/swagger-feature
                 rrc/coerce-exceptions-middleware
                 rrc/coerce-request-middleware
                 rrc/coerce-response-middleware]
    :coercion reitit.coercion.spec/coercion
    :swagger {:id ::api
              :info {:title "my-api"
                     :description "using [reitit](https://github.com/metosin/reitit)."}
              :produces #{"application/json"
                          "application/edn"
                          "application/transit+json"}
              :consumes #{"application/json"
                          "application/edn"
                          "application/transit+json"}}}
   ["/swagger.json"
    {:get {:no-doc true
           :handler (swagger/create-swagger-handler)}}]
   ["/scramblies"
    {:get {:summary "scramble solver"
           :parameters {:query {:source string?, :pattern string?}}
           :responses {200 {:body {:result boolean?}}}
           :handler (fn [{{{:keys [source pattern]} :query} :parameters}]
                      {:status 200
                       :body {:result (solver/scramble? source pattern)}})}}]])
