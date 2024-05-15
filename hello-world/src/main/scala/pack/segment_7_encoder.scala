package mypack




import chisel3._
import chisel3.util.{switch, is}
import chisel3.stage.ChiselStage
import chisel3.experimental.ChiselEnum



class segment_7_encoder extends Module {
val io = IO(new Bundle {
    val i_val = Input(UInt(4.W))
    val o_val = Output(UInt(7.W))
})

    io.o_val := 0.U
    switch(io.i_val){
        is("b0000".U)  {io.o_val := "b0000001".U}
        is("b0001".U)  {io.o_val := "b1001111".U}
        is("b0010".U)  {io.o_val := "b0010010".U}
        is("b0011".U)  {io.o_val := "b0000110".U}
        is("b0100".U)  {io.o_val := "b1001100".U}
        is("b0101".U)  {io.o_val := "b1100100".U}
        is("b0110".U)  {io.o_val := "b0101000".U}
        is("b0111".U)  {io.o_val := "b0001111".U}
        is("b1000".U)  {io.o_val := "b0000000".U}
        is("b1001".U)  {io.o_val := "b0000100".U}
    }

}



class counter_mod_10 extends Module{

    val io = IO(new Bundle{
        val o_val = Output(UInt(7.W))
    })


    val decod_7_seg = Module(new segment_7_encoder())
    
    val r_reg = RegInit(0.U(4.W))
    
    r_reg := Mux(r_reg===9.U,0.U,r_reg + 1.U)

    decod_7_seg.io.i_val := r_reg
    
    io.o_val := decod_7_seg.io.o_val
}

object  counter_mod_10 extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new counter_mod_10())
}