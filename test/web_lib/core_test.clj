(ns web-lib.core-test
  (:require [clojure.test :refer :all]
            [web-lib.core :refer :all]))

(deftest prepend-context-tests
  (testing "default context /"
    (let [req {:context "/"}]
      (is (= (prepend-context req "/") "/"))
      (is (= (prepend-context req "foo") "/foo"))
      (is (= (prepend-context req "foo/bar.js") "/foo/bar.js"))
      (is (= (prepend-context req "/css/checkmate.css") "/css/checkmate.css"))))
  
  (testing "a different context than the default"
    (let [req {:context "/advent"}]
      (is (= (prepend-context req "/css/checkmate.css") "/advent/css/checkmate.css")))))
