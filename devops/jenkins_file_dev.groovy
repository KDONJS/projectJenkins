@Library('shared-library@master')

import sharedLibrary.toolsJenkins

def tools = new toolsJenkins(steps, this)
def nombre = "Yorlin"
def credentialsId = "2"
def remoteHost = "161.132.42.130"

try {
    node {
        stage('execute Sh') {
            tools.executeSh()
        }
        stage('verify Python') {
            tools.verifyPython()
        }
        stage('execute Py') {
            tools.executePy()
        }
    }
} catch (e) {
    //tools.notifySlack("Error: ${e}")
    throw e
}
