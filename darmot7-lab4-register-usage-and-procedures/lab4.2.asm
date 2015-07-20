.text
.globl main
main: 
addu $sp, $sp, -4 # increase the stack by 4
sw $ra, 4($sp) #store the addres of $ra into the stack

jal test
nop

lw $ra,4($sp) #get the stored address of $ra from the stack
jr $ra
test: nop
jr $ra