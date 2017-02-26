(defproject nestory-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [cheshire "5.7.0"]
                 [http-kit "2.2.0"]
                 [environ "1.1.0"]
                 [com.taoensso/faraday "1.9.0"]
                 [mount "0.1.11"]
                 [camel-snake-kebab "0.4.0"]
                 [uswitch/lambada "0.1.2"]]
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[http-kit.fake "0.2.1"]]}}
  :uberjar-name "nestory-clj.jar")
