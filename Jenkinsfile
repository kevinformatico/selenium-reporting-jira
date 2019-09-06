pipeline {

  agent any

  stages {

      stage('Limpia el Proyecto') {
          steps {
              sh 'mvn clean'
              echo 'Hizo el Clean'
          }
      }

      stage('Ejecutpo las pruebas') {
          steps {
             sh 'mvn install'
             echo 'Hizooo el Install'
          }
      }
  }
}