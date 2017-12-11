kubectl create -f https://k8s.io/docs/tasks/access-application-cluster/redis-master.yaml

$ kubectl get pods redis-master -o wide
NAME           READY     STATUS    RESTARTS   AGE       IP          NODE
redis-master   2/2       Running   0          9m        10.32.0.8   lu1

The 2/2 shows the pod "redis-master" has two containers and both containers are ready.

$ redis-cli 10.32.0.8
Could not connect to Redis at 127.0.0.1:6379: Connection refused

Forward port 6379 on the local workstation to port 6379 of redis-master pod:
kubectl port-forward redis-master 6379:6379

$ redis-cli 
127.0.0.1:6379> ping
PONG
