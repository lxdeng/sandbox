#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PROMPT ">"
void error();
int printStatement();

int main(void) {
  char buf[100];

  while(1) {
    printf(PROMPT);
    scanf("%s", buf);

    if(buf[0] == 'e') {
      if(strcmp("exit", buf) == 0)
        exit(0);
    }

    // print statement
    if(buf[0] == 'p') {
      if (printStatement(buf))
        break;
    }

    if ((buf[0] >= 'a' &&  buf[0] <= 'z') ||
        (buf[0] >= 'A' &&  buf[0] <= 'Z')) {
       
    } else {
      error();
    }
  }
}

int printStatement(char* buf) {
  if (strncmp("print ", buf, 7) == 0) {
    printf("todo print var");
    return 1;
  }
  return 0;
}

void error() {
  printf("error: unknow statement\n");
}
