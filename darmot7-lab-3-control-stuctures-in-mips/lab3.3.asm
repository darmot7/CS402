.data

var1: .word 8
var2: .word 5
var3: .word -2014
start: .word 1
limit: .word 100

.text
.globl main

main: 

lw $s0, limit
lw $t0, start
lw $t1, var1

Loop: ble $s0, $t1, Exit
addi $t1, $t1, 1
j Loop

Exit:

jr $ra # return from main