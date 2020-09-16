.data 0x10000000
msg1: .asciiz "Please enter an float number: "
.text
.globl main
# Inside main there are some calls (syscall) which will change the
# value in $31 ($ra) which initially contains the return address
# from main. This needs to be saved.

main: addu $s0, $ra, $0 # save $31 in $16
li $v0, 4 # system call for print_str
la $a0, msg1 # address of string to print
syscall

# now get an float from the user
li $v0, 6 # system call for read_float
syscall # the float placed in $v0

# do some computation here with the number
# addu $t0, $v0, $0 # move the number in $t0
# sll $t0, $t0, 8 # last digit of your SSN instead of 2

# print the result
li $v0, 2 # system call for print_double
mov.s $f12, $f0 # move number to print 
syscall

# restore now the return address in $ra and return from main
addu $ra, $0, $s0 # return address back in $31
jr $ra # return from main
