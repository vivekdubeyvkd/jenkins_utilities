import jenkins.*, jenkins.model.*
import hudson.*, hudson.model.*

Hudson.instance.queue.items.each { 
  if(it.getAssignedLabel().toString() == '<label name>'){
          println(it.getAssignedLabel())
          println(it.getInQueueForString())
  }
}
