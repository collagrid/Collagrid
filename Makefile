.DEFAULT_GOAL := help
SHELL := /bin/bash
UNAME_S := $(shell uname -s)
SEMVER3 := $(shell cat .version)


ifndef ENV_FILE
ENV_FILE := .env
export ENV_FILE
endif

ifndef DEVENV_FILE
DEVENV_FILE := .env.devenv
export DEVENV_FILE
endif


db: ## start postgresql and mongodb local
	docker compose up -d

db-down: ## stop postgresql and mongodb local
	docker compose down

db-destroy: ## destroy and delete the local `.data` folder
	rm -rf .data/

db-gen: ## generate db schema
	pnpm run db:gen
install:
	pnpm install && make build

build:
	pnpm build:dst:pre && pnpm build:sr

web:
	cd packages/datasheet && pnpm run dev

server:
	cd packages/server && pnpm run start:dev

server2:
	source scripts/export-env.sh $$ENV_FILE;\
	source scripts/export-env.sh $$DEVENV_FILE;\
	pnpm run start:room-server

commit:
	git add . && pnpm run commit
