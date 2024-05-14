import chisel3._

class Mux extends Module {
  val io = IO(new Bundle {
    val i_sel = Input(Bool())
    val o_out = Output(UInt(3.W))
  })

    val sel = true.B
    val a = "b111".U
    val b = "b101".U

    val result = Mux(io.i_sel,a,b)

    io.o_out := result
}
/**
 * An object extending App to generate the Verilog code.
 */
object mux extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new Mux())
}