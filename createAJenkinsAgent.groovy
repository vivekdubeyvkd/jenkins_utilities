node('nodeName'){
        env.NODE_NAME="IP.IP.IP.IP" // or node DNS name
        env.JAVA_HOME = '<java home>'
        echo "${JAVA_HOME}"
        env.JENKINS_URL="<Jenkins URL>"
        env.NODE_SLAVE_HOME='<path on slave machine>'
        env.EXECUTORS=1
        env.LABELS=""
        env.USERID='<username>'           
        stage("Add ${NODE_NAME} slave to Jenkins master"){
            sh returnStatus: true, script: """
                curl -s -k env.JENKINS_URL/jnlpJars/jenkins-cli.jar -o jenkins-cli.jar
                cat <<-EOF | ${JAVA_HOME}/bin/java -jar ./jenkins-cli.jar -s ${JENKINS_URL} create-node ${NODE_NAME}
                <slave>
                <name>${NODE_NAME}</name>
                <description>${NODE_NAME}</description>
                <remoteFS>${NODE_SLAVE_HOME}</remoteFS>
                <numExecutors>${EXECUTORS}</numExecutors>
                <mode>NORMAL</mode>
                <retentionStrategy class="hudson.slaves.RetentionStrategy\$Always"/>
                <launcher class="hudson.slaves.CommandLauncher">
                <agentCommand>ssh -o StrictHostKeyChecking=no ${USERID}@${NODE_NAME} java -jar ${NODE_SLAVE_HOME}/slave.jar</agentCommand>
                </launcher>
                <label>${LABELS}</label>
                <nodeProperties/>
                </slave>
                EOF                 
            """
        }
}
