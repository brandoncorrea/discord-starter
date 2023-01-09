(ns acme.events)

(defmulti handle-event (fn [type _] type))
(defmethod handle-event :default [_ _])
