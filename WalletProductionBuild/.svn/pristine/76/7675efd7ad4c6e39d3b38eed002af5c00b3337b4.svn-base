This document explains how to set your environment up to run the eWallet application with SILENT LOGIN on SMARTIPSVO2DEV(10.0.10.202) and on your LOCALHOST.


Section-1 : TESTING SILENT LOGIN ON SMRTIPSVO2DEV (10.0.10.202)
---------------------------------------------------------------
If you are testing on smrtipsvo2dev, silent-login will be set-up to authenticate against the "Login-Servlet Application" deployed on server SHADOWCAT in STF environment

1) Ensure that the application.properties (/usr/o2/wlapp/wlappdomain/properties/finance) file on the smrtsipsvo2dev WebLogic application server's classpath contains the following properties -

    o2.login.new.user.url=http://login-servlet.o2.co.uk:9000/sar/login
    o2.login.new.user.return.url=http://dev-smart421.o2.co.uk:8080/finance/newUserLoginCheck.do
    o2.login.new.user.failure.url=http://dev-smart421.o2.co.uk:8080/finance/newUserLoginCheck.do

2) In your hosts (c:\windows\system32\drivers\etc) file add the following entries

	127.0.0.1        localhost login-servlet.o2.co.uk
	10.0.10.202      dev-smart421.o2.co.uk

3) Set up a tunnel to LoginServlet server SHADOWCAT -

    a)Open Putty and load the configuration for O2-REF-GOTO (82.132.153.105) server.
    b)Set up a tunnel to look like this  - L9000 shadowcat:8080. This means that we tell the putty connection to forward requests on localhost/127.0.0.1/login-servlet.o2.co.uk:9000 to shadowcat:8080

Now, log in to O2-REF-GOTO and leave it running

4) Access eWallet landing page as follows - http://dev-smart421.o2.co.uk:8080/finance/inititate.do?productid=1001

---------------------------------------------------------------------
---------------------------------------------------------------------
---------------------------------------------------------------------

Section-2 : TESTING SILENT LOGIN ON LOCALHOST
---------------------------------------------------------------
1) In the eWallet project, open file <project_name>/web/WEB-INF/o2finance.xml and

comment out -  <import resource="o2finance-business.xml"/>
un-comment  -  <import resource="o2finance-business-test.xml"/>

2) Do a fresh build.

3) Ensure that the application.properties (/usr/o2/wlapp/wlappdomain/properties/finance) file in your local WebLogic application server's classpath contains the following properties -

    o2.login.new.user.url=http://localhost:8080/finance/loginSilently.do
    o2.login.new.user.return.url=http://localhost:8080/finance/newUserLoginCheck.do
    o2.login.new.user.failure.url=http://localhost:8080/finance/newUserLoginCheck.do
    
4) Deploy application to WebLogic.
 
5) Access eWallet landing page as follows - http://localhost:8080/finance/inititate.do?productid=1001