import jenkins.*
import jenkins.model.*
import hudson.* 
import hudson.model.*
   
jenkins = Hudson.instance

def get_nodes(){
   for (int i =0; i < jenkins.slaves.size(); i++) {
         println jenkins.slaves[i].computer.name   
    }  
}

get_nodes()
