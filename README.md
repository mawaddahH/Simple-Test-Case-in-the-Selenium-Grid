# Simple-Test-Case-in-the-Selenium-Grid
Assignment 2 W10D4- SDA - Software QA Bootcamp

# Table of contents
* [Question](#question)
* [Answer With Output Screenshots](#answer-with-output-screenshots)
  * [Set up](#set-up)
  * [STEP 1: Chrome browser in selenium grid with desired capabilities.](#step-1--chrome-browser-in-selenium-grid-with-desired-capabilities)
  * [STEP 2: Creating An Instance Of Remotewebdriver.](#step-2--creating-an-instance-of-remotewebdriver)
  * [STEP 3: Create the program to run the test case on the Selenium Grid.](#step-3--create-the-program-to-run-the-test-case-on-the-selenium-grid)


---
# Question
- STEP 1: Chrome browser in selenium grid with desired capabilities.
- STEP 2: Creating An Instance Of Remotewebdriver.
- STEP 3: Create the program to run the test case on the Selenium Grid.

---

# Answer With Output Screenshots
## Set up
before running the code, there are some steps that need to take considered:

### First:
Setup:
- [JDK](https://www.oracle.com/java/technologies/downloads/) (Lastest)
- [Eclipse](https://www.eclipse.org/) (Lastest)

Donwload the necessary jar files:
- [Selenium](https://www.selenium.dev/downloads/) (Lastest).
- [TestNG](http://www.java2s.com/Code/Jar/t/Downloadtestng685jar.htm) (Lastest).

### Second:
Add them as a library in the classpath of the project
- _click-reight on the file project >Build path > configure Bild path > Java Build Path > Libraries > classpath > add external JARs > Apply and close_.

### Third:
Setting Up Selenium Grid in the Command Line

1. Add the chrome web driver in the Environment Variable

- _Environment Variable--> system variable--> Path-->Add the driver path_

My path was: C:\Users\lo0ol\Downloads\Compressed\chromedriver_win32_2\

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185756634-6460ebbb-b680-4cd8-a2cd-5c987d32133b.png" width=30% height=30%>
</p>

2. Add the selenium file in the same folder of the chrome web driver.
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185756677-650c83ce-f21b-48ec-bd66-49d5256d5b66.png" width=50% height=50%>
</p>


3. Open CMD then write this line
```md
java -jar selenium-server-4.4.0.jar standalone
```

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185755999-f5eb2050-fa27-417c-926f-e75a6f776fb3.png" width=80% height=80%>
</p>


---

## STEP 1: Chrome browser in selenium grid with desired capabilities.
In this step, I used `DesiredCapabilities`

```md
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
```

---

## STEP 2: Creating An Instance Of Remotewebdriver.
In this step, I used `RemoteWebDriver`

For the following code add your URL
```md
driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444"), cap);
```

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185756273-f87cf0b8-d709-4b43-9cb8-5b54f8c25268.png" width=80% height=80%>
</p>

The final code
```md
@BeforeSuite
public void chromepage() throws MalformedURLException {
	// set configuration
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("platformName", "Windows");
	cap.setCapability("se:name", "My simple test"); 
	cap.setCapability("se:sampleMetadata", "Sample metadata value"); 
	cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
	//RemoteWebDriver
	driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444"), cap);

	// open codingdojo website
	driver.get("https://www.codingdojo.com");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
}
```

---

## STEP 2: Create the program to run the test case on the Selenium Grid
In this step, I used [yahoo](https://login.yahoo.com) website.

The final code
```md
@Test
public void verifyYahooPageTitle() {
	// open yahoo page
	System.out.println(" Browse yahoo home page ");
	driver.navigate().to("https://login.yahoo.com");
	String strPageTitle = driver.getTitle();
	System.out.println(" Verifying yahoo homepage title ");
	Assert.assertTrue(true, "Yahoo");
	System.out.println(" Yahoo homepage title match. **");
}
```
 
 ### The Code Run:
<p align="center">

<img src="https://user-images.githubusercontent.com/48597284/185757122-2e90af40-c582-4c12-8641-4402bec2d0db.png" width=80% height=80%>

https://user-images.githubusercontent.com/48597284/185757190-cb8142f2-b677-4ca3-b3a5-b245de046018.mp4

</p>
