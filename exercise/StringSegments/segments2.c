#include <stdio.h>
#include <string.h>

// white space can be only ' '
int countSegments(char* s);

int main(int argc, char *argv[])
{
  char s[] =" hello  world   ";
  int n = countSegments(s);
  printf("%d\n", n);
}

int countSegments(char* s) {
  int len = strlen(s);
  int count = 0;

  for (int i = 0; i < len; i++) {
    if (s[i] != ' ' && (s[i+1] == ' ' || s[i+1] == '\0'))
       ++count;
  }

  return count;
}
