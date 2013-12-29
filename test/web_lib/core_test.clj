(ns web-lib.core-test
  (:require [clojure.test :refer :all]
            [web-lib.core :refer :all]))

(deftest starts-with?-tests
  (testing "strings containing the substring"
    (is (true? (starts-with? "asdf" "asdf")))
    (is (true? (starts-with? "asdf" "as")))
    (is (true? (starts-with? "ad" "")))
    (is (true? (starts-with? "asdf" "a"))))
  (testing "non containing strings"
    (is (false? (starts-with? "foo" "bar")))
    (is (false? (starts-with? "" "a")))))

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
