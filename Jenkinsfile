pipeline {
    agent any

    stages {
        stage('Prepare ansible agents') {
            steps {
                ansiblePlaybook credentialsId: 'sshkey', disableHostKeyChecking: true, installation: 'MyAnsible', inventory: 'ansible/dev.inv', playbook: 'ansible/playbook.yml'
            }
        }
        stage('Create Image and Start Container') {
            steps {
                ansiblePlaybook credentialsId: 'sshkey', disableHostKeyChecking: true, installation: 'MyAnsible', inventory: 'ansible/dev_python3.inv', playbook: 'ansible/playbook_docker.yml'
            }
        }
        stage('Run Tests') {
          steps {
            dir('selenium') {
              sh 'mvn clean install -DapplicationUrl=http://34.242.31.109:8080/'
            }
          }
        }
    }
}
