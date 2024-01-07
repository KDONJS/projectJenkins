@Library('shared-library@master')

import sharedLibrary.toolsJenkisn

def tools = new toolsJenkisn(steps, this)
def nombre = "Yorlin"
def credentialsId = "2"
def remoteHost = "161.132.42.130"

try {
    node {
        stage('Saludo de pipeline') {
            tools.call("${nombre}" as String)
        }
        stage('Hacer un echo') {
            steps {
                sh "mkdir jenkins-file"
                sh "ls"
            }
        }
        stage('SonarCloud') {
            tools.analisisCodigo()
        }
    }
} catch (e) {
    tools.notifySlack("Error: ${e}")
    throw e
}
