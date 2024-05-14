package mypack
import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec




class countingtest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "counting"
  it should "pass" in {
    test(new counting).withAnnotations (Seq( /*VerilatorBackendAnnotation,*/ WriteVcdAnnotation )) { c =>
      c.clock.setTimeout(0)
      println("Start the count")
      for (i <- 0 until 10) {
        c.clock.step(1)
        println("the value is " + c.io.cntReg. peekInt())
        }
      }
      println("\nEnd the count")
    }
  }

