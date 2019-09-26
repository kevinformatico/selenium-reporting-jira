pipeline {
  agent {
    docker {
      image 'markhobson/maven-chrome'
    }
<<<<<<< HEAD
=======

>>>>>>> f2ff74337df21a13001e36e4916df5460081d830
  }
  stages {
    stage('No impacto') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
<<<<<<< HEAD
}
=======
  post {
    always {
      archiveArtifacts(artifacts: 'target/', fingerprint: true)
      junit 'target/cucumber.xml'
      publishTestResults(serverAddress: 'http://35.199.73.222:90', projectKey: 'FAL', filePath: 'target/cucumber-report/cucumber.json', format: 'Cucumber', autoCreateTestCases: true)

    }
>>>>>>> f2ff74337df21a13001e36e4916df5460081d830

  }
}