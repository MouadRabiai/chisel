circuit muxreg :
  module muxreg :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip i_sel : UInt<1>, flip a : UInt<8>, flip b : UInt<8>, o_out : UInt<8>}

    wire wir : UInt<8> @[muxreg.scala 12:19]
    node result = mux(io.i_sel, io.a, io.b) @[muxreg.scala 14:21]
    wir <= result @[muxreg.scala 15:9]
    reg reg : UInt, clock with :
      reset => (UInt<1>("h0"), reg) @[muxreg.scala 18:22]
    reg <= wir @[muxreg.scala 18:22]
    io.o_out <= reg @[muxreg.scala 20:14]

