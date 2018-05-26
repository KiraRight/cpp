package main

import scala.annotation.tailrec

object lab6 {

  def first(list: List[(String, Int)]): (List[(String, Int)], List[(String, Int)]) = {
    (list.sortBy(_._2), list.sortBy(_._1))
  }

  def addRepeated(list: List[Int]): List[Int] = {
    list.foldRight(List[Int]()) { (right, left) => right :: right :: left }
  }

  @tailrec
  def fibonachi(number: Int, prev: Int, current: Int): Boolean = {
    if (number > current) fibonachi(number, current, prev + current)
    else if (number == current) true
    else false
  }

  def fibonachiList(list: List[Int]): List[Int] = {
    list.filter((num: Int) => fibonachi(num, 1, 1))
  }
}