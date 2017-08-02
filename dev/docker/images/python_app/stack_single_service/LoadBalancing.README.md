1. Start only the swarm manager

2. Deploy the app with 2 replicas. Both containers run on the manager node.

3. Start the second node of the swarm

4. Scale up the service lab_web
   $ docker service scale lab_web=3
   the third container starts on the second node

5. on the manager node,
$ curl http://localhost
<h3>Hello World!</h3><b>Hostname:</b> 168054b0ecd0<br/><b>Visits:</b> <i>cannot connect to Redis, counter disabled</i>

$ curl http://localhost
<h3>Hello World!</h3><b>Hostname:</b> 466a467988dd<br/><b>Visits:</b> <i>cannot connect to Redis, counter disabled</i>

$ curl http://localhost
<h3>Hello World!</h3><b>Hostname:</b> 3c7d45d1b7fe<br/><b>Visits:</b> <i>cannot connect to Redis, counter disabled</i>

It loadbalances to the three containers, due to the ingress routing mesh.
