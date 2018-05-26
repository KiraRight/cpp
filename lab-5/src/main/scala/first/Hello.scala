package first

import scala.Console
import scala.util.control.Breaks._
import scala.math.pow
import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Hello
{
  def main(args: Array[String]) =
  {
    val number = 2
    println("Set degree: ")
    val degree = Console.readInt()
    println("pow number recurcive = " + elevateRecursiveStart(number, degree))
    println("Set number: ")
    val numberForProblem = Console.readInt()
    val array = recursiveProblemStart(numberForProblem)
    println("Recursive: " + array.head + "+" + array(1) + "=" + numberForProblem)
    println("pow number = " + elevate(number, degree))
    val array1 = startProblem(numberForProblem)
    println(array1.head + "+" + array1(1) + "=" + numberForProblem)
  }

  //def elevate(number: Int, degree: Int): Int = pow(number, degree).intValue()

  @tailrec
  def elevateRecursive(number: Int, degree: Int, res: Int): Int = {
    if(degree == 0)
      res
    else
      elevateRecursive(number, degree-1, res*number)
  }

  def elevateRecursiveStart(number: Int, degree: Int): Int = {
    elevateRecursive(number, degree, 1)
  }

  def recursiveProblemStart(i: Int): Array[Int] =
  {
    recursiveProblem(i,i - 2, 3)
  }

  @tailrec
  def recursiveProblem(number: Int, firstNumber: Int,secondNumber: Int): Array[Int] = {
    if (((recursiveSimple(firstNumber, 2)) == true) && ((recursiveSimple(secondNumber -1, 2)) == true))
      Array[Int](firstNumber,secondNumber - 1)
    else
      recursiveProblem(number, number - secondNumber, secondNumber + 1)
  }

  @tailrec
  def recursiveSimple(number: Int, i: Int): Boolean = {
    if (i == number) true
    else {
      if (number % i == 0) false
      else recursiveSimple(number, i + 1)
    }
  }



  def elevate(number: Int, degree: Int): Int ={
    if(degree == 0) 1
    else number * elevate(number,degree - 1)
  }

  def startProblem(number: Int): Array[Int] = {
    val first = problem(number, 2)
    Array[Int]( number - first, first)
  }

  def problem(number: Int, first: Int): Int = {
    if(first == 0 || first == 1)
      problem(number, first + 1)
    if(simple(first, first - 1) == false || simple(number - first, number - first -1) == false)
      problem(number, first + 1)
    else
      first
  }

  def simple(number: Int, i: Int): Boolean = {
    if (i != 1 & i != 0) {
      if (number % i == 0) false
      else simple(number, i - 1)
    }
    else {
      if (number == 1) false
      else true
    }
  }
}
