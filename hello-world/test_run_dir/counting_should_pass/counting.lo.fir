circuit counting :
  module counting :
    input clock : Clock
    input reset : UInt<1>
    output io_cntReg : UInt<8>

    reg cnt : UInt<8>, clock with :
      reset => (UInt<1>("h0"), cnt) @[counting.scala 15:22]
    node _cnt_T = eq(cnt, UInt<4>("h9")) @[counting.scala 17:20]
    node _cnt_T_1 = add(cnt, UInt<1>("h1")) @[counting.scala 17:39]
    node _cnt_T_2 = tail(_cnt_T_1, 1) @[counting.scala 17:39]
    node _cnt_T_3 = mux(_cnt_T, UInt<1>("h0"), _cnt_T_2) @[counting.scala 17:15]
    io_cntReg <= cnt @[counting.scala 18:15]
    cnt <= mux(reset, UInt<8>("h0"), _cnt_T_3) @[counting.scala 15:{22,22} 17:9]
