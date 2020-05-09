String[] online_nodes = []
String[] offline_nodes = []

for (Node node in jenkins.model.Jenkins.instance.nodes) {
  // Make sure slave is online
  if (node != null && node.toComputer() != null &&  node.toComputer().online) {
       online_nodes += node.name 
  } else {
        offline_nodes += node.name 
  }
}

println "+++++++++++++ OffLine nodes ++++++++++"
println offline_nodes
println "++++++++++++++++++++++++++++++++++++++"

println "+++++++++++++ OnLine nodes ++++++++++"
println online_nodes
println "++++++++++++++++++++++++++++++++++++++"
