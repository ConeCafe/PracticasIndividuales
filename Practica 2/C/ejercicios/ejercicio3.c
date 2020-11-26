#include"ejercicio3.h"

void lecturaFichero3(){
    FILE *fp;
    fp = fopen("ficheros/PI2Ej3DatosEntrada.txt", "r");
    char numsLeidos[20];

    if(fp == NULL){
        printf("No se pudo abrir el fichero");
    }else{
        while(fgets(numsLeidos,20,fp)!=NULL){
            char * lineaAux = strtok(numsLeidos, ",");
            base = atol(lineaAux);
            lineaAux = strtok(NULL, ",");
            pot = atoi(lineaAux);
            printf("%ld %d\n", base, pot);
            printf("1. Iterativa (while): %ld\n", potenciaIterativa(base, pot));
            printf("2. Recursiva no final: %ld\n", potenciaRecNoFinal(base, pot));
            printf("3. Recursiva final: %ld\n\n", potenciaRecFinal(base, pot));

            
        }
    }
}

long potenciaIterativa(long i, int j){
    long res = 1;
    while(j>0){
        if(j%2==1){
            res*=i;
        }
        i*=i;
        j/=2;
    }
    return res;
}
long potenciaRecNoFinal(long i, int j){
    
    long res = 1;
    if(j<=0){
        return 1;
    }else{
        if(j%2==1){
            res *= i;
        }
        return res * potenciaRecFinal(i*i, j/2);
    }
}

long potenciaRecFinal(long i, int j){
    return potenciaRecFinalAux(i, j, 1);
}
long potenciaRecFinalAux(long i, int j, long res){
    if(j<=0){
        return res;
    }else{
        if(j%2==1){
            res *= i;
        }
        return potenciaRecFinalAux(i*i, j/2, res);
    }
}
