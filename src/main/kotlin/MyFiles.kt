import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class MyFiles {

    fun compressFiles(paths: ArrayList<String>) {
        try {
            val text = paths.joinToString("\n-----\n") { path ->
                FileReader(path).use { fr ->
                    Scanner(fr).use { sc ->
                        generateSequence { if (sc.hasNextLine()) sc.nextLine() else null }.joinToString("\n")
                    }
                }
            }

            FileWriter(File("myFile.Ashkan")).use { wr ->
                wr.write(text)
            }

            println("compressing files finished ...")
        } catch (e: Exception) {
            println("Error in compressFiles function in class MyFiles !!")
            println("your file have an Error !...")
            println(e.message)
        }
    }

    fun extractFiles(path: String, listOfFiles: ArrayList<String>) {
        try {
            FileReader(path).use { fr ->
                Scanner(fr).use { sc ->
                    for (item in listOfFiles) {
                        val saveInfo = generateSequence {
                            if (sc.hasNextLine()) sc.nextLine() else null
                        }.takeWhile { it != "-----$item-----" }.joinToString("\n")

                        FileWriter(File("extractFiles//$item")).use { wr ->
                            wr.write(saveInfo)
                        }
                    }
                }
            }

            println("extracting files finished ...")
        } catch (e: Exception) {
            println("Error in extractFiles function in class MyFiles !!")
            println("your file have an Error !...")
            println(e.message)
        }
    }
}
