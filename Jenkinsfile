pipeline {
    agent any

    tools {
            maven 'maven' // Nom de l'installation Maven dans Jenkins
        }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/saarmas/Basic-Spring.git', branch: 'main'
            }
        }

        stage('Display Message') {
                    steps {
                        // Display a message indicating successful Git checkout
                        echo 'Git checkout successful! Repository cloned.'
                    }
                }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('mvn clean package successful passed') {
                    steps {
                        // Display a message indicating successful Git checkout
                        echo 'mvn clean install!'
                    }
                }


    }

    //comment test
}
