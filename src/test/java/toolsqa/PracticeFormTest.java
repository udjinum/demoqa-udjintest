package toolsqa;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    private final String url = "https://demoqa.com/automation-practice-form";

    private final SelenideElement titleForm = $("h5");
    private final SelenideElement nameLabel = $("[id=userName-label]");
    private final SelenideElement firstNameInput = $("[id=firstName]");
    private final SelenideElement lastNameInput = $("[id=lastName]");
    private final SelenideElement emailLabel = $("[id=userEmail-label]");
    private final SelenideElement emailInput = $("[id=userEmail]");

    private final SelenideElement genderContainer = $("[id=genterWrapper]");
    private final SelenideElement genderLabel = genderContainer.$(".col-md-3");
    private final SelenideElement maleInput = genderContainer.$("[id=gender-radio-1]");
    private final SelenideElement maleLabel = genderContainer.$("[for=gender-radio-1]");
    private final SelenideElement femaleInput = genderContainer.$("[id=gender-radio-2]");
    private final SelenideElement femaleLabel = genderContainer.$("[for=gender-radio-2]");
    private final SelenideElement otherInput = genderContainer.$("[id=gender-radio-3]");
    private final SelenideElement otherLabel = genderContainer.$("[for=gender-radio-3]");

    private final SelenideElement mobileLabel = $("[id=userNumber-label]");
    private final SelenideElement mobileNumberInput = $("[id=userNumber]");

    private final SelenideElement dateOfBirthLabel = $("[id=dateOfBirth-label]");
    private final SelenideElement dateOfBirthInput = $("[id=dateOfBirthInput]");
    private final SelenideElement subjectsLabel = $("[id=subjects-label]");
    private final SelenideElement subjectsInput = $("[id=subjectsInput]");

    private final SelenideElement hobbiesContainer = $("[id=hobbiesWrapper]");
    private final SelenideElement hobbiesLabel = hobbiesContainer.$(".form-label");
    private final SelenideElement sportInput = hobbiesContainer.$("[id=hobbies-checkbox-1]");
    private final SelenideElement sportLabel = hobbiesContainer.$("[for=hobbies-checkbox-1]");
    private final SelenideElement readingInput = hobbiesContainer.$("[id=hobbies-checkbox-2]");
    private final SelenideElement readingLabel = hobbiesContainer.$("[for=hobbies-checkbox-2]");
    private final SelenideElement musicInput = hobbiesContainer.$("[id=hobbies-checkbox-3]");
    private final SelenideElement musicLabel = hobbiesContainer.$("[for=hobbies-checkbox-3]");

    private final SelenideElement pictureLabel = $x("//*[@id='subjects-label' and text()='Picture']");
    private final SelenideElement selectPictureLabel = $("[for=uploadPicture]");
    private final SelenideElement uploadPictureButton = $("[id=uploadPicture]");
    private final SelenideElement currentAddressLabel = $("[id=currentAddress-label]");
    private final SelenideElement currentAddressInput = $("[id=currentAddress]");

    private final SelenideElement stateAndCityContainer = $("[id=stateCity-wrapper]");
    private final SelenideElement stateAndCityLabel = stateAndCityContainer.$("[id=stateCity-label]");
    private final SelenideElement selectStateLabel = stateAndCityContainer.$("[id=state]");
    private final SelenideElement selectStateInput = stateAndCityContainer.$("[id=react-select-3-input]");
    private final SelenideElement selectCityLabel = stateAndCityContainer.$("[id=city]");
    private final SelenideElement selectCityInput = stateAndCityContainer.$("[id=react-select-4-input]");

    private final SelenideElement submitButton = $(".btn-primary");

    private final SelenideElement modalWindowContainer = $(".modal-content");
    private final SelenideElement titleModal = modalWindowContainer.$(".modal-title");
    private final SelenideElement tableContainer = modalWindowContainer.$(".table");
    private final ElementsCollection cells = tableContainer.$$x(".//td");
    private final SelenideElement closeButton = modalWindowContainer.$("[id=closeLargeModal]");


    @BeforeEach
    public void setUpBeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Checking visible elements on the page")
    public void elementsOnPageShouldBeVisibleTest() {
        open(url);
        titleForm.shouldHave(exactTextCaseSensitive("Student Registration Form"));
        nameLabel.shouldHave(exactTextCaseSensitive("Name"));
        firstNameInput.shouldBe(visible).shouldHave(placeholder("First Name"));
        lastNameInput.shouldBe(visible).shouldHave(placeholder("Last Name"));
        emailLabel.shouldHave(exactTextCaseSensitive("Email"));
        emailInput.shouldBe(visible).shouldHave(placeholder("name@example.com"));
        genderLabel.shouldHave(exactTextCaseSensitive("Gender"));
        maleInput.shouldHave(value("Male"));
        maleLabel.shouldHave(exactTextCaseSensitive("Male"));
        femaleInput.shouldHave(value("Female"));
        femaleLabel.shouldHave(exactTextCaseSensitive("Female"));
        otherInput.shouldHave(value("Other"));
        otherLabel.shouldHave(exactTextCaseSensitive("Other"));
        mobileLabel.shouldHave(exactTextCaseSensitive("Mobile(10 Digits)"));
        mobileNumberInput.shouldBe(visible).shouldHave(placeholder("Mobile Number"));
        dateOfBirthLabel.shouldHave(exactTextCaseSensitive("Date of Birth"));
        dateOfBirthInput.shouldHave(value(calendar()));
        subjectsLabel.shouldHave(exactTextCaseSensitive("Subjects"));
        subjectsInput.shouldBe(visible);
        hobbiesLabel.shouldHave(exactTextCaseSensitive("Hobbies"));
        sportInput.shouldHave(value("1"));
        sportLabel.shouldHave(exactTextCaseSensitive("Sports"));
        readingInput.shouldHave(value("2"));
        readingLabel.shouldHave(exactTextCaseSensitive("Reading"));
        musicInput.shouldHave(value("3"));
        musicLabel.shouldHave(exactTextCaseSensitive("Music"));
        pictureLabel.shouldHave(exactTextCaseSensitive("Picture"));
        selectPictureLabel.shouldHave(exactTextCaseSensitive("Select picture"));
        uploadPictureButton.shouldBe(visible);
        currentAddressLabel.shouldHave(exactTextCaseSensitive("Current Address"));
        currentAddressInput.shouldBe(visible).shouldHave(placeholder("Current Address"));
        stateAndCityLabel.shouldHave(exactTextCaseSensitive("State and City"));
        selectStateLabel.shouldHave(exactTextCaseSensitive("Select State"));
        selectStateInput.shouldBe(visible).shouldBe(enabled);
        selectCityLabel.shouldHave(exactTextCaseSensitive("Select City"));
        selectCityInput.shouldBe(visible).shouldBe(disabled);
        submitButton.shouldBe(visible).shouldHave(exactTextCaseSensitive("Submit"));
    }

    @Test
    @DisplayName("Checking submit registration form")
    public void submitRegistrationFormTest() {
        String dateOfBirth = "02 Feb 1981";
        File picture = new File("src/test/resources/ava.jpg");
        open(url);
        firstNameInput.val("Ivan");
        lastNameInput.val("Ivanov");
        emailInput.val("email@test.com");
        maleLabel.click();
        mobileNumberInput.val("9031111111");
        dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        dateOfBirthInput.sendKeys(dateOfBirth, Keys.CONTROL + "v");
        dateOfBirthInput.pressEnter();
        subjectsInput.val("Chemistry").pressEnter();
        sportLabel.click();
        musicLabel.click();
        uploadPictureButton.uploadFile(picture);
        currentAddressInput.val("Pushkin str, 56");
        selectStateInput.val("NCR").sendKeys(Keys.ARROW_DOWN);
        selectStateInput.pressEnter();
        selectCityInput.val("Noida").click();
        selectCityInput.pressEnter();
        submitButton.click();
        modalWindowContainer.shouldBe(visible);
        titleModal.shouldHave(exactTextCaseSensitive("Thanks for submitting the form"));
        checkTextsInTable("Student Name","Ivan Ivanov");
        checkTextsInTable("Student Email","email@test.com");
        checkTextsInTable("Gender","Male");
        checkTextsInTable("Mobile","9031111111");
        checkTextsInTable("Date of Birth","02 February,1981");
        checkTextsInTable("Subjects","Chemistry");
        checkTextsInTable("Hobbies","Sports, Music");
        checkTextsInTable("Picture","ava.jpg");
        checkTextsInTable("Address","Pushkin str, 56");
        checkTextsInTable("State and City","NCR Noida");
        closeButton.click();
        modalWindowContainer.shouldBe(hidden);
    }

    private static Condition placeholder(String placeholder) {
        return new Condition("placeholder") {
            @Override
            public boolean apply(Driver driver, WebElement element) {
                return element.getAttribute("placeholder").equals(placeholder);
            }
        };
    }

    private String calendar() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    private void checkTextsInTable(String label, String value) {
        cells.findBy(text(label)).parent().shouldHave(text(value));
    }
}
