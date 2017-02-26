(ns nestory-clj.nest-api-test
  (:require [cheshire.core :as json]
            [camel-snake-kebab.core :refer [->kebab-case-keyword]]
            [clojure.test :refer :all]
            [org.httpkit.fake :refer [with-fake-http]]
            [nestory-clj.nest-api :refer :all]))

(def sample-nest-api-response (-> "test/nestory_clj/nest-response.json" 
                                  slurp
                                  (json/parse-string ->kebab-case-keyword)))

(def expected-structure {
  :humidity 55
  :target-temperature 21.5
  :name "Hallway"
  :ambient-temperature 20.5
  :away-status "home"
  :structure-id "c-SEshyQhB7ft2mluyF3otVjI8WUnxDJpNaAd1gcaLCgvx8ogw5m-g"
  :thermostat-id "JZ-U65a4K6EKQmzsnTzFPbTE2K-T_Yco"
  :has-leaf false
  :heating-state "heating"
  :time-to-target "~0"
  :is-using-emergency-heat false})

(deftest nest-api-extraction
  (testing "can extract nest data from api"
    (is (= {:humidity 55
            :target-temperature 21.5
            :name "Hallway"
            :ambient-temperature 20.5
            :away-status "home"
            :structure-id "c-SEshyQhB7ft2mluyF3otVjI8WUnxDJpNaAd1gcaLCgvx8ogw5m-g"
            :thermostat-id "JZ-U65a4K6EKQmzsnTzFPbTE2K-T_Yco"
            :has-leaf false
            :heating-state "heating"
            :time-to-target "~0"
            :is-using-emergency-heat false} (nest-data sample-nest-api-response)))))

(deftest nest-fetch-data
  (testing "fetches data from nest api"
    (with-fake-http [{:url "https://developer-api.nest.com"
                      :method :get} "fake http response"]
      (is (= (:body (get-nest-data! {:nest {:url "https://developer-api.nest.com"
                                     :api-key "asdf"}})) "fake http response")))))
