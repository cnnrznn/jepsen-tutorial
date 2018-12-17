(ns jepsen.etcdemo
  (:require [clojure.tools.logging :refer :all]
            [clojure.string :as str]
            [jepsen [cli :as cli]
                    [control :as ctrl]
                    [db :as db]
                    [tests :as tests]]
            [jepsen.control.util :as cu]
            [jepsen.os.debian :as debian]))

(defn db
  "Etcd DB for a particular version."
  [version]
  (reify db/DB
    (setup! [_ test node]
      (info node "installing etcd" version))

    (teardown! [_ test node]
      (info node "tearing down etcd"))))

(defn etcd-test
  "Given an options map from the command line runner (e.g. :nodes, :ssh,
  :concurrency, ...), constructs a test map."
  [opts]
  (merge tests/noop-test
         opts
         {:name "etcd"
          :os debian/os
          :db (db "v3.1.5")}))

(defn -main
  "A very good place to start."
  [& args]
  (cli/run! (cli/single-test-cmd {:test-fn etcd-test})
            args))
