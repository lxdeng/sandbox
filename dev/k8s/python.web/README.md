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

