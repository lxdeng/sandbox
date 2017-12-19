#! /usr/bin/python

vars = []
while True:
  line = raw_input('>')
  print line
  if line == "exit":
    break

  if '=' not in line:
    print 'error: ', line
    continue 

  name, value = line.split('=')
  vars.append((name, value))

print vars
