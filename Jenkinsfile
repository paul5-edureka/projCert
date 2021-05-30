pipeline {
    agent any
    
    options {
        disableConcurrentBuilds()     
    }    

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
                try {
                    sh 'mvn clean install -Dwebdriver.chrome.driver=/usr/bin/chromedriver -DapplicationUrl=http://172.31.30.131:8080/'      
                } finally {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/junitreports/*.xml'
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/surefire-reports', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])        
                }    
            }
          }
        }
    }
    
    post {
        success {
            echo 'Posting success'    
        }    
        failure {
            echo 'posting failure'
        }    
    }    
}
