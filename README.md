# acme

A Discord bot designed to... well, that part is up to you.

## Config

Create `config.edn` in the same directory as `project.clj` with the following 
structure and add your Discord bot's token:

````clojure
{:token "BOT_TOKEN"}
````

## Running Server Locally

    clj -Mrun

## Running Tests

    # clojure specs:
    clj -Mspec:test
    # clojure specs automatically running when fileds are changed:
    clj -Mspec:test -a
