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
