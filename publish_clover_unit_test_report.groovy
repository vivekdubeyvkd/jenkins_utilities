CLOVER_REPORT_DIR = "clover/coverage"
CLOVER_REPORT_XML = "clover.xml"
 
 step([
     $class: 'CloverPublisher',
     cloverReportDir: CLOVER_REPORT_DIR,
     cloverReportFileName: CLOVER_REPORT_XML,
     healthyTarget: [methodCoverage: 80, conditionalCoverage: 80, statementCoverage: 80], // optional, default is: method=70, conditional=80, statement=80
     unhealthyTarget: [methodCoverage: 50, conditionalCoverage: 50, statementCoverage: 50], // optional, default is none
     failingTarget: [methodCoverage: 0, conditionalCoverage: 0, statementCoverage: 0]     // optional, default is none
])
