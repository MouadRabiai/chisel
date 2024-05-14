package mypack




import chisel3._




class AND_EQU extends Module {
val io = IO(new Bundle {
val a = Input(UInt (2.W))
val b = Input(UInt (2.W))
val out = Output (UInt (2.W))
val equ = Output (Bool ())
})


io.out := io.a & io.b
io.equ := io.a === io.b
}


object  AND_EQU extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new AND_EQU())
}