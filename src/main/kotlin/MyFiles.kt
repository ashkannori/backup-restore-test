import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class MyFiles {

    fun compressFiles(paths: ArrayList<String>) {
        var text: String = ""

        try {
            for (item in paths) {
                val fr = FileReader(item)
                val sc = Scanner(fr)
                while (sc.hasNext()) {
                    text += sc.nextLine()
                }

                fr.close()

                text += "\n-----$item-----\n"  // at the end of the string, when the new file starts, use this text to separate the files
            }

            val myFile = File("myFile.Ashkan")
            val wr = FileWriter(myFile)
            wr.write(text)

            wr.close()

            println("compressing files finished ...")        // This is a text to announce the end of the process
        } catch (e: Exception) {
            println("Error in compressFiles function in class MyFiles !!")
            println("your file have an Error !...")
            println(e.message)
        }
    }

    fun extractFiles(path: String, listOfFiles: ArrayList<String>) {
        try {
            val fr = FileReader(path)
            val sc = Scanner(fr)
            for (item in listOfFiles) {
                var saveInfo: String = ""
                while (sc.hasNext()) {
                    val temp = sc.nextLine()
                    if (temp.equals("-----$item-----")) {
                        break
                    }
                    saveInfo += temp
                }
                val myFile = File("extractFiles//$item")        // the path of extract files
                val wr = FileWriter(myFile)
                wr.write(saveInfo)
                wr.close()
            }
            fr.close()

            println("extracting files finished ...")        // This is a text to announce the end of the process
        } catch (e: Exception) {
            println("Error in extractFiles function in class MyFiles !!")
            println("your file have an Error !...")
            println(e.message)
        }
    }
}