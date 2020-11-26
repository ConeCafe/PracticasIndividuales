/*
 * ejercicio3.c
 *
 *  Created on: Oct 29, 2020
 *      Author: jorge
 */


#include "ejercicio3.h"

void solucion3(){
    printf("\n");
    float puntoX, puntoY;
    float primerCuadrante = 0.0;
    float segundoCuadrante = 0.0;
    float tercerCuadrante = 0.0;
    float cuartoCuadrante = 0.0;
    int controlador = 0;
    bool firstPrimero = true;
    bool firstSegundo = true;
    bool firstTercero = true;
    bool firstCuarto = true;

    enum cuadrantes Cuad[4];
    FILE *fp;
    fp = fopen("ficheros/prueba3.txt", "r");
    if (fp == NULL)
    {
        printf("Could not open file");
    }else{
        while(fscanf(fp, "(%f, %f)\n", &puntoX, &puntoY) != EOF){
            if(puntoX<0&&puntoY<0){

                if(firstTercero){
                    Cuad[controlador]=TERCER_CUADRANTE;
                    controlador++;
                    firstTercero=false;
                }
                tercerCuadrante += puntoX;
            }else if(puntoX<0&&puntoY>0){
                if(firstSegundo){
                    Cuad[controlador]=SEGUNDO_CUADRANTE;
                    controlador++;
                    firstSegundo=false;
                }
                segundoCuadrante += puntoX;
            }else if(puntoX>0&&puntoY<0){
                if(firstCuarto){
                    Cuad[controlador]=CUARTO_CUADRANTE;
                    controlador++;
                    firstCuarto=false;
                }
                cuartoCuadrante += puntoX;
            }else{
                if(firstPrimero){
                    Cuad[controlador]=PRIMER_CUADRANTE;
                    controlador++;
                    firstPrimero=false;
                }
                primerCuadrante += puntoX;
            }

        }
    }
    int final = 0;
    printf("{");
    while(final<4){
        if(final!=0){
                printf(", ");
            }
        switch(Cuad[final]){
            case PRIMER_CUADRANTE:
                printf("PRIMER_CUADRANTE=%f", primerCuadrante);
                break;
            case SEGUNDO_CUADRANTE:
                printf("SEGUNDO_CUADRANTE=%f", segundoCuadrante);
                break;
            case TERCER_CUADRANTE:
                printf("TERCER_CUADRANTE=%f", tercerCuadrante);
                break;
            default:
                printf("CUARTO_CUADRANTE=%f", cuartoCuadrante);
                break;
        }
        final++;
    }
    printf("}");
}
