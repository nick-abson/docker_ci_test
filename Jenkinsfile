pipeline {
  agent any
  stages {
    stage('compile api') {
      parallel {
        stage('compile api') {
          steps {
            sh '''cd api
mvn compile'''
          }
        }
        stage('compile app') {
          steps {
            sh '''cd app
mvn compile'''
          }
        }
      }
    }
    stage('integration test') {
      parallel {
        stage('integration test (api)') {
          steps {
            sh 'mvn integration-test'
          }
        }
        stage('test (app)') {
          steps {
            sh 'mvn test'
          }
        }
      }
    }
    stage('package') {
      parallel {
        stage('package (api)') {
          steps {
            sh 'mvn package'
          }
        }
        stage('package (app)') {
          steps {
            sh 'mvn package'
          }
        }
      }
    }
  }
}