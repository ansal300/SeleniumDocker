FROM bellsoft/liberica-openjdk-alpine-musl
# Install curl jq
RUN apk add curl jq
#Workspace
WORKDIR /home/selenium
#Adding Required Files
ADD /target/docker-resources /home/selenium
Add runner.sh  runner.sh
#Env Variables
#Browser
#HUB_HOST
#TEST_SUITE
#THREAD_COUNT

ENTRYPOINT sh runner.sh