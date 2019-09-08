

/*Name-Saad Ahmad
  Roll no.-2018409*/

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

#define MAX_HISTORY 100
#define clear() printf("\033[H\033[J")  

char* hist[MAX_HISTORY]; 
int counter = 0;

int scanner(char* toChange){ 
    char* buffer; 
    buffer = readline("Saad@shell>>> "); 
    if(strlen(buffer) != 0){ 
        strcpy(toChange, buffer); 
        hist[counter] = buffer;
        counter++;
        return 0; 
    } else { 
        return -1; 
    } 
} 

void parseSpace(char* str, char** parsed){  
    for (int i = 0; i < 100; i++) { 
        parsed[i] = strsep(&str, " "); 
        if (parsed[i] == NULL) 
            break; 
        if (strlen(parsed[i]) == 0) 
            i--; 
    } 
} 

void joinSpacesforEcho(bool flagPassed, char *args[], char* str){
    int i;
    if(flagPassed){
        i=2;
    }
    else{
        i=1;
    }
    while(args[i]!=NULL){
        str = strcat(str, args[i]);
        str = strcat(str, " ");
        if(args[i+1]==NULL){
            return;
        }
        if(strlen(str)>1024){
            printf("Error! The string that was passed was too long\n");
            return;
        }
        i++;
    }
}

void callHistory(){
    if(hist[1]==NULL){
        printf("No history available\n");
    }
    else{
        int cc = 0;
        while(hist[cc]!=NULL){
            printf("%d %s\n",cc,hist[cc]);
            cc++;
        }
    }
}

void callEcho(char* toPrint, bool nflag){
    if(nflag){
        printf("%s",toPrint);    
    }
    else{
        printf("%s\n",toPrint);
    }
}

int callCd(char* arg){
    if(opendir(arg)){
        chdir(arg);
    }
    else{
        printf("The directory doesnt exist!\n");
    }
    return 0;
}

void callExit(){
    printf("\nExiting\n");
    exit(0);
}

void callPwd(){
    char buffer[1024];
    getcwd(buffer, 1024);
    printf("Present working dir: %s\n", buffer);
}

int main(){
    char inputString[1024], *parsedArgs[100]; 
    bool flagPassed = false; 
    clear();
    printf("WELCOME TO LION'S DEN\n\n");
    while(true){
        if(scanner(inputString)!=-1){
            char *argsToPass[3];
            parseSpace(inputString, parsedArgs);
            if(parsedArgs[2]==NULL){
                argsToPass[0] = parsedArgs[1];
                flagPassed = false;
            }
            else{
                argsToPass[0] = parsedArgs[2];
                argsToPass[1] = parsedArgs[1];
                flagPassed = true;
            }   
            if(strcmp(parsedArgs[0], "ls")==0){
                callLs(argsToPass, flagPassed);
            }
            else if(strcmp(parsedArgs[0], "date")==0){
                callDate(argsToPass, flagPassed);
            }
            else if(strcmp(parsedArgs[0], "mkdir")==0){
                callMkdir(argsToPass, flagPassed);
            }
            else if(strcmp(parsedArgs[0], "rm")==0){
                callRm(argsToPass, flagPassed);
            }
            else if(strcmp(parsedArgs[0], "cat")==0){
                callCat(argsToPass, flagPassed);
            }
            else if(strcmp(parsedArgs[0], "history")==0){
                callHistory();
            }
            else if(strcmp(parsedArgs[0], "echo")==0){
                bool flag_for_echo = false;
                bool nflag = false;
                if(strcmp(parsedArgs[1], "-n")==0){
                    flag_for_echo = true;
                    nflag = true;
                }  
                char temp[1024] = "";
                joinSpacesforEcho(flag_for_echo, parsedArgs, temp);
                callEcho(temp, nflag);
                flag_for_echo = false;
                nflag = false;
            }
            else if(strcmp(parsedArgs[0], "pwd")==0){
                callPwd();
            }
            else if(strcmp(parsedArgs[0], "cd")==0){
                if(flagPassed){
                    callCd(parsedArgs[2]);
                }
                else{
                    callCd(parsedArgs[1]);
                }
            }
            else if(strcmp(parsedArgs[0], "exit")==0){
                callExit();
            }
            else{
                printf("No such command exists with the given argument!\n");
            }
        } else{printf("No command passed, Exiting...\n"); break;}
    }
}

