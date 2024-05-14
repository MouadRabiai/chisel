circuit AND_EQU :
  module AND_EQU :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip a : UInt<2>, flip b : UInt<2>, out : UInt<2>, equ : UInt<1>}

    node _io_out_T = and(io.a, io.b) @[AND_EQU.scala 20:16]
    io.out <= _io_out_T @[AND_EQU.scala 20:8]
    node _io_equ_T = eq(io.a, io.b) @[AND_EQU.scala 21:16]
    io.equ <= _io_equ_T @[AND_EQU.scala 21:8]

