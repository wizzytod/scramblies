(ns scramblies.test.solver
  (:require [clojure.test :refer [deftest testing is]]
            [scramblies.solver :refer [scrumble?]]))


(deftest test-solver

  (testing "match"
    (is (true? (scrumble? "abc" "bca"))))

  (testing "not match"
    (is (false? (scrumble? "abcd" "bcae"))))

  (testing "ex1"
    (is (true? (scrumble? "rekqodlw" "world"))))

  (testing "ex2"
    (is (true? (scrumble? "cedewaraaossoqqyt" "codewars"))))

  (testing "ex3"
    (is (false? (scrumble? "katas" "steak"))))

  (testing "source is shorter"
    (is (false? (scrumble? "kata" "steak"))))

  (testing "nil is nil"
    (is (true? (scrumble? nil nil))))

  (testing "empty is nil"
    (is (true? (scrumble? "" nil))))

  (testing "empty is nil"
    (is (true? (scrumble? nil "")))))
