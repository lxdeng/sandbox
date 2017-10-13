1. test env with configmap:

$ kubectl create configmap test-config --from-literal=prop1=hello --from-literal=prop2=world

$ kubectl describe configmap test-config
Name:         test-config
Namespace:    default
Labels:       <none>
Annotations:  <none>

Data
====
prop1:
----
hello
prop2:
----
world
Events:  <none>

$ kubectl get pods -a
NAME                        READY     STATUS      RESTARTS   AGE
test-pod                    0/1       Completed   0          17s

$ kubectl logs test-pod
hello world

2. test volume with configmap from file
$ kubectl create configmap file-config --from-file=./props.txt

@lu1:~$ kubectl get configmap file-config -o yaml
apiVersion: v1
data:
  props.txt: |
    prop1=hello
    prop2=world
kind: ConfigMap
metadata:
  creationTimestamp: 2017-10-13T21:09:08Z
  name: file-config
  namespace: default
  resourceVersion: "76627"
  selfLink: /api/v1/namespaces/default/configmaps/file-config
  uid: c0808521-b05a-11e7-ad11-0800277d9948

$ kubectl logs test-pod
props.txt
prop1=hello
prop2=world
