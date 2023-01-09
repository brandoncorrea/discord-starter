(ns acme.main-spec
  (:require [acme.events :as events]
            [acme.main :as sut]
            [acme.spec-helper :as spec-helper]
            [discljord.events :as discord-events]
            [speclj.core :refer :all]
            [speclj.stub :as stub]))

(describe "Main"
  (with-stubs)
  (spec-helper/stub-bot)

  (around [it]
    (with-redefs [discord-events/message-pump! (stub :discord/message-pump!)]
      (it)))

  (it "initializes with bot token"
    (with-redefs [slurp (fn [file] ({"config.edn" "{:token \"TOKEN\"}"} file))]
      (sut/-main)
      (let [[init! pump! stop!] @stub/*stubbed-invocations*]
        (should= [:bot/init! ["TOKEN"]] init!)
        (should= [:discord/message-pump! [:bot/events events/handle-event]] pump!)
        (should= [:bot/stop! []] stop!))))
  )
