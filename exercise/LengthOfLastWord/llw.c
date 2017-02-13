#include <stdio.h>
#include <string.h>

int lengthOfLastWord(char* s);

int main(int argc, char *argv[])
{
  char s[] = " hello world   ";
  int n = lengthOfLastWord(s);
  printf("%d\n", n);
}

int lengthOfLastWord(char* s) {
  int len = strlen(s);
  if (len == 0) return 0;

  int end = len - 1;
  while (s[end] == ' ' && end >= 0) --end;

  if (end < 0) return 0;

  int begin = end;
  while (begin >= 0 && s[begin] != ' ') --begin;

  return end - begin;
}
