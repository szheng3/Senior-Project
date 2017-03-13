# SeniorProject
Made by Team55 Advisor: Prof. Homayoun Yousefi'zadeh

Prerequement:


To simulate the website, below are required:

1. Java JDK 1.7
    Can be downloaded from webite: 
    http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html
    ![Screenshot](https://cloud.githubusercontent.com/assets/23114334/21918854/6b1d50d8-d90a-11e6-9f40-eef8acdaa23f.png)

2. IntelliJ [Ultimate] Edition, which is cross platform IDEA and could be used in Windows, Mac, Linux system
    Can be acquired using student account and download at:
    https://www.jetbrains.com/idea/

3. JBoss Environment 7.1.1
    Can be downloaded from website:
    http://jbossas.jboss.org/downloads/
    ![jbossenvironment](https://cloud.githubusercontent.com/assets/23114334/21919583/42a63984-d910-11e6-8c73-55208d2566fa.png)

Usage:


With above preparation done, simulate the website with following steps:


1.  Open IntelliJ IDEA, Click "Import Project".
    ![idea_00](https://cloud.githubusercontent.com/assets/23114334/21919800/08b9a5f6-d912-11e6-8427-1ae2bb9c61ad.png)

2.  Choose the Project folder you've saved to, click "OK".
    below is the example location that I used.
    ![idea_01](https://cloud.githubusercontent.com/assets/23114334/21919819/211a6b30-d912-11e6-9244-00bc0618fbdc.png)

3.  Choose Maven, click "next"
    ![idea_02](https://cloud.githubusercontent.com/assets/23114334/21919879/6f392626-d912-11e6-8b04-2001fc08cf5d.png)

4.  Check the box in front of "Import Maven projects automatically"
    ![idea_03](https://cloud.githubusercontent.com/assets/23114334/21919891/7994532a-d912-11e6-9a75-805b9716a0c4.png)
    ![idea_03a](https://cloud.githubusercontent.com/assets/23114334/21919910/8a92d57a-d912-11e6-9930-04006ef44fea.png)

5.  Click "next"

    ![idea_04](https://cloud.githubusercontent.com/assets/23114334/21919931/c58e097e-d912-11e6-8822-9a404d35cdde.png)

6.  Click the "+" bottom, choose "JDK"
    ![idea_05](https://cloud.githubusercontent.com/assets/23114334/21919942/dca1076a-d912-11e6-801a-17ed260b9d14.png)

7.  Choose the jdk 1.7 file folder you saved to.
    below is the example location of my jdk 1.7.0_80
    ![idea_06](https://cloud.githubusercontent.com/assets/23114334/21919952/eed99938-d912-11e6-9c19-124d4f84600f.png)

8.  Click "OK"

    ![idea_07](https://cloud.githubusercontent.com/assets/23114334/21919969/0cc8142e-d913-11e6-9b96-fbda02c7766d.png)

9.  Click "finish"

    ![idea_08](https://cloud.githubusercontent.com/assets/23114334/21919980/20e515f6-d913-11e6-9d35-8815033c9a4b.png)

10. On the top right corner, click the second icon, press "Edit Configurations"
    ![idea_09](https://cloud.githubusercontent.com/assets/23114334/21919988/2d9a51d0-d913-11e6-97ed-d0be819947b7.png)

11. Click the "+" bottom, choose JBoss Server - Local.
    Note that if you are using Community version of IntelliJ, you won't have this option.
    So make sure you are using the Ultimate version.
    ![idea_10](https://cloud.githubusercontent.com/assets/23114334/21920019/5a8656c6-d913-11e6-8996-8f0a0bb71358.png)

    To Run MachineLearning, add VM Option in IntelliJ.

12.  In Build Config, click the highlighted icon, as shown:

    ![vm0](https://cloud.githubusercontent.com/assets/23114334/23767571/da1a8ce2-04bd-11e7-82fd-e8d9a6343b19.png)

13.  Copy and paste VM Option, click "OK"

    -Xms1g
    -Xmx1g
    -XX:MaxPermSize=2g
    -Djava.net.preferIPv4Stack=true
    -Dorg.jboss.resolver.warning=true
    -Dsun.rmi.dgc.client.gcInterval=3600000
    -Dsun.rmi.dgc.server.gcInterval=3600000
    -Djboss.modules.system.pkgs=org.jboss.byteman
    -Djava.awt.headless=true
    -Djboss.server.default.config=standalone.xml
    -XX:-UseSplitVerifier

    ![vm1](https://cloud.githubusercontent.com/assets/23114334/23767580/e227a0a0-04bd-11e7-8a43-8aaaf32ef661.png)

    now you should be able to run Machine Learning algorithm.

14. This should be the window you see after previous step.
    Click "Deployment", and click the "+" bottom on the right, choose "Artifact..."
    ![idea_11](https://cloud.githubusercontent.com/assets/23114334/21920052/8a761de4-d913-11e6-9e24-20df17d85cd4.png)
    ![idea_12](https://cloud.githubusercontent.com/assets/23114334/21920071/a6ef5792-d913-11e6-9e01-ad5328e1e229.png)

15. Choose "SeniorProject:war", click "OK"

    ![idea_13](https://cloud.githubusercontent.com/assets/23114334/21920081/c1ce90f0-d913-11e6-97ba-89f848cde10e.png)

16. Click "OK"
    ![idea_14](https://cloud.githubusercontent.com/assets/23114334/21920095/d17f8e96-d913-11e6-99f8-d70cced705b4.png)

17. At the top right corner of the main window, click the left most icon to build your project.
    Then click the third bottom which looks like a green play bottom,
    and wait for just a sec IntelliJ should be opening your website for you automatically.
    Shown below is the opened demo version of our project.
    ![idea_15](https://cloud.githubusercontent.com/assets/23114334/21920107/e08af6f0-d913-11e6-8239-181c1ef59467.png)
    ![idea_16](https://cloud.githubusercontent.com/assets/23114334/21920157/27013ed2-d914-11e6-923d-1146084bdcfd.png)

To run our Project in JBoss Environment,
first we need to add 2 .jar files as lib in IntelliJ.
Following below steps to set up lib.

18.  in IntelliJ top left corner, File - Project Structure
    ![lib00](https://cloud.githubusercontent.com/assets/23114334/22007888/412ea442-dc2b-11e6-88b2-76573bdc7095.png)


19.  go to Libraries - click "+" - Java
    ![lib01](https://cloud.githubusercontent.com/assets/23114334/22007922/92b585c4-dc2b-11e6-8f68-52fe782c3e38.png)


20.  Choose the Obfuscation .jar file, it's located in:
    {Project root location}/src/main/webapp/WEB-INF/lib
    Click "OK"

   ![lib02r1](https://cloud.githubusercontent.com/assets/23114334/23768142/e07a3aa4-04bf-11e7-9333-4c5599678787.png)


21.  Click "OK" to add this library as module

   ![lib02r2](https://cloud.githubusercontent.com/assets/23114334/23768153/e87733d8-04bf-11e7-869b-e6986f858cd7.png)


do the same for mysql-connector-java-5.1.40.jar, located at the same location. 

22.  now it should be all done.
    Check Libraries we can see a new 3rd party lib "obfuscation" and "mysql-connector-java-5.1.40" are added

   ![lib03r](https://cloud.githubusercontent.com/assets/23114334/23768268/540ae522-04c0-11e7-9315-7d43cc9764e1.png)


23.  Check Modules, a new "obfuscation" and jdbc module is added.

   ![lib04r](https://cloud.githubusercontent.com/assets/23114334/23768327/750e9480-04c0-11e7-8931-4ca14c1ce12b.png)


24.  Now we should be able to run the project in JBoss Environment.
    Click the run bottom, project will be built and IntelliJ will automatically open the website for us:
    Shown is the first page you will see using our website, it's a log-in windows.
    Authentication prevents use of website without login. 
    Now create your account and start explore our project website!
    
    
   ![demo0](https://cloud.githubusercontent.com/assets/23114334/23768508/2224b712-04c1-11e7-9727-006269a25ea8.png)

   ![demo2](https://cloud.githubusercontent.com/assets/23114334/23768525/371fde80-04c1-11e7-9a32-5dd3167113b1.png)
    
   ![demo1](https://cloud.githubusercontent.com/assets/23114334/23768516/2b870d78-04c1-11e7-9142-d622a6eb12c7.png)
    
   ![demo3](https://cloud.githubusercontent.com/assets/23114334/23768535/3c7ad3d0-04c1-11e7-9e3f-ecbb430373ba.png)
    
   ![demo5](https://cloud.githubusercontent.com/assets/23114334/23770123/ad4a5bee-04c6-11e7-80df-389dafc38d92.png)

   The sample input file for our Machine Learning algorithm is located at:
    src\main\webapp\WEB-INF\lib
    
    
   # References:
    
   deeplearning4j:https://deeplearning4j.org/