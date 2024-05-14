package mypack



import chisel3._




class counting extends Module {
  val io = IO(new Bundle {
    val cntReg = Output(UInt(8.W))
  })

    val cnt = RegInit(0.U(8.W))
   
    cnt := Mux(cnt === 9.U, 0.U , cnt + 1.U)
    io.cntReg := cnt
    //println(cnt)
    //printf("Current cnt value: %d\n", cnt) }
}

/**
 * An object extending App to generate the Verilog code.
 */
object counting extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new counting())
}