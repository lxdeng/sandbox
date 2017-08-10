#!/bin/sh

IPT=/sbin/iptables

# flush
$IPT -F

# policies
$IPT -P OUTPUT ACCEPT
$IPT -P INPUT DROP
$IPT -P FORWARD DROP

# allowed inputs

# add to INPUT chain, to allow all packets from loopback interface
$IPT -A INPUT --in-interface lo -j ACCEPT

# add to INPUT chain, to allow traffic to the local server on port 8080
$IPT -A INPUT -p tcp --dport 8080 -j ACCEPT

# ssh
$IPT -A INPUT -p tcp --dport 22 -j ACCEPT

# allow response from the accessed server
# for example, without it, ping www.google.com fails
$IPT  -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT
