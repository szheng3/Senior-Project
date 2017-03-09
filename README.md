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

12. This should be the window you see after previous step.
    Click "Deployment", and click the "+" bottom on the right, choose "Artifact..."
    ![idea_11](https://cloud.githubusercontent.com/assets/23114334/21920052/8a761de4-d913-11e6-9e24-20df17d85cd4.png)
    ![idea_12](https://cloud.githubusercontent.com/assets/23114334/21920071/a6ef5792-d913-11e6-9e01-ad5328e1e229.png)

13. Choose "SeniorProject:war", click "OK"

    ![idea_13](https://cloud.githubusercontent.com/assets/23114334/21920081/c1ce90f0-d913-11e6-97ba-89f848cde10e.png)

14. Click "OK"
    ![idea_14](https://cloud.githubusercontent.com/assets/23114334/21920095/d17f8e96-d913-11e6-99f8-d70cced705b4.png)

15. At the top right corner of the main window, click the left most icon to build your project.
    Then click the third bottom which looks like a green play bottom,
    and wait for just a sec IntelliJ should be opening your website for you automatically.
    Shown below is the opened demo version of our project.
    ![idea_15](https://cloud.githubusercontent.com/assets/23114334/21920107/e08af6f0-d913-11e6-8239-181c1ef59467.png)
    ![idea_16](https://cloud.githubusercontent.com/assets/23114334/21920157/27013ed2-d914-11e6-923d-1146084bdcfd.png)

To run our Obfuscated .jar file in JBoss Environment,
first we need to add the Obfuscated .jar file as lib in IntelliJ.
Following below steps to set up lib.

1.  in IntelliJ top left corner, File - Project Structure
    ![lib00](https://cloud.githubusercontent.com/assets/23114334/22007888/412ea442-dc2b-11e6-88b2-76573bdc7095.png)


2.  go to Libraries - click "+" - Java
    ![lib01](https://cloud.githubusercontent.com/assets/23114334/22007922/92b585c4-dc2b-11e6-8f68-52fe782c3e38.png)


3.  Choose the Obfuscated .jar file, it's located in:
    {Project root location}/src/main/webapp/WEB-INF/lib
    Click "OK"
    ![lib02](https://cloud.githubusercontent.com/assets/23114334/22007943/a929c69e-dc2b-11e6-9060-c22cc271be33.png)


4.  Click "OK" to add this library as module

    ![lib02a](https://cloud.githubusercontent.com/assets/23114334/22007977/d62900ec-dc2b-11e6-93df-a972eea535ee.png)


5.  now it should be all done.
    Check Libraries we can see a new 3rd party lib "obfuscated" is added
    ![lib03](https://cloud.githubusercontent.com/assets/23114334/22007980/de071826-dc2b-11e6-82cf-d8031823ee76.png)


6.  Check Modules, a new "obfuscated" module is added.
    ![lib04](https://cloud.githubusercontent.com/assets/23114334/22008002/01432096-dc2c-11e6-9aa3-496308740cbf.png)


7.  Now we should be able to run the Obfuscated .jar in JBoss Environment.
    Click the run bottom, project will be built and IntelliJ will automatically open the website for us:
    Click "Choose File" bottom
    ![web0](https://cloud.githubusercontent.com/assets/23114334/22008047/5f32a3de-dc2c-11e6-8a25-58f33fe3fbd5.png)


8.  A window will pop up.
    The test .jar is a java program which calls Johnsons's Algorithm to sort a given graph.
    Let's select the data text file for the graph, as shown below:
    (it is stored in the root folder of this project)
    Click "Open" johnsonsGraphData.txt
    ![web1](https://cloud.githubusercontent.com/assets/23114334/22008088/b894db18-dc2c-11e6-948c-8c3a585d556d.png)


9.  Click "upload"
    ![web2](https://cloud.githubusercontent.com/assets/23114334/22008106/de45efb4-dc2c-11e6-8430-86ec0fec16da.png)


10. It will upload the data .txt file and Obfuscated Johnson's Algorithm will run.
    If it runs successfully, the output will be displayed as a table.
    ![web3](https://cloud.githubusercontent.com/assets/23114334/22008140/28d09ab6-dc2d-11e6-83ba-a97650b6b4c8.png)

To use DataBase, set MySQL as following:

0.  addr = "localhost"
1.  port = "3306"
2.  username = "root"
3.  pw = "123456"
4.  make sure a DB "test" is in the list.

Add JDBC ver 5.1.40 as lib, it's stored in wepapp/WEB-INF/lib in the project folder.
Make sure in your IntelliJ Project Structures you see it in BOTH Modules and Libraries. As below:
    ![mysql0](https://cloud.githubusercontent.com/assets/23114334/22181524/37de19a6-e043-11e6-8b98-aa67efa38635.png)
    ![mysql1](https://cloud.githubusercontent.com/assets/23114334/22181528/47aa2c6c-e043-11e6-8d8c-914f4d6497fe.png)


To Run MachineLearning, add VM Option in IntelliJ.

0.  In Build Config, click the highlighted icon, as shown:



1.  Copy and paste VM Option, click "OK"

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


now you should be able to run Machine Learning algorithm.