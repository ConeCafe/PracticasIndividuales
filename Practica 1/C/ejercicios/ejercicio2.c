/*
 * ejercicio2.c
 *
 *  Created on: Oct 29, 2020
 *      Author: jorge
 */


#include "ejercicio2.h"

void solucion2(){
    FILE *fp;
    fp = fopen("ficheros/prueba2.txt", "r");
    char aux1[100];
    int aux2;
    if (fp == NULL)
    {
        printf("Could not open file");
    }else{
        while(fscanf(fp, "%s %d", aux1, &aux2) != EOF){
            ejercicioN(aux1, aux2);
        }
    }
}

void ejercicioN(char sol[], int limite){
    int i = 1;
    char caracterLim[100]="";
    sprintf(caracterLim, " %d", limite);
    strcat(sol, caracterLim);
    char vOut[100]="";
    while(i<=limite){
        if(esPrimo(i)){
            int aux = i*i;

            sprintf(vOut, "\n%d", aux);
            strcat(sol, vOut);

        }i++;
    }
    printf("\n%s\n========================================", sol);
}

bool esPrimo(int i){
    if(i==2){
        return true;
    }
    else if(i<2){
        return false;
    }
    else{
        int j = 2;
        while(j<=i/2){
            if(i%j==0){
                return false;
            }
            j++;
        }
        return true;
    }
}
