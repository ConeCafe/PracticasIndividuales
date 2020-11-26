/*
 * test.c
 *
 *  Created on: Oct 29, 2020
 *      Author: jorge
 */


#include "test.h"

int main(){
    //Ejercicio 1
    int * res;
    char * res2;

    int i = 0;
    res = solucion1();

    while(i<countAux){
        if(i==0){
            printf("[%d", res[i]);
        }else{
        printf(", %d", res[i]);
        }
        i++;
    }
    printf("]");
    //Fin Ejercicio 1

    //Ejercicio 2
    solucion2();
    //Fin ejercicio 2
    solucion3();
    //Ejercicio 3
    return 1;

}
