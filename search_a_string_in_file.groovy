fileLines = readFile('abc.txt').readLines()
searchResult = fileLines.findAll { it.contains('searchpattern') }
searchResultVal = searchResult[0]
