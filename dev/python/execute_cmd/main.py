#!/usr/bin/python

import executeutil

r, out, err = executeutil.execute_cmd("ls")
print "r=" + str(r) + "\n"
print "out:\n" + out
print "err:\n" + err

password ="abc123"
r, out, err = executeutil.execute_cmd_with_password("./echo.py", password)
print "r=" + str(r) + "\n"
print "out:\n" + out
print "err:\n" + err

