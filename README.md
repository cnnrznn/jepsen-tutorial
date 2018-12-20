PREPARATION

A few things need to be done to run the tests.

CONTAINERS:
First, build the docker image using the `context-d` directory.
Then, spawn some number (typically 5) of containers to run the system.
Alternatively, you could have the system deployed in the wild, in which case you just need to configure how Jepsen will SSH into each node.

DEPENDENCIES:
For ubuntu-based systems, `libzip2` does not exist.
Make a directory `jepsen.etcdemo/checkouts` and add to it a symlink to the Jepsen project.
Inside the Jepsen project, edit the debian code do `libzip4`.
When issuing `lein run test ...`, leiningen should automagically choose this local copy.

RUN:
1. `./start-containers.sh`.
2. cd into the jepsen.etcdemo repository.
3. `lein run test --time-limit <seconds>`
4. `./stop-containers.sh`
