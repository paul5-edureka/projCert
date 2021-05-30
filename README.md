# projCert

## Repository Contents
### ansible
Contains the playbooks and inventory files
### selenium
Maven project with Selenium tests
### website
Content is exactly same as the main repo from where this is forked
### Jenkinsfile
Create a Jenkins pipeline project and point to this GitRepo JenkinFile, 
Webhook in GitRepo will notify the Jenkins job of any changes.
### dockerfile
Will copy contents of the website, and start Http server
### user-data_JenkinsMaster.txt
Copy and paste contents of this file to the user-data section of Jenkins Master Amazon Linux Instance
### user-data_TestServer.txt
Copy and paste contents of this file to the user-data section of the Test Server Amazon Linux Instance


