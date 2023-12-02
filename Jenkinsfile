pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image'){
            steps{
                bat 'docker build -t=556730/seleniumdocker .'
            }
        }

        stage('Push Image'){

            steps{

                bat 'docker push 556730/seleniumdocker'

            }
        }

    }

}