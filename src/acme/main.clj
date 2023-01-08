(ns acme.main
  (:require [acme.bot :as bot]
            [acme.events :as events]
            [acme.message-create]
            [acme.ready]
            [clojure.edn :as edn]
            [discljord.events :as discord-events]))

(defn -main [& _]
  (try
    (-> "config.edn" slurp edn/read-string :token bot/init!)
    (discord-events/message-pump! (bot/events) events/handle-event)
    (finally (bot/stop!))))
