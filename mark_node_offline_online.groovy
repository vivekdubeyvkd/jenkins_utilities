import jenkins.*
import jenkins.model.*
import hudson.* 
import hudson.model.*

jenkins = Hudson.instance

@NonCPS
def mark_offline_or_bring_node_back_online(nodeName, actionType){
    for (int i =0; i < jenkins.slaves.size(); i++) {
        computer = jenkins.slaves[i].computer
        if(computer.name == 'ind-vmscm06-07.corp.intuit.net'){
            if(actionType == 'offline'){
                if(! computer.offline){
                    println('marking ' + computer.name + ' offline')
                    computer.setTemporarilyOffline(true)
                    computer.doChangeOfflineCause('marking this machine offline') 
                }
            }else if(actionType == 'online'){
                println('bringing ' + computer.name + ' online')
                computer.setTemporarilyOffline(false)
            }          
        }   
    }  
}
// use is shown below
mark_offline_or_bring_node_back_online('testnode', 'offline')
mark_offline_or_bring_node_back_online('testnode', 'online')
