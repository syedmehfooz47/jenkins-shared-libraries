# Jenkins Shared Library

- Shared libraries in Jenkins Pipelines are reusable pieces of code that can be organized into functions and classes.
- These libraries allow you to encapsulate common logic, making it easier to maintain and share across multiple pipelines and projects.
- Shared library must be inside the **vars** directory in your github repository
- Shared library uses **groovy** syntax and file name ends with **.groovy** extension.

#

## How to create and use shared library in Jenkins

### How to create Shared library

- Login to your Jenkins dashboard. <a href="">Jenkins Installation</a>
- Go to **Manage Jenkins** --> **System** and search for **Global Trusted Pipeline Libraries**.
<img src="https://github.com/syedmehfooz47/jenkins-shared-libraries/blob/main/assests/config1.png" />

  **Name:** Shared <br>
  **Default version:** \<branch name><br>
  **Project repository:** <https://github.com/syedmehfooz47/jenkins-shared-libraries.git> <br>

****
<img src="https://github.com/syedmehfooz47/jenkins-shared-libraries/blob/main/assests/config2.png" />

#

### How to use it in Jenkins pipeline

- Go to your declarative pipeline
- Add **@Library('Shared') _** at the very first line of your jenkins pipeline.
<img src="https://github.com/syedmehfooz47/jenkins-shared-libraries/blob/main/assests/pipeline.png" />

**Note:** @Library() _ is the syntax to use shared library.

## Jenkins

Jenkins requires Java to run, yet not all Linux distributions include Java by default. Additionally, not all Java versions are compatible with Jenkins.

```bash
sudo apt update
sudo apt install fontconfig openjdk-21-jre
java -version
```

Long Term Support release

```bash
sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2026.key
echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc]" \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt update
sudo apt install jenkins
```
