import scala.sys.process._
import java.io.File
object Run extends App {
  val libsToLink = Seq("gp")
  private val srcdir = "src"
  val libs = for {
    fs <- new File(srcdir).listFiles()
    crit <- libsToLink
    if (fs.getName.contains(crit))
  } yield (fs.getName)
  println(s"libs to include : ${libs.toList}")
//  s"cd ${srcdir}".!!
//  Process(Seq("cd",srcdir),new File(srcdir)).!!
  println("pwd".!!)
  libs foreach (x=>Process(s"sdcc -I ../inc -c ${x}",new File(srcdir)).!!)
//  s"cd ../".!!
//  Process(Seq("cd","../"),new File(srcdir)).!!
  println("pwd".!!)



//  val cmd = "uname -a" // Your command
//  val output = cmd.!! // Captures the output
//  println(output)
}
