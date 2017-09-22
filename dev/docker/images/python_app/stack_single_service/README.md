$ docker stack deploy -c docker-compose.yml lab
Creating network lab_webnet
Creating service lab_web


$ docker stack ls
NAME           SERVICES
lab  1

$ docker stack services lab
ID            NAME     MODE        REPLICAS  IMAGE
uve6rz5q947k  lab_web  replicated  2/2       longx/friendlyhello:test

$ docker stack ps lab
ID            NAME       IMAGE                     NODE  DESIRED STATE  CURRENT STATE           ERROR  PORTS
xgoxd8ivycle  lab_web.1  longx/friendlyhello:test  t30   Running        Running 59 seconds ago         
xnez2fis5s2s  lab_web.2  longx/friendlyhello:test  t30   Running        Running 59 seconds ago     

$ docker service ls
ID            NAME     MODE        REPLICAS  IMAGE
uve6rz5q947k  lab_web  replicated  2/2       longx/friendlyhello:test

lxdeng@t30 ~/github/sandbox/dev/docker/images/python_app $ docker service ps lab_web
ID            NAME       IMAGE                     NODE  DESIRED STATE  CURRENT STATE           ERROR  PORTS
xgoxd8ivycle  lab_web.1  longx/friendlyhello:test  t30   Running        Running 14 minutes ago         
xnez2fis5s2s  lab_web.2  longx/friendlyhello:test  t30   Running        Running 14 minutes ago 

$ docker network inspect lab_webnet
"Driver": "overlay"

observe loadbalancing:

$ curl http://localhost:80
<h3>Hello World!</h3><b>Hostname:</b> 3c7d45d1b7fe<br/><b>Visits:</b> <i>cannot connect to Redis, counter disabled</i>

 $ curl http://localhost:80
<h3>Hello World!</h3><b>Hostname:</b> 3cf3d09fa3c5<br/><b>Visits:</b> <i>cannot connect to Redis, counter disabled</i>

Scale up:
$ docker service scale lab_web=3
lab_web scaled to 3
lxdeng@t30 ~/github/sandbox/dev/docker/images/python_app/stack_single_service $ docker service ls
ID            NAME     MODE        REPLICAS  IMAGE
uve6rz5q947k  lab_web  replicated  3/3       longx/friendlyhello:test

Scale down:
$ docker service scale lab_web=2

Network:
docker inspect <container>. It shows the container is put into two networks: ingress and lab_webnet.
It seems the container is also in the the docker_gwbridge network, as the following. But the inspect command does not show it.

$ docker exec -it <container id> sh
# ip addr show
It shows three IPs:
  one for lab_web
  one for ingress
  one for docker_gwbridge 


