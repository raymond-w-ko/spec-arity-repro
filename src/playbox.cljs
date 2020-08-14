(ns playbox
  (:require
   [cljs.spec.alpha :as spec]
   [cljs.spec.test.alpha :as st]

   ;; NOTE: uncomment this and code breaks
   [orchestra-cljs.spec.test]

   [expound.alpha :as expound]))

(defn fake-expound-str
  "Some docstring"
  ([spec form]
   (fake-expound-str spec form {}))
  ([spec form opts]
   (println spec form opts)))
(spec/fdef fake-expound-str
  :args (spec/cat :spec any?
                  :form any?
                  :opts (spec/? any?))
  :ret string?)

(defn test-fn []
  (cljs.spec.test.alpha/instrument `fake-expound-str)
  (fake-expound-str 1 2))

(defn handler []
  (js/console.log "Hello, World!")
  (test-fn)
  (js/console.log "Goodbye, World!"))
