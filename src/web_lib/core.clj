(ns web-lib.core
  (:require [clojure.string :as string]))

(set! *warn-on-reflection* true)

(defn prepend-context
  "Given a ring request and a link to a resource, prepends the context to the link."
  [{context :context} link]
  (let [^String context (or context "")
        parts-with-context (apply str context (if (.startsWith context "/") "" "/")
                                  link)]
    (string/replace parts-with-context #"^//" "/")))
