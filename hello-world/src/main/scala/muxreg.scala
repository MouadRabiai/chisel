import chisel3._

class muxreg extends Module {
  val io = IO(new Bundle {
    val i_sel = Input(Bool())
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val o_out = Output(UInt(8.W))
  })

    
    val wir = Wire(UInt(8.W))

    val result = Mux(io.i_sel,io.a,io.b)
    wir := result
    

    val reg = RegNext(wir)
    
    io.o_out := reg

}
/**
 * An object extending App to generate the Verilog code.
 */
object muxreg extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new muxreg())
}