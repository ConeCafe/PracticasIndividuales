################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../ejercicios/ejercicio1.c \
../ejercicios/ejercicio2.c \
../ejercicios/ejercicio3.c 

OBJS += \
./ejercicios/ejercicio1.o \
./ejercicios/ejercicio2.o \
./ejercicios/ejercicio3.o 

C_DEPS += \
./ejercicios/ejercicio1.d \
./ejercicios/ejercicio2.d \
./ejercicios/ejercicio3.d 


# Each subdirectory must supply rules for building sources it contributes
ejercicios/%.o: ../ejercicios/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: Cross GCC Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


