@Library('shared-library@master')

import sharedLibrary.toolsJenkisn

def tools = new toolsJenkisn()

try {
    node {
        stage('Saludo de pipeline') {
            tools.call("Yorlin")
        }
    }
} catch (e) {
    tools.notifySlack("Error: ${e}")
    throw e
}