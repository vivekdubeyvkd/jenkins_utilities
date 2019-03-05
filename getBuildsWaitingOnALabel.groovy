import jenkins.*
import jenkins.model.*
import hudson.* 
import hudson.model.*

Hudson.instance.queue.items.each { 
  if(it.getAssignedLabel().toString() == '<label name>'){
          println(it.getAssignedLabel())
          println(it.getInQueueForString())
  }
}
