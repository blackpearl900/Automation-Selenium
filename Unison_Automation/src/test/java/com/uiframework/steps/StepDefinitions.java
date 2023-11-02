package com.uiframework.steps;

import com.uiframework.common.Base;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.Select;

public class StepDefinitions extends Base {


    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Thread.sleep(2000);
    }

    @When("User enter invalid username")
    public void user_enter_invalid_username() {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("umair");
    }

    @When("User enter valid username")
    public void user_enter_valid_username() throws IOException {
        PropsFunction();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("username"));
    }

    @And("User enter valid password")
    public void user_enter_valid_password() throws IOException {
        PropsFunction();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
    }

    @And("User enter invalid password")
    public void user_enter_invalid_password() {
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("umair");
    }

    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(login_btn).click();
        Thread.sleep(3000);
    }

    @Then("User should not be redirected to Unison Dashboard")
    public void user_should_not_be_redirected_to_unison_dashboard() {
        if (driver.findElement(error_msg).isDisplayed()) {
            assertEquals("Username or password incorrect", driver.findElement(error_msg).getText());
        } else {
            System.out.println("Error message of incorrect credentials not displayed");
        }
    }

    @Then("User should be redirected to Unison Dashboard")
    public void user_should_be_redirected_to_unison_dashboard() throws IOException, InterruptedException {
        driver.findElement(click_on_Dashboard).click();

    }

    @Then("User navigates to the Email Management module")
    public void user_navigates_to_the_email_management_module() throws InterruptedException {
        WebElement emailClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("div.navbarMain:nth-child(2) div.navWide div.wideDiv div.ui.mini.secondary.stackable.navigation-bar.menu > a.item:nth-child(11)")));
        emailClick.click();
        Thread.sleep(2000);
    }

    @When("User navigates to compose email")
    public void user_navigates_to_compose_email() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(compose_btn));
        driver.findElement(compose_btn).click();
    }

    @And("User selects sender email and provide recipients")
    public void user_selects_sender_email_and_provide_recipients() throws InterruptedException {
        driver.findElement(sender).click();
        Thread.sleep(1000);
        driver.findElement(sender).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(sender).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement recipient = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Recipients']")));
        recipient.click();
        recipient.sendKeys("umair.dastagir@avanzasolutions.com");
    }

    @And("User enters the subject and body of the email")
    public void user_enters_the_subject_and_body_of_the_email() throws InterruptedException {
        driver.findElement(subject).sendKeys("Email Composition Test Automation");
        Thread.sleep(1000);
        driver.findElement(email_body).sendKeys(body);
    }

    @Then("User selects the email template and sends the email")
    public void user_selects_the_email_template_and_sends_the_email() throws InterruptedException {
        driver.findElement(template).click();
        Thread.sleep(1000);
        driver.findElement(select_temp).click();
        Thread.sleep(1000);
        driver.findElement(send_btn).click();
        Thread.sleep(4000);
        String text = driver.findElement(By.className("top-right")).getText();

        if (text.contains("successfully"))
            System.out.println("**** Email successfully sent to the user **** ");
        else
            System.out.println("Email not sent");
        System.out.println("                ");
    }

    @Then("User navigates to the sent emails and verify if the email was sent or not")
    public void user_navigates_to_the_sent_emails_and_verify_if_the_email_was_sent_or_not() throws InterruptedException {

        driver.findElement(sentbox_btn).click();
        Thread.sleep(2000);
        driver.findElement(select1stcheckbox).click();
        Thread.sleep(2000);
        driver.findElement(open_sent_Email).click();
        Thread.sleep(2000);

        assertEquals(body, driver.findElement(sent_body).getText());
    }


    @When("User selects CNIC from dropdown and enters the CNIC in search box")
    public void user_selects_cnic_from_dropdown_and_enters_the_cnic_in_search_box() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("searchInput")));

        /*driver.findElement(entity_dropdown).click();
        Thread.sleep(2000);*/
        /*driver.findElement(entity_dropdown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(entity_dropdown).sendKeys(Keys.ENTER);
        Thread.sleep(2000);*/
        driver.findElement(By.name("searchInput")).sendKeys("1234567890123");
        Thread.sleep(1000);
    }

    @And("User attempts to search that CNIC")
    public void user_attempts_to_search_that_CNIC() throws InterruptedException {
        driver.findElement(By.name("searchInput")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @And("User closes the active session if there is one already")
    public void userClosesTheActiveSessionIfThereIsOneAlready() throws InterruptedException {

Thread.sleep(3000);


        String value = driver.findElement(session_value).getText();

        if (value.contains("1")) {
            driver.findElement(session_btn).click();
            Thread.sleep(1000);
            driver.findElement(show_btn).click();
            Thread.sleep(1000);
            driver.findElement(end_session).click();
            Thread.sleep(1000);
        }
    }

    @Then("Search results should return the customer details")
    public void search_results_should_return_the_customer_details() {
        String text = driver.findElement(By.className("top-right")).getText();
        if (text.contains("No result")) {
            System.out.println("No data found against the user");
        } else {
            System.out.println("Customer Search Success");
        }
    }

    @When("User validates the questionnaire")
    public void user_validates_the_questionnaire() throws InterruptedException {
        driver.findElement(radio1).click();
        //Thread.sleep(1000);
        driver.findElement(radio2).click();
        //Thread.sleep(1000);
        driver.findElement(radio3).click();
        //Thread.sleep(1000);
        //driver.findElement(radio4).click();
        //Thread.sleep(2000);
        driver.findElement(btn_validate).click();
        Thread.sleep(3000);
    }

    @Then("The details of customer should be shown to user")
    public void The_details_of_customer_should_be_shown_to_user() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ui_segment));

        driver.findElement(ui_segment).click();
        Thread.sleep(4000);
        String validateurl = driver.getCurrentUrl();
        System.out.println(validateurl);
        if (validateurl.contains("CUSTOMERS_HUB_MAIN")) {
            System.out.println("Details successfully shown");
        } else {
            Assert.fail("Details of customer not shown to the user");
        }
    }

    @When("User is on the Service Request Page")
    public void userIsOnTheServiceRequestPage() throws InterruptedException {
        WebElement SRClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("#root > div:nth-child(1) > div > div:nth-child(1) > div.navbarMain > div.navWide > div > div > a:nth-child(3)")));
        SRClick.click();
        Thread.sleep(2000);
    }

    @And("The execution report is sent to the designated email of stakeholders")

    @And("User enters a service no in the search bar and search")
    public void userEntersAServiceNoInTheSearchBarAndSearch() throws InterruptedException {
        driver.findElement(By.id("filterText")).sendKeys(SR);
        Thread.sleep(1000);
        driver.findElement(By.id("filterText")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @Then("search results should return that SR")
    public void searchResultsShouldReturnThatSR() throws InterruptedException {
        assertEquals(SR, driver.findElement(first_SR).getText());
        Thread.sleep(1000);
        driver.findElement(first_SR).click();
        Thread.sleep(2000);
    }

    @When("User is on the Cases page")
    public void userIsOnTheCasesPage() throws InterruptedException {
        WebElement casesClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("#root > div:nth-child(1) > div > div:nth-child(1) > div.navbarMain > div.navWide > div > div > a:nth-child(4)")));
        casesClick.click();
        Thread.sleep(2000);
    }

    @And("User enter a case no in the search bar and search")
    public void userEnterACaseNoInTheSearchBarAndSearch() throws InterruptedException {
        driver.findElement(By.id("filterText")).sendKeys(caseNo);
        Thread.sleep(1000);
        driver.findElement(By.id("filterText")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @Then("Search results should return that Case")
    public void searchResultsShouldReturnThatCase() throws InterruptedException {
        assertEquals(caseNo, driver.findElement(first_case).getText());
        Thread.sleep(1000);
        driver.findElement(first_case).click();
        Thread.sleep(2000);
    }

    @When("User is on the Leads page")
    public void userIsOnTheLeadsPage() throws InterruptedException {
        WebElement leadsClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("#root > div:nth-child(1) > div > div:nth-child(1) > div.navbarMain > div.navWide > div > div > a:nth-child(5)")));
        leadsClick.click();
        Thread.sleep(2000);
    }

    @And("User navigates to the Add Lead option")
    public void userNavigatesToTheAddLeadOption() throws InterruptedException {
        driver.findElement(req_lead_btn).click();
        Thread.sleep(2000);
    }

    @And("User enters the required details and search for customer")
    public void userEntersTheRequiredDetailsAndSearchForCustomer() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("HOME_CITY")));

        driver.findElement(By.id("HOME_CITY")).sendKeys("Dubai");
        Thread.sleep(1000);
        driver.findElement(lead_search_btn).click();
        Thread.sleep(2000);
    }

    @And("User selects the customer and proceeds to the next screen")
    public void userSelectsTheCustomerAndProceedsToTheNextScreen() throws InterruptedException {
        //WebElement arrowbtn = driver.findElement(By.xpath("//*[@id=\"myGrid\"]/div/div/div[4]/span[2]/div[3]/button"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(first_customer));

        driver.findElement(first_customer).click();
        Thread.sleep(1000);
        driver.findElement(next_btn).click();
        Thread.sleep(3000);
    }

    @And("User enters the required details for the creation of a new Lead and save it")
    public void userEntersTheRequiredDetailsForTheCreationOfANewLeadAndSaveIt() throws InterruptedException {
        driver.findElement(By.id("CUST_CALLBACK_PHONE")).sendKeys("03428026506");
        Thread.sleep(1000);
        driver.findElement(By.id("APPOINTMENT_DATE")).sendKeys("06-Jun-2023 00:55:00");
        Thread.sleep(1000);

        WebElement field = driver.findElement(By.id("REF_LEAD_NUM"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", field);

        driver.findElement(branch).click();
        Thread.sleep(1000);
        driver.findElement(select_branch).click();
        Thread.sleep(1000);
        driver.findElement(product).click();
        Thread.sleep(1000);
        driver.findElement(select_product).click();
        Thread.sleep(1000);

        WebElement field2 = driver.findElement(By.id("CUST_MOBILE_NUM"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView();", field2);

        driver.findElement(By.id("CUST_MOBILE_NUM")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("CUST_MOBILE_NUM")).sendKeys("123456789");
        Thread.sleep(3000);
        driver.findElement(lead_save_btn).click();
        Thread.sleep(3000);
    }

    @Then("The lead should be created")
    public void theLeadShouldBeCreated() {
        String text = driver.findElement(By.className("top-right")).getText();
        if (text.contains("successfully")) {
            System.out.println("Lead creation successfully");
        } else {
            System.out.println("Lead creation was not successful");
        }
    }

    @When("User navigates to the new SR button")
    public void userNavigatesToTheNewSRButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(req_btn));

        WebElement field = driver.findElement(req_btn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", field);

        driver.findElement(req_btn).click();
        Thread.sleep(1000);
    }

    @And("User selects the request they want to make from list")
    public void userSelectsTheRequestTheyWantToMakeFromList() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toggle1));

        driver.findElement(SR_search).sendKeys("Account opening");
        Thread.sleep(1000);

        driver.findElement(toggle1).click();
        Thread.sleep(1000);
        //driver.findElement(toggle2).click();
        //Thread.sleep(1000);
        //driver.findElement(toggle3).click();
        //Thread.sleep(1000);
        /*driver.findElement(SR_val).click();
        Thread.sleep(1000);*/
        driver.findElement(nextSR_btn).click();
        Thread.sleep(1000);
    }

    @And("User enters all of the required details and save")
    public void userEntersAllOfTheRequiredDetailsAndSave() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CUST_CALLBACK_PHONE")));

        driver.findElement(By.id("CUST_CALLBACK_PHONE")).sendKeys("03428026506");
        Thread.sleep(1000);

        WebElement field = driver.findElement(By.id("CNIC"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", field);

        driver.findElement(By.id("CNIC")).sendKeys("5440032148751");
        Thread.sleep(1000);
        /*driver.findElement(By.id("PO_BOX")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("CUST_MOBILE_NUM")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("CUST_MOBILE_NUM")).sendKeys("2025550141");
        Thread.sleep(1000);
        driver.findElement(By.id("MOBILE_NUM")).sendKeys("2025550141");
        Thread.sleep(1000);
        driver.findElement(By.id("RES_TEL_NUM")).clear();
        driver.findElement(By.id("RES_TEL_NUM")).sendKeys("2025550141");
        Thread.sleep(1000);*/
        driver.findElement(saveSR_btn).click();
        Thread.sleep(2000);
    }

    @Then("The newly created SR should be shown in the list")
    public void theNewlyCreatedSRShouldBeShownInTheList() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        Date date = new Date();
        String date1 = dateFormat.format(date);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(created_on));

        String createdOn = driver.findElement(created_on).getText();
        if (createdOn.contains(date1)) {
            System.out.println("SR created successfully");
        } else {
            Assert.fail("SR creation not successful");
        }
    }

    @When("User navigates to the Cases tab and clicks on the new Case Request button")
    public void userNavigatesToTheCasesTabAndClicksOnTheNewCaseRequestButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        //scrolling to see cases tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated(click_on_case_in_customer_hub));
        driver.findElement(click_on_case_in_customer_hub).click();
        Thread.sleep(1000);
    }

    @And("User enters all of the required details for a Case and save")
    public void userEntersAllOfTheRequiredDetailsForACaseAndSave() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CUST_CALLBACK_PHONE")));

        driver.findElement(By.id("CUST_CALLBACK_PHONE")).sendKeys("03428026506");
        Thread.sleep(1000);
        driver.findElement(saveCase_btn).click();
        Thread.sleep(3000);
    }

    @When("User navigates to the Leads tab and clicks on the new Lead Request button")
    public void userNavigatesToTheLeadsTabAndClicksOnTheNewLeadRequestButton() throws InterruptedException {
        WebElement leadsClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/h3/div/a[3]")));
        leadsClick.click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(req_btn));

        driver.findElement(req_btn).click();
        Thread.sleep(1000);
    }

    @And("User enters all of the required details for a Lead and save")
    public void userEntersAllOfTheRequiredDetailsForALeadAndSave() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CUST_CALLBACK_PHONE")));

        driver.findElement(By.id("CUST_CALLBACK_PHONE")).sendKeys("03428026506");
        Thread.sleep(1000);
        driver.findElement(By.id("APPOINTMENT_DATE")).sendKeys("06-Jun-2023 00:55:00");
        Thread.sleep(1000);

        driver.findElement(branch).click();
        Thread.sleep(1000);
        driver.findElement(select_branch).click();
        Thread.sleep(1000);
        driver.findElement(product).click();
        Thread.sleep(1000);
        driver.findElement(select_product).click();
        Thread.sleep(1000);

        WebElement field = driver.findElement(lead_save_btn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", field);

        driver.findElement(lead_save_btn).click();
        Thread.sleep(3000);

        driver.navigate().refresh();

        WebElement leadsClick = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/h3/div/a[3]")));
        leadsClick.click();
    }

    @Then("The newly created Lead should be shown in the list")
    public void theNewlyCreatedLeadShouldBeShownInTheList() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        Date date = new Date();
        String date1 = dateFormat.format(date);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(created_on));

        String createdOn = driver.findElement(created_on).getText();

        if (createdOn.contains(date1)) {
            System.out.println("Lead created successfully");
        } else {
            Assert.fail("Created Lead is not shown in the list");
        }
    }

    @When("User enter valid username of user to whom SR has been assigned")
    public void userEnterValidUsernameOfUserToWhomSRHasBeenAssigned() {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("saadahmed");
    }

    @And("User navigates to the Agent Desktop")
    public void userNavigatesToTheAgentDesktop() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(agnt_dsktp));

        driver.findElement(agnt_dsktp).click();
        Thread.sleep(1000);
    }

    @When("User navigates to the recently saved SR")
    public void userNavigatesToTheRecentlySavedSR() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(first_SR_val));

        driver.findElement(first_SR_val).click();
        Thread.sleep(1000);
    }

    @And("User changes the status of SR from initiated to assigned")
    public void userChangesTheStatusOfSRFromInitiatedToAssigned() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_assigned));

        driver.findElement(btn_assigned).click();
        Thread.sleep(1000);
        driver.findElement(btn_mark).click();
        Thread.sleep(1000);
        driver.findElement(roles_drop).click();
        Thread.sleep(1000);
        driver.findElement(roles_select).click();
        Thread.sleep(1000);
        driver.findElement(units_drop).click();
        Thread.sleep(1000);
        driver.findElement(units_select).click();
        Thread.sleep(1000);
        driver.findElement(users_drop).click();
        Thread.sleep(1000);
        driver.findElement(users_select).click();
        Thread.sleep(1000);
        driver.findElement(notes).sendKeys("Service Request Assignment Through Test Automation");
        Thread.sleep(1000);
        driver.findElement(btn_doneSR).click();
        Thread.sleep(1000);
    }

    @And("User logs out and logs in with the assigned SR user")
    public void userLogsOutAndLogsInWithTheAssignedSRUser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile_btn));

        driver.findElement(profile_btn).click();
        Thread.sleep(1000);
        driver.findElement(btn_logout).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("testuser1");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/form/div/button")).click();
        Thread.sleep(2000);
    }

    @And("User logs out and logs in with the assigned case user")
    public void userLogsOutAndLogsInWithTheAssignedcaseUser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile_btn));

        driver.findElement(profile_btn).click();
        Thread.sleep(1000);
        driver.findElement(btn_logout).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("rupal.damani");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/form/div/button")).click();
        Thread.sleep(2000);
    }

    @And("User changes the status of SR from assigned to in progress")
    public void userChangesTheStatusOfSRFromAssignedToInProgress() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_inprogress));

        driver.findElement(btn_inprogress).click();
        Thread.sleep(1000);
        driver.findElement(btn_mark).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(notes_assigned));

        driver.findElement(notes_assigned).sendKeys("Service Request Assignment Through Test Automation");
        Thread.sleep(1000);
        driver.findElement(btn_doneIP).click();
        Thread.sleep(1000);
    }

    @And("User logs out")
    public void userLogsOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile_btn));

        driver.findElement(profile_btn).click();
        Thread.sleep(1000);
        driver.findElement(btn_logout).click();
        Thread.sleep(1000);
    }

    @And("User changes the status of SR from in progress to Done")
    public void userChangesTheStatusOfSRFromInProgressToDone() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_done));

        driver.findElement(btn_done).click();
        Thread.sleep(1000);
        driver.findElement(btn_mark).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(notes_assigned));

        driver.findElement(notes_assigned).sendKeys("Service Request Assignment Through Test Automation");
        Thread.sleep(1000);
        driver.findElement(btn_doneIP).click();
        Thread.sleep(1000);
    }


    @And("User changes the status of SR from Done to Closed")
    public void userChangesTheStatusOfSRFromDoneToClosed() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_closed));

        driver.findElement(btn_closed).click();
        Thread.sleep(1000);
        driver.findElement(btn_mark).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(notes_assigned));

        driver.findElement(notes_assigned).sendKeys("Service Request Closure Through Test Automation");
        Thread.sleep(1000);
        driver.findElement(btn_doneIP).click();
        Thread.sleep(1000);
    }

    @Then("corresponding SR should be closed")
    public void correspondingSRShouldBeClosed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(closed_text));

        String closed = driver.findElement(closed_text).getText();

        if (closed.contains("Closed")) {
            System.out.println("Service Request closed successfully");
        } else {
            Assert.fail("Service Request closure not successful");
        }
    }

    @When("User enter Upper and lower case username")
    public void userEnterUpperAndLowerCaseUsername() throws IOException {
        PropsFunction();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("upperUsername"));
    }

    @And("User enter Upper and lower case password")
    public void userEnterUpperAndLowerCasePassword() throws IOException {
        PropsFunction();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(props.getProperty("upperPassword"));
    }

    @When("User enter invalid credentials greater than the number defined in system")
    public void userEnterInvalidCredentialsGreaterThanTheNumberDefinedInSystem() throws IOException, InterruptedException {
        PropsFunction();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("limitUsername"));
        Thread.sleep(1005);
        Assert.assertEquals("The length for login field exceeds the maximum allowed.\n", driver.findElement(login_vldn_error).getText());
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(props.getProperty("limitPassword"));
        Thread.sleep(1005);  //error messages validation code yet to be added
        Assert.assertEquals("The length for login field exceeds the maximum allowed.\n", driver.findElement(login_vldn_error).getText());
    }


    @And("User click on Service Request Tab")
    public void userClickOnServiceRequestTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SR_tab));

        driver.findElement(SR_tab).click();
        Thread.sleep(1000);
    }

    @Then("Successful Service request tab should be displayed")
    public void successfulServiceRequestTabShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SR_header));

        Assert.assertEquals("SERVICE REQUEST", driver.findElement(SR_header).getText());
    }

    @And("User click on PDF and CSV button")
    public void userClickOnPDFAndCSVButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(csv_btn));

        driver.findElement(csv_btn).click();
        Thread.sleep(1000);
        driver.findElement(pdf_btn).click();
        Thread.sleep(1000);
    }

    @Then("User using PDF and CSV buttons should download a SR file in format of PDF and CSV")
    public void userUsingPDFAndCSVButtonsShouldDownloadASRFileInFormatOfPDFAndCSV() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MMMddyyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);

        PropsFunction();
        String dirPath = props.getProperty("downloadsPath");
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(date1)) {
                    System.out.println("Both CSV and PDF files downloaded and present in the directory");
                    listFile.delete();
                    break;
                }
            }
        }
    }

    @And("Export button should be visible")
    public void exportButtonShouldBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(csv_btn));
    }

    @And("Refresh Button should be visible")
    public void refreshButtonShouldBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rfrsh_btn));
    }

    @And("Service Request Number should be visible")
    public void serviceRequestNumberShouldBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rqst_val_SR));
    }

    @And("Setting Button should be visible")
    public void settingButtonShouldBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(stng_btn));
    }

    @And("Mandatory search fields are Service Request Number, CNIC, Product and Priority etc")
    public void mandatorySearchFieldsAreServiceRequestNumberCNICProductAndPriorityEtc() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rqst_no_search));

        Assert.assertTrue(driver.findElement(rqst_no_search).isDisplayed());
        Assert.assertTrue(driver.findElement(cnic_search).isDisplayed());
        Assert.assertTrue(driver.findElement(prdct_search).isDisplayed());
    }

    @And("User Input valid Service Request Number")
    public void userInputValidServiceRequestNumber() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rqst_no_search));

        driver.findElement(rqst_search).sendKeys(props.getProperty("SRsearch"));
        Thread.sleep(1000);
    }

    @Then("Successful service Request should be searched from Service Request Number")
    public void successfulServiceRequestShouldBeSearchedFromServiceRequestNumber() throws InterruptedException {
        Assert.assertEquals(props.getProperty("SRsearchValid"), driver.findElement(rqst_first).getText());
        Thread.sleep(1000);
    }

    @And("User Input invalid Service Request Number")
    public void userInputInvalidServiceRequestNumber() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rqst_no_search));

        driver.findElement(rqst_search).sendKeys(props.getProperty("SRsearchInvalid"));
        Thread.sleep(1000);
    }

    @Then("Service Request should not be searched from Service Request Number")
    public void serviceRequestShouldNotBeSearchedFromServiceRequestNumber() throws InterruptedException {
        //Assert.assertEquals(props.getProperty("SRsearchValid"), driver.findElement(rqst_first).getText());
        Thread.sleep(1000);
    }

    @And("User Input valid CNIC")
    public void userInputValidCNIC() throws InterruptedException {
        driver.findElement(cnicSearch).sendKeys(props.getProperty("cnicSearch"));
        Thread.sleep(1000);
        driver.findElement(cnicSearch).sendKeys(Keys.ENTER);
    }

    @Then("Successful service Request should be searched from Customer ID \\(CNIC)")
    public void successfulServiceRequestShouldBeSearchedFromCustomerIDCNIC() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cnic_first));

        Assert.assertEquals(props.getProperty("cnicSearch"), driver.findElement(cnic_first).getText());
        Thread.sleep(1000);
    }

    @And("User Input invalid Customer ID \\(CNIC)")
    public void userInputInvalidCustomerIDCNIC() throws InterruptedException {
        driver.findElement(cnicSearch).sendKeys(props.getProperty("cnicSearchInvalid"));
        Thread.sleep(1000);
        driver.findElement(cnicSearch).sendKeys(Keys.ENTER);
    }

    @Then("Service Request should not be searched from Customer ID \\(CNIC)")
    public void serviceRequestShouldNotBeSearchedFromCustomerIDCNIC() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cnic_first));

        if (driver.findElement(cnic_first).isDisplayed()) {
            Assert.fail("Invalid CNIC is diplayed");
        } else {
            System.out.println("Invalid CNIC not displayed");
        }
    }

    @And("User select valid Service Type from drop down")
    public void userSelectValidServiceTypeFromDropDown() {
        driver.findElement(srvc_type_dropdown).click();
    }

    @Then("Successful service Request should be searched from Service Typel")
    public void successfulServiceRequestShouldBeSearchedFromServiceTypel() {
    }

    //Cases details by Muhammad Adnan Adil
    @And("User click on Cases Tab")
    public void User_click_on_Cases_Tab() throws InterruptedException {
        driver.findElement(User_click_on_Cases_Tab).click();
        Thread.sleep(2000);
    }

    @Then("Successful cases screen should be displayed")
    public void Successful_cases_screen_should_be_displayed() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Cases_module_text_verify));
        Assert.assertEquals("CASES", driver.findElement(Cases_module_text_verify).getText());
        System.out.println("Cases text is displayed");

        //Fetching CNIC & Product list from the page.
        CNIC = driver.findElement(get_CNIC).getText();
    }

    @Then("Successful cases summary screen should be displayed")
    public void Successful_cases_summary_screen_should_be_displayed() throws IOException, InterruptedException {
        Thread.sleep(5000);
        assertTrue(driver.findElement(header_of_cases_detail).isDisplayed());
        System.out.println("Grid Summary Details are displayed");
    }

    @Then("Cases screen should contains Add, Download PDF and CSV Buttons on its right top")
    public void Cases_screen_should_contains_Add_Download_PDF_and_CSV_Buttons_on_its_right_top() throws IOException, InterruptedException {
        Thread.sleep(2000);
        assertTrue(driver.findElement(cases_button_validation).isDisplayed());
        System.out.println("PDF button has been displayed");
    }

    @And("User enter details in the search area of product")
    public void User_enter_details_in_the_search_area_of_product() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enter_values_in_product_search));

        PropsFunction();
        driver.findElement(enter_values_in_product_search).sendKeys(props.getProperty("searchproductincase"));
        Thread.sleep(2000);
    }

    @Then("Products should be searched and should be shown to user.")
    public void Products_should_be_searched_and_should_be_shown_to_user() throws IOException, InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(find_values_products_list_of_SR));

        driver.findElement(enter_values_in_product_search).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        String product_search = driver.findElement(enter_values_in_product_search).getText();
        Thread.sleep(2000);
        if (driver.findElement(enter_values_in_product_search).isDisplayed()) {
            assertEquals(props.getProperty("searchproductincase"), driver.findElement(find_values_products_list_of_SR).getText());
        } else {
            System.out.println("Unable to display");
        }
    }

    @And("User Click on any Cases ticket number")
    public void User_Click_on_any_Cases_ticket_number() throws IOException, InterruptedException {
        Thread.sleep(2000);
        case_number = driver.findElement(click_on_case_number).getText();
        driver.findElement(click_on_case_number).click();
    }

    @Then("Successful Cases details screen should be viewed by clicking on Cases ticket number hyperlink from Cases summary screen")
    public void detail_screen_of_case() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(case_detail));

        String verify_case_number = driver.findElement(case_detail).getText();
        if (verify_case_number.equals(case_number)) {
            System.out.println("Case numbers are verified");
        } else {
            Assert.fail("Case numbers mismatched.");
        }
    }

    @Then("Make sure to successfully display current state and actor")
    public void Successfull_display_of_current_state_and_actor() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(case_detail));

        String verify_case_number = driver.findElement(case_detail).getText();

        // Check if "state_of_case" contains "Open"
        String state_of_case = driver.findElement(state_element_Case_detail_screen).getText();
        if (state_of_case.contains("Open")) {
            System.out.println("State of the case is 'Open'");
        } else {
            Assert.fail("State of the case is not 'Open'");
        }

        if (verify_case_number.equals(case_number)) {
            System.out.println("Case numbers are verified");
        } else {
            Assert.fail("Case numbers mismatched.");
        }

        driver.findElement(clickonarrowofcasedetailscreen).click();
        String actor_show_Case = driver.findElement(actor_show_element).getText();
        if (actor_show_Case.contains("rupal damani")) {
            System.out.println("'Rupal Damani' is available in 'ACTOR_SHOW'");
        } else {
            Assert.fail("'ACTOR' is not available in 'ACTOR_SHOW'");
        }
    }

    @Then("Make sure to All fields mentioned should be shown to user")
    public void display_all_fields() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(case_detail));
        String field_verifications = driver.findElement(field_verification_of_case_detail_screen).getText();

        if (field_verifications.contains(CNIC)) {
            System.out.print("CNIC matches");
        } else {
            Assert.fail("CNIC are not matched");
        }
    }

    @And("click on case")
    public void click_on_cases() throws IOException, InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(click_on_cases_in_agent_desktop).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(add_button_of_case_in_agent_desktop));
        driver.findElement(add_button_of_case_in_agent_desktop).click();
    }

    @And("click on case only")
    public void click_on_cases_only() throws IOException, InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(click_on_cases_in_agent_desktop).click();

    }

    @And("Search case in search area")
    public void Search_case_in_search_area() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(seach_case_for_add).sendKeys(props.getProperty("searchcase"));
        Thread.sleep(2000);
        driver.findElement(click_on_first_searched_case).click();
        Thread.sleep(2000);
    }

    @And("User click on Next button")
    public void User_click_on_Next_button() throws IOException, InterruptedException {
        driver.findElement(click_on_next_button_in_case).click();
        Thread.sleep(2000);

    }

    @And("User click on submit button")
    public void click_on_submit() throws IOException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(click_on_submit_button));

        driver.findElement(click_on_submit_button).click();
        Thread.sleep(1000);
    }

    @Then("Make sure that case should display an error")
    public void error_on_submit_case() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_of_case));

        String get_error = driver.findElement(error_of_case).getText();
        System.out.println(get_error);
        if (get_error.contains("Required")) {
            System.out.println("These fields are required" + get_error);
        } else {
            Assert.fail("hello fail");
        }
    }

    @And("User Enter details in the provided fields")
    public void enter_details_in_case() throws IOException, InterruptedException {
        Actions a = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(case_channel_drop));
        driver.findElement(case_channel_drop).click();
        Thread.sleep(1000);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        driver.findElement(case_channel_drop).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(case_account_drop).click();
        Thread.sleep(1000);
        a.keyDown(Keys.DOWN);
        driver.findElement(case_account_drop).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(complaintnature).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div/div/div[8]/div/div/div/div/div[2]/div[1]")).click();
        driver.findElement(find_notes_case).sendKeys("Notes are added for testing purpose");
        driver.findElement(case_find_Mode).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div/div/div[11]/div/div/div/div/div[2]/div[1]")).click();
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.ENTER);
        driver.findElement(case_email).sendKeys("hello@Avanzasolutions.com");
        driver.findElement(case_address).sendKeys("Test Address Avanza Karachi");
        Thread.sleep(1000);
        driver.findElement(click_on_submit_button).click();
        Thread.sleep(1000);

    }

    @Then("Case should be saved successfully and success message should be shown to user")
    public void theNewlyCreatedCaseShouldBeShownInTheList() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(displaybalance));

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();
        System.out.println(gettextfromdisplaybalance);

        if (gettextfromdisplaybalance.contains("CA")) {
            System.out.println("complaint has been added successfully");
        } else {
            Assert.fail("Case has been failed");
        }
    }

    @Then("Make sure that pop up should disappear and user should be routed to backscreen")
    public void backbuttonverificationoncase() {
        driver.findElement(Back_button_of_case).click();

        if (driver.findElement(pop_up).isDisplayed()) {
            Assert.fail("POPUP is still shown to user");
        } else {
            System.out.println("Back button Passed");
        }
    }

    @And("User click on PDF and CSV button for case")
    public void userclickonpdfandcsvofcase() throws IOException {
        driver.findElement(pdfofCase).click();
        driver.findElement(CSVofCase).click();
    }


    @Then("User using PDF and CSV buttons should download a case file in format of PDF and CSV")
    public void csvofcase() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MMMddyyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);

        PropsFunction();
        String dirPath = props.getProperty("downloadsPath");
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(date1)) {
                    System.out.println("Both CSV and PDF files downloaded and present in the directory");
                    break;
                }
            }
        }
    }

    @And("user click on topcase")
    public void clickontopcase() throws IOException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);

        driver.findElement(clickontopcase).click();
    }

    @Then("Make sure that activity area should be shown")
    public void activityareaofcases() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String textofactivity = driver.findElement(activities_area).getText();
        System.out.println(activities_area);

        if (textofactivity.contains("History") && textofactivity.contains("Notes")) {
            System.out.println("Activies are shown");
        } else {
            Assert.fail("Activities are not shown to user");
        }

    }

    @Then("Make sure that case should have CA in it")
    public void case_number_validation() throws IOException, InterruptedException {
        Thread.sleep(1000);
        String findCAincase = driver.findElement(clickontopcase).getText();
        if (findCAincase.contains("CA")) {
            System.out.println(clickontopcase + "contains CA");
        } else {
            Assert.fail("CA is not displayed in the Case");
        }
    }

    @Then("User enter valid username for agent")
    public void loginwithagent() throws IOException, InterruptedException {
        PropsFunction();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("agenttovalidatecase"));
    }

    @And("Click on in Process")
    public void clickoninprocess() throws IOException, InterruptedException {
        Thread.sleep(1000);
        driver.findElement(clickonInprocess).click();
    }

    @Then("Make sure that all grids on dashboard should be shown")
    public void validatedashboard() throws IOException, InterruptedException {

        if (driver.findElement(SRLoggrlog).isDisplayed() && driver.findElement(SRclosed).isDisplayed() && driver.findElement(srresolvedpermonth).isDisplayed()) {
            System.out.println("Testcases passed");
        } else {
            Assert.fail("Failed testcases");
        }

    }

    @Then("Make sure that global search area should be displayed")
    public void validateifgloablsearchisdisplayed() throws IOException, InterruptedException {
        if (driver.findElement(globalsearcharea).isDisplayed()) {
            System.out.println("Global Search Area is displayed");
        } else {
            Assert.fail("Global searching Fails");
        }
    }

    @And("Case should be searched")
    public void Caseshouldbesearched() throws IOException, InterruptedException {
        driver.findElement(globalsearcharea).sendKeys("CA");
        Thread.sleep(2000);
        Actions a = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultareaofglobalsearch));
        driver.findElement(resultareaofglobalsearch).click();
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.ENTER);
        System.out.println("Keys pressed twice down");
        Thread.sleep(2000);

    }

    @Then("Make sure that Case should be shown to user.")
    public void caseshouldbeshown() throws IOException, InterruptedException {
        String globalsearch = driver.findElement(resultareaofglobalsearch).getText();
        System.out.println(globalsearch);
        Thread.sleep(2000);
        String caseverification = driver.findElement(casedisplayagainstglobalsearch).getText();
        Thread.sleep(2000);

        if (caseverification.contains(globalsearch)) {
            System.out.println(globalsearch);
        } else {
            Assert.fail("Cases are not matched");
        }
    }

    @And("SR should be searched")
    public void SRshouldbesearched() throws IOException, InterruptedException {
        driver.findElement(globalsearcharea).sendKeys("SR");
        Thread.sleep(2000);
        Actions a = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultareaofglobalsearch));
        driver.findElement(resultareaofglobalsearch).click();
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.ENTER);
        System.out.println("Keys pressed twice down for SR");
        Thread.sleep(2000);

    }

    @And("User click on Filter Tab \\(Right side of grid)")
    public void userClickOnFilterTabRightSideOfGrid() throws InterruptedException {
        driver.findElement(filter_btn).click();
        Thread.sleep(1000);
    }


    @And("User click on Add Filter")
    public void userClickOnAddFilter() throws InterruptedException {
        driver.findElement(add_filter).click();
        Thread.sleep(1000);
    }

    @Then("Successful window should be appeared with following dropdowns Field Operator and Value")
    public void successfulWindowShouldBeAppearedWithFollowingDropdownsFieldOperatorAndValue() {
        if (driver.findElement(filter_dialog).isDisplayed()) {
            System.out.println("Filter dialog box displayed");
        } else {
            Assert.fail("Filter dialog box not displayed");
        }
    }

    @And("User select option from Fields & Operator dropdown and enter input in Value")
    public void userSelectOptionFromFieldsOperatorDropdownAndEnterInputInValue() throws InterruptedException {

        driver.findElement(field_drop).click();
        driver.findElement(field_CNIC).click();
        driver.findElement(operator_drop).click();
        driver.findElement(operator_contains).click();
        driver.findElement(val_txt).sendKeys("1234567890123");
        Thread.sleep(1000);
    }

    @And("User click on done and save button")
    public void userClickOnDoneAndSaveButton() throws InterruptedException {
        driver.findElement(done_btn).click();
        Thread.sleep(1000);
        driver.findElement(save_filter_btn).click();
        Thread.sleep(1000);
    }

    @Then("Data according to filters should be displayed")
    public void dataAccordingToFiltersShouldBeDisplayed() {
        //Search results return empty (Constraint)
        Assert.fail("No search results returned");
    }

    @And("User click on any Service Request")
    public void userClickOnAnyServiceRequest() throws InterruptedException {

        Thread.sleep(2000);

        if (driver.findElement(SR_val_first_div).isDisplayed()) {
            SR_Val = driver.findElement(SR_val_first).getText();

            driver.findElement(SR_val_first).click();
            Thread.sleep(1000);
        } else {
            Assert.fail("SR Values not displayed in the grid");
        }

    }

    @Then("Service Request details screen should be viewed by clicking on Service Request ticket number hyperlink from Service Request summary screen")
    public void serviceRequestDetailsScreenShouldBeViewedByClickingOnServiceRequestTicketNumberHyperlinkFromServiceRequestSummaryScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SR_detail_val));

        if (driver.findElement(SR_detail_val).getText().contains(SR_Val)) {
            System.out.println("SR value details displayed successfully");
        } else {
            Assert.fail("SR value details not displayed");
        }
    }

    @And("User clicks on the settings link and User clicks on the users option")
    public void userClicksOnTheSettingsLinkAndUserClicksOnTheUsersOption() throws InterruptedException {
        driver.findElement(settings_btn).click();
        Thread.sleep(1000);
        driver.findElement(Users_admin).click();
        Thread.sleep(1000);
    }

    @And("Search and select the locked user")
    public void searchAndSelectTheLockedUser() throws InterruptedException {
        driver.findElement(loginID_input).sendKeys(props.getProperty("blockedUsername"));
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(user_option1));

        driver.findElement(user_option1).click();
        Thread.sleep(1000);
        driver.findElement(user_edit_btn).click();
        Thread.sleep(1000);
    }

    @And("Mark the locked user account as active and clicks on save button")
    public void markTheLockedUserAccountAsActiveAndClicksOnSaveButton() throws InterruptedException {
        driver.findElement(is_active_toggle).click();
        Thread.sleep(1000);
        driver.findElement(saveclose_user_btn).click();
        Thread.sleep(5000);
    }

    @Then("User change should be made successfully and user account should be unlocked")
    public void userChangeShouldBeMadeSuccessfullyAndUserAccountShouldBeUnlocked() throws InterruptedException {
        driver.findElement(profile_btn).click();
        Thread.sleep(1000);
        driver.findElement(btn_logout).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys(props.getProperty("blockedUsername"));
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/form/div/button")).click();
        Thread.sleep(2000);

        if (driver.findElement(dash_grid).isDisplayed()) {
            System.out.println("Case Passed");
        } else {
            Assert.fail("User unlocking failed because login was not succesful from a recently unblcoked user");
        }

    }

    @When("User click on log out button")
    public void userClickOnLogOutButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile_btn));

        driver.findElement(profile_btn).click();
        Thread.sleep(1000);
        driver.findElement(btn_logout).click();
        Thread.sleep(1000);
    }

    @Then("User should be logged out from the system and should redirect to login page")
    public void userShouldBeLoggedOutFromTheSystemAndShouldRedirectToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @When("User enter valid username of an in-active account")
    public void userEnterValidUsernameOfAnInActiveAccount() throws InterruptedException, IOException {
        PropsFunction();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("blockedUsername"));
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
        Thread.sleep(1000);
    }

    @When("User login from Service Request Manager")
    public void userLoginFromServiceRequestManager() throws InterruptedException, IOException {
        PropsFunction();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Thread.sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("SRmanager"));
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
        driver.findElement(login_btn).click();
        Thread.sleep(3000);
    }

    @When("User login from call agent ID")
    public void userLoginFromCallAgentID() throws InterruptedException, IOException {
        PropsFunction();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Thread.sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(props.getProperty("callAgentUser"));
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(props.getProperty("password"));
        driver.findElement(login_btn).click();
        Thread.sleep(3000);

    }

    @Then("Make sure that SR should be shown to user")
    public void SRshouldbeshown() throws IOException, InterruptedException {
        String globalsearch = driver.findElement(resultareaofglobalsearch).getText();
        System.out.println(globalsearch);
        Thread.sleep(2000);
        String srverification = driver.findElement(SRdisplayagainstglobalsearch).getText();
        Thread.sleep(2000);

        if (srverification.contains(globalsearch)) {
            System.out.println(globalsearch);
        } else {
            Assert.fail("SR are not matched");
        }
    }

    @Then("Enter invalid details on the provided area")
    public void enterinvaliddetailsinglobalsearch() throws IOException, InterruptedException {
        driver.findElement(globalsearcharea).sendKeys("Test");
    }

    // Agent Desktop
    @Then("Make sure that name should be displayed")
    public void namedisplay() throws Exception {
        String agentdesktopsummaryarea = driver.findElement(findsummarybodyinagentdesktop).getText();
        System.out.println(agentdesktopsummaryarea);
        if (agentdesktopsummaryarea.contains("Full Name")) {
            System.out.println("Full name has been displayed");
        } else {
            Assert.fail("Testcase Failed");
        }
    }

    @When("User selects CNIC from dropdown and enters the invalid CNIC in search box")
    public void user_selects_cnic_from_dropdown_and_enters_the_invalid_cnic_in_search_box() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("searchInput")));

        driver.findElement(By.name("searchInput")).sendKeys("11");
        Thread.sleep(1000);
    }

    @Then("Make sure that Error should be displayed")
    public void error_of_agent_desktop_should_shown() throws IOException, InterruptedException {
        String textfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();
        System.out.println(textfromfinderrormessageofinvalidcnic);

        if (textfromfinderrormessageofinvalidcnic.contains("No Results")) {
            System.out.println("testcase passed");
        } else {
            Assert.fail("Testcase Failed");
        }
    }

    @Then("Make sure that All values should be shown in agent selection dropdown")
    public void dropdown_values_in_agentdesktop() throws IOException, InterruptedException {

        String textfromcheckvaluesindropdownofagentdesktop = driver.findElement(checkvaluesindropdownofagentdesktop).getText();

        System.out.println(textfromcheckvaluesindropdownofagentdesktop);

        if (textfromcheckvaluesindropdownofagentdesktop.contains("CNIC") && textfromcheckvaluesindropdownofagentdesktop.contains("Debit Card Number")) {
            System.out.println("testcase passed");
        } else {
            Assert.fail("Testcase Failed");
        }
    }

    @Then("Make sure that name Gender Nationality Date of Birth should be displayed")
    public void verify_stuff_in_agent_desktop() throws IOException, InterruptedException {
        String agentdesktopsummaryarea = driver.findElement(findsummarybodyinagentdesktop).getText();
        System.out.println(agentdesktopsummaryarea);

        if (agentdesktopsummaryarea.contains("Full Name") &&
                agentdesktopsummaryarea.contains("Date of Birth") &&
                agentdesktopsummaryarea.contains("Mobile Number") &&
                agentdesktopsummaryarea.contains("Mobile Number")) {
            System.out.println("Full name has been displayed");
        } else {
            Assert.fail("Testcase Failed");
        }
    }

    @Then("Then make sure that caution box should be shown to user")
    public void verify_caution_box() throws IOException, InterruptedException {
        if (driver.findElement(checkcautionBoxMainDivBlue).isDisplayed()) {
            System.out.println("Caution box shown");
        } else {
            Assert.fail("Testcase Failed for caution");
        }
    }

    @And("User clicks on walk-in customer")
    public void clickonwalkincustomer() throws IOException, InterruptedException {
        driver.findElement(clickonwalkincustomer).click();
        Thread.sleep(2000);
        String findtextofwalkin = driver.findElement(verificaitonofwalkincustomer).getText();
        System.out.println(findtextofwalkin);

        if (findtextofwalkin.contains("WALK")) {
            System.out.println("Walkin Customer found");
        } else {
            Assert.fail("Walkin Failed");
        }
    }

    @And("User click on Add button")
    public void clickonwalkincustomeraddbutton() throws IOException, InterruptedException {
        driver.findElement(clickonaddofwalkincustomer).click();
        Thread.sleep(2000);

    }

    @And("User Enter details in the provided fields of Walk-in customer and submit")
    public void enterwalkindetails() throws IOException, InterruptedException {
        driver.findElement(fullnamewalkin).sendKeys("Muhammad Adnan Adil");
        driver.findElement(mobilewalkin).sendKeys("03331231231234");
        driver.findElement(cnicwalkin).sendKeys("1720117201161");

        Actions a = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderwalkin));
        driver.findElement(genderwalkin).click();
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.ENTER);
        driver.findElement(addresswalkin).sendKeys("Test address");
        driver.findElement(martialwalkin).click();
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.ENTER);
        driver.findElement(clickonsavebuttonofwalkin).click();
    }

    @Then("Make sure that upon pressing submit an error should be displayed")
    public void enterwalkindetails_erroronsubmit() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(clickonsavebuttonofwalkin).click();
        String textfromerrorofsubmittion = driver.findElement(errorofsubmittion).getText();
        System.out.println(textfromerrorofsubmittion);
        if (textfromerrorofsubmittion.contains("Required")) {
            System.out.println("Error has been shown to user");
        } else {
            Assert.fail("Testcases has been failed");
        }
    }

    @And("click on session button then show")
    public void session_close_manually() throws IOException, InterruptedException {
        driver.findElement(session_btn).click();
        Thread.sleep(1000);
        driver.findElement(show_btn).click();
        Thread.sleep(1000);
        Actions a = new Actions(driver);
        driver.findElement(selectlevel1ofagentdesktop).click();
        Thread.sleep(1000);
        driver.findElement(select1stelement).click();
        Thread.sleep(2000);
        driver.findElement(selectlevel2ofagentdesktop).click();
        Thread.sleep(1000);
        driver.findElement(select2ndelement).click();
        Thread.sleep(1000);
        Thread.sleep(2000);
        driver.findElement(clickonAddbutton).click();
        Thread.sleep(2000);

        driver.findElement(notesofendsession).sendKeys("Test data");
        driver.findElement(clickonstar).click();


        String gettextfromactivitytype = driver.findElement(activitytype).getText();
        System.out.println(gettextfromactivitytype);
        if (gettextfromactivitytype.contains("Internal")) {
            System.out.println("testcase passed");
        } else {
            Assert.fail("Testcase has been failled");
        }
    }

    @Then("Session should be ended")
    public void session_should_ended() throws IOException, InterruptedException {
        driver.findElement(end_session).click();

        Thread.sleep(3000);

        String value = driver.findElement(session_value).getText();

        if (value.contains("0")) {
            System.out.println("Testcase passed");
        } else {
            Assert.fail("Failed");
        }
    }

    @And("User navigates to the Customer hub")
    public void userNavigatesToThecustomerhub() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customer_hub));

        driver.findElement(customer_hub).click();
        Thread.sleep(1000);

        String textfromrecentcustomer = driver.findElement(recent_customer).getText();
        if (textfromrecentcustomer.contains("Recent Customer")) {
            System.out.println("proceed to another step");
        } else {
            Assert.fail("Case failed");
        }
    }

    @And("Make sure that User navigates to the customer hub and record is displayed")
    public void navigatetocustomerhub() throws InterruptedException {


        driver.findElement(customer_hub).click();
        Thread.sleep(2000);
        driver.findElement(recent_customer).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(whilepageofrecentcustomer));


        String gettextfrmomrecentcustomer = driver.findElement(whilepageofrecentcustomer).getText();
        if (gettextfrmomrecentcustomer.contains("FARHAD JADOON")) {
            System.out.println("Testcases has been passed");
        } else {
            Assert.fail("Case Failed");

        }
    }

    @And("Click on Financial Accounts")
    public void gotofinanciaAccounts() throws InterruptedException {

        driver.findElement(FinancialAccounts).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(verificationofcustomeraccounts));

        String gettextfromaccountsection = driver.findElement(verificationofcustomeraccounts).getText();

        if (gettextfromaccountsection.contains("Saving")) {
            System.out.println("Testcase is passed");
        } else {
            Assert.fail("Testcase failed");
        }
    }

    @And("Go to Balance Inquiry")
    public void gotobalanceinqiry() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        driver.findElement(clicknthreedots).click();
        Thread.sleep(2000);
        driver.findElement(gotobalanceinquiry).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that balance should be shown to user")
    public void displayBI() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BInextbutton));

        driver.findElement(BInextbutton).click();
        Thread.sleep(1000);

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();
        System.out.println(gettextfromdisplaybalance);

        if (gettextfromdisplaybalance.contains("Processed Ok")) {
            System.out.println("Testcase passed");
        } else {
            Assert.fail("Case failed");
        }
    }

    @Then("Warning should be provided to the user on logging a similar Case")
    public void warning_of_duplicate() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(duplicate_message));

        String gettextfromduplicatemsg = driver.findElement(duplicate_message).getText();
        System.out.println(gettextfromduplicatemsg);

        if (gettextfromduplicatemsg.contains("already exist")) {
            System.out.println("Testcase passed");
        } else {
            Assert.fail("Case failed");
        }
    }

    @And("User enter details in the search area of case - Date Filter")
    public void enter_details_in_date_filter() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(case_to_date));

        Actions a = new Actions(driver);

        driver.findElement(casefromdate).sendKeys("08/01/2023");
        Thread.sleep(2000);
        a.keyDown(Keys.ENTER);

        driver.findElement(casetodate).sendKeys("09/01/2023");
        Thread.sleep(2000);
        a.keyDown(Keys.ENTER);

        Thread.sleep(3000);
    }

    @Then("Cases should be displayed")
    public void display_cases() throws IOException, InterruptedException {

        Thread.sleep(2000);

        String gettextfromcaseno = driver.findElement(casecase).getText();

        if (gettextfromcaseno.contains("CA")) {
            System.out.println("Testcases is passed and CA Is displayed");
        } else {
            Assert.fail("CA is not displayed");
        }
    }

    @And("Go to Account Details")
    public void account_Details() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        driver.findElement(clicknthreedots).click();
        Thread.sleep(2000);
        driver.findElement(gotoAccountdetails).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Account details should be shown to user")
    public void verify_account_details() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        WebElement accountNumElement = driver.findElement(display_account_num);
        WebElement accountTypeElement = driver.findElement(display_Account_type);
        WebElement branchNameElement = driver.findElement(display_branch_name);
        WebElement currencyElement = driver.findElement(display_currency);
        WebElement accountStatusElement = driver.findElement(display_Account_status);

        if (accountNumElement.getText().isEmpty() ||
                accountTypeElement.getText().isEmpty() ||
                branchNameElement.getText().isEmpty() ||
                currencyElement.getText().isEmpty() ||
                accountStatusElement.getText().isEmpty()) {

            Assert.fail("Testcase is failed");
        } else {
            System.out.println("testcase passed");
        }
    }

    @And("Go to cheque book Details")
    public void checque_book_details() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        driver.findElement(clicknthreedots).click();
        Thread.sleep(2000);
        driver.findElement(gotochequebookdetails).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that cheque book Details should be shown to user")
    public void chequebookpage() throws InterruptedException {

        String gettextfromaccountchqe = driver.findElement(Accountinchque).getText();

        if (gettextfromaccountchqe.isEmpty()) {

            Assert.fail("Failed because account isn't displayed");
        } else {
            driver.findElement(nextbuttoncheque).click();
            Thread.sleep(3000);

            String gettextfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();

            if (gettextfromfinderrormessageofinvalidcnic.contains("Processed Ok")) {
                System.out.println("Cheque Book Detail are displayed");
            } else {
                Assert.fail("Cheque Book Detail are not shown to user");
            }
        }
    }

    @And("Go to debit card list by accounts")
    public void debit_card_list() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        driver.findElement(clicknthreedots).click();
        Thread.sleep(2000);
        driver.findElement(gotodebitcardlist).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that debit card list should be shown to user")
    public void debit_card_list_should_be_shown() throws InterruptedException {

        String gettextfromaccountchqe = driver.findElement(Accountinchque).getText();

        if (gettextfromaccountchqe.isEmpty()) {

            Assert.fail("Failed because account isn't displayed");
        } else {

            driver.findElement(nextbuttoncardlist).click();
            Thread.sleep(3000);

            String gettextfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();

            if (gettextfromfinderrormessageofinvalidcnic.contains("Processed Ok")) {
                System.out.println("Debit Card list are displayed");
            } else {
                Assert.fail("Debit Card listare not shown to user");
            }
        }
    }

    @And("Go to mini statement")
    public void mini_statement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        driver.findElement(clicknthreedots).click();
        Thread.sleep(2000);
        driver.findElement(gotoministatement).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that mini statement should be shown to user")
    public void mini_statement_display() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Accountinchque));

        WebElement accountNumElement = driver.findElement(display_account_num);
        WebElement accountTypeElement = driver.findElement(display_Account_type);
        WebElement branchNameElement = driver.findElement(display_branch_name);
        WebElement currencyElement = driver.findElement(display_currency);

        if (accountNumElement.getText().isEmpty() ||
                accountTypeElement.getText().isEmpty() ||
                branchNameElement.getText().isEmpty() ||
                currencyElement.getText().isEmpty()) {

            Assert.fail("Not all details are shown to user");
        } else {
            driver.findElement(nextbuttoncheque).click();
            Thread.sleep(1000);

            String gettextfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();

            if (gettextfromfinderrormessageofinvalidcnic.contains("Processed Ok")) {
                System.out.println("Mini statement is displayed");
            } else {
                Assert.fail("Mini statement is shown to user");
            }

        }
    }

    @And("Go to SMS Estatment status")
    public void gotosmsestatementstatus() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        driver.findElement(clicknthreedots).click();
        Thread.sleep(2000);
        driver.findElement(gotoestatementsmsstatus).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that SMS Estatment should be shown to user")
    public void sms_estatement_display() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Accountinchque));

        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(2000);

        WebElement accountNumElement = driver.findElement(display_account_num);
        WebElement accountTypeElement = driver.findElement(display_Account_type);
        WebElement branchNameElement = driver.findElement(display_branch_name);
        WebElement currencyElement = driver.findElement(display_currency);
        WebElement email = driver.findElement(display_email);
        WebElement frequency = driver.findElement(display_frequency);
        WebElement Statement_Registration_Flag = driver.findElement(display_EStatement_Registration_Flag);

        if (accountNumElement.getText().isEmpty() ||
                accountTypeElement.getText().isEmpty() ||
                branchNameElement.getText().isEmpty() ||
                currencyElement.getText().isEmpty() ||
                email.getText().isEmpty() ||
                frequency.getText().isEmpty() ||
                Statement_Registration_Flag.getText().isEmpty()) {

            Assert.fail("Not all details of are SMS - EStatement Status shown to user");

        } else {
            System.out.println("All items of SMS etstament status are shown to user");
        }
    }

    @And("Go to Credit Card details")
    public void gotocreditcarddetails() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");

        driver.findElement(clicknthreedots_creditcard).click();
        Thread.sleep(2000);
        driver.findElement(gotocreditcarddetails).click();
        Thread.sleep(2000);
    }


    @Then("Make sure that Credit Card Detail should be shown to user")
    public void credit_card_details() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        WebElement accountNumElement = driver.findElement(display_account_num);
        WebElement accountTypeElement = driver.findElement(acct);
        WebElement branchNameElement = driver.findElement(display_branch_name);
        WebElement currencyElement = driver.findElement(display_currency);

        WebElement AvailableCashAdvanceLimit = driver.findElement(validateavailablecashlimit);
        WebElement TotalCashAdvanceLimit = driver.findElement(validatetotalcashlimit);
        WebElement OutstandingBalance = driver.findElement(validateoutstandingbalance);
        WebElement RewardPointsEarned = driver.findElement(validaterewardpoints);

        WebElement RewardPointsRedeemed = driver.findElement(validaterewardpointsredeemed);
        WebElement RewardPointsAvailable = driver.findElement(validaterewardpointsavailable);
        WebElement AvailableCreditLimit = driver.findElement(validateavailablecreditlimit);
        WebElement CreditLimit = driver.findElement(validatecreditlimit);

        WebElement LastPaymentAmount = driver.findElement(validatelastpaymentamount);
        WebElement LastPaymentDate = driver.findElement(validatelastpaymentdate);


        if (accountNumElement.getText().isEmpty() ||
                accountTypeElement.getText().isEmpty() ||
                branchNameElement.getText().isEmpty() ||
                currencyElement.getText().isEmpty() ||
                AvailableCashAdvanceLimit.getText().isEmpty() ||
                TotalCashAdvanceLimit.getText().isEmpty() ||
                OutstandingBalance.getText().isEmpty() ||
                RewardPointsEarned.getText().isEmpty() ||
                RewardPointsRedeemed.getText().isEmpty() ||
                RewardPointsAvailable.getText().isEmpty() ||
                AvailableCreditLimit.getText().isEmpty() ||
                CreditLimit.getText().isEmpty() ||
                LastPaymentAmount.getText().isEmpty() ||
                LastPaymentDate.getText().isEmpty()) {

            Assert.fail("Some items of credit cards is/are missing in credit card details");

        } else {
            System.out.println("All items of credit card details are shown to user");
        }
    }

    @And("Go to Credit Card last 10 transactions")
    public void gotocreditcardlast10transactions() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");

        driver.findElement(clicknthreedots_creditcard).click();
        Thread.sleep(2000);
        driver.findElement(gotocreditcardlast10transactions).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Credit Card Last 10 Transaction should be shown to user")
    public void cclast10transactions() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(nextbuttoncardlist).click();

        Thread.sleep(1000);

        String gettextfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();

        if (gettextfromfinderrormessageofinvalidcnic.contains("Processed")) {
            System.out.println("Last 10 transactions shown to user");
        } else {
            Assert.fail("Last 10 transactions are not shown to user");
        }

    }

    @And("Go to cross border enablment")
    public void crossborderenablement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(2000);
        driver.findElement(gotocrossborderenable).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Cross Border transaction should be enabled")
    public void enablethecrossbordertransaction() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(nextbuttoncheque).click();
        Thread.sleep(2000);

        String gettextfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();

        if (gettextfromfinderrormessageofinvalidcnic.contains("Processed")) {
            System.out.println("Cross Border Enabled");
        } else {
            Assert.fail("Cross Border Enable is  not enabled");
        }
    }

    @And("Go to Cross Border Status Fetch")
    public void crossborderstatusfetch() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(2000);
        driver.findElement(gotocrossborderstatusfetch).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Cross Border Status should be fetched")
    public void crossborderenablementstatus() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(2000);

        String gettextfromvalidatestatusofbordercross = driver.findElement(validatestatusofbordercross).getText();
        System.out.println(gettextfromvalidatestatusofbordercross);

        if (gettextfromvalidatestatusofbordercross.contains("Inactive") ||
                gettextfromvalidatestatusofbordercross.contains("active")) {
            System.out.println("Cross Border Status is Fetched");
        } else {
            Assert.fail("Cross Border Enable is  not enabled");
        }
    }

    @And("Go to Debit Card Detail")
    public void debitcarddetails() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(2000);
        driver.findElement(gotodebitcarddetails).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Debit Card Detail should be fetched")
    public void fetchdebitcarddetails() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));


        WebElement accountNumElement = driver.findElement(display_account_num);
        WebElement accountTypeElement = driver.findElement(acct);
        WebElement branchNameElement = driver.findElement(display_branch_name);
        WebElement currencyElement = driver.findElement(display_currency);
        WebElement AvailableCashAdvanceLimit = driver.findElement(validateavailablecashlimit);
        WebElement TotalCashAdvanceLimit = driver.findElement(validatetotalcashlimit);
        WebElement OutstandingBalance = driver.findElement(validateoutstandingbalance);
        WebElement RewardPointsEarned = driver.findElement(validaterewardpoints);
        WebElement RewardPointsRedeemed = driver.findElement(validaterewardpointsredeemed);

        if (accountNumElement.getText().isEmpty() ||
                accountTypeElement.getText().isEmpty() ||
                branchNameElement.getText().isEmpty() ||
                currencyElement.getText().isEmpty() ||
                AvailableCashAdvanceLimit.getText().isEmpty() ||
                TotalCashAdvanceLimit.getText().isEmpty() ||
                OutstandingBalance.getText().isEmpty() ||
                RewardPointsEarned.getText().isEmpty() ||
                RewardPointsRedeemed.getText().isEmpty()) {

            Assert.fail("Some items of Debit Card Detail is/are missing in credit card details");

        } else {
            System.out.println("All items of cDebit Card Detail are shown to user");
        }
    }

    @And("Go to Debit Card Status Change")
    public void debitcardstatuschange() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(2000);
        driver.findElement(gotodebitcardstatuschange).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Debit Card status should be changed")
    public void debitcardstatuschangeverification() throws InterruptedException {

        Actions a = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(cardstatuschangedropdown).click();
        Thread.sleep(2000);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.ENTER);

        driver.findElement(clickondebitcardbutton).click();
        Thread.sleep(2000);

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();

        if (gettextfromdisplaybalance.contains("Processed Ok")) {
            System.out.println("Status of debit card has been changed");
        } else {
            Assert.fail("Case failed for debit card status changed");
        }
    }

    @And("Go to Debit Card Status fetch")
    public void debitcardstatusfetch() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(2000);
        driver.findElement(gotodebitcardstatusfetch).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Debit Card status should be fetched")
    public void debitcardstatusfetchverification() throws InterruptedException {

        Actions a = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(clickondebitcardbutton).click();
        Thread.sleep(2000);

        String gettextfromvalidatecardstatus = driver.findElement(validatecardstatus).getText();
        System.out.println(gettextfromvalidatecardstatus);

        if (gettextfromvalidatecardstatus.contains("Cold") ||
                gettextfromvalidatecardstatus.contains("Hot") ||
                gettextfromvalidatecardstatus.contains("Warm"))
            System.out.println(gettextfromvalidatecardstatus + " is shown to user");

        else {
            Assert.fail("Card status is missing");
        }
    }
    @And("Go to GDCI Service Block")
    public void GDCIserviceblock() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(5000);
        driver.findElement(gotogdciblock).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that GDCI Service should be Block")
    public void GDCIserviceblockverification() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(selectchanneltype).click();
        Thread.sleep(1000);
        driver.findElement(selectivr).click();

        driver.findElement(clickondebitcardbutton).click();
        Thread.sleep(1000);

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();

        if (gettextfromdisplaybalance.contains("Processed Ok")) {
            System.out.println("GDCI Service has been Blocked");
        } else {
            Assert.fail("Failed to block GCI service");
        }
    }

    @And("Go to GDCI Service unBlock")
    public void GDCIserviceunblock() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(5000);
        driver.findElement(gotogdunblock).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that GDCI Service should be unBlock")
    public void gdciserviceunblock() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(selectchanneltype).click();
        Thread.sleep(1000);
        driver.findElement(selectivr).click();

        driver.findElement(clickondebitcardbutton).click();
        Thread.sleep(1000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(displaybalance));

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();

        if (gettextfromdisplaybalance.contains("Processed Ok")) {
            System.out.println("GDCI Service has been Un Blocked");
        } else {
            Assert.fail("Failed to un block GCI service");
        }
    }

    @And("Go to Internet Session Status")
    public void internetsessionstatus() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(5000);
        driver.findElement(internetsessionstatus).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Internet session status should be shown to user")
    public void internetsessionstatusdetails() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(2000);

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();
        String gettextfromcheckstatus = driver.findElement(checkstatus).getText();
        System.out.println(gettextfromcheckstatus);

        Thread.sleep(1000);

        if (gettextfromdisplaybalance.contains("Processed Ok") &&
                gettextfromcheckstatus.contains("Y") ||
                gettextfromcheckstatus.contains("N")) {
            System.out.println("Internet session status has been shown");
        } else {
            Assert.fail("Internet session status has been not shown");
        }
    }

    @And("Go to Online VISA Transaction")
    public void onlinevisatransaction() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(clicknthreedots_debitcard).click();
        Thread.sleep(1000);
        driver.findElement(gotovisatransaction).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Online VISA transaction session request should be submitted")
    public void onlinevisatransactionsessionrequest() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(sessiontyperequestdd).click();
        Thread.sleep(1000);
        driver.findElement(sessionddvalue).click();
        Thread.sleep(1000);
        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(1000);


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(displaybalance));

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();

        if(gettextfromdisplaybalance.contains("Processed Ok")){
            System.out.println("Session request has been initiated");
        }
        else{
            Assert.fail("Session request has not been initiated");
        }
    }

    @And("Click on Transaction Pad")
    public void gototpad() throws InterruptedException {

        driver.findElement(transactionpage).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(verificationofatmdemo));

        String gettextfromaccountsection = driver.findElement(verificationofatmdemo).getText();

        if (gettextfromaccountsection.contains("ATM")) {
            System.out.println("Transaction pad is accessed");
        } else {
            Assert.fail("Transaction pad is not accessed");
        }
    }

    @And("Go to ATM Customer Demographics")
    public void ATMCustomerDemographics() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(verificationofatmdemo).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that ATM Customer Demographics should be shown")
    public void verificationofatmcustomerdemographics() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        String gettextfromdisplay_account_num = driver.findElement(display_account_num).getText();
        System.out.println(gettextfromdisplay_account_num);

        if (gettextfromdisplay_account_num.isEmpty()) {
            Assert.fail("Account number is missing");
        } else {

            driver.findElement(nextbuttoncardlist).click();

            Thread.sleep(5000);

            String gettextfromfinderrormessageofinvalidcnic = driver.findElement(finderrormessageofinvalidcnic).getText();

            WebElement gettextfromFullname = driver.findElement(display_account_num);

            if(gettextfromFullname.getText().isEmpty()){
                System.out.println("ATM Customer Demographics - All fields are available");
            }
            else{
                Assert.fail("ATM Customer Demographics - Few fields are missing");
            }
        }
    }
    @And("Go to ATM Statement For One Year")
    public void verificationofatmforoneyear() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(verificationofatmforoneyear).click();
        Thread.sleep(2000);
    }

    @And("Make sure that ATM Statement For One Year should be shown")
    public void statementatmforoneyear() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(display_account_num).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[2]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("STATEMENT_FROM_DATE")).sendKeys("01-Jan-2023");
        Thread.sleep(2000);
        driver.findElement(By.id("STATEMENT_TO_DATE")).sendKeys("01-DEC-2023");
        Thread.sleep(2000);
        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(2000);

        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();
        System.out.println(gettextfromdisplaybalance);

        if (gettextfromdisplaybalance.contains("Processed Ok")) {
            System.out.println("Full statement has been displayed");
        } else {
            Assert.fail("Full statement has not been displayed");
        }
    }

    @And("Go to ATM Today Transaction Statement")
    public void gotoatmtodaytransactions() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(verificationofatmforoneyear).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that ATM Today Transaction Statement should be shown")
    public void atmtodayverification() throws IOException, InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(display_account_num).click();
        Thread.sleep(2000);

        driver.findElement(selectaccount).click();

        WebElement gettextfromopeningbalance = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div"));
        WebElement gettextfromclosingbalance = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div/div/div"));
        //WebElement gettextfromdesc = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[4]/div/div/div"));

        if(gettextfromopeningbalance.getText().isEmpty() ||
                gettextfromclosingbalance.getText().isEmpty()
                ) {
            Assert.fail("All fields are not displayed");

        }
        else {
            driver.findElement(nextbuttoncardlist).click();
            Thread.sleep(2000);

            String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();

            if (gettextfromdisplaybalance.contains("Processed Ok")) {
                System.out.println("ATM Today Transaction Statement has been displayed");
            } else {
                Assert.fail("ATM Today Transaction Statement has not been displayed");
            }
        }

    }

    @And("Go to Account Customer Demographics")
    public void atmcustomerdemo() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(gotoacccustomdemo).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Account Customer Demographics should be shown")
    public void accountcustdemo() throws InterruptedException, IOException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        WebElement gettextfromdisplay_account_num = driver.findElement(display_account_num);

        if(gettextfromdisplay_account_num.getText().isEmpty()){
            Assert.fail("Account is not displayed");
        }
        else {
            driver.findElement(nextbuttoncardlist).click();
            Thread.sleep(2000);

            WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofMinutes(5));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(displayhome));

            WebElement accountNumElement = driver.findElement(display_account_num);
            WebElement branchNameElement = driver.findElement(display_branch_name);
            WebElement currencyElement = driver.findElement(display_currency);
            WebElement accountStatusElement = driver.findElement(display_Account_status);

            if(accountStatusElement.getText().isEmpty() ||
                    branchNameElement.getText().isEmpty() ||
                    currencyElement.getText().isEmpty() ||
                    accountStatusElement.getText().isEmpty()) {

                Assert.fail("Account Customer Demographics is not shown to user");
            }

            else {
                System.out.println("Few fields are missings in Account customer demographics");

            }
    }
 }

    @When("User enter valid username of user to whom case has been assigned")
    public void userEnterValidUsernameOfUserToWhomcaseHasBeenAssigned() {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("rupal.damani");
    }

    @When("User navigates to the recently saved case")
    public void userNavigatesToTheRecentlySavedcase() throws InterruptedException {

        Thread.sleep(2000);


        driver.findElement(user_click_on_case_no).click();
        Thread.sleep(2000);
    }

    @And("User changes the status of case from Open to initiated")
    public void userChangesTheStatusOfcaseFromInitiatedToAssigned() throws InterruptedException {

        Thread.sleep(3000);

        //Assert.assertEquals("CASES", driver.findElement(Cases_module_text_verify).getText());

        System.out.println("Cases text is displayed");

        driver.findElement(userclickonintitiated).click();
        Thread.sleep(2000);

        driver.findElement(markascurrentstage).click();
        Thread.sleep(2000);

        driver.findElement(roles_drop).click();
        Thread.sleep(1000);

        driver.findElement(roles_select).click();
        Thread.sleep(1000);

        driver.findElement(units_drop).click();
        Thread.sleep(1000);

        driver.findElement(units_select).click();
        Thread.sleep(1000);

        driver.findElement(users_dropcase).click();
        Thread.sleep(1000);

        driver.findElement(user_select_case).click();
        Thread.sleep(1000);

        driver.findElement(notes).sendKeys("Case Assignment Through Test Automation");
        Thread.sleep(1000);

        driver.findElement(btn_doneSR).click();

        Thread.sleep(9000);
        System.out.println("Waiting");

        WebDriverWait waiting = new WebDriverWait(driver,Duration.ofMinutes(10));
        waiting.until(ExpectedConditions.invisibilityOfElementLocated(btn_doneSR));

    }

    @And("User changes the status of case from initiated to in progress")
    public void userChangesTheStatusOfcaseFromintitiatedToInProgress() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getBtn_inprogress));

        driver.findElement(getBtn_inprogress).click();
        Thread.sleep(1000);
        driver.findElement(markascurrentstage).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(notes_assigned));

        Thread.sleep(2000);

        driver.findElement(notes_assigned).sendKeys("Case Assignment Through Test Automation");
        Thread.sleep(2000);

        driver.findElement(donebtncase).click();
        Thread.sleep(1000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(donebtncase));


    }

    @Then("User navigates to the settings button and selects Roles under Users and Control")
    public void userNavigatesToTheSettingsButtonAndSelectsRolesUnderUsersAndControl() throws InterruptedException {
        driver.findElement(settings_btn).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Roles_option));

        driver.findElement(Roles_option).click();
        Thread.sleep(1000);
    }

    @And("User enters the role name, secondary name and selects the parent role from the dropdown")
    public void userEntersTheRoleNameSecondaryNameAndSelectsTheParentRoleFromTheDropdown() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(role_text));

        driver.findElement(role_text).sendKeys("Test Role");
        Thread.sleep(1000);
    }

    @Then("User navigates to the settings button and selects Groups under Users and Control")
    public void userNavigatesToTheSettingsButtonAndSelectsGroupsUnderUsersAndControl() throws InterruptedException {
        driver.findElement(settings_btn).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Groups_option));

        driver.findElement(Groups_option).click();
        Thread.sleep(1000);
    }

    @Then("User navigates to the settings button and selects Organization Unit under Users and Control")
    public void userNavigatesToTheSettingsButtonAndSelectsOrganizationUnitUnderUsersAndControl() throws InterruptedException {
        driver.findElement(settings_btn).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orgunit_option));

        driver.findElement(orgunit_option).click();
        Thread.sleep(1000);
    }

    @Then("User navigates to the settings button and selects Users under Users and Control")
    public void userNavigatesToTheSettingsButtonAndSelectsUsersUnderUsersAndControl() throws InterruptedException {
        driver.findElement(settings_btn).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Users_option));

        driver.findElement(Users_option).click();
        Thread.sleep(1000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(add_user_btn));

        driver.findElement(add_user_btn).click();
        Thread.sleep(1000);
    }

    @And("User clicks on the help desk button to navigate to the help desk screen")
    public void userClicksOnTheHelpDeskButtonToNavigateToTheHelpDeskScreen() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(help_desk_optn));

        driver.findElement(help_desk_optn).click();
        Thread.sleep(1000);
    }

    @And("User clicks on the new help desk ticket button")
    public void userClicksOnTheNewHelpDeskTicketButton() throws InterruptedException {
        driver.findElement(new_helpdesk_tckt).click();
        Thread.sleep(1000);
    }

    @And("Help desk ticket popup should be opened and then user selects the right option")
    public void helpDeskTicketPopupShouldBeOpenedAndThenUserSelectsTheRightOption() throws InterruptedException {
        driver.findElement(help_desk_search).sendKeys("Access Control");
        Thread.sleep(1000);
        driver.findElement(help_desk_option).click();
        Thread.sleep(1000);
        driver.findElement(help_desk_nxtBtn).click();
        Thread.sleep(1000);
    }

    @Then("User fills all of the details in the fields and click save to log the help desk ticket")
    public void userFillsAllOfTheDetailsInTheFieldsAndClickSaveToLogTheHelpDeskTicket() throws InterruptedException {
        driver.findElement(comp_nature_drop).sendKeys("comp");
        Thread.sleep(1000);
        driver.findElement(comp_nature_drop).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement field = driver.findElement(help_desk_saveBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", field);

        driver.findElement(help_desk_saveBtn).click();
        Thread.sleep(9000);
    }

    @Then("Help desk ticket should be logged successfully")
    public void helpDeskTicketShouldBeLoggedSuccessfully() {
    }
    @And("User changes the status of case from in progress to resolved")
    public void userChangesTheStatusOfcaseFromInProgressToresolved() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(markascurrentstage));

        driver.findElement(clickonresolve).click();
        Thread.sleep(1000);
        driver.findElement(markascurrentstage).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(notes_assigned));

        driver.findElement(notes_assigned).sendKeys("Case Assignment Through Test Automation");
        Thread.sleep(1000);
        driver.findElement(btn_doneIP).click();
        Thread.sleep(1000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(btn_doneIP));


    }

    @And("User changes the status of case from Done to Closed")
    public void userChangesTheStatusOfcaseFromDoneToClosed() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(markascurrentstage));

        driver.findElement(case_btn_closed).click();
        Thread.sleep(1000);
        driver.findElement(markascurrentstage).click();
        Thread.sleep(1000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(notes_assigned));

        driver.findElement(notes_assigned).sendKeys("Service Request Closure Through Test Automation");
        Thread.sleep(1000);
        driver.findElement(btn_doneIP).click();
        Thread.sleep(1000);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(btn_doneIP));

    }

    @Then("corresponding case should be closed")
    public void correspondingcaseShouldBeClosed() throws InterruptedException {

        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(casecontainer));

        String closed = driver.findElement(casecontainer).getText();
        System.out.println(closed);

        if (closed.contains("Closed")) {
            System.out.println("case closed successfully");
        } else {
            Assert.fail("case closure not successful");
        }
    }

    @And("Go to Account Statement For One Year")
    public void acctstatmentforoneyear() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(gotoacctstatement).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Account Statement For One Year should be shown")
    public void accountstatmentforoneyear() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(display_account_num).click();
        Thread.sleep(2000);

        driver.findElement(selectaccount).click();
        Thread.sleep(2000);
        driver.findElement(By.id("STATEMENT_FROM_DATE")).sendKeys("01-Jan-2023");
        Thread.sleep(2000);
        driver.findElement(By.id("STATEMENT_TO_DATE")).sendKeys("01-DEC-2023");
        Thread.sleep(2000);
        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(2000);


        String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();
        System.out.println(gettextfromdisplaybalance);

        if (gettextfromdisplaybalance.contains("Processed Ok")) {
            System.out.println("Account Statement For One Year has been displayed");
        } else {
            Assert.fail("Account Statement For One Year has not been displayed");
        }
    }

    @And("Go to Account Today Transaction Statement")
    public void acounttodaystatement() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(gototodayacctstatmnt).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Account Statement today should be shown")
    public void accountstatmentfortoday() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(display_account_num));

        driver.findElement(display_account_num).click();
        Thread.sleep(2000);

        driver.findElement(selectaccount).click();
        Thread.sleep(2000);

        WebElement openingbalance = driver.findElement(openingbal);
        WebElement closingbalance = driver.findElement(display_branch_name);

        if(openingbalance.getText().isEmpty() ||
                closingbalance.getText().isEmpty())
        {
            Assert.fail("One of Opening or closing balance is missing");
        }
        else {

            driver.findElement(nextbuttoncardlist).click();
            Thread.sleep(2000);

            String gettextfromdisplaybalance = driver.findElement(displaybalance).getText();
            System.out.println(gettextfromdisplaybalance);

            if (gettextfromdisplaybalance.contains("Processed Ok")) {
                System.out.println("Account Statement For One Year has been displayed");
            } else {
                Assert.fail("Account Statement For One Year has not been displayed");
            }

        }
    }

    @And("Go to Accounts List")
    public void accountlist() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");

        driver.findElement(gototodayacctlist).click();
        Thread.sleep(2000);
    }

    @Then("Make sure that Account list should be shown")
    public void displayaccountlist() throws InterruptedException {

       Thread.sleep(5000);

        driver.findElement(display_account_num).click();
        Thread.sleep(2000);

        driver.findElement(selectaccount).click();
        Thread.sleep(2000);

        driver.findElement(nextbuttoncardlist).click();
        Thread.sleep(2000);

        System.out.println("Waiting to display success or error message");

        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofMinutes(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(find_acct_num));

        WebElement displayaccountnum = driver.findElement(find_acct_num);
        WebElement displayaccounttype = driver.findElement(find_acct_type);
        WebElement displayIBAN = driver.findElement(IBAN);

        if(displayaccountnum.getText().isEmpty() ||
                displayaccounttype.getText().isEmpty() ||
                displayIBAN.getText().isEmpty())
        {
            Assert.fail("Either one of " + displayaccountnum + " or " + displayaccounttype + " or " + displayIBAN + " is missing");
        }
        else
        {
            System.out.println("All items " + displayaccountnum + " and " + displayaccounttype + " and " + displayIBAN + " are displayed");
        }
    }

    @Then("User enters all of the required details and successfully registers a new user")
    public void userEntersAllOfTheRequiredDetailsAndSuccessfullyRegistersANewUser() throws InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys("NewUser");
        Thread.sleep(1000);

        driver.findElement(user_ID).sendKeys("newuser");
        Thread.sleep(1000);

        driver.findElement(email_ID).sendKeys("umair.dastagir@avanzasolutions.com");
        Thread.sleep(1000);

        driver.findElement(default_locale).click();
        Thread.sleep(1000);

        driver.findElement(locale_english).click();
        Thread.sleep(1000);

        driver.findElement(group_assignment).click();
        Thread.sleep(1000);

        driver.findElement(group_assignment).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(sec_policy).click();
        Thread.sleep(1000);

        driver.findElement(sec_policy).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(user_save_btn).click();
        Thread.sleep(2000);
    }

    @Then("User add all of the required details and register a new org unit")
    public void userAddAllOfTheRequiredDetailsAndRegisterANewOrgUnit() throws InterruptedException {

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(org_type));

        driver.findElement(org_type).click();
        Thread.sleep(1000);

        driver.findElement(org_sales).click();
        Thread.sleep(1000);

        driver.findElement(prim_name).sendKeys("test");
        Thread.sleep(1000);

        WebElement field = driver.findElement(org_add_btn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", field);

        driver.findElement(org_add_btn).click();
        Thread.sleep(2000);

    }
}