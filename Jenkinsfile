pipeline {
  agent any
  stages {

    stage('Clean Work Space') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: 'target/', fingerprint: true)
      junit 'target/cucumber.xml'
      publishTestResults(serverAddress: 'http://35.235.105.137', projectKey: 'POC', filePath: 'target/cucumber.json', format: 'Cucumber', autoCreateTestCases: true)

    }
  }
}