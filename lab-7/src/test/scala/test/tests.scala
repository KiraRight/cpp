package test

import main.lab6
import main._
import main.lab6.{Email, Sms, VoiceRecording}
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

class tests extends FunSuite {

  test("for different numbers") {
    assert(lab6.mulAndSum(List(4, -2, 4, -9, 5, 3, 1, -5)) == (-90, 17))
  }

  test("nothing") {
    assert(lab6.mulAndSum(List()) == (1, 0))
  }

  test("for positive numbers") {
    assert(lab6.mulAndSum(List(1,2,3,7,5)) == (1, 18))
  }

  test("for negative numbers") {
    assert(lab6.mulAndSum(List(-4, -2, -4, 0, -5)) == (160, 0))
  }

  test("for Email") {
    assert(lab6.getNotification(Email("Anastasia", "We test it!", "This is only string for testing")) == "(ring!) Sender: Anastasia Title: We test it! Message: This is only string for testing")
  }

  test("for SMS") {
    assert(lab6.getNotification(Sms("Anastasia", "We send sms")) == "Sms from Anastasia Message: We send sms")
  }

  test("for voice") {
    assert(lab6.getNotification(VoiceRecording("Anastasia", "link")) == "Voice recording from Anastasia link: link")
  }
}