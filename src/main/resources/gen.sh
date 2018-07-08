keytool -genkey -validity 700 -keyalg RSA -keysize 2048 -noprompt -alias tomcat -dname "CN=sandbox1.me, OU=ID, O=JAMES, L=NC, S=North Carolina, C=Raleigh" -keystore keystore.jks -storepass password -keypass password
keytool -export -alias tomcat -keystore keystore.jks -storepass password -rfc -file X509_certificate.cer
