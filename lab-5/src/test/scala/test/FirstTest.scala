package test

import org.scalatest._
import first.Hello

/*class FirstTest extends FunSuite {


  val hello = Hello

  test("test 0 degree method") {
    assert(hello.elevate(15,0) == 1)
  }

  test("test 0 degree recursive method") {
    assert(hello.elevateRecursive(15,0,1) == 1)
  }

  test("test something degree method") {
    assert(hello.elevate(2,3) == 8)
  }

  test("test something degree recursive method") {
    assert(hello.elevateRecursive(2,3,1) == 8)
  }
}*/

class FirstTest extends FlatSpec with Matchers {


  val hello = Hello

  it should "test degree method" in {
    Hello.elevate(2,3) should be (8)
    Hello.elevateRecursiveStart(2,3) should be(8)
  }

  it should "test problemmethod" in {
    val array = Array[Int](5,3)
    Hello.recursiveProblem(8,6,3) should be(array)
    Hello.startProblem(8) should be(array)
  }
}