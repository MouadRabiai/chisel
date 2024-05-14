circuit DeviceUnderTestPrintf :
  module DeviceUnderTestPrintf :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip a : UInt<2>, flip b : UInt<2>, out : UInt<2>}

    node _io_out_T = and(io.a, io.b) @[DeviceUnderTestPrintf.scala 21:16]
    io.out <= _io_out_T @[DeviceUnderTestPrintf.scala 21:8]
    node _T = bits(reset, 0, 0) @[DeviceUnderTestPrintf.scala 22:8]
    node _T_1 = eq(_T, UInt<1>("h0")) @[DeviceUnderTestPrintf.scala 22:8]
    when _T_1 : @[DeviceUnderTestPrintf.scala 22:8]
      printf(clock, UInt<1>("h1"), "dut: %d %d %d\n", io.a, io.b, io.out) : printf @[DeviceUnderTestPrintf.scala 22:8]

