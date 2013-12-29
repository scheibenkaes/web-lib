(ns web-lib.core
  (:require [clojure.string :as string]))

(defn starts-with?
  "clj(s) compatible startsWith implementation"
  [str sub]
  (let [pattern (re-pattern sub)]
    (-> (re-find pattern str) nil? not)))

(defn prepend-context
  "Given a ringesque map containing :context and a link to a resource,
   prepends the context to the link."
  [{context :context} link]
  (let [context (or context "")
        parts-with-context (apply str context (if (starts-with? context "/") "" "/")
                                  link)]
    (string/replace parts-with-context #"^//" "/")))
