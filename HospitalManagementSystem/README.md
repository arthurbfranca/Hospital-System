# Super Basic Login/Register Web Project

## Getting Set Up
> I had to download the Java EE IDE to be able to create dynamic web projects in Eclipse (I don't think regular Eclipse has this funcionality). This version of Eclipse can be downloaded here: https://www.eclipse.org/downloads/packages/release/2019-12/r/eclipse-ide-enterprise-java-developers.<br/>
> I also used Apache Tomcat to run the web app. This can be downloaded here: https://tomcat.apache.org/download-90.cgi. I downloaded both the Core Binary Distribution and the Source Code Distribution.
> This video was very helpful for getting Tomcat configured in Eclipse: https://www.youtube.com/watch?v=R7DlcnrXfYE.

## Using the Application
1. Once you have Tomcat configured and you've got the project loaded into Eclipse, you can now run the application. <br/>
2. Right click on the project and then click Run As > Run on Server >  <br/>
3. The webpage should open as a new tab in your default web browser, but you can also access it manually at http://localhost:8080/HospitalManagementSystem/. <br/>
4. You will be shown a login page at which you can enter a username and password. <br/>
> Currently, the system doesn't have any database of users so it will accept any entries and will welcome the user by their username. <br/>
5. If you click the Registration link at the bottom right, you will be taken to a registration page.
> Currently, the only authentication is checking that the two passwords entered match. Different account types are not yet taken into account. <br/>

Note: I would like to look into the possibility of exporting the project from Eclipse as a WAR file and deploying the war file to Tomcat so that users can access the web app without having to download all these files and run it through Eclipse.

## General System Execution
1. When you run the system, execution begins in the *web.xml* file.
> The welcome-file-list tag tells the system to set *login.jsp* as the welcome file, so the login page is loaded as the welcome page.
2. This login page (login.jsp) consists of a login form (note the form tag: form action="login" method="post").
> When the user hits submit, the system will do the "login" action that was defined in the web.xml file.
> This action passes control over to *LoginServlet.java*, which grabs the information from the user request and displays a confirmation message.
3. If you go back to the login/welcome page, a very similar thing happens with the registration.
