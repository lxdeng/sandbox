https://medium.com/google-cloud/understanding-kubernetes-networking-services-f0cb48e4cc82

Understanding kubernetes networking: services

A service is a type of kubernetes resource that causes a proxy to be configured to forward requests to a set of pods. The set of pods that will receive traffic is determined by the selector, which matches labels assigned to the pods when they were created. Once the service is created we can see that it has been assigned an IP address and will accept requests on port 80.

ClusterIP is the default service type, and it means “the service will be assigned an IP address reachable from any pod in the cluster.” 

Use (cluster DNS) name to access the service.
$ kubectl create -f test-client.yaml 
pod "test-client" created

$ kubectl logs test-client
HTTP/1.0 200 OK
Server: SimpleHTTP/0.6 Python/2.7.14
Date: Wed, 10 Jan 2018 00:03:15 GMT
Content-type: text/html
Content-Length: 48
Last-Modified: Tue, 09 Jan 2018 23:22:17 GMT

<p>Hello from service-test-5d4545b575-rvdnf</p>




With "ClusterIP" type service, we can still define external IP 192.168.29.221, which is the IP of the host.
https://kubernetes.io/docs/concepts/services-networking/service/#external-ips

If there are external IPs that route to one or more cluster nodes, Kubernetes services can be exposed on those externalIPs. Traffic that ingresses into the cluster with the external IP (as destination IP), on the service port, will be routed to one of the service endpoints. externalIPs are not managed by Kubernetes and are the responsibility of the cluster administrator.


$ kubectl apply -f pythonweb.service.externalIp.yaml

$ curl http://192.168.29.221
<p>Hello from service-test-5d4545b575-z6jnj</p>
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://192.168.29.221
<p>Hello from service-test-5d4545b575-z6jnj</p>
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://192.168.29.221
<p>Hello from service-test-5d4545b575-z6jnj</p>
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://192.168.29.221
<p>Hello from service-test-5d4545b575-qpqhb</p>
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://192.168.29.221

From different host lu3,
lxdeng@lu3:~$ curl http://lu1
<p>Hello from service-test-5d4545b575-z6jnj</p>
lxdeng@lu3:~$ curl http://lu1
<p>Hello from service-test-5d4545b575-qpqhb</p>


Combine type "NodePort" and external IP:

lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ kubectl get svc
NAME                          TYPE        CLUSTER-IP      EXTERNAL-IP      PORT(S)             AGE
service-test                  NodePort    10.105.29.211   192.168.29.221   80:32550/TCP        4s

lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://192.168.29.221:32550
<p>Hello from service-test-5d4545b575-z6jnj</p>
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://192.168.29.221:80
<p>Hello from service-test-5d4545b575-z6jnj</p>
lxdeng@lu1:~/github/lxdeng/sandbox/dev/k8s/python.web$ curl http://10.105.29.211:80
<p>Hello from service-test-5d4545b575-qpqhb</p>
