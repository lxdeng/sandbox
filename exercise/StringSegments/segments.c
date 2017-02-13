#include <stdio.h>

int countSegments(char* s);

int main(int argc, char *argv[])
{
  char s[] =" hello  world   ";
  int n = countSegments(s);
  printf("%d\n", n);
}

int isSpace(char c) {
  if (c == ' ' || c == '\t' || c == '\n')
    return 1;
  else
    return 0;
}

int countSegments(char* s) {
  int count = 0;

  for(;;) {
    while (isSpace(*s)) ++s;

    if (*s == '\0')
      return count;

    ++count;
    while(!isSpace(*s) && *s !='\0') ++s;
  }
}
