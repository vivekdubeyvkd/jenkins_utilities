def get_jenkins_stage_time(build_url, stageName){
    build_number = build_url.split('/')[-1]
    build_job_url = build_url.replaceAll("${build_number}.*", "")
    withCredentials([string(credentialsId: 'datatheorem_token', variable: ''), usernamePassword(credentialsId: 'jenkins-user-id', passwordVariable: 'JPWD', usernameVariable: 'JUSER')]) {
        sh """
            curl -k -u ${JUSER}:${JPWD} ${build_job_url}wfapi/runs -o ${WORKSPACE}/tmp.json 
        """
    }
    
    input_json = readJSON file: "${WORKSPACE}/tmp.json"
    
    for(index = 0; index < input_json.size(); index++){
        if(input_json[index]["id"] == build_number) {
            stages = input_json[index]["stages"]
            for(index1 = 0 ; index1 < stages.size() ; index1++){
                if(stages[index1]["name"] =~ stageName){
                    println("stage execution time : " + stages[prvious_index]["durationMillis"])
                }
            } 
        }    
    }  
}

node {
    get_jenkins_stage_time("<jenkins build url>", "stageName")
}
