gcc -o mysetuid setuid.c

# change owner to root
sudo chown root:root mysetuid

# suid bit
sudo chmod u+s mysetuid

ll mysetuid 
-rwsrwxr-x 1 root root 8977 Sep 15 15:23 mysetuid*

as user lxdeng, execute mysetuid
output:

This process ID is 10958
The Real user ID is 1000
The Effective user ID is 0
The Real group ID: 1000
The Effective group ID: 1000
The user ID of uucp is 10
The Real user ID is 10
The Effective user ID is 10
The Real group ID: 1000
The Effective group ID: 1000

Reason:
Since the mysetuid has Effective ID as 0, which means it has superuser privileges, so it can change its real user and effective user to any id, like the user id of the user "uucp".

See 8.10 of Advanced Programming in the Unix Environment.
