(ns nestory-clj.config
    (:require [mount.core :refer [defstate]]
              [environ.core :refer [env]]
              [clojure.string :as str]))

(defstate config
    :start {:nest    {:url "https://developer-api.nest.com"
                      :api-key (env :nest-api-key)}
            :darksky {:api-key (env :darksky-api-key)
                      :latlong (str/replace (env :latlong) "|" ",")}
            :dynamodb {:table-name (env :dynamodb-table)}})
