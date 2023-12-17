@Library('shared-library@master')

import sharedLibrary.toolsJenkisn

def tools = new toolsJenkisn(this)
def nombre = "Yorlin"

try {
    node {
        stage('Saludo de pipeline') {
            tools.call("${nombre}" as String)
        }
        stage('Hacer un echo') {
            tools.printMessage("Hola ${nombre}")
        }
        stage('SonarCloud') {
            tools.analisisCodigo()
        }
    }
} catch (e) {
    tools.notifySlack("Error: ${e}")
    throw e
}
