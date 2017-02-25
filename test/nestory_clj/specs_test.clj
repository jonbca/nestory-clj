(ns nestory-clj.specs-test
  (:require [clojure.test :refer :all]
            [clojure.spec :as s]
            [nestory-clj.specs :refer :all :as n]))

(deftest test-spec
  (testing "a nest api record has required properties"
    (is (s/valid? :nestory-clj.specs/nest
       {:humidity 55
        :target-temperature 20
        :name "Living room"
        :ambient-temperature 33.2
        :away-status "away"
        :structure-id "some-structure"
        :thermostat-id "some thermostat"
        :has-leaf true
        :heating-state "heating"
        :time-to-target "~2h"
        :is-using-emergency-heat true})))
  (testing "weather record has the required properties"
    (is (s/valid? :nestory-clj.specs/weather
      {:outside-temperature 34
       :outside-humidity 22
       :apparent-temperature 32.5
       :wind-speed 1.2
       :cloud-cover 33
       :dew-point 9})))
       
  (testing "dynamo record contains all the required properties"
    (is (s/valid? :nestory-clj.specs/dynamo-record
         {:outside-temperature 34
          :outside-humidity 22
          :apparent-temperature 32.5
          :wind-speed 1.2
          :cloud-cover 33
          :dew-point 9
          :humidity 55
          :target-temperature 20
          :name "Living room"
          :ambient-temperature 33.2
          :away-status "away"
          :structure-id "some-structure"
          :thermostat-id "some thermostat"
          :has-leaf true
          :heating-state "heating"
          :time-to-target "~2h"
          :is-using-emergency-heat true}))))
