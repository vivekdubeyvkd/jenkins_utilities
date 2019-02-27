Jenkins.instance.getItemByFullName("<full job name with path>").getBuildByNumber(<put build number here>).finish(hudson.model.Result.ABORTED, new java.io.IOException("Aborting build"));
