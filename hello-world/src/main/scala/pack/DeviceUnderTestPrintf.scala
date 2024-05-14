package mypack




import chisel3._








class DeviceUnderTestPrintf extends Module {
val io = IO(new Bundle {
val a = Input(UInt (2.W))
val b = Input(UInt (2.W))
val out = Output (UInt (2.W))
})
io.out := io.a & io.b
printf ("dut: %d %d %d\n", io.a, io.b, io.out)
}


object  DeviceUnderTestPrintf extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new DeviceUnderTestPrintf())
}