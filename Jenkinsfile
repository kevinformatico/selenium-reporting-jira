pipeline {
    agent {
        docker {
            image 'markhobson/maven-chrome'
        }
    }
    stages {
        stage('Descarga de features'){
            steps {
                downloadFeatureFiles serverAddress: 'http://34.95.164.112:90',
                    projectKey: 'FAL',
                    targetPath:'src/test/java/Features'
            }
        }
        stage('No impacto') {
            steps {
                sh 'mvn clean install -Dheadless=true -Ddocker=true'
            }
        }

        stage('Reporting') {
            steps {
                step(
                    [$class: 'ZfjReporter',
                    serverAddress: 'http://34.95.164.112:90',
                    projectKey:'FAL',
                    versionKey:'1',
                    cycleKey:'Prueba',
                    cycleDuration:'1 days',
                    cyclePrefix:'']
                )
            }
        }

    }

}

