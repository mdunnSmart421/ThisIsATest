The Two Way SSL Services will expect to retrieve SSL/TLS certificates from a Java Key Store (JKS). 
Java Virtual Machines usually come with keytool to help you create a new key store.

keytool helps you to:

1. Create a new JKS with a new private key
2. Generate a Certificate Signing Request (CSR) for the private key in this JKS
3. Import a certificate that you received for this CSR into your JKS

keytool DOES NOT however let you import an existing private key for which you already have a certificate. 
You need to do this yourself, here's how:

You must have both the certificate and the private key that was used to create the original signing request.

Let's assume you have a PEM file that contains a private key and certificate, both in PEM format as the file names suggest.
( You may have a separate file for the private key and the certificate ).

PEM format is 'kind-of-human-readable' and looks like e.g.

-----BEGIN CERTIFICATE-----
MIIDVTCCAj2gAwIBAgIJAIxFw77eaVrXMA0GCSqGSIb3DQEBBQUAMCUxCzAJBgNV
BAoTAm8yMRYwFAYDVQQDEw10aW1iZXJsYWtld2Vi....uDf6VOFuB9ZocK2LHxmZ
PnFo4QKL1NHJYtfTHM7fQWBG9/fbE5tUA4iR3QWQ4HMBP7Ng7405Q6c=
-----END CERTIFICATE-----

-----BEGIN RSA PRIVATE KEY-----
Proc-Type: 4,ENCRYPTED
DEK-Info: DES-EDE3-CBC,F395FCD50D3EA829

ptuTB529kJuQIGXeUPtTIgJ5uvjr6S31W+sp3kjhdMEI8lWFLo2qA2GdRfCkxVm7
O5oMJU8EBzHhMEEKXjG9ieaH0quidcFFfTl+p4J....FS1wygmyCt0DxPoO4txi+
d6B9ycPRxG5e0lanoSguqOiZwnflYdDGyaKJMl+UQNKbNsz17r4v2KgiMwiZ+LoG
-----END RSA PRIVATE KEY-----

Using OpenSSL (http://gnuwin32.sourceforge.net/packages/openssl.htm), convert both 
the key and the certificate into DER format:

   openssl pkcs8 -topk8 -nocrypt -in key.pem -inform PEM -out key.der -outform DER

   openssl x509 -in cert.pem -inform PEM -out cert.der -outform DER

You will now need to import these files into the JKS. 

com.o2.finance.util.ImportKey.java will do this for you and run it as follows:

   java ImportKey <path_to_key> <path_to_cert>

e.g.

> java ImportKey key.der cert.der

The console should report something like the following:

Using keystore-file : c:/Documents and Settings/SWatson/keystore.ImportKey
One certificate, no chain.
Key and certificate stored.
Alias:importkey  Password:importkey

Now you have a proper JKS containing our private key and certificate in a file called keystore.ImportKey, 
using 'importkey' as alias and also as password. 

For any further changes, like changing the password we can use keytool.