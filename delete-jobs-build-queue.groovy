import hudson.model.*

def q = Jenkins.instance.queue

q.items.each {
  if (it =~ 'pattern') {
    q.cancel(it.task)
  }
}
