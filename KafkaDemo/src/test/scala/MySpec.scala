import org.scalatest.FlatSpec

class MySpec extends FlatSpec  {
  "An empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }
}
