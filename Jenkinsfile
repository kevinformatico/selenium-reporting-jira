pipeline {

  agent any

  stages {

      stage('Limpia el Proyecto') {
          steps {
              bat 'mvn clean'
              echo 'Hizo el Clean'
          }
      }

      stage('Ejecutpo las pruebas') {
          steps {
             bat 'mvn install'
             echo 'Hizooo el Install'
          }
      }
  }
}