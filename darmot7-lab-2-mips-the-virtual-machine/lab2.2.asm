.data 0x10010000

var1: .word 34 	 # initialzing var1
var2: .word 23 	 # initialzing var2
var3: .word 56	 # initialzing var3
var4: .word 78	 # initialzing var4
first:.byte 'j'	 # initialzing first
last: .byte 'h'  # initialzing last

.text
.globl main
main: addu $s0, $ra, $0# save $31 in $16

lw $t0, var1	#loading var1 into $t0
lw $t1, var2	#loading var2 into $t1
lw $t2, var3	#loading var3 into $t2
lw $t3, var4	#loading var1 into $t3

lw $t0, var4 # make $t0 = var4 -- The new value of var1 will be the initial value of var4, 
lw $t1, var3 # make $t1 = var3 -- the new value of var2 will be the initial value of var3
lw $t2, var2 # make $t2 = var2 -- the new value of var3 will be the initial value of var3
lw $t3, var1 # make $t3 = var1 -- the new value of var4 will be the initial value of var3

# restore now the return address in $ra and return from main
addu $ra, $0, $s0 # return address back in $31
jr $ra # return from main