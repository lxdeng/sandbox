import com.taobao.Company
import com.taobao.hr.Employee

object Main extends App {
  println("Hello, World!")

  val c = new com.taobao.Company("Yun Ma")
  c.ceoGreet()

  val c2 = new Company("Yun Ma")
  c2.ceoGreet()

  val emp = new Employee("Xiaoer", 18)
  emp.works()
}
