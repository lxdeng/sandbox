docker build -t hello-node:v1 .

1. kubectl run hello-node --image=hello-node:v1 --port=8080

To get pod internal IP.
kubectl get pods
kubectl describe pod hello-node-xxxxxxx


$ curl http://10.32.0.5:8080
Hello World!

expose pods as services:
$ kubectl expose deployment/bootcamp --type="ClusterIP" --port=8080

scale up to 2 pods

$ kubectl logs -f hello-node-69b47b745c-f88sq

Using cluster ip to observe loadbalance.
curl http://10.105.239.143:8080/


2. Create a pod using Pod Manifest.
kubectl apply -f hello-pod.yaml 

kubectl delete -f hello-pod.yaml

grace period is 30 seconds
