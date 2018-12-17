(ns jepsen.etcdemo
  (:require [jepsen.cli :as cli]
            [jepsen.tests :as tests]))

(defn etcd-test
  "Given an options map from the command line runner (e.g. :nodes, :ssh,
  :concurrency, ...), constructs a test map."
  [opts]
  (merge tests/noop-test
         opts))

(defn -main
  "A very good place to start."
  [& args]
  (cli/run! (cli/single-test-cmd {:test-fn etcd-test})
            args))
