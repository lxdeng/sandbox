gcc -c tinymath.c -o tinymath.o
ar rcs libtinymath.a tinymath.o 
cd test
gcc -o test test.c ../libtinymath.a
