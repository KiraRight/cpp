package test

import main.lab6
import main._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

class tests extends FunSuite {
  test("sorting") {
    assert(lab6.first(List(("Jeck", 3), ("Alex", 1), ("Glory", 5), ("Niko", 4))) == (List(("Alex", 1), ("Jeck", 3), ("Niko", 4), ("Glory", 5)), List(("Alex", 1), ("Glory", 5), ("Jeck", 3), ("Niko", 4))))
  }

  test("one element sorting") {
    assert(lab6.first(List(("Jeck", 3))) == (List(("Jeck", 3)), List(("Jeck", 3))))
  }

  test("two elements sortung") {
    assert(lab6.first(List(("Jeck", 3), ("Alex", 4))) == (List(("Jeck", 3), ("Alex", 4)), List(("Alex", 4), ("Jeck", 3))))
  }

  test("null sortung") {
    assert(lab6.first(List()) == (List(), List()))
  }

  test("add for many numbers") {
    assert(lab6.addRepeated(List(1, 2, 3, 2, 4, 5, 5)) == List(1, 1, 2, 2, 3, 3, 2, 2, 4, 4, 5, 5, 5, 5))
  }

  test("add for one numbers") {
    assert(lab6.addRepeated(List(1)) == List(1, 1))
  }

  test("add for null") {
    assert(lab6.addRepeated(List()) == List())
  }

  test("fibonachi by test") {
    assert(lab6.fibonachiList(List(1, 2, 3, 2, 4, 5, 5, 6, 7, 8, 9, 10)) == List(1, 2, 3, 2, 5, 5, 8))
  }

  test("fibonachi for one number - yes") {
    assert(lab6.fibonachiList(List(8)) == List(8))
  }

  test("fibonachi default") {
    assert(lab6.fibonachiList(List(4,6,7)) == List())
  }

  test("fibonachi null") {
    assert(lab6.fibonachiList(List()) == List())
  }

  test("test example fib") {
    assert(lab6.fibonachiList(List(1, 2, 4,5,8,13,27,55)) == List(1,2,5,8,13,55))
  }
}