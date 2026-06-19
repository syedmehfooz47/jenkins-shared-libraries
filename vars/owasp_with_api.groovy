def call() {

    withCredentials([
        string(credentialsId: 'NVD_API_KEY', variable: 'NVD_API_KEY')
    ]) {

        try {

            echo "Starting OWASP Dependency Check Scan..."

            dependencyCheck(
                odcInstallation: 'OWASP',
                additionalArguments: """
                    --scan ./
                    --nvdApiKey ${NVD_API_KEY}
                    --nvdApiDelay 3500
                    --format XML
                """
            )

        } catch (Exception e) {

            echo "Dependency Check failed: ${e.getMessage()}"
            throw e

        } finally {

            dependencyCheckPublisher(
                pattern: '**/dependency-check-report.xml'
            )

        }
    }
}
