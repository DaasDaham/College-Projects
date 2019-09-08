#include<stdio.h> 
#include<string.h> 
#include<stdlib.h> 
#include<unistd.h> 
#include<sys/types.h> 
#include<sys/wait.h> 
#include <dirent.h> 
#include <stdbool.h>
#include<readline/readline.h>
#include "functions.h"

int callMkdir(char *args[], bool flagOn){
    pid_t pid = fork();
    if (pid == -1) { 
        printf("could not fork\n"); 
    } else if (pid == 0) { 
        if(!flagOn){
            if (execl("/bin/mkdir","/bin/mkdir",args[0],(char*) NULL) < 0) { 
                printf("\nCould not execute command\n"); 
            }
        }
        else{
            if (execl("/bin/mkdir","/bin/mkdir",args[1],args[0],(char*) NULL) < 0) { 
                printf("\nCould not execute command\n"); 
            }
        } 
        exit(0); 
    } else { 
        pid = wait(NULL);   
    }
    return 0;
}