(ns playbox
  (:require
   [cljs.spec.alpha :as spec]
   [cljs.spec.test.alpha :as stest]

   [orchestra-cljs.spec.test :as orc]

   [expound.alpha :as expound]))

(defn fake-expound-str
  "Some docstring"
  ([spec form]
   (fake-expound-str spec form {}))
  ([spec form opts]
   (println spec form opts)
   form))
(spec/fdef fake-expound-str
  :args (spec/cat :spec any?
                  :form any?
                  :opts (spec/? any?))
  :ret string?)

(defn test-fn []
  (orc/instrument `fake-expound-str)
  (fake-expound-str :foo "bar"))

(defn handler []
  (js/console.log "Hello, World!")
  (test-fn)
  (js/console.log "Goodbye, World!"))
