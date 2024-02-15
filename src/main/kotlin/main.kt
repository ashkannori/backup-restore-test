import java.lang.Exception

fun main() {
    workOnFiles()
}

fun workOnFiles() {
    val listOfFiles: ArrayList<String> = arrayListOf()
    var number: Int = 0

    try {
        print("Enter the number of your file : ")
        number = readLine()!!.toInt()

        for (i in 1..number) {
            print("the path file[$i] : ")
            val path: String = readLine()!!.toString()
            listOfFiles.add(path)
        }

        MyFiles().compressFiles(listOfFiles)
        MyFiles().extractFiles("myFile.Ashkan", listOfFiles)
    } catch (e: Exception) {
        println("Error!! : you did not enter anything or your entry is incorrect ...")
        println(e.message)
    }
}