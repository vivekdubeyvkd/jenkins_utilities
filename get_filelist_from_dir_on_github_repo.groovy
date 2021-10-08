/**
   This utility shows how to use GitHub rest API to list all files under a directory on GitHub repo without actually cloning the repo locally
**/

json_file = "dir_files.json"

def get_filelist_from_dir_on_github_repo(){
        remoteBranch = "master"
        REMOTE_FOLDER_NAME = ""
        GITHUB_API = ""
        GITHUB_ORG = "vivekdubeyvkd"
        GITHUB_REPO = "python-utilities"
        GITHUB_API_ROOT = "https://api.github.com/repos/${GITHUB_ORG}/${GITHUB_REPO}/contents"
  
        if(REMOTE_FOLDER_NAME == ""){
            GITHUB_API = GITHUB_API_ROOT + "?ref=${remoteBranch}"
        } else {
            GITHUB_API = GITHUB_API_ROOT + "/${REMOTE_FOLDER_NAME}?ref=${remoteBranch}"
        }
        
        withCredentials([usernamePassword(credentialsId: 'github_token', passwordVariable: 'GPWD', usernameVariable: 'GUSR')]) {
            sh """#!/bin/bash
                  if [ -f ${json_file} ]
                  then
                     rm -rf ${json_file}
                  fi
                  curl -u "$GUSR:$GPWD" "${GITHUB_API}" > ${json_file}
            """
        } 
  
        if(fileExists(json_file)){    
            fileListJson = readJSON file: json_file, text: ''
            if(fileListJson =~ "documentation_url" && fileListJson =~ "Not Found"){
                echo """
                     ${REMOTE_FOLDER_NAME} does not exist on repo for ${remoteBranch} branch
                """
            } else {
                echo """
                      Files on remote repo are:
                """
                for(counter = 0; counter < fileListJson.size(); counter++){
                    fileName = fileListJson[counter]["name"]
                    println(fileName)
                }  
            }
        }
}  

