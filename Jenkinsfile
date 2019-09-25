pipeline {
  agent {
    docker {
      image 'markhobson/maven-chrome'
    }

  }
  stages {
    stage('No impacto') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
  post {
    always {
      archiveArtifacts(artifacts: 'target/', fingerprint: true)
      junit 'target/cucumber.xml'
      publishTestResults(serverAddress: 'http://35.199.73.222:90', projectKey: 'FAL', filePath: 'target/cucumber-report/cucumber.json', format: 'Cucumber', autoCreateTestCases: true)

    }

  }
}