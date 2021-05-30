# projCert

## Repository Contents
### ansible
Contains the playbooks and inventory files
### selenium
Maven project with Selenium tests
**applicationUrl** and **webdriver.chrome.driver** are passes as system properties.
___Need to update the Jenkinsfile when ansible inventory changes___ 
```
sh 'mvn clean install -Dwebdriver.chrome.driver=/usr/bin/chromedriver -DapplicationUrl=http://172.31.30.131:8080/'
```
### website
Content is exactly same as the main repo from where this is forked
### Jenkinsfile
Create a Jenkins pipeline project and point to this GitRepo JenkinFile, 
Webhook configured in GitRepo will notify the Jenkins job of any changes.
### dockerfile
Will copy contents of the website, and start Http server
### user-data_JenkinsMaster.txt
Copy and paste contents of this file to the user-data section of Amazon Linux Instance Jenkins Master
### user-data_TestServer.txt
Copy and paste contents of this file to the user-data section of the Amazon Linux Instance Test Server 
