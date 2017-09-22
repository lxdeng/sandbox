1. Without publishing ports
$ docker service create --name helloworld alpine ping docker.com

Create a service (without defining a stack)

Scale up:
$ docker service scale helloworld=2
helloworld scaled to 2

Network:
The containers are put into the default "bridge" network.


2. With publishing ports
$ docker service create --name web1 --replicas=2 --publish 80:80 longx/friendlyhello:test
Network:
The containers are put into the "ingress" network. 
