circuit Mux :
  module Mux :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip i_sel : UInt<1>, o_out : UInt<3>}

    node result = mux(io.i_sel, UInt<3>("h7"), UInt<3>("h5")) @[Mux.scala 13:21]
    io.o_out <= result @[Mux.scala 15:14]

