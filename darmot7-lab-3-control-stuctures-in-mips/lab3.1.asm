.data

var1: .word 8
var2: .word 5
var3: .word -2014

.text
.globl main

main: 

lw $t0, var1
lw $t1, var2
lw $t2, var3

beq $t0, $t1, Equal 

lw $t7, var1
sw $t1, var1
sw $t7, var2

beq $0,$0,Exit

Equal:
sw $t2, var1
sw $t2, var2

Exit:

lw $t0, var1
lw $t1, var2
lw $t2, var3

jr $ra # return from main