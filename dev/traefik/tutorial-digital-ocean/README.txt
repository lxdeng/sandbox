https://www.digitalocean.com/community/tutorials/how-to-use-traefik-as-a-reverse-proxy-for-docker-containers-on-ubuntu-16-04

htpasswd -nb admin welcome1

export WORDPRESS_DB_PASSWORD=welcome1
export MYSQL_ROOT_PASSWORD=welcome1

in /etc/hosts, set
lu3$ cat /etc/hosts
127.0.0.1	localhost
192.168.29.223  monitor.example.com
192.168.29.223  blog.example.com
192.168.29.223  db-admin.example.com

Question:
Somehow the http://db-admin.example.com:8080 does not resolve to the db admin console. Needs further looking.
