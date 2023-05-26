package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    
    private WebDriver drivers;
    
    @FindBy(name = "firstName")
    private WebElement firstNameField;
    
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    
    @FindBy(name = "phone")
    private WebElement phoneField;
    
    @FindBy(id = "userName")
    private WebElement emailField;
    
    @FindBy(name = "address1")
    private WebElement addressField;
    
    @FindBy(name = "city")
    private WebElement cityField;
    
    @FindBy(name = "state")
    private WebElement stateField;
    
    @FindBy(name = "postalCode")
    private WebElement postalCodeField;
    
    @FindBy(name = "country")
    private WebElement countryField;
    
    @FindBy(id = "email")
    private WebElement usernameField;
    
    @FindBy(name = "password")
    private WebElement passwordField;
    
    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordField;
    
    @FindBy(name = "submit")
    private WebElement submitButton;
    
    public RegistrationPage(WebDriver driver) {
        this.drivers = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void fillRegistrationForm(String firstName, String lastName, String phone, String email, 
            String address, String city, String state, String postalCode, String country, 
            String username, String password, String confirmPassword) {
        
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        postalCodeField.sendKeys(postalCode);
        Select select = new Select(countryField);
        select.selectByVisibleText(country);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        submitButton.click();
    }
    
}
