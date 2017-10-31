https://www.ctl.io/developers/blog/post/dockerfile-entrypoint-vs-cmd/

CMD or ENTRYPOINT defines the default executable.
CMD: override the default CMD, by specifying an argument after the image name when starting the container
     $ docker run demo hostname, to override the CMD defined for the image
ENTRYPOINT: override the default ENTRYPOINT, by using the --entrypoint flag
     $ docker run --entrypoint hostname demo
With ENTRYPOINT, you don't want or expect the user to override the executable you've specified.

Combine ENTRYPOINT and CMD
When both an ENTRYPOINT and CMD are specified, the CMD string(s) will be appended to the ENTRYPOINT in order to generate the container's command string. 

http://goinbigdata.com/docker-run-vs-cmd-vs-entrypoint/
  CMD has three forms:
    CMD ["executable","param1","param2"] (exec form, preferred)
    CMD ["param1","param2"] (sets additional default parameters for ENTRYPOINT in exec form)
    CMD command param1 param2 (shell form)

