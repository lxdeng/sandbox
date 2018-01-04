lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/node.js.hello$ kubectl apply -f hello-pod.yaml
pod "hello-node" created
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/node.js.hello$ kubectl get pods
NAME         READY     STATUS    RESTARTS   AGE
hello-node   1/1       Running   0          10s
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/node.js.hello$ kubectl get service
NAME         TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   33d
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/node.js.hello$ kubectl get deployment
No resources found.
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/node.js.hello$ kubectl get ReplicaSet
No resources found.

add labels:
$ kubectl label pod hello-node "run=hello"

create replicaset:
$ kubectl apply -f hello-rs.yaml

scale to 4:
$ kubectl scale --replicas=2 rs/hello-node-rs

$ kubectl get pods
NAME                  READY     STATUS    RESTARTS   AGE
hello-node            1/1       Running   0          18h
hello-node-rs-bthk5   1/1       Running   0          2m
hello-node-rs-mgfh5   1/1       Running   0          2m
hello-node-rs-vfvg5   1/1       Running   0          2s
