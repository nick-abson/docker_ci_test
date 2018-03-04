pipeline {
  agent any
  stages {
    stage('compile api') {
      steps {
        sh '''cd api
mvn test'''
      }
    }
  }
}