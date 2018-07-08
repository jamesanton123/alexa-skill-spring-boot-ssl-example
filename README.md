# Alexa Spring boot example with ssl
This project should make it easy to host an ssl enabled alexa servlet.

## Getting Started
You will need to have a domain name and dns server setup that points to your ip address.
You need to port forward in your router on 443.
You need to allow traffic through your firewall on 443.

I have included a file named gen.sh to generate your keystore and x509 certificate 

Make sure to go through the gen.sh, and modify the fields for your domain name, so it will match.

After running gen.sh, it will generate a keystore.jks file which will be used during startup of this application.
In alexa developer console on amazon's website, you will need to upload the x509 self signed
certificate that was also generated when running gen.sh

Troubleshooting tips:
    Alexa cannot reach the requested skill
        Verify that port 443 can be reached from external computer. This is a nifty little website to do that for you: http://canyouseeme.org/
            
        Make sure in the endpoint configuration that you have https://YOUR_DOMAIN:443/test set and your 
            x509 certificate has been uploaded   
    
    for some reason I had to set environment variable java.io.tmpdir to C:\temp on windows10
    

