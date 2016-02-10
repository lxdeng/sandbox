import os
import subprocess as sub

def execute_cmd(command):
    print "Executing cmd: " + command
    proc = sub.Popen(command, stdout=sub.PIPE, stderr=sub.PIPE, shell=True)
    output, error = proc.communicate()
    exit_code = proc.returncode
    print "finished executing cmd: " + command
    return exit_code, output, error

def execute_cmd_with_password(command, password):
    print "Executing cmd requiring password: " + command
    proc = sub.Popen(command, stdin=sub.PIPE, stdout=sub.PIPE, stderr=sub.PIPE, shell=True)
    output, error = proc.communicate(password)
    exit_code = proc.returncode
    print "Finished executing cmd: " + command
    return exit_code, output, error

def execute_cmd_nohup(command):
    print "Executing cmd nohup: " + command

    command2 = 'nohup ' + command + ' &'
    os.system(command2)

    return 0, 'execute_cmd_nohup: command submitted', ''
