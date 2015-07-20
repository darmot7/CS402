.data 0x10000000

msg1: .asciiz "Please enter an integer number: "
msg2: .asciiz "If the bytes were layerd in reverse the order the number would be:  "
user1: .word 0

.text
.globl main


main: 

li $v0, 4 # system call for print_str
la $a0, msg1 # address of string to print
syscall

move $a0, $0


li $v0, 5 # system call for read_int
syscall

sw $v0, user1


Reverse_bytes:

la $s0, user1

lb $t0, 0($s0)
lb $t1, 1($s0)
lb $t2, 2($s0)
lb $t3, 3($s0)

sb $t0, 6($s0)
sb $t1, 4($s0)
sb $t2, 2($s0)
sb $t3, 0($s0)

lw $s0, user1




li $v0, 4 # system call for print_str
la $a0, msg2 # address of string to print
syscall

move $a0, $0

li $v0, 1 # system call for print_int
#addu $a0, $s0, 0 # address of string to print
la $a0, user1
syscall

jr $ra


