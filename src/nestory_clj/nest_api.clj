(ns nestory-clj.nest-api
  (:require [nestory-clj.config :refer [config]]
            [org.httpkit.client :as http]))

(defn- thermostat-property [body property]
  (-> body (get-in [:devices :thermostats]) vals first property))

(defn- structure-property [body property]
  (-> body :structures vals first property))

(defn nest-data [body]
  (let [extract-thermostat-data (partial thermostat-property body)
        extract-structure-data (partial structure-property body)]
    {:humidity (extract-thermostat-data :humidity)
     :target-temperature (extract-thermostat-data :target-temperature-c)
     :name (extract-thermostat-data :name)
     :ambient-temperature (extract-thermostat-data :ambient-temperature-c)
     :away-status (extract-structure-data :away)
     :structure-id (extract-structure-data :structure-id)
     :thermostat-id (extract-thermostat-data :device-id)
     :has-leaf (extract-thermostat-data :has-leaf)
     :heating-state (extract-thermostat-data :hvac-state)
     :time-to-target (extract-thermostat-data :time-to-target)
     :is-using-emergency-heat (extract-thermostat-data :is-using-emergency-heat)}))

(defn get-nest-data!
  ([] (get-nest-data! config))
  ([{{url :url, api-key :api-key} :nest}]
    @(http/get url {:oauth-token api-key})))
