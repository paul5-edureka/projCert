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
    }
}
