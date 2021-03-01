#!/usr/bin/env groovy

def call(String buildResult) {
    if ( buildResult == "SUCCESS" ) {
        slackSend color: "good", message: "*SUCCESSFULL*: ${env.JOB_NAME} - Build number #${env.BUILD_NUMBER}\nFor more info go to ${env.BUILD_URL}"
    }
    else if( buildResult == "FAILURE" ) { 
        slackSend color: "danger", message: "*FAILED*: ${env.JOB_NAME} - Build number #${env.BUILD_NUMBER}\nFor more info go to ${env.BUILD_URL}"
    }
    else if( buildResult == "UNSTABLE" ) { 
        slackSend color: "warning", message: "*UNSTABLE*: ${env.JOB_NAME} - Build number #${env.BUILD_NUMBER}\nFor more info go to ${env.BUILD_URL}"
    }
    else {
        slackSend color: "danger", message: "*UNCLEAR*: ${env.JOB_NAME} - Build number #${env.BUILD_NUMBER}\nFor more info go to ${env.BUILD_URL}"
    }
}