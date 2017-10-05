“Latest” tag simply means “the last build/tag that ran without a specific tag/version specified”.

docker build -t longx/test .

$ docker tag longx/test longx/test:1

lxdeng@lu1:~/github/lxdeng/sandbox/dev/docker/images/test_tag$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
longx/test          1                   0e2b4639bb8f        4 minutes ago       5.61MB
longx/test          latest              0e2b4639bb8f        4 minutes ago       5.61MB
busybox             ubuntu-14.04        d16744963217        2 years ago         5.61MB

$ docker login

$ docker push longx/test

go to hub.docker.com, it has two tags: latest and 1, which points to the same image.

Update Dockerfile, from "this is version 1" to "this is version 2"

$ docker build -t longx/test .

$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
longx/test          latest              261b862882ac        5 seconds ago       5.61MB
longx/test          1                   0e2b4639bb8f        10 minutes ago      5.61MB
busybox             ubuntu-14.04        d16744963217        2 years ago         5.61MB

$ docker tag longx/test longx/test:2 

go to hub.docker.com, it has three tags: latest and 1, 2.
