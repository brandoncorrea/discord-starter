(ns acme.ready
  (:require [acme.bot :as bot]
            [acme.events :as events]
            [discljord.connections :as discord-ws]))

(defmethod events/handle-event :ready
  [_ _]
  (discord-ws/status-update! (bot/gateway) :activity (discord-ws/create-activity :name "Say hello!")))
