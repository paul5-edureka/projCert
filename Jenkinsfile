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
              sh 'mvn clean install -Dwebdriver.chrome.driver=/usr/bin/chromedriver -DapplicationUrl=http://172.31.30.131:8080/'
              junit allowEmptyResults: true, testResults: 'target/surefire-reports/junitreports/*.xml'
              publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/surefire-reports', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])  
            }
          }
        }
    }
}
