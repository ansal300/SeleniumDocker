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
                bat 'docker build -t=556730/seleniumdocker:latest .'
            }
        }

        stage('Push Image'){

            steps{

                bat 'docker push 556730/seleniumdocker:latest'
                bat "docker tag 556730/seleniumdocker:latest 556730/seleniumdocker:${env.Build_NUMBER}"
                bat "docker push 556730/seleniumdocker:${env.Build_NUMBER}"

            }
        }

    }

}