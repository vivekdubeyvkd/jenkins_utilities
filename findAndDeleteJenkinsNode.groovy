
def findAndDeleteNodeByName(nodeName){
    hudson.model.Hudson.instance.slaves.each {
        machineObj = it.getComputer()
        if(machineObj.getName().toString() == nodeName) {
            println("Node found ${nodeName}, so it will be deleted ......")
            machineObj.doDoDelete()
        }
    }      
}

def findAndDeleteNodesByPattern(nodeNamePattern){
    hudson.model.Hudson.instance.slaves.each {
        machineObj = it.getComputer()
        machineName = machineObj.getName().toString()
        if(machineName =~ nodeNamePattern) {
            println("Node ${machineName} matching with input node name ${nodeNamePattern} pattern, so it will be deleted ......")
            machineObj.doDoDelete()
        }
    }      
}

// If I want to delete a node with a name as testNode, I will call findAndDeleteNode this as shown below
findAndDeleteNodeByName('testNode')

// If I want to delete all nodes having a pattern test in their name e.g. testNode1, testNode2, testNode3 etc, I will call findAndDeleteNodesByPattern this as shown below
findAndDeleteNodesByPattern('test')
