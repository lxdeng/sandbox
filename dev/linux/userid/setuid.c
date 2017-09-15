#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pwd.h>

#define INVALID_UID  -1
uid_t getuidByName(const char *name)
{
    if(name) {
        struct passwd *pwd = getpwnam(name); /* don't free, see getpwnam() for details */
        if(pwd) return pwd->pw_uid;
    }
    return INVALID_UID;
}

int main(void) {

    printf("This process ID is %d\n", getpid());
    printf("The Real user ID is %d\n", getuid());
    printf("The Effective user ID is %d\n", geteuid());
    printf("The Real group ID: %d\n", getgid());
    printf("The Effective group ID: %d\n", getegid());

    uid_t id = getuidByName("uucp");
    printf("The user ID of uucp is %d\n", id);

    if((setuid(id))<0) {
        printf("setuid() failed.\n");
        return -1;
    }

    printf("The Real user ID is %d\n", getuid());
    printf("The Effective user ID is %d\n", geteuid());
    printf("The Real group ID: %d\n", getgid());
    printf("The Effective group ID: %d\n", getegid());

    return 0;
}
