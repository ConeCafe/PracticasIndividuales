#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
long base = 0;
int pot = 0;
void lecturaFichero3();
long potenciaRecNoFinal(long i, int j);
long potenciaRecFinal(long i, int j);
long potenciaRecFinalAux(long i, int j, long res);
long potenciaIterativa(long i, int j);