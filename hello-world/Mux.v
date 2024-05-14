module Mux(
  input        clock,
  input        reset,
  input        io_i_sel,
  output [2:0] io_o_out
);
  assign io_o_out = io_i_sel ? 3'h7 : 3'h5; // @[Mux.scala 13:21]
endmodule
