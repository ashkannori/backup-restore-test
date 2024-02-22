fun main(args: Array<String>) {
    workOnFiles()
}

fun workOnFiles() {
    try {
        print("Enter the number of your file : ")
        val number = readLine()?.toIntOrNull() ?: throw Exception("Invalid input")

        val listOfFiles = ArrayList<String>(number)
        repeat(number) {
            print("the path file[${it + 1}] : ")
            val path = readLine() ?: throw Exception("Invalid input")
            listOfFiles.add(path)
        }

        val myFiles = MyFiles()
        myFiles.compressFiles(listOfFiles)
        myFiles.extractFiles("myFile.Ashkan", listOfFiles)
    } catch (e: Exception) {
        println("Error!! : you did not enter anything or your entry is incorrect ...")
        println(e.message)
    }
}
