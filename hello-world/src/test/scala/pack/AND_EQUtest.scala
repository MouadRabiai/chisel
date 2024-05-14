package mypack

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec





class AND_EQUtest extends AnyFlatSpec with
ChiselScalatestTester {
"AND_EQU" should "pass" in {
test(new AND_EQU ).withAnnotations (Seq( /*VerilatorBackendAnnotation,*/ WriteVcdAnnotation )) { dut =>
for(a <- 0 until 3){
    for(b <- 0 until 0){
        
        dut.io.a.poke(a.U)
        dut.io.b.poke(b.U)
        dut.clock.step(1)
        println (" Result is: " + dut.io.out. peekInt ())
    
    }
    }
    
}
}
}