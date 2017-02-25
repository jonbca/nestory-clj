(ns nestory-clj.specs
  (:require [clojure.spec :as s]))

(s/def ::temperature number?)

(s/def ::humidity int?)
(s/def ::target-temperature ::temperature)
(s/def ::name string?)
(s/def ::ambient-temperature ::temperature)
(s/def ::away-status string?)
(s/def ::structure-id string?)
(s/def ::thermostat-id string?)
(s/def ::has-leaf boolean?)
(s/def ::heating-state string?)
(s/def ::time-to-target string?)
(s/def ::is-using-emergency-heat boolean?)
(s/def ::outside-temperature ::temperature)
(s/def ::weather-conditions string?)
(s/def ::outside-humidity number?)
(s/def ::apparent-temperature ::temperature)
(s/def ::wind-speed number?)
(s/def ::cloud-cover number?)
(s/def ::dew-point number?)

(s/def ::nest (s/keys :req-un [::humidity
                              ::target-temperature
                              ::name
                              ::ambient-temperature
                              ::away-status
                              ::structure-id
                              ::thermostat-id
                              ::has-leaf
                              ::heating-state
                              ::time-to-target
                              ::is-using-emergency-heat]))

(s/def ::weather (s/keys :req-un [::outside-temperature
                                  ::outside-humidity
                                  ::apparent-temperature
                                  ::wind-speed
                                  ::cloud-cover
                                  ::dew-point]))

(s/def ::dynamo-record (s/merge ::weather ::nest))                                  
