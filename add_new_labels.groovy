hudson = hudson.model.Hudson.instance
hudson.slaves.findAll { it.nodeName.contains("nodename") }.each { slave -> 
  print "Slave  $slave.nodeName : Labels: $slave.labelString"
  slave.labelString = slave.labelString + " " + "new_label_value"
  println "   --> New labels: $slave.labelString"
}
hudson.save()
