(ns acme.message-create
  (:require [acme.bot :as bot]
            [acme.events :as events]
            [discljord.formatting :as formatting]
            [discljord.messaging :as discord-rest]))

(def responses ["Hello there" "Good evening" "Good morning" "G'day" "Hi" "Howdy :cowboy:"])

(defn random-response [user]
  (str (rand-nth responses) ", " (formatting/mention-user user) \!))

(defmethod events/handle-event :message-create
  [_ {:keys [channel-id author mentions] :as _data}]
  (when (some #{@bot/id} (map :id mentions))
    (discord-rest/create-message! (bot/rest-connection) channel-id :content (random-response author))))
