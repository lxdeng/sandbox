#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

/* child process inherits the real and effective uid and group id */

int main(void){

    printf("This process ID is %d\n", getpid());
    printf("The Real user ID is %d\n", getuid());
    printf("The Effective user ID is %d\n", geteuid());
    printf("The Real group ID: %d\n", getgid());
    printf("The Effective group ID: %d\n", getegid());

    int val;
    if((val=fork()) < 0) {
        printf("Problem creating new process\n");
        return 1;
    }

    //fork returns 0 to newly created process    
    if(val==0) {
        printf("Child process ID is %d\n", getpid());
        printf("The Real user ID is %d\n", getuid());
        printf("The Effective user ID is %d\n", geteuid());
        printf("The Real group ID: %d\n", getgid());
        printf("The Effective group ID: %d\n", getegid());

    }

    return 0;
}
