$ kubectl apply -f hostPath.yaml 
pod "test-pd" created

$ kubectl get pods -o wide
NAME                        READY     STATUS    RESTARTS   AGE       IP          NODE
test-pd                     1/1       Running   0          36s       10.44.0.2   lu2

lu1:~$ kubectl exec -it test-pd sh
# ls /cache
#

lu2:~$ ls -ld /home/lxdeng/data
drwxr-xr-x 2 root root 4096 Oct 13 11:04 /home/lxdeng/data
