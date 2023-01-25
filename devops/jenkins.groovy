@Library('shared-library@master')

import sharedLibrary.toolsJenkisn

def tools = new toolsJenkisn(this)
def nombre = "Yorlin"

try {
    node {
        stage('Saludo de pipeline') {
            tools.call("${nombre}" as String)
        }
    }
} catch (e) {
    tools.notifySlack("Error: ${e}")
    throw e
}