current_dir := $(shell pwd)
name := spec-arity-repro

.PHONY: all
all:
	echo "Chose a Makefile target"

update-node-deep-deps:
	rm -rf node_modules
	rm -f package-lock.json
	npm install

outdated:
	clojure -Aoutdated --aliases outdated --aliases handler
update-cljs:
	clojure -Aoutdated --aliases outdated --aliases handler --write

watch:
	rm -f handler.js
	rm -f handler.js.map
	./node_modules/.bin/shadow-cljs watch handler
release:
	rm -f handler.js
	rm -f handler.js.map
	./node_modules/.bin/shadow-cljs release handler
