#include"ejercicio1.h"


void lecturaFichero(){


    FILE *fp;
    fp = fopen("ficheros/PI2Ej1DatosEntrada.txt", "r");
    char lineaLeida[100];

    if(fp == NULL){
        printf("No se pudo abrir el fichero");
    }else{
        while(fgets(lineaLeida,100,fp)!=NULL){
            char * lineaAux = strtok(lineaLeida, "#");
            strcpy(primeraMitad, lineaAux);
            lineaAux = strtok(NULL, "#");
            strcpy(segundaMitad, lineaAux);
            printf("%s, %s Iterativo: %d\nRecursivo Final: %d\n\n", primeraMitad, segundaMitad, solucionIterativa(), solucionRecFinal());
            
        }
    }

}

int solucionRecFinal(){
    return solucionRecFinalAux(0);
}

int solucionRecFinalAux(int i){
    if(i == MAX_TAM || primeraMitad[i]!=segundaMitad[i]){
        return i;
    }else{
        return solucionRecFinalAux(i+1);
    }
}

int solucionIterativa(){
    int i = 0;
    while(i!=MAX_TAM && primeraMitad[i]==segundaMitad[i]){
        i++;
    }
    return i;
}