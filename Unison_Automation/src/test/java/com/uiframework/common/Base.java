package com.uiframework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Base {
    public static WebDriver driver;

    public final By error_msg = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[3]");
    public final By compose_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[1]/button");
    public final By sender = By.xpath("//div[@name='sender']");
    public final By subject = By.xpath("//input[@placeholder='Subject']");
    public final By template = By.xpath("//div[@class='ui selection dropdown']");
    public final By select_temp = By.xpath("//span[normalize-space()='Lead Addition Request Number']");
    public final By email_body = By.xpath("//div[@class='ql-editor ql-blank']");
    public final By sentbox_btn = By.xpath("//span[@class='mail-folder-name'][normalize-space()='Sent']");
    public final By inbox_btn = By.xpath("//span[normalize-space()='Inbox']");
    public final By send_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div[4]/div/div/button[2]");
    public final By sent_body = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div[5]/div/div[2]/p");
    public final By select1stcheckbox = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[1]/div[1]");
    public final By open_sent_Email = By.xpath("//tbody/tr[2]/td[3]");
    public final By entity_dropdown = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div/form/div/div[1]/div");
    public final By radio1 = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[1]/td[3]/span/div");
    public final By radio2 = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[2]/td[3]/span/div");
    public final By radio3 = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[3]/td[3]/span/div");
    public final By radio4 = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[4]/td[3]/span/div");
    public final By btn_validate = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/button");
    public final By ui_segment = By.xpath("//body/div[@id='root']/div/div/div[@class='body']/div[@id='MV_DETAIL']/div[@class='ui stackable vertically divided grid']/div[@class='row']/div[2]/div[1]/div[1]/div[2]/div[1]");
    public final By first_SR = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div/div[1]/div/span[2]/div/div/a");
    public final By first_SR_val = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]/span/a");
    public final By first_case = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div/div[1]/div/span[2]/div/div/a");
    public final By req_btn = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/div/div[2]/div/div/a");
    public final By req_lead_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/a[1]");
    public final By lead_search_btn = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div[1]/div/div[1]/div/div[2]/button[2]");
    public final By first_customer = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]");
    public final By next_btn = By.xpath("/html/body/div[2]/div/div[3]/button");
    public final By login_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/form/div/button");
    public final By branch = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[5]/div/div/div/div/i");
    public final By select_branch = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[5]/div/div/div/div/div[2]/div[1]");
    public final By product = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[7]/div/div/div/div/i");
    public final By select_product = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[7]/div/div/div/div/div[2]/div[1]");
    public final By lead_save_btn = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button[1]");
    public final By session_value = By.xpath("//*[@id=\"root\"]/div[1]/div/div[3]/div/div/div/div/div/button[1]/span");
    public final By session_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[3]/div/div/div/div/div/button[1]");
    public final By show_btn = By.xpath("/html/body/div[2]/div[2]/div/div[4]/div/button");
    public final By end_session = By.xpath("/html/body/div[3]/div/div[3]/button");
    public final By created_on = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]/span/span");
    public final By SR_val = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[8]");
    public final By nextSR_btn = By.xpath("/html/body/div[2]/div/div[3]/button");
    public final By saveSR_btn = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button[1]");
    public final By toggle1 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li");
    public final By toggle2 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[5]/div/div");
    // public final By toggle3 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[6]");
    public final By toggle_case1 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[1]/div/div");
    public final By toggle_case2 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[8]/div/div");
    public final By toggle3 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[7]/div/div");
    public final By clickaddbuttonofcases = By.xpath("//a[@class='actionIconStyle']//img[@class='ui image']");
    public final By searching_in_case_topup_search_area = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[8]/div/div");
    public final By toggle_case3 = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[13]/div/div");
    public final By case_val = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[14]");
    public final By nextCase_btn = By.xpath("/html/body/div[2]/div/div[3]/button");
    public final By saveCase_btn = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button[1]");
    public final By btn_assigned = By.xpath("//*[@id=\"9000041134\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[4]/span[2]");
    public final By btn_inprogress = By.xpath("//*[@id=\"9000041134\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[2]/span[2]");
    public final By btn_closed = By.xpath("//*[@id=\"9000041134\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[2]/span[2]");
    public final By btn_done = By.xpath("//*[@id=\"9000041134\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[2]/span[2]");
    public final By btn_mark = By.xpath("//*[@id=\"9000041134\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[2]/div/button");
    public final By roles_drop = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[1]/div/i");
    public final By roles_select = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[1]/div/div[2]/div[1]");
    public final By units_drop = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[2]/div/i");
    public final By units_select = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[2]/div/div[2]/div[1]");
    public final By users_drop = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/i");
    public final By users_dropcase = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div[1]/div/input");

    public final By users_select = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/div[2]/div");
    public final By user_select_case = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div[1]/div/div[2]/div[4]");
    public final By notes = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[3]/div[2]/div[1]");
    public final By notes_assigned = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/div[2]/div[1]");
    public final By assigned_text = By.xpath("//*[@id=\"9000041134\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/span");
    public final By closed_text = By.xpath("//*[@id=\"9000041134\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/span");
    public final By profile_btn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]");
    public final By btn_logout = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]");
    public final By btn_doneSR = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[4]/div/button");
    public final By donebtncase = By.xpath("//button[contains(text(),'Done')]");
    public final By btn_doneIP = By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div/button");
    public final By agnt_dsktp = By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div[2]/div[2]/div/div/a[1]");
    public final By vldtn_msg = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div/div");
    public final By login_vldn_error = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div[1]/div[3]");
    public final By SR_tab = By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div[2]/div[2]/div/div/a[7]");
    public final By SR_header = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div[1]/h3/div/div");
    public final By csv_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/a[2]");
    public final By pdf_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/a[3]");
    public final By rfrsh_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/button");
    public final By stng_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[2]/div/div/div");
    public final By rqst_val_SR = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[12]/div[1]/div/span[2]/div/div/a");
    public final By rqst_no_search = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[1]/div[3]/div/span[1]");
    public final By cnic_search = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[3]/div/span[1]");
    public final By prdct_search = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[3]/div/span[1]");
    public final By rqst_search = By.id("filterText");
    public final By rqst_first = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[12]/div[1]/div/span[2]/div/div/a");
    public final By cnicSearch = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/input");
    public final By cnic_first = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[7]/div[2]");
    public final By srvc_type_dropdown = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[5]/div[1]/div/div/select");
    public final By srvc_type_first = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[7]/div[5]");
    public final By click_on_case_in_customer_hub = By.xpath("//a[@class='tabTitle']//span[contains(text(),'Cases')]");
    public final By User_click_on_Cases_Tab = By.xpath("//div[@class='wideDiv']//div[@class='ui mini secondary stackable navigation-bar menu']//a[@class='item'][contains(text(),'Cases')]");
    public final By Cases_module_text_verify = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[1]/div[1]/h3/div/div");
    public final By header_of_cases_detail = By.xpath("//div[@class='ag-header ag-pivot-off']");
    public final By cases_button_validation = By.xpath("//body/div[@id='root']/div/div/div[@class='body']/div[@class='widget']/div[@class='container fullContainer widgetOuterDiv']/div/div[@class='ui block top attached header widget-header']/div[@class='ui grid']/div[@class='stretched row']/div[@class='right aligned eight wide computer six wide mobile eight wide tablet column']/div[@class='ui segment']/div[@class='ui primary buttons']/div[@class='actionBtnMainDiv']/a[3]/img[1]");
    public final By enter_values_in_product_search = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[4]/div[1]/div/div/div/input");
    public final By find_values_products_list_of_SR = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[10]/div[4]");
    public final By click_on_case_number = By.xpath("//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-range-left']//div[@class='ag-cell-wrapper']//span[@class='ag-cell-value']//div[@class='ag-react-container']");
    public final By activities_area = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/h3[1]");
    public final By clickontopcase = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/a[1]");
    public final By selectlevel1ofagentdesktop = By.name("activity1Value");
    public final By selectlevel2ofagentdesktop = By.name("activity2Value");
    public final By clickonAddbutton = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div/form/div[1]/div[3]");
    public final By select1stelement = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div/form/div[1]/div[1]/div/div[2]/div[2]/span");
    public final By select2ndelement = By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div/form/div[1]/div[2]/div/div[2]/div[2]/span");
    public final By activitytype = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div/table/tbody/tr/td[4]");
    public final By notesofendsession = By.name("notes");
    public final By clickonstar = By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/div[2]/div/div[2]/div[2]/div/div/i[5]");
    public final By clickonresolve = By.xpath("//*[@id=\"99000041135\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[7]/span[2]");

    public String case_number;
    public String CNIC;
    public final By get_CNIC = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[6]/div[2]");

    public final By case_detail = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]");
    public final By filter_btn = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/button[1]");
    public final By add_filter = By.xpath("//button[contains(text(),'Add Filter')]");
    public final By filter_dialog = By.xpath("//body/div[2]");
    public final By field_drop = By.xpath("//body/div[2]/div[1]/form[1]/div[1]/div[1]");
    public final By field_CNIC = By.xpath("//body/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]");
    public final By operator_drop = By.xpath("//body/div[2]/div[1]/form[1]/div[2]/div[1]");
    public final By operator_contains = By.xpath("//body/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]");
    public final By val_txt = By.xpath("//body/div[2]/div[1]/form[1]/div[3]/div[1]/input[1]");
    public final By done_btn = By.xpath("//button[contains(text(),'Done')]");
    public final By save_filter_btn = By.xpath("//button[contains(text(),'Save')]");
    public final By SR_val_first = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/span[2]/div[1]/div[1]/a[1]");
    public final By SR_val_first_div = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/span[2]/div[1]/div[1]");
    public final By SR_detail_val = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
    public final By settings_btn = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]");
    public final By Users_admin = By.xpath("//a[contains(text(),'Users')]");
    public final By loginID_input = By.id("ag-input-id-34");
    public final By user_option1 = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[10]");
    public final By user_edit_btn = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/button[1]");
    public final By is_active_toggle = By.name("isActive");
    public final By saveclose_user_btn = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/button[1]");
    public final By dash_grid = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]");
    public final By SR_search = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/input");
    public final By state_element_Case_detail_screen = By.className("taskNameSpan");
    public final By clickonarrowofcasedetailscreen = By.className("logAccordionTitle");
    public final By actor_show_element = By.className("assignListHeight");
    public final By field_verification_of_case_detail_screen = By.className("form-body");
    public final By click_on_cases_in_agent_desktop = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/h3/div/a[2]/span");
    public final By add_button_of_case_in_agent_desktop = By.className("actionIconStyle");
    public final By seach_case_for_add = By.className("rstm-search");
    public final By click_on_first_searched_case = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]");
    public final By click_on_next_button_in_case = By.xpath("/html/body/div[2]/div/div[3]/button");
    public final By click_on_submit_button = By.xpath("//button[@type='submit']");
    public final By error_of_case = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]");
    public final By click_on_Dashboard = By.xpath("/html/body/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]");
    public final By getClick_on_Dashboard_list = By.xpath("/html/body/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div");
    public final By Dashboard_body = By.xpath("//div[@class='react-grid-layout layout']");
    public final By case_channel_drop = By.xpath("//body[@class='dimmable dimmed blurring scrolling']/div[@class='ui top aligned page modals dimmer transition visible active']/div[@class='ui scrolling modal transition visible active']/div[@class='scrolling content']/div/div[@class='rsw_2Y']/div[@class='rsw_2f rsw_1z rsw_1M rsw_3G']/div/div[@class='widget']/div[@class='container fullContainer']/div/div[@class='ui attached segment widget-body']/div[@class='form-body']/div[@class='accordion ui']/div[1]/div[2]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/input[1]");

    public final By case_account_drop = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/input[1]");

    public final By find_notes_case = By.id("NOTES");
    public final By case_find_Mode = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[1]");
    public final By case_email = By.id("CUST_CALLBACK_EMAIL");
    public final By case_address = By.id("ALTERNATE_ADDRESS");
    public final By Back_button_of_case = By.xpath("//a[@class='float']");
    public final By pop_up = By.xpath("/html/body/div[2]/div");
    public String SR_Val;
    public final By CSVofCase = By.xpath("//div[@class='actionBtnMainDiv']");
    public final By pdfofCase = By.xpath("//a[@content='Export to PDF']");
    public final By clickonInprocess = By.xpath("//*[@id=\"99000041135\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[9]/span[2]");
    public final By SRLoggrlog = By.xpath("//*[@id=\"DashWgtParent\"]/div[1]/div[1]/div/div");
    public final By SRclosed = By.xpath("//*[@id=\"DashWgtParent\"]/div[1]/div[1]/div/div/div[2]/div/div");
    public final By srresolvedpermonth = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/svg[1]/text[1]/tspan[1]");
    public final By globalsearcharea = By.id("global-search");
    public final By resultareaofglobalsearch = By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div");
    public String globalsearch;
    public final By casedisplayagainstglobalsearch = By.xpath("//*[@id=\"99000041135\"]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div");
    public final By SRdisplayagainstglobalsearch = By.xpath("//*[@id=\"99000041134\"]/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/div");
    public final String body = "Unison Ace Automation Test Suite";
    public final String SR = "SR2103230001";
    public final String caseNo = "C1901230001";
    public final By findTest = By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div");
    public final By findsummarybodyinagentdesktop = By.className("summary-body");
    public final By finderrormessageofinvalidcnic = By.className("top-right");
    public final By checkvaluesindropdownofagentdesktop = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/form/div/div[1]/div/div[2]");
    public final By checkcautionBoxMainDivBlue = By.className("cautionBoxMainDivBlue-ch");
    public final By clickonwalkincustomer = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/h3/div/a[2]");
    public final By verificaitonofwalkincustomer = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/h3/div");
    public final By clickonaddofwalkincustomer = By.className("actionIconStyle");
    public final By fullnamewalkin = By.xpath("//*[@id=\"FULL_NAME\"]");
    public final By mobilewalkin = By.xpath("//*[@id=\"MOBILE_PHONE\"]");
    public final By cnicwalkin = By.xpath("//*[@id=\"RELATIONSHIP_NUM\"]");
    public final By genderwalkin = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/div/div/div[6]/div/div/div/div/input");
    public final By addresswalkin = By.xpath("//*[@id=\"HOME_ADDRESS_1\"]");
    public final By martialwalkin = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/div/div/div[17]/div/div/div/div/input");
    public final By clickonsavebuttonofwalkin = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button[1]");
    public final By errorofsubmittion = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]");
    public final By Roles_option = By.linkText("Roles");
    public final By role_text = By.name("roleName");
    public final By secondaryName_text = By.name("secondaryName");
    public final By Groups_option = By.linkText("Groups");
    public final By orgunit_option = By.linkText("Organization Unit");
    public final By Users_option = By.linkText("Users");
    public final By help_desk_optn = By.linkText("Help Desk");
    public final By new_helpdesk_tckt = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/a[1]");
    public final By help_desk_search = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/input");
    public final By help_desk_option = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li[1]");
    public final By help_desk_nxtBtn = By.xpath("/html/body/div[2]/div/div[3]/button");
    public final By comp_nature_drop = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div/div/div/input");
    public final By help_desk_saveBtn = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button[1]");
    public final By customer_hub = By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]");
    public final By recent_customer = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/div/div[2]/div/h3/div/a[2]");
    public final By whilepageofrecentcustomer = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div");
    public final By transactionpad = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/h3/div/a[3]/span");
    public final By ATMcustomerdemographics = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/a[1]/div/div");
    public final By FinancialAccounts = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/h3/div/a[2]/span");
    public final By verificationofcustomeraccounts = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table");
    public final By clicknthreedots = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/i");
    public final By clicknthreedots_creditcard = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/table/tbody/tr[1]/td[8]/div/div");
    public final By gotobalanceinquiry = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/div[2]/div[2]");
    public final By gotoAccountdetails = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/div[2]/div[1]");
    public final By BInextbutton = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
    public final By displaybalance = By.className("top-right");
    public final By complaintnature = By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]");
    public final By created_on_complaint = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]");
    public final By duplicate_message = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/span");
    public final By case_to_date = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[2]/div");
    public final By case_from_date = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[6]/div[1]/div/div/div[4]/div");
    public final By case_no = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div/div[1]");
    public final By display_case = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[4]/div[1]/div/span[2]");
    public final By display_account_num = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div");
    public final By display_Account_type = By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    public final By display_branch_name = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[3]/div/div/div");
    public final By display_currency = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[4]/div/div/div");
    public final By display_email = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[5]/div/div/div");
    public final By display_frequency = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[6]/div/div/div/span");
    public final By display_EStatement_Registration_Flag = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[7]/div/div/div/span");
    public final By display_Account_status = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div/div/div");
    public final By gotochequebookdetails = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/div[2]/div[3]");
    public final By Accountinchque = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div");
    public final By nextbuttoncheque = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
    public final By nextbuttoncardlist = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
    public final By gotodebitcardlist = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/div[2]/div[4]");
    public final By gotoministatement = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/div[2]/div[5]");
    public final By gotoestatementsmsstatus = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/div/div[2]/div[6]");
    public final By gotocreditcarddetails = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/table/tbody/tr[1]/td[8]/div/div/div[2]/div[1]");
    public final By gotocreditcardlast10transactions = By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/div[2]/div[2]");
    public final By validateavailablecashlimit = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div/div/div");
    public final By validatetotalcashlimit = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[6]/div/div/div");
    public final By validateoutstandingbalance = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[7]/div/div/div");
    public final By validaterewardpoints = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[8]/div/div/div");
    public final By validaterewardpointsredeemed = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[9]/div/div/div");
    public final By validaterewardpointsavailable = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[10]/div/div/div");
    public final By validateavailablecreditlimit = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[11]/div/div/div");
    public final By validatecreditlimit = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[12]/div/div/div");
    public final By validatelastpaymentamount = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[13]/div/div/div");
    public final By validatelastpaymentdate = By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[14]/div/div/div");
    public final By clicknthreedots_debitcard = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/i[1]");
    public final By gotocrossborderenable = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/div[2]/div[1]");
    public final By gotocrossborderstatusfetch = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/div[2]/div[2]");
    public final By validatestatusofbordercross = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]");
    public final By gotodebitcarddetails = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/div[2]/div[3]");
    public final By gotodebitcardstatuschange = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/div[2]/div[4]");
    public final By cardstatuschangedropdown = By.xpath("//div[contains(text(),'Hot')]");
    public final By clickondebitcardbutton = By.xpath("//button[contains(text(),'Next')]");
    public final By gotodebitcardstatusfetch = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/div[2]/div[5]");
    public final By validatecardstatus = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
    public final By gotogdciblock = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[4]/div/div/div[2]/div[6]");
    public final By selectchanneltype = By.xpath("//body/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]");
    public final By selectivr = By.xpath("//body/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]");
    public final By gotogdunblock = By.xpath("//tbody/tr[1]/td[4]/div[1]/div[1]/div[2]/div[7]");
    public final By gotointernetsessionstatus = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[4]/div[1]/div[1]/div[2]/div[8]");
    public final By internetsessionstatus = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[4]/div/div/div[2]/div[8]");
    public final By checkstatus = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div/span");
    public final By gotovisatransaction = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[4]/div/div/div[2]/div[9]");
    public final By sessiontyperequestdd = By.xpath("//body/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    public final By sessionddvalue = By.xpath("//span[contains(text(),'Issue Resolution')]");
    public final By openingbal = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div");
    public final By transactionpage = By.xpath("//span[contains(text(),'Transaction Pad')]");
    public final By verificationofatmdemo = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/a[1]/div/div");
    public final By noofemp = By.xpath("//body/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/div[1]/div[1]/div[1]");
    public final By verificationofatmforoneyear = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/a[2]/div/div");
    public final By verificationofatmtoday = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/a[3]/div/div");
    public final By gotoacccustomdemo = By.xpath("//*[@id=\"MV_DETAIL\"]/div/div/div[4]/div/div/div[2]/div/div/div/div/div[1]/div/a[4]/div/div");

    public final By clickoncaseno = By.xpath("//*[@id=\"myGrid\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/div[4]/div[1]/div/span[2]/div");
    public final By user_click_on_case_no = By.xpath("//tbody/tr[1]/td[1]/span[1]");
    public final By userclickonintitiated = By.xpath("//*[@id=\"99000041135\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[2]/span[2]");
    public final By markascurrentstage = By.xpath("//*[@id=\"99000041135\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[2]/div");
    public final By getBtn_inprogress = By.xpath("//span[contains(text(),'In Process')]");
    public final By case_btn_closed = By.xpath("//*[@id=\"99000041135\"]/div/div/div[2]/div/div/div[1]/div/div/div/div[1]/div/div/div[5]/span[2]");
    public final By casecontainer = By.className("tabContainer");
    public final By displayhome = By.xpath("//label[contains(text(),'Home Address')]");
    public final By gotoacctstatement = By.xpath("//div[contains(text(),'Account Statement For One Year')]");
    public final By selectaccount = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div[2]/div[1]");
    public final By gototodayacctstatmnt = By.xpath("//div[contains(text(),'Account Today Transaction Statement')]");
    public final By gototodayacctlist = By.xpath("//div[contains(text(),'Accounts List')]");
    public final By IBAN = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]");
    public final By find_acct_num = By.xpath("//body/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    public final By find_acct_type = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]");

    public final By acct = By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    public final By casefromdate = By.xpath("///body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]");
    public final By casetodate = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]");
    public final By casecase = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[2]/div[1]/div[1]");
    public final By add_user_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/button");
    public final By firstName = By.name("firstName");
    public final By user_ID = By.name("userId");
    public final By email_ID = By.name("email");
    public final By sec_policy = By.name("securityPolicy");
    public final By default_locale = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/form/div[1]/div/div/div/div[9]/div/div/div");
    public final By locale_english = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/form/div[1]/div/div/div/div[9]/div/div/div/div[2]/div[2]");
    public final By group_assignment = By.xpath("//*[@id=\"react-select-2-input\"]");
    public final By user_save_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/form/div[2]/button[1]");
    public final By prim_name = By.name("orgNamePrm");
    public final By org_type = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[1]/div/div");
    public final By org_sales = By.id("0000000004");
    public final By org_add_btn = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/form/div[2]/button[1]");


    public final Properties props = new Properties();

    public void PropsFunction() throws IOException {

        FileInputStream ip = new FileInputStream("src\\test\\java\\com\\uiframework\\common\\config.properties");

        props.load(ip);
    }

    public static void EmailFunction() throws IOException {
        Properties props = new Properties();

        FileInputStream ip = new FileInputStream("src\\test\\java\\com\\uiframework\\common\\config.properties");

        props.load(ip);

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", props.getProperty("smtpPort"));

        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", props.getProperty("smtpPort"));

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(props.getProperty("email"), props.getProperty("pass"));
                    }
                });

        try {
            // Create object of MimeMessage class
            Message message = new MimeMessage(session);

            // Set the from address
            //message.setFrom(new InternetAddress("umair.dastagir@avanzasolutions.com"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("adnan.adil@avanzasolutions.com, umair.dastagir@avanzasolutions.com"));

            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            DateFormat dateFormat2 = new SimpleDateFormat("hh:mm aa");
            Date date = new Date();
            String date1 = dateFormat.format(date);
            String date2 = dateFormat2.format(date);

            // Add the subject link
            message.setSubject(props.getProperty("emailSubject"));

            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText("A latest test run was executed on " + date1 + " at " + date2 + "\n \nTest report can be viewed at: https://reports.cucumber.io/report-collections/d34867fe-6d35-4fd6-9e40-1713c321876e");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            String filename = "C:\\Users\\umair.dastagir\\IdeaProjects\\Unison_Automation\\target\\cucumber-reports\\cucumberreport.html";

            // Create data source and pass the filename
            DataSource source = new FileDataSource(filename);

            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));

            // set the file
            messageBodyPart2.setFileName("Cucumber-Report.html");

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            // multipart.addBodyPart(messageBodyPart2);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            System.out.println("Email Sent");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }
    }
}