circuit AND_EQU :
  module AND_EQU :
    input clock : Clock
    input reset : UInt<1>
    input io_a : UInt<2>
    input io_b : UInt<2>
    output io_out : UInt<2>
    output io_equ : UInt<1>

    node _io_out_T = and(io_a, io_b) @[AND_EQU.scala 20:16]
    node _io_equ_T = eq(io_a, io_b) @[AND_EQU.scala 21:16]
    io_out <= _io_out_T @[AND_EQU.scala 20:8]
    io_equ <= _io_equ_T @[AND_EQU.scala 21:8]
