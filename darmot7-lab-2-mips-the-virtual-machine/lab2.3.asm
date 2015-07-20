.data 0x10010000

var1: 		#initialize var1
var2:		#initialize var2
var3:		#initialize var3
var4:		#initialize var4


.text
.globl main
main: 


addi $t0, $0, 4		#inserting data into $t0 register
addi $t1, $1, 5		#inserting data into $t1 register
addi $t2, $2, 6		#inserting data into $t2 register
addi $t3, $3, 7		#inserting data into $t3 register


sh $t3, var4 # make $t0 = var4 -- The new value of var1 will be the initial value of var4 
sh $t2, var3 # make $t1 = var3 -- the new value of var2 will be the initial value of var3
sh $t1, var2 # make $t2 = var2 -- the new value of var3 will be the initial value of var3
sh $t0, var1 # make $t3 = var1 -- the new value of var4 will be the initial value of var3

sh $t3, var1 # make $t0 = var4 -- The new value of var1 will be the initial value of var4 
sh $t2, var2 # make $t1 = var3 -- the new value of var2 will be the initial value of var3
sh $t1, var3 # make $t2 = var2 -- the new value of var3 will be the initial value of var3
sh $t0, var4 # make $t3 = var1 -- the new value of var4 will be the initial value of var3

lw $t0, var1 	#loading var1 back into $t0
lw $t1, var2	#loading var1 back into $t1
lw $t2, var3	#loading var1 back into $t2
lw $t3, var4	#loading var1 back into $t3

# restore now the return address in $ra and return from main

jr $ra # return from main