(ns scramblies.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [scramblies.core-test]))

(doo-tests 'scramblies.core-test)

