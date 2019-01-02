#!/bin/bash
for i in `seq 1 10`;
do
	echo $i
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"instrumentId": '$i' }' http://localhost:8080/open-book
	curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"instrumentId": '$i' }' http://localhost:8080/close-book
done
