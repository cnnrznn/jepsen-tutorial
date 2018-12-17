FROM ubuntu:xenial

RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y \
              vim openssh-server wget iputils-ping \
              net-tools

RUN echo 'root:root' | chpasswd
RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
RUN mkdir /var/run/sshd

CMD ["/usr/sbin/sshd", "-D"]
