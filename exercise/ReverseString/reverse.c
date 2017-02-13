#include <stdio.h>
#include <string.h>

char* reverseString(char* s);

int main(int argc, char *argv[])
{
  char s[] = "hello";
  char *p = reverseString(s);
  printf("%s\n", p);
}

/*
char* reverseString(char* s) {
  int n = strlen(s);
  char swap;
  for (int i = 0; i < n; i++){
    swap = s[i];
    s[i] = s[n-1];
    s[n-1] = swap;
    n--;
  }    
  return s;
}
*/

char* reverseString(char* s) {
  int n = strlen(s);
  char swap;
  for (int i = 0; i < n/2; i++){
    swap = s[i];
    s[i] = s[n-1-i];
    s[n-1-i] = swap;
  }  
  return s;
}
