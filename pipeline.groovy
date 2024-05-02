pipeline {
    agent any
    
    environment {
        DIRECTORY_PATH = "/Users/mohakahuja/.jenkins"
        TESTING_ENVIRONMENT = "QA"
        PRODUCTION_ENVIRONMENT = "SomanshAhuja"
    }
    
    stages {
        stage('Build') {
            steps {
                echo "Fetching source code from: ${env.DIRECTORY_PATH}"
                echo "Compiling the code and generating necessary artifacts"
            }
        }
        stage('Test') {
            steps {
                echo "Running unit tests"
                echo "Running integration tests"
            }
        }
        stage('Code Quality Check') {
            steps {
                echo "Checking the quality of the code"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying the application to testing environment: ${env.TESTING_ENVIRONMENT}"
            }
        }
        stage('Approval') {
            steps {
                echo "Waiting for manual approval..."
                sleep time: 10, unit: 'SECONDS'
            }
        }
        stage('Deploy to Production') {
            steps {
                echo "Deploying the application to production environment: ${env.PRODUCTION_ENVIRONMENT}"
            }
        }
    }
}
