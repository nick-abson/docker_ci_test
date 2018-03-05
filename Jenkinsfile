pipeline {
  agent any
  stages {
    stage('compile api') {
      parallel {
        stage('compile api') {
          steps {
            sh 'cd api;mvn clean compile'
          }
        }
        stage('compile app') {
          steps {
            sh 'cd app;mvn clean compile'
          }
        }
      }
    }
    stage('integration test') {
      parallel {
        stage('integration test (api)') {
          steps {
            sh 'cd api;mvn integration-test'
          }
        }
        stage('test (app)') {
          steps {
            sh 'cd app;mvn test'
          }
        }
      }
    }
    stage('package') {
      parallel {
        stage('package (api)') {
          steps {
            sh 'cd api;mvn package -DskipTests'
          }
        }
        stage('package (app)') {
          steps {
            sh 'cd app;mvn package -DskipTests'
          }
        }
      }
    }
  }
}