package ru.mts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainWindow {

    public WebDriver webDriver;
    private Actions action;
    private WebDriverWait wait;

    public MainWindow(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.action = new Actions(webDriver);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(8));
    }

    @FindBy(css = "li.main-menu-navigation__item")
    private WebElement mainMenuNavigation;

    @FindBy(xpath = "//div[@class='menu-content__main-blocks']")
    private WebElement menuContentMainBlock;

    public void hoverOnToolbarItem() {
        action.moveToElement(mainMenuNavigation).perform();
        wait.until(ExpectedConditions.visibilityOf((menuContentMainBlock)));
    }

    public Actions hoverOnMainBlock() {
        return action.moveToElement(menuContentMainBlock);
    }

    public boolean checkMainBlockVisible() {
        return  menuContentMainBlock.isDisplayed();
    }
}
