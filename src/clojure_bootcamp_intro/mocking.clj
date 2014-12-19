(ns clojure-bootcamp-intro.mocking)

; Imaginary database API:

(def database {"tommi" {:name "Tommi"
                        :twitter "@ikitommi"}
               "jarppe" {:name "Jarppe"
                         :twitter "@jarppe"}})

(defn find-user-by-id [id]
  (get database id))

; Imaginary database REST API to test:
(defn get-user [request]
  "id in request should be same as database key string"
  (let [id    (get-in request [:params :id])
        user  (find-user-by-id id)]
    (if user
      {:status 200 :body user}
      {:status 404 :body "user not dound"}) ))
