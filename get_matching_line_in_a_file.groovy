
def get_matching_lines_in_file(filePath, pattern){
    lines = readFile(filePath).readLines()
    result = lines.findAll { it.contains(pattern) }
    if(result[0]){
        return result[0].toString()
    }
    return 
}

// call this function with absolute filePath and pattern that you want to search in that file
// e.g. if vivek.txt in my file in current dir and vivek is pattern that I want to search, then I will call this function as shown below
matchingLine = get_matching_lines_in_file("/tmp/vivek.txt", "vivek")
if(matchingLine){
   println("matching line found ") 
   println(matchingLine) 
} else {
   println("No matching line found ") 
}  
