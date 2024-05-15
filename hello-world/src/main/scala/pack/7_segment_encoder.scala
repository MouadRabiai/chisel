package mypack




import chisel3._



class 7_segment_encoder extends Module {
val io = IO(new Bundle {
    val in_val = Input(UInt(4.W))
    val out_val = Output(UInt(7.W))
})


    switch(io.in_val){
        is("b0000".U)  {io.out_val := "b0000001"}
        is("b0001".U)  {io.out_val := "b1001111"}
        is("b0010".U)  {io.out_val := "b0010010"}
        is("b0011".U)  {io.out_val := "b0000110"}
        is("b0100".U)  {io.out_val := "b1001100"}
        is("b0101".U)  {io.out_val := "b1100100"}
        is("b0110".U)  {io.out_val := "b0101000"}
        is("b0111".U)  {io.out_val := "b0001111"}
        is("b1000".U)  {io.out_val := "b0000000"}
        is("b1001".U)  {io.out_val := "b0000100"}
    }

}

object  7_segment_encoder extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new 7_segment_encoder())
}