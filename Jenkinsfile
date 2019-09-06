pipeline {

  agent any

  stages {

      stage('Limpia el Proyecto') {
          steps {
              bash 'mvn clean'
              echo 'Hizo el Clean'
          }
      }

      stage('Ejecutpo las pruebas') {
          steps {
             bash 'mvn install'
             echo 'Hizooo el Install'
          }
      }
  }
}