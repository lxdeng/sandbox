see ../node.js.hello for the app
kubectl run hello-node --image=hello-node:v1 --port=8080
kubectl scale --replicas=2 deployment/hello-node

$ kubectl create -f hello-service.yaml

$ kubectl get endpoints hello-node
NAME         ENDPOINTS                         AGE
hello-node   10.32.0.11:8080,10.32.0.12:8080   1m

note the port 18080 is different from targetPort 8080 of the PODs.
$ curl http://10.107.253.22:18080
