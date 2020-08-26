// creating an example file with the list of remote branches
bat """
    git branch -r > branch.list
"""
branch_list_files_list = readFile("branch.list").readLines()
        
for (index =0; index < branch_list_files_list.size(); index++ ) {
    remoteBranchName = branch_list_files_list[index]
    localBranchname = remoteBranchName.split('/')[-1]
    if(!(remoteBranchName =~ 'master')){
       bat """
           git checkout -b ${localBranchname} ${remoteBranchName} 
       """
    }
}
