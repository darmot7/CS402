.data 
 getX: .asciiz   "Enter a positive x value: "
 getY: .asciiz   "Enter a positive y value: "
getposX: .asciiz "YOU MUST ENTER A POSITVE VALUE FOR X: " 
getposY: .asciiz "YOU MUST ENTER A POSITVE VALUE FOR Y: " 
answer:  .asciiz   "The answer is: " 
 n: .asciiz   "\n" 
 
.text 

 .globl main 

 main:   

addi $sp, $sp, -12  # make stack.
sw   $ra, 0($sp)      # store return address
sw   $t0, 4($sp)      # stores inital value of $t0
sw   $t1, 8($sp)      # stores inital value of $t0


la $a0, getX # prompt for x
li $v0, 4     
syscall

getnumx:

li $v0, 5 # Read and store x
syscall
move $t0, $v0  # x = $t0

blt $t0, $0, negativex

la $a0, getY # prompt for y
li $v0, 4       
syscall

getnumy:
li $v0, 5 # read and store y
syscall
move $t1, $v0  # y = $t1

blt $t1, $0, negativey

move $a0, $t0   # use $a0 for the recursive calls for x 
move $a1, $t1   # use $a1 for the recursive calls for y 

jal Ackermann	
 
#move value
move  $a2, $v0
sub $sp, $sp, 4  #make stack
sw $a0, 0($sp)   

la $a0, answer #The answer is
li $v0, 4     
syscall

move $a0, $a2  #Print value
li $v0, 1     
syscall

la $a0, n #print a line
li $v0, 4     
syscall

lw $a0, 0($sp) # restore 
addi $sp, $sp, 4  

lw $ra, 0($sp) # restore stack
lw $t0, 4($sp)  
lw $t1, 8($sp) 
sub $sp, $sp, -12   

# exit system call 
li $v0, 10 
syscall 

 Ackermann:
        addi $sp, $sp, -8       #offset stack
        sw $t0, 4($sp) 		#save result          
        sw $ra, 0($sp) 		#backup $ra 
	addi $t7, $t7, 1  	#recursive counter

 xeqz:  #  x == 0
        
	# if not check y
        bne $a0, $0, yeqz
        
	#  x+1
        addi $v0, $a1,   1
        j end 		#this is the bottom out case

 yeqz:   # check whether y == 0 if not both are greater
        bne $a1, $zero, else
        

	#A(x-1,1)
        addi $a0, $a0, -1	# x-1
        addi $a1, $zero, 1
        jal   Ackermann      
        j end

 else:		# Save x for second call
        add $t0, $a0, $zero
        addi $a1, $a1, -1	# A(x,(y - 1))
        jal Ackermann
        			
        addi $a0, $t0, -1	# A(x-1,A(x, (y - 1)))
        add $a1, $v0, $zero
        jal Ackermann
        j   end

 end:        
        lw $ra, 0($sp)	 # get stack pointer back
        addi $sp, $sp, 8 # reset the stack
        jr $ra	  	 # return


negativex: 

li $v0, 4		#calls print_string
la $a0, getposX		#load the address
syscall
j getnumx

negativey: 

li $v0, 4		#calls print_string
la $a0, getposY		#load the address
syscall
j getnumy