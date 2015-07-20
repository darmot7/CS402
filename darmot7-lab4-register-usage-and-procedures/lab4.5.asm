.data 0x10000000

msg1: .asciiz "Please enter an integer number: "
msg2: .asciiz "The number you entered is negative, please enter another number: "

.text
.globl main


main: 

li $v0, 4 # system call for print_str
la $a0, msg1 # address of string to print
syscall
move $a0, $0

getnum:

li $v0, 5 # system call for read_int
syscall
add $t0, $v0, $0

ble $t0, 0, negative


Factorial:

subu $sp, $sp, 4	
sw $ra, 4($sp)		# save the return address on stack

beqz $t0, terminate	# test for termination
subu $sp, $sp, 4	# do not terminate yet
sw $t0, 4($sp)		# save the parameter
sub $t0, $t0, 1		# will call with a smaller argument
jal Factorial
			# after the termination condition is reached these lines
			# will be executed

lw $t0, 4($sp)		# the argument I have saved on stack
mul $v0, $v0, $t0	# do the multiplication
lw $ra, 8($sp)		# prepare to return
addu $sp, $sp, 8	# I’ve popped 2 words (an address and
addi $t3, $v0, 0	# outputs the answer to $t3 so i know what the answer is....
jr $ra

terminate:		# .. an argument)

li $v0, 1		# 0! = 1 is the return value
lw $ra, 4($sp)		# get the return address
addu $sp, $sp, 4	# adjust the stack pointer

jr $ra	# return

negative: 

li $v0, 4		#calls print_string
la $a0, msg2		#load the address
syscall

move $v0, $0

nop
j getnum
nop