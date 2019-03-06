import jenkins.*
import jenkins.model.*
import hudson.* 
import hudson.model.*
   
jenkins = Hudson.instance

def get_nodes_label(){
   for (int i =0; i < jenkins.slaves.size(); i++) {
         println(jenkins.slaves[i].computer.name + " : " + jenkins.slaves[i].labelString)
    }  
}

get_nodes_label()
