#!/bin/bash
HOST=$1
PORT=$2
set -x

check () {
    curl -k -i -X GET https://$HOST:$PORT/weather
    read
}

write () {
    curl -k -i -X POST -H 'Content-Type: application/json' -d '[{"time":1,"humidity":99,"temp":105},{"time":2,"humidity":95,"temp":50}]' https://$HOST:$PORT/createWeathers
    read
}

writeOne () {
    curl -k -i -X POST -H 'Content-Type: application/json' -d '{"time":1,"humidity":99,"temp":105}' https://$HOST:$PORT/createWeather
    read
}

check
write
check
writeOne
check