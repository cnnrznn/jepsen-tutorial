PREPARATION

A few things need to be done to run the tests.

CONTAINERS:
First, build the docker image using the `context-d` directory.
Then, spawn some number (typically 5) of containers to run the system.
Alternatively, you could have the system deployed in the wild, in which case you just need to configure how Jepsen will SSH into each node.

DEPENDENCIES:
For ubuntu-based systems, `libzip2` does not exist.
Make a directory `<leiningen-prj>/checkouts` and add to it a symlink to the Jepsen project.
Inside the Jepsen project, edit the debian code do `libzip4`.
When issuing `lein run test ...`, leiningen should automagically choose this local copy.
