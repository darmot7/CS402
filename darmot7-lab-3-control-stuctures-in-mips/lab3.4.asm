.data
myarray: .space 100

.text
.globl main


main:
    li $t4,0
    la $t5, myarray   # load the address of the array into $a1

loop:
    bgt $t0,3,exit #exit when $t0 = 3
    addi $t0,$t0,1 # add one to the counter

    addi $t3, $t3, 1         # increment t3 by 1
    sb $t4, 0($a1)           # store the new value into memory
    addi $t5, $t5, 1         # increment $t5 by one, to point to the next element in the array
    j loop  

exit:
jr $ra # return from main