// fuction SimpleFunction.test 2
(SimpleFunction.test)
@SP
A=M
M=0
@SP
M=M+1
@SP
A=M
M=0
@SP
M=M+1
//push local 0--------------------------
//#get local 0
@LCL
D=M
@0
A=D+A
D=M
//#pushStack
@SP
A=M
M=D
@SP
M=M+1
//push local 1--------------------------
//#get local 1
@LCL
D=M
@1
A=D+A
D=M
//#pushStack
@SP
A=M
M=D
@SP
M=M+1
//command add----------------------------------
@SP
A=M-1
D=M
A=A-1
M=M+D
@SP
M=M-1
//command not----------------------------------
@SP
A=M-1
M=!M
//push argument 0--------------------------
//#get argument 0
@ARG
D=M
@0
A=D+A
D=M
//#pushStack
@SP
A=M
M=D
@SP
M=M+1
//command add----------------------------------
@SP
A=M-1
D=M
A=A-1
M=M+D
@SP
M=M-1
//push argument 1--------------------------
//#get argument 1
@ARG
D=M
@1
A=D+A
D=M
//#pushStack
@SP
A=M
M=D
@SP
M=M+1
//command sub----------------------------------
@SP
A=M-1
D=M
A=A-1
M=M-D
@SP
M=M-1
// return 
LCL
D=M
@R13
M=D
@R13
D=M
@5
D=D-A
@R14
M=D
@SP
A=M
D=M
@ARG
A=M
M=D
@SP
M=M-1
@ARG
D=M + 1
@SP
M=D
@R13
D=M
@1
A = D - A
D=M
@THAT
M=D
@R13
D = M
@2
A = D - A
D=M
@THIS
M=D
@13
D=M
@3
A=D - A
D=M
@ARG
M=D
R13
D=M
@4
A=D-A
D=M
@LCL
M=D
@R14
0;JMP
