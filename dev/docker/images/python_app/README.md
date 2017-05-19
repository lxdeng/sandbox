$docker build -t friendlyhello .
$docker run -p 4000:80 friendlyhello
$curl http://localhost:4000

$ docker exec -it <container-id> bash
root@9c802486e09b:/app#
root@9c802486e09b:/app# ls
Dockerfile  app.py  requirements.txt

$docker stop 9c802486e09b
$docker start 9c802486e09b
$docker logs -f 9c802486e09b # follow the log output
