#!/usr/bin/env groovy

def call(String buildResult) {
    if ( buildResult == "SUCCESS" ) {
        slackSend color: "good", message: "${env.JOB_NAME} - Build number ${env.BUILD_NUMBER}\nExecution status SUCCESSFULL - For more info go to ${env.BUILD_URL}"
    }
    else if( buildResult == "FAILURE" ) { 
        slackSend color: "danger", message: "${env.JOB_NAME} - Build number ${env.BUILD_NUMBER}\nExecution status FAILED - For more info go to ${env.BUILD_URL}"
    }
    else if( buildResult == "UNSTABLE" ) { 
        slackSend color: "warning", message: "${env.JOB_NAME} - Build number ${env.BUILD_NUMBER}\nExecution status UNSTABLE - For more info go to ${env.BUILD_URL}"
    }
    else {
        slackSend color: "danger", message: "${env.JOB_NAME} - Build number ${env.BUILD_NUMBER}\nExecution status UNCLEAR - For more info go to ${env.BUILD_URL}"
    }
}