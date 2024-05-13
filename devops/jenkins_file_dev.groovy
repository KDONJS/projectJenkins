@Library('shared-library@develop')

import sharedLibrary.toolsJenkisn

def tools = new toolsJenkisn(steps, this)
def nombre = "Yorlin"
def credentialsId = "2"
def remoteHost = "161.132.42.130"

try {
    node {
        stage('Saludo de pipeline') {
            tools.callToActions("${nombre}" as String)
        }
    }
} catch (e) {
    //tools.notifySlack("Error: ${e}")
    throw e
}
