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

docs:
	pnpm run docs

lint:
	cd packages/core && pnpm run lint

dev:
	cd packages/core && pnpm run dev

commit:
	git add . && pnpm run commit

schemas:
	pnpm exec -- yml-to-model gen ./schema/user.yml -t ./schema/templateJava -o ./schema/java -l java
