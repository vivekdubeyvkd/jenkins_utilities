def jobname = "<full job name with path>"
def buildnum = <build number>

def job = Jenkins.instance.getItemByFullName(jobname)
 for (build in job.builds) {
     if (build.fullName == jobname && buildnum == build.getNumber().toInteger()){
       if (build.isBuilding()){
         print build
         build.doStop();
         //build.doKill();
       }
     }
    
}
