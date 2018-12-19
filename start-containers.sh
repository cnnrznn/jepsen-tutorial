#!/bin/bash

for i in $(seq 5)
do
        docker run --init -d --cap-add=NET_ADMIN jepsen
done
