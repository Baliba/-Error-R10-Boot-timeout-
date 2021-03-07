# -Error-R10-Boot-timeout- please edit this code to see it completely
watch my video on youtube : https://www.youtube.com/watch?v=7--PIqUrkYw
1) check the procfile add code 
 
        web java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
        JAVA_TOOL_OPTIONS -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8
        
3) check the AppApplication do everything correctly
Extends app to SpringBootServletInitializer
add this method
  @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(BysAppApplication.class);
   }
   
4) pom file add plugin NB: heroku as a plugin for Jar APP and one for WAR app if you have add the plugin for JAR app replace to this 
     <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals><goal>copy</goal></goals>
                    <configuration>
                        <artifactItems>
                            <artifactItem>
                                <groupId>com.heroku</groupId>
                                <artifactId>webapp-runner</artifactId>
                                <version>9.0.41.0</version>
                                <destFileName>webapp-runner.jar</destFileName>
                            </artifactItem>
                        </artifactItems>
                    </configuration>
                </execution>
            </executions>
        </plugin>
     dont forget to add this in the pom.xml 
  	 <packaging>war</packaging>
     please check the pom.xml file to see a sample
     
     On heruko dont forget to check the resources and see if those lines are enable to do that click on the pencil's icon and open them .
     
        web java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
        JAVA_TOOL_OPTIONS -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8
     
     To finish dont forget to check the run properties configuration it must be on JRE
