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



}

