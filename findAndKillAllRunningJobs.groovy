job_pattern = ''

Thread.getAllStackTraces().keySet().each() {
    if (it.name.contains(job_pattern)) {  
      println "Stopping $it.name"
      it.stop()
    }
}
