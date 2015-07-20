.data 0x10000000
msg1: .asciiz "Please enter an integer number: "
msg2: .asciiz "This is the largest number you entered: "
.text
.globl main


main: 

add $sp, $sp, -4 # want to store 2 words (which is 8 bytes)
sw $ra, 4($sp) # push $ra

li $v0, 4 # system call for print_str
la $a0, msg1 # address of string to print
syscall

move $a0, $0


li $v0, 5 # system call for read_int
syscall

addu $t0, $v0, 0
move $a0, $0


li $v0, 4 # system call for print_str
la $a0, msg1 # address of string to print
syscall

li $v0, 5 # system call for read_int
syscall

addu $t1, $v0, 0
move $a0, $0

jal largest
nop

lw $ra,4($sp)
jr $ra

largest: nop

bgt $t0, $t1, first

li $v0, 4 # system call for print_str
la $a0, msg2 # address of string to print
syscall
move $a0, $0

li $v0, 1 # system call for print_int
addu $a0, $t1, 0 # address of string to print
syscall


move $v0, $0

j end

first:

li $v0, 4 # system call for print_str
la $a0, msg2 # address of string to print
syscall

move $a0, $0

li $v0, 1 # system call for print_int
addu $a0, $t0, 0 # address of string to print
syscall

end:nop

#lw $ra, 4($sp)
j $ra