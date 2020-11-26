/*
 * ejercicio1.c
 *
 *  Created on: Oct 29, 2020
 *      Author: jorge
 */

#include "ejercicio1.h"

int * solucion1(){
    int * data = malloc (sizeof (int) * 255);
    int count = 0;
    int a;
    int b;
    int c;
    int d;
    int e;

    FILE *fp;
    fp = fopen("ficheros/prueba1.txt", "r");
    if (fp == NULL)
    {
        printf("Could not open file");
    }else{
        while(fscanf(fp, "%d, %d, %d, %d, %d", &a, &b, &c, &d, &e) != EOF){
            int auxiliar[5];
            int res = 0;
            auxiliar[0]=a;
            auxiliar[1]=b;
            auxiliar[2]=c;
            auxiliar[3]=d;
            auxiliar[4]=e;
            while(res<5){
                if(esPrimo(auxiliar[res])){
                    data[count]=auxiliar[res];
                    count++;
                }
                res++;
            }
        }

    
    }
    countAux=count;
    return data;
}

