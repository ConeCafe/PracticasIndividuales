#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char prueba[] = "buenosdiaspepe#buenosdiasjuan";
void lecturaFichero();
char primeraMitad[100];
char segundaMitad[100];
int solucionRecFinal();
int solucionRecFinalAux(int i);
int solucionIterativa();
int MAX_TAM = 99;