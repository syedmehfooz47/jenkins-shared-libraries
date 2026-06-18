def call(){
  try {


    echo "Starting Dependency-Check Scan..."
    dependencyCheck additionalArguments: '--scan ./ --nvdApiDelay 8000', odcInstallation: 'OWASP'
  } catch (Exception e) {


    echo "Scan failed due to database corruption or API error. Auto-purging local cache..."
    dependencyCheck additionalArguments: '--purge', odcInstallation: 'OWASP'


    echo "Retrying scan with a fresh database..."
    dependencyCheck additionalArguments: '--scan ./ --nvdApiDelay 8000', odcInstallation: 'OWASP'
  } finally {


    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
  }
}
