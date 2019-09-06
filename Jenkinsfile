pipeline {

  agent any

  stages {

      stage('Limpia el Proyecto') {
          steps {
              bash mvn clean
          }
      }

      stage('Ejecutpo las pruebas') {
          steps {
             bash mvn install
          }
      }
  }
}