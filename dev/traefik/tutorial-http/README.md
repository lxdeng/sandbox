/usr/local/bin/docker-compose up -d

lu3$ curl -H host:webv1.example.com http://lu3
<h1>This request was processed by host: aa74ddce35dd</h1>

lu3$ curl -H host:webv2.example.com http://lu3
<h1>New Release! Now v2! This request was processed by host: 524f20bf5f10</h1>

lu3$ /usr/local/bin/docker-compose scale webv1=2
WARNING: The scale command is deprecated. Use the up command with the --scale flag instead.
Starting tutorialhttp_webv1_1 ... done
Creating tutorialhttp_webv1_2 ... done

$ curl -H host:webv1.example.com http://lu3
<h1>This request was processed by host: fb1e1d5a484e</h1>
$ curl -H host:webv1.example.com http://lu3
<h1>This request was processed by host: aa74ddce35dd</h1>

