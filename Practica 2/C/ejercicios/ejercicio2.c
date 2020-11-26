#include"ejercicio2.h"

void lecturaFichero2(){
    FILE *fp;
    fp = fopen("ficheros/PI2Ej2DatosEntrada.txt", "r");
    char numsLeidos[20];

    if(fp == NULL){
        printf("No se pudo abrir el fichero");
    }else{
        while(fgets(numsLeidos,20,fp)!=NULL){
            char * lineaAux = strtok(numsLeidos, ",");
            a = atoi(lineaAux);
            lineaAux = strtok(NULL, ",");
            b = atoi(lineaAux);

            bool resultado = esMultiploRecFinal(a, b);
            bool resultadoIterativo = esMultiploIterativo(a, b);
            printf("%d,%d\n", a,b);
            if(resultadoIterativo){
                printf("1. Iterativa (while): true\n");
            }else{
                printf("1. Iterativa (while): false\n");
            }
            if(resultado){
                printf("2. Recursiva final: true\n\n");
            }else{
                printf("2. Recursiva final: false\n\n");
            }
            
        }
    }
}

bool esMultiploRecFinal(int i, int j){
    return esMultiploRecFinalAux(i, j, true);
}

bool esMultiploRecFinalAux(int i, int j, bool res){
    if(i-j==0){
        return res;
    }else if(0<i&&i<j){
        res = false;
        return res;
    }else{
        return esMultiploRecFinalAux(i-j,j,res);
    }
}

bool esMultiploIterativo(int i, int j){
    bool res = false;
    int num1 = i;
    int num2 = j;
    while(!res && num1>=num2){
        if(num1-num2==0){
            res = true;
        }
        num1-=num2;
    }
    return res;
}