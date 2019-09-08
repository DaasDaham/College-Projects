My attempt at making my own shell as a part of an assignment. Run the makefile to compile the files and then run the binary.

I have made 5 files which contain external (ls, mkdir, rm, etc.) commands and one header file and one file which contains the main() function.

Each external command is handled through the use of system calls. Every call is first forked and through execl(), the command is run which is referenced to the binaries of commands. The parent waits for the forked child to execute by using wait().

All the five external commands support all types of flags that their man page contains  and echo supports the -n flag.
