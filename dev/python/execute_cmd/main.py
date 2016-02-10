#!/usr/bin/python

import executeutil

print "execute ls command"
r, out, err = executeutil.execute_cmd("ls")
print "r=" + str(r) + "\n"
print "out:\n" + out
print "err:\n" + err

print "execute a command with a password"
password ="abc123"
r, out, err = executeutil.execute_cmd_with_password("./echo.py", password)
print "r=" + str(r) + "\n"
print "out:\n" + out
print "err:\n" + err

# start a simple web server in background
# curl http://localhost:8000
print "execute a command(simple web server) in background"
cmd = "python -m SimpleHTTPServer"
r, out, err = executeutil.execute_cmd_nohup(cmd)
print "r=" + str(r) + "\n"
print "out:\n" + out
print "err:\n" + err
