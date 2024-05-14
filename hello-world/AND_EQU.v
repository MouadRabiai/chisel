module AND_EQU(
  input        clock,
  input        reset,
  input  [1:0] io_a,
  input  [1:0] io_b,
  output [1:0] io_out,
  output       io_equ
);
  assign io_out = io_a & io_b; // @[AND_EQU.scala 20:16]
  assign io_equ = io_a == io_b; // @[AND_EQU.scala 21:16]
endmodule
