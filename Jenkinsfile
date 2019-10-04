pipeline {
    agent {
        docker {
            image 'markhobson/maven-chrome'
        }
    }
    stages {
        stage('No impacto') {
            steps {
                sh 'mvn clean install -Dheadless=true -Ddocker=true'
            }
        }
    }

    post {
        always {
          archiveArtifacts(artifacts: 'target/', fingerprint: true)
          junit 'target/cucumber.xml'
          publishTestResults(serverAddress: 'https://jira.falabella.com', projectKey: 'PBAN', filePath: 'target/cucumber-report/cucumber.json', format: 'Cucumber', autoCreateTestCases: true)
        }
     }
}

