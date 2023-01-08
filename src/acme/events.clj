(ns acme.events)

(defmulti handle-event (fn [type _data] type))
(defmethod handle-event :default [_ _])
