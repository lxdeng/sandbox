see ../node.js.hello for the app
kubectl run hello-node --image=hello-node:v1 --port=8080
kubectl scale --replicas=2 deployment/hello-node

Case 1:
$ kubectl create -f hello-service.yaml

$ kubectl get endpoints hello-node
NAME         ENDPOINTS                         AGE
hello-node   10.32.0.11:8080,10.32.0.12:8080   1m

note the port 18080 is different from targetPort 8080 of the PODs.
$ curl http://10.107.253.22:18080


Case 2:
$ kubectl create -f hello-service-no-selector.yaml

endpoints object is not created.
$ kubectl get endpoints

$ kubectl get service
NAME         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)     AGE
hello-node   ClusterIP   10.104.100.75   <none>        18080/TCP   15s

$ curl http://10.104.100.75:18080
curl: (7) Failed to connect to 10.104.100.75 port 18080: Connection refused

$ kubectl get pods -o wide
NAME                          READY     STATUS    RESTARTS   AGE       IP           NODE
hello-node-69b47b745c-2vvhl   1/1       Running   0          42m       10.32.0.12   lu1
hello-node-69b47b745c-5lgcl   1/1       Running   0          45m       10.32.0.11   lu1

Create the endpoints to match the service:
$ kubectl create -f hello-endpoint.yaml

Now it works!
$ curl http://10.104.100.75:18080
