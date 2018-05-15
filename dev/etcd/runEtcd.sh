#!/bin/sh

docker run -d -v /usr/share/ca-certificates/:/etc/ssl/certs -p 4001:4001 -p 2380:2380 -p 2379:2379 \
 --name etcd0 quay.io/coreos/etcd:v2.3.8 \
 -name etcd0 \
 -advertise-client-urls http://192.168.29.221:2379,http://192.168.29.221:4001 \
 -listen-client-urls http://0.0.0.0:2379 \
 -initial-advertise-peer-urls http://192.168.29.221:2380 \
 -listen-peer-urls http://0.0.0.0:2380 \
 -initial-cluster-token etcd-cluster-1 \
 -initial-cluster etcd0=http://192.168.29.221:2380,etcd1=http://192.168.29.221:3380,etcd2=http://192.168.29.221:4380 \
 -initial-cluster-state new

docker run -d -v /usr/share/ca-certificates/:/etc/ssl/certs -p 5001:4001 -p 3380:2380 -p 3379:2379 \
 --name etcd1 quay.io/coreos/etcd:v2.3.8 \
 -name etcd1 \
 -advertise-client-urls http://192.168.29.221:3379,http://192.168.29.221:5001 \
 -listen-client-urls http://0.0.0.0:3379 \
 -initial-advertise-peer-urls http://192.168.29.221:3380 \
 -listen-peer-urls http://0.0.0.0:3380 \
 -initial-cluster-token etcd-cluster-1 \
 -initial-cluster etcd0=http://192.168.29.221:2380,etcd1=http://192.168.29.221:3380,etcd2=http://192.168.29.221:4380 \
 -initial-cluster-state new

docker run -d -v /usr/share/ca-certificates/:/etc/ssl/certs -p 6001:4001 -p 4380:2380 -p 4379:2379 \
 --name etcd2 quay.io/coreos/etcd:v2.3.8 \
 -name etcd2 \
 -advertise-client-urls http://192.168.29.221:4379,http://0.0.0.0:6001 \
 -listen-client-urls http://0.0.0.0:4379 \
 -initial-advertise-peer-urls http://192.168.29.221:4380 \
 -listen-peer-urls http://0.0.0.0:4380 \
 -initial-cluster-token etcd-cluster-1 \
 -initial-cluster etcd0=http://192.168.29.221:2380,etcd1=http://192.168.29.221:3380,etcd2=http://192.168.29.221:4380 \
 -initial-cluster-state new
