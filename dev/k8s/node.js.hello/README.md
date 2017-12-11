docker build -t hello-node:v1 .

1. kubectl run hello-node --image=hello-node:v1 --port=8080

To get pod internal IP.
kubectl get pods
kubectl describe pod hello-node-xxxxxxx


$ curl http://10.32.0.5:8080
Hello World!

expose pods as services:
$ kubectl expose deployment/hello-node --type="ClusterIP" --port=8080

to get cluster-IP
$ kubectl get service hello-node

scale up to have 2 pods
$ kubectl scale deployments/hello-node --replicas=2

$ kubectl get pod
NAME                          READY     STATUS    RESTARTS   AGE
hello-node-69b47b745c-7l2hc   1/1       Running   0          3m
hello-node-69b47b745c-mv42c   1/1       Running   0          2s

$ kubectl logs -f hello-node-69b47b745c-f88sq

Using cluster ip to observe loadbalance.
curl http://10.105.239.143:8080/

Join a second node. From the second node, it can access by using the cluster-ip. It can also access by using the private IPs.
From second node lu2,
lu2$ curl http://10.101.111.37:8080
Hello World!

2. Create a pod using Pod Manifest.
kubectl apply -f hello-pod.yaml 

kubectl delete -f hello-pod.yaml

grace period is 30 seconds
