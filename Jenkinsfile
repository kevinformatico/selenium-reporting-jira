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
          publishTestResults(serverAddress:'http://35.247.232.57:70', projectKey: 'FAL', filePath: 'target/cucumber-report/cucumber.json', format: 'Cucumber', autoCreateTestCases: false)
        }
    }

}

