package main

import scala.annotation.tailrec

object lab6 {

  def mulAndSum(list:List[Int]):(Int,Int) = {
    list.foldLeft((1,0))((pair, elem) => {
      val (mul,sum) = pair
      elem match {
        case 0 => pair
        case x if x > 0 =>(mul, sum +x)
        case x => (mul * x, sum)
      }
    })
  }

  abstract class Notification {}

  case class Email(sender: String, title: String, body: String) extends Notification {}

  case class Sms(caller: String, message: String) extends Notification {}

  case class VoiceRecording(contactName: String, link: String) extends Notification {}

  def getNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, body) => "(ring!) Sender: " + sender + " Title: " + title + " Message: " + body
      case Sms(caller, message) => "Sms from " + caller + " Message: " + message
      case VoiceRecording(contactName, link) => "Voice recording from " + contactName + " link: " + link
      case _ => "Unknown notification!"
    }
  }

  /*def first(list: List[(String, Int)]): (List[(String, Int)], List[(String, Int)]) = {
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
  }*/
}