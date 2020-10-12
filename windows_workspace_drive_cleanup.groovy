def cleanup(){
    stage('Clean Up'){
        bat """
            pushd %WORKSPACE%\..
            echo off
            FOR /D %%i IN (*) DO  ( 
                if not "%%i" == "${JOB_BASE_NAME}" (
                    echo on
                    ECHO "removing %%i to clear some space from WORKSPACE root drive to ensure that build does not fail with Disk Space issue"
                    echo off
                    rd /s /q %%i
                    set ERRORLEVEL=0
                )    
            )
            dir
        """
    }
}

node('windows') {
   cleanup()
}
