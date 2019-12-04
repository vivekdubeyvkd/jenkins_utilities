inputDirList = []
dirList = findFiles(glob: '**/*.txt')
for(index=0; index < dirList.size(); index++){
    // this is the trick, we need use enoding to ensure that we can split it and store it into an array, without encoding it was failing
    dirName = java.net.URLEncoder.encode(dirList[index].path, "UTF-8").replace('%5C', ' ').split()[1]
    if(! inputDirList.contains(dir_name)){
         inputDirList.add(dirName)
    }    
}
