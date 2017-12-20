1. Pre-processing: via the GNU C Preprocessor, which includes the headers (#include) and expands the macros (#define).
> cpp hello.c > hello.i

2. Compilation: The compiler compiles the pre-processed source code into assembly code for a specific processor.
> gcc -S hello.i

3. Assembly: The assembler (as) converts the assembly code into machine code in the object file "hello.o".
> as -o hello.o hello.s

4. Linker: Finally, the linker (ld.exe) links the object code with the library code to produce an executable file "hello.exe".
> ld -o hello hello.o ...libraries...

run gcc -v to find the ...libraries...

to see its shared object dependencies:
ldd <executable>

static link:
$ gcc -static x.c -o x
