import org.apache.commons.lang3.StringUtils
import jenkins.*
import jenkins.model.*
import hudson.* 
import hudson.model.*
  
Hudson.instance.queue.items.each { 
  job_name = StringUtils.substringBetween(it.toString(), "[", "]");
  println job_name
}
