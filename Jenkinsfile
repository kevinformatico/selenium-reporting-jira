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

         stage 'report test result'
            step (
                [class: 'JUnitResultArchiver' , testResults="**/target/failsafe-reports/TEST-*.xml"]
            )

            step (
                [class: 'ZfjReporter', serverAdress:'http://34.95.164.112:90', projectKey:'JIRA-3', versionKey:'1', cycleKey:'createNewCycle', cycleDuration:'30 days', cyclePrefix='']
            )
        }

    }

    /*
    post {
        always {
          archiveArtifacts(artifacts: 'target/', fingerprint: true)
          junit 'target/cucumber.xml'
          publishTestResults(serverAddress: 'http://34.95.164.112:90', projectKey: 'JIRA', filePath: 'target/cucumber-report/cucumber.json', format: 'Cucumber', autoCreateTestCases: false)
        }
    }
    */
}

