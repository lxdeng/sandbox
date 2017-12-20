int factorial(int x) {
  int f = 1;
  for (int i = 2; i <= x; i++) {
    f = f * i;
  }
  return f;
}
