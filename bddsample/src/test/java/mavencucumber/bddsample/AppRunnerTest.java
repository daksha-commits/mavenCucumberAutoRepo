package mavencucumber.bddsample;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	
@RunWith(Cucumber.class)
@CucumberOptions( 
		  monochrome=true,
		  //dryRun=true,
		  glue= { "mavencucumber.bddsample.stepdefinitions"}, 
		  features= {"classpath:feature"},
		  plugin={"pretty", "html:target/bddsample-htmlreport",
		  		  "json:target/bddsample-jason"//,
		  		//"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
		  		  } 
		  )
 
public class AppRunnerTest 
{



}
