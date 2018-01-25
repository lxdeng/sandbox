import com.taobao.Company
import com.taobao.hr.Employee
import com.taobao.sales.Product

object Main extends App {
  println("Hello, World!")

  val c = new com.taobao.Company("Yun Ma")
  c.ceoGreet()

  val c2 = new Company("Yun Ma")
  c2.ceoGreet()

  val emp = new Employee("Xiaoer", 18)
  emp.works()

  val p = new Product(1, "Desk Lamp")
  println(p.id())
  println(p.id) // the () is not needed

  val p2 = new Product()
  printf("p2's name = \"%s\"\n", p2.name)
}
