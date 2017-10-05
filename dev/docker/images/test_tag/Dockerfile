FROM busybox:ubuntu-14.04

RUN echo "#!/bin/sh" > /test.sh
RUN echo "echo \"this is version 1\"" >> /test.sh
RUN chmod +x /test.sh 

ENTRYPOINT ["/test.sh"]
