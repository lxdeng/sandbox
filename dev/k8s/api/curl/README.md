Start the proxy, which handles the API server and authtication.
$ kubectl proxy --port=8080 &

To list pods of default namespace

$ curl http://localhost:8080/api/v1/namespaces/default/pods
{
  "kind": "PodList",
  "apiVersion": "v1",
  "metadata": {
    "selfLink": "/api/v1/namespaces/default/pods",
    "resourceVersion": "452986"
  },
  "items": [

   .....

}


It lists pods in default namespace, including completed ones. Same as the followingn command:

$ kubectl get pods --namespace default -a
NAME                            READY     STATUS      RESTARTS   AGE
service-test-5d4545b575-gcnhw   1/1       Running     1          1d
service-test-5d4545b575-gw8vh   1/1       Running     1          1d
test-client                     0/1       Completed   0          1d


To list a single pod:
$ curl http://localhost:8080/api/v1/namespaces/default/pods/service-test-5d4545b575-gcnhw
lxdeng@lu1:~$  curl http://localhost:8080/api/v1/namespaces/default/pods/service-test-5d4545b575-gcnhw
{
  "kind": "Pod",
  "apiVersion": "v1",
  "metadata": {
    "name": "service-test-5d4545b575-gcnhw",
    "generateName": "service-test-5d4545b575-",
    "namespace": "default",
    "selfLink": "/api/v1/namespaces/default/pods/service-test-5d4545b575-gcnhw",

   .....
}

To list all pods
curl http://localhost:8080/api/v1/pods


To list services:

curl http://localhost:8080/api/v1/namespaces/default/services

$ kubectl get services --namespace default
NAME           TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)   AGE
kubernetes     ClusterIP   10.96.0.1       <none>        443/TCP   17d
service-test   ClusterIP   10.100.54.191   <none>        80/TCP    1d

