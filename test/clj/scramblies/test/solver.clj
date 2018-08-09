(ns scramblies.test.solver
  (:require [clojure.test :refer [deftest testing is]]
            [scramblies.solver :refer [scramble?]]))


(deftest test-solver

  (testing "match"
    (is (true? (scramble? "abc" "bca"))))

  (testing "not match"
    (is (false? (scramble? "abcd" "bcae"))))

  (testing "ex1"
    (is (true? (scramble? "rekqodlw" "world"))))

  (testing "ex2"
    (is (true? (scramble? "cedewaraaossoqqyt" "codewars"))))

  (testing "ex3"
    (is (false? (scramble? "katas" "steak"))))

  (testing "source is shorter"
    (is (false? (scramble? "kata" "steak"))))

  (testing "nil is nil"
    (is (true? (scramble? nil nil))))

  (testing "empty is nil"
    (is (true? (scramble? "" nil))))

  (testing "empty is nil"
    (is (true? (scramble? nil "")))))
