package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class SubscriptionsPage extends SidebarMenuPage<SubscriptionsPage> {





    @FindBy(xpath = "//a[@href='/products']")
    private WebElement seeAllLink;
    @FindBy(xpath = "//div[@class ='item']//a")
    private WebElement seeDetailsLink;

    @FindBy(xpath = "//article[1]//button")
    private WebElement buyNowButtonOfPlatinumSubscription;
    @FindBy(xpath = "//div[@class ='modal cancel-subscription']//button[@class='btn-submit']")
    private WebElement yesButtonInPopup;

    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfPlatinumProduct;

    @FindBy(xpath = "//div[@class ='items']//div[1]//button")
    private WebElement buyNowButtonOfMonthlyPlan;

    @FindBy(xpath = "//div[@class= 'methods']//div[1]")
    private WebElement methodCard;

    @FindBy(xpath = "//button")
    private WebElement buttonProceed;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userName;
    @FindBy(xpath = "//article[1]")
    private WebElement attributePlatinumSubscription ;
    @FindBy(xpath = "//article[4]")
    private WebElement attributeVpnSubscription ;

    @FindBy(xpath = "//div[3]//iframe")
    private WebElement cardNumberFrame;
    @FindBy(xpath = "//input[@placeholder='Card Number']")
    private WebElement cardNumber;
    @FindBy(xpath = "(//div[4]//iframe)[position() =1]")
    private WebElement cardDateFrame;
    @FindBy(xpath = "//input[@placeholder='__/__']")
    private WebElement cardDate;
    @FindBy(xpath = "(//div[4]//iframe)[position() =2]")
    private WebElement cardSvvCodeFrame;
    @FindBy(xpath = "//input[@placeholder='___']")
    private WebElement cardSvvCode;
    @FindBy(xpath = "//button[@class]")
    private WebElement proceedButton;
    @FindBy(xpath = "//h1")
    private WebElement informationMessage;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration-success.svg']")
    private WebElement successfulImage;
    @FindBy(xpath = "//img[@src ='/images/cancel-subscription-illustration.svg']")
    private WebElement imageOfCancelSubscription;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration-error.svg']")
    private WebElement errorImage;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration.svg']")
    private WebElement paymentImage;
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buttonGoToCatalogue;
    @FindBy(xpath = "//button")
    private WebElement buttonUnsubscribe;
    @FindBy(xpath = "//img[@src='./images/empty-subscription-illustration.svg']")
    private WebElement mainImageSubscriptionPage;
    @FindBy(xpath = "//h3[@class='title']")
    private List<WebElement> h3TextAllSubscriptions;
    @FindBy(xpath = "//span[@class ='price']")
    private List<WebElement> priceAllSubscriptions;
    @FindBy(xpath = "//div[@class ='purchase']//span[@class='price'][1]")
    private WebElement priceEmailStandardSubscription;
    @FindBy(xpath = "//div[@class ='periods']//button[2]")
    private WebElement yearOfToggle;
    @FindBy(xpath = "//img[@src='data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNjAiIGhlaWdodD0iNjAiIHZpZXdCb3g9IjAgMCA2MCA2MCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGcgY2xpcC1wYXRoPSJ1cmwoI2NsaXAwXzI4NjVfMjMyMTQpIj4KPG1hc2sgaWQ9Im1hc2swXzI4NjVfMjMyMTQiIHN0eWxlPSJtYXNrLXR5cGU6YWxwaGEiIG1hc2tVbml0cz0idXNlclNwYWNlT25Vc2UiIHg9IjAiIHk9IjAiIHdpZHRoPSIxMzAiIGhlaWdodD0iMTMwIj4KPHJlY3Qgd2lkdGg9IjEzMCIgaGVpZ2h0PSIxMzAiIHJ4PSIyMCIgZmlsbD0iI0Q5RDlEOSIvPgo8L21hc2s+CjxnIG1hc2s9InVybCgjbWFzazBfMjg2NV8yMzIxNCkiPgo8cmVjdCB4PSI4Ni42OTE0IiB5PSI0MS4zNTk0IiB3aWR0aD0iOTAuODQwOCIgaGVpZ2h0PSI4Mi43MyIgcng9IjIzLjMwODciIHRyYW5zZm9ybT0icm90YXRlKDE0NS40MzEgODYuNjkxNCA0MS4zNTk0KSIgZmlsbD0idXJsKCNwYWludDFfbGluZWFyXzI4NjVfMjMyMTQpIi8+CjxnIG9wYWNpdHk9IjAuNSI+CjxwYXRoIGQ9Ik0yMC43NzYgNDkuODA4NEwyMS4yMjIxIDQ3LjYxMkwyMS4yMjU5IDQ3LjU5MzRMMjEuMjI0OSA0Ny41NzQ1QzIxLjExMTIgNDUuMzE5NCAyMC43NDU0IDQzLjEyOTYgMTkuODQ3MSA0MS4xNjIzQzIwLjE3OTEgNDAuNjI5OCAyMC40MDMzIDM5LjkzNDMgMjAuNTY4OCAzOS4xNTk1QzIwLjc0MjEgMzguMzQ4IDIwLjg1MzYgMzcuNDM2MiAyMC45NTI2IDM2LjUxMTFMMjAuOTU4MiAzNi40NTlMMjAuOTMwMSAzNi40MTQ3TDE4LjA2MzYgMzEuODk4TDE4LjAwNzYgMzEuODA5OUwxNy45NDMgMzEuODIzN0MxNy45MzQxIDMxLjgxODIgMTcuOTIyNSAzMS44MTA0IDE3LjkwODIgMzEuOEMxNy44NjA4IDMxLjc2NTMgMTcuNzk4OCAzMS43MTIyIDE3LjcyOTcgMzEuNjQ3MUMxNy41OTE4IDMxLjUxNjkgMTcuNDM4NSAzMS4zNTA5IDE3LjMzNjQgMzEuMjE3MUwxNy4yODY0IDMxLjE1MTdMMTcuMjA0NCAzMS4xNTg3QzE3LjEwNDkgMzEuMTY3MiAxNy4wMDMyIDMxLjE3NTEgMTYuODk3OSAzMS4xODE3TDE2Ljg5NzEgMzEuMTgxOEMxNS43NjMgMzEuMjU5OSAxNC45MjM3IDMxLjA0MjMgMTQuMzA4MSAzMC42MzQ0QzEzLjY5MjQgMzAuMjI2NSAxMy4yODQ3IDI5LjYxNzkgMTMuMDMyOSAyOC44ODQ2QzEyLjUyNzIgMjcuNDExOSAxMi42NjEgMjUuNDY2MSAxMi45ODU1IDIzLjc2MUMxMy4xNTE4IDIzLjE0OTYgMTMuMDQxMyAyMi43MjU1IDEyLjcyMjUgMjIuNDY5N0MxMi40MjI1IDIyLjIyODkgMTEuOTc3NSAyMi4xNzM0IDExLjU2MjMgMjIuMTg0MkMxMS4xMzk1IDIyLjE5NTIgMTAuNzA5OCAyMi4yNzY1IDEwLjQwOTIgMjIuMzQ0M0MxMC4zMTA2IDIyLjM2NjYgMTAuMjI0NyAyMi4zODc3IDEwLjE1NzYgMjIuNDA0NUMxMC4xMTY4IDIyLjEyNTUgMTAuMjQ2NiAyMS43NiAxMC41MzE5IDIxLjM5MTdDMTAuODM5NCAyMC45OTQ5IDExLjMwMDkgMjAuNjMyNiAxMS44MTE0IDIwLjQzNDhDMTEuODY0MyAyMC40Njg2IDExLjkyNDEgMjAuNTAwNCAxMS45ODQ4IDIwLjUzMTJDMTIuMDI0MSAyMC41NTEyIDEyLjA2MzMgMjAuNTcwNSAxMi4xMDM2IDIwLjU5MDRDMTIuMTYzMiAyMC42MTk4IDEyLjIyNTIgMjAuNjUwMyAxMi4yOTM3IDIwLjY4NkMxMi41MTUzIDIwLjgwMTQgMTIuNzU3NyAyMC45NDcyIDEyLjk3MDUgMjEuMTZDMTMuMzgzNCAyMS41NzMgMTMuNzE0IDIyLjI2OCAxMy40NzIyIDIzLjU3MzhDMTMuMzQ2OCAyMy43OTM2IDEzLjI1NiAyNC4wOTM3IDEzLjE5OCAyNC40MzYxQzEzLjEzNzUgMjQuNzkzNSAxMy4xMTExIDI1LjIwNzEgMTMuMTIyNCAyNS42NDM5QzEzLjE0NTEgMjYuNTE2MyAxMy4zMTkgMjcuNDk0OSAxMy42ODY0IDI4LjMxNzNDMTQuMDUzIDI5LjEzODEgMTQuNjIzIDI5LjgyNTEgMTUuNDQ5MyAzMC4wNjgyQzE2LjI3NzMgMzAuMzExOCAxNy4zMTU3IDMwLjA5NTkgMTguNTg2NSAyOS4yMTY4TDE4LjYwNzkgMjkuMjAyTDE4LjYyMzEgMjkuMTgwOUwxOS4zNDgxIDI4LjE2OTJDMjEuNDk5NSAyNi45MzI0IDIyLjk2MiAyNi4xMjc2IDI1LjczNiAyNS4wNzQ1TDI1Ljc3MzMgMjUuMDYwM0wyNS43OTg3IDI1LjAyOTVDMjYuMjI0OCAyNC41MTA1IDI2Ljg5OTcgMjMuNjkyOSAyNy41MjI3IDIyLjk1NDRDMjguMTQ5NiAyMi4yMTE0IDI4LjcxNDIgMjEuNTYwMSAyOC45MjQ5IDIxLjM2NDFMMjguOTI1NyAyMS4zNjMzQzI5LjAyMDggMjEuMjczNyAyOS41NjAzIDIwLjg0NDMgMzAuMzI3NCAyMC4zNjU0TDMwLjM0OTEgMjAuMzUxOEwzMC4zNjUxIDIwLjMzMThDMzAuOTgxMyAxOS41NjE0IDMxLjU5OTggMTguNDY5NyAzMi4wNDk3IDE3LjQyNTFDMzIuMjc0OSAxNi45MDIyIDMyLjQ1OTIgMTYuMzg4IDMyLjU3OTkgMTUuOTI4NUMzMi42OTk5IDE1LjQ3MjIgMzIuNzYwNiAxNS4wNTc3IDMyLjcyODUgMTQuNzM5M0wzMi43MDAxIDE0LjQ1NzNMMzIuNDgyOSAxNC42MzkzTDMyLjQ3MSAxNC42NDkzQzMyLjMzNjQgMTQuNzYyMSAzMi4yMDggMTQuODY5NyAzMi4wNzc2IDE0Ljk1NjJDMzEuOTQzNiAxNS4wNDUgMzEuODE4NSAxNS4xMDM4IDMxLjY5NzYgMTUuMTIyNUMzMS40Nzk1IDE1LjE1NiAzMS4yMDU0IDE1LjA2NjQgMzAuODYyNiAxNC41NDM4TDMwLjg2MjUgMTQuNTQzN0MzMC43NDU1IDE0LjM2NTcgMzAuNzMwOCAxNC4xOTUxIDMwLjc4MjggMTQuMDM2QzMwLjgzNjcgMTMuODcwOSAzMC45NjczIDEzLjcwNTEgMzEuMTY0IDEzLjU1OTZDMzEuNTU4MSAxMy4yNjggMzIuMTc2OSAxMy4wODg2IDMyLjc4MzMgMTMuMTYwNkwzMi44NTkzIDEzLjE2OTZMMzIuOTExMiAxMy4xMTM1TDMyLjk3ODMgMTMuMDQwOUwzMy4wNTk3IDEyLjk1MjdMMzIuOTkxNiAxMi44NTM5QzMyLjgwNDMgMTIuNTgyNCAzMi44MDIxIDEyLjI1NjggMzIuOTI4OCAxMS45MDY3QzMzLjA1NjIgMTEuNTU0OSAzMy4zMDg1IDExLjE5NzIgMzMuNTk1OCAxMC44OTMxQzMzLjg4MzMgMTAuNTg4OCAzNC4xOTQ2IDEwLjM0OTkgMzQuNDI4IDEwLjIzQzM0LjQ0NTUgMTAuMjIxIDM0LjQ2MjIgMTAuMjEyOSAzNC40Nzc5IDEwLjIwNTdDMzQuMjI3NSAxMC40MjYxIDMzLjk4OTcgMTAuNjczIDMzLjg0MSAxMC45NjEyQzMzLjY0MDggMTEuMzQ5MSAzMy42MDc1IDExLjggMzMuODczMyAxMi4zMzU0TDMzLjk1MzEgMTIuNDk2MUwzNC4wOTcxIDEyLjM4OTFDMzQuNDYyNiAxMi4xMTc3IDM0Ljc5ODQgMTEuOTc2NSAzNS4xMTYgMTEuOTI4NUMzNS40MzMzIDExLjg4MDYgMzUuNzQyNiAxMS45MjQyIDM2LjA1NzUgMTIuMDM3N0wzNi4wNTc2IDEyLjAzNzdMMzYuNzQyOSAxMi4yODQzTDM2Ljc1MzIgMTIuMjg4TDM2Ljc2MzkgMTIuMjkwMUMzNy44MTg0IDEyLjUwMzkgMzguOTQwMSAxMi4yMDM5IDM5LjgyNjIgMTEuOTY2OUMzOS45MjUxIDExLjk0MDUgNDAuMDIxIDExLjkxNDggNDAuMTEzNiAxMS44OTA3QzQwLjM0NzQgMTEuODI5OSA0MC41NTkgMTEuNzc5MSA0MC43NDYxIDExLjc0ODRDNDAuOTM0NSAxMS43MTc2IDQxLjA4ODMgMTEuNzA4OCA0MS4yMDg4IDExLjcyNjJDNDEuMzI2NyAxMS43NDMzIDQxLjQwMjMgMTEuNzgzNyA0MS40NTE5IDExLjg0MzZDNDEuNTAzMiAxMS45MDU2IDQxLjU0NDEgMTIuMDA5MiA0MS41NDk1IDEyLjE4Nkw0MS41NDk1IDEyLjE4NjFMNDEuNTY0NCAxMi42NjMxQzQxLjIyODUgMTIuOTI1MiA0MC44MTU0IDEzLjE2OCA0MC4zNDQzIDEzLjM5NjdMMzkuODM5NSAxMy42NDE3TDQwLjM5OTMgMTMuNjgxMkM0MC43ODI0IDEzLjcwODMgNDEuMjE0NiAxMy42MTQ1IDQxLjU4ODkgMTMuNDgyTDQxLjU5NTQgMTMuNzAxNkw0MC43NzQ1IDE0LjQyMjVMNDAuNzYwNSAxNC40MzQ3TDQwLjc0OTkgMTQuNDVDMzkuOTg2NiAxNS41NTczIDM5LjA1NDEgMTYuNjM3MyAzNy45MzMxIDE3LjM4MjFMMzcuODUwMSAxNy40MzczTDM3Ljg2ODggMTcuNTM1MkMzNy44ODIyIDE3LjYwNTIgMzcuODg4OCAxNy43MTQ3IDM3Ljg5MSAxNy44NjM5QzM3Ljg5MjcgMTcuOTggMzcuODkxNyAxOC4xMTMyIDM3Ljg5MDcgMTguMjYxM0MzNy44OTA0IDE4LjMwMSAzNy44OTAyIDE4LjM0MTcgMzcuODg5OSAxOC4zODM1TDM3Ljg4OTEgMTguNTIwOUwzOC4wMjU5IDE4LjUzMzdDMzkuMzg1NCAxOC42NjE2IDQwLjgxMyAxOC40ODE0IDQxLjk4ODQgMTguMTIxNEw0Mi4wNjMgMTguMDk4NUw0Mi4wNTgyIDE4LjEwMzlDNDAuOTY4NCAxOS4zMjE0IDM5LjczMzUgMjAuMTU1OSAzOC4yMTM1IDIwLjUyMTRMMzguMDYyMyAyMC41NTc3TDM4LjEwNDEgMjAuNzA3NUMzOC4xMzM4IDIwLjgxMzggMzguMTY3OCAyMC45MTc2IDM4LjIwNjQgMjEuMDE4NEwzOC4yMTU3IDIxLjA0MjdMMzguMjMyNiAyMS4wNjI0QzM4LjQzOTIgMjEuMzAzMSAzOC42MDM2IDIxLjU2NjEgMzguNzE0IDIxLjg1ODFMMzguNzE3MSAyMS44NjYzTDM4LjcyMTEgMjEuODc0MUMzOC44Nzc5IDIyLjE3NjUgMzkuMDA0NSAyMi40NjE2IDM5LjEwODcgMjIuNzM1NEwzOS4xNDg0IDIyLjgzOTZMMzkuMjU5NyAyMi44MzE2QzM5LjYzOCAyMi44MDQ0IDQwLjAwNzYgMjIuNzkxNyA0MC4zOTczIDIyLjc3ODNDNDEuMTExOCAyMi43NTM4IDQxLjg5NCAyMi43MjcgNDIuOTIxOSAyMi42MDM4TDQ2Ljk3MDcgMjMuODI3N0w0Ni45NzIzIDIzLjgyODJMNDkuNTk4NiAyNC41OTA5TDQ4LjI2NTQgMjUuMjg0Mkw0Ni43MDEyIDI0LjU1MDVMNDYuNjg0NCAyNC41NDI3TDQ2LjY2NjEgMjQuNTM5MUM0Ni4zMjY2IDI0LjQ3MzIgNDUuOTk4MSAyNC40ODY3IDQ1LjY3NzggMjQuNTI2MUM0NS41MTc4IDI0LjU0NTggNDUuMzU4MSAyNC41NzIyIDQ1LjIwMDEgMjQuNTk4OUw0NS4xNTk0IDI0LjYwNTdDNDUuMDE0MyAyNC42MzAyIDQ0Ljg3MDUgMjQuNjU0NSA0NC43MjQ4IDI0LjY3NDZDNDQuMDkzNiAyNC43NjE1IDQzLjQ0MjMgMjQuNzY2OSA0Mi42ODUyIDI0LjMzODhMNDIuNjIxMyAyNC4zMDI3TDQyLjU1MzYgMjQuMzMwOUM0Mi4yMjI5IDI0LjQ2ODggNDEuODQ3NSAyNC42NjYxIDQxLjQzOTkgMjQuOTAxOUw0MS4xNDMyIDI1LjA3MzZMNDEuNDcwNiAyNS4xNzVDNDEuNjI2OSAyNS4yMjM1IDQxLjc4NzQgMjUuMjc0NyA0MS45NTQ1IDI1LjMyOEM0Mi41MDYxIDI1LjUwMzkgNDMuMTI5NSAyNS43MDI4IDQzLjkxNDQgMjUuOTAyOUw0Ni40MjE5IDI5Ljg5MTVMNDcuMzM0NSAzMS45MjA2TDQ1LjkwMzkgMzEuNTgzM0w0NS42NzEgMzAuMTc1OEw0NS42NjYxIDMwLjE0NjRMNDUuNjUwMyAzMC4xMjFDNDUuMDM5NCAyOS4xNDA5IDQ0LjQzMDUgMjguNjgzMiA0My44MzExIDI4LjM3OTNDNDMuNjA0IDI4LjI2NDIgNDMuMzc3IDI4LjE3MDcgNDMuMTU4NSAyOC4wODA3QzQzLjA5MzkgMjguMDU0MSA0My4wMyAyOC4wMjc5IDQyLjk2NzEgMjguMDAxNEM0Mi42ODgyIDI3Ljg4NDEgNDIuNDIwNyAyNy43NjA4IDQyLjE1ODggMjcuNTg1OEw0Mi4xMDUyIDI3LjU1TDQyLjA0MjQgMjcuNTY0MkM0MS40MTI4IDI3LjcwNjEgNDAuNjUyNCAyNy45MzYyIDM5LjgzODMgMjguMTgyNEMzOS40OTc2IDI4LjI4NTUgMzkuMTQ3NCAyOC4zOTE0IDM4Ljc5MzUgMjguNDk0OUwzOC43MzQ3IDI4LjUxMjFMMzguNzA0OCAyOC41NjU2QzM4LjA2OTcgMjkuNjk4NCAzNy4yNjQzIDMwLjk2NyAzNi4wNTc3IDMxLjk4NjRMMzEuNzA2NSAzNC4wNTc3TDMxLjU4MTMgMzQuMTE3M0wzMS42MzA5IDM0LjI0NjhDMzEuNjU1NyAzNC4zMTE1IDMxLjY3ODEgMzQuMzc2NiAzMS42OTc5IDM0LjQ0MjdDMzEuNzIzNiAzNC41MzA4IDMxLjc0NDcgMzQuNjE4NCAzMS43NjA5IDM0LjcwNTVMMzEuNzc1NSAzNC43ODM5TDMxLjg0ODYgMzQuODE1N0MzMi4xNDkgMzQuOTQ2MiAzMi40MzkxIDM1LjEyNDUgMzIuNTgzOSAzNS4yOTA1QzMyLjY1NzcgMzUuMzc1IDMyLjY3MDggMzUuNDI5OSAzMi42Njc4IDM1LjQ1NzJDMzIuNjY1OCAzNS40NzUgMzIuNjUxNSAzNS41MjQzIDMyLjUzMTQgMzUuNTg0MkwzMi41MzExIDM1LjU4NDNDMzIuMzU5IDM1LjY3MDYgMzIuMTM2OSAzNS42OTMzIDMxLjg4NDcgMzUuNjc3NEwzMS43NiAzNS42Njk2TDMxLjcyOTggMzUuNzkwOEMzMS43MTg3IDM1LjgzNTQgMzEuNzA2MyAzNS44ODAxIDMxLjY5MyAzNS45MjQ1TDMxLjY2NDYgMzYuMDE5MkwzMS43NDA0IDM2LjA4MjZDMzEuOTY3MyAzNi4yNzI2IDMyLjE0NDYgMzYuNDc1NiAzMi4yMDU1IDM2LjYzMDdDMzIuMjM0OSAzNi43MDU4IDMyLjIyNzUgMzYuNzQ0MyAzMi4yMTc3IDM2Ljc2MzFDMzIuMjA3NiAzNi43ODIzIDMyLjE3MzIgMzYuODIyNCAzMi4wNTU1IDM2Ljg1MTVMMzIuMDU1NCAzNi44NTE1QzMxLjg1NjMgMzYuOTAwOCAzMS42MjAzIDM2Ljg2ODMgMzEuMzYyOSAzNi43ODg1TDMxLjI2NjYgMzYuNzU4NkwzMS4yMDI2IDM2LjgzNjZDMzEuMTUyNiAzNi44OTc0IDMxLjEwMDUgMzYuOTU1OSAzMS4wNDU1IDM3LjAxMjFMMzAuOTcyOCAzNy4wODY1TDMxLjAxNjkgMzcuMTgwNkMzMS4xMzkgMzcuNDQxMyAzMS4yMDk3IDM3LjY5MDggMzEuMTk3MiAzNy44NTE0QzMxLjE5MTIgMzcuOTI4IDMxLjE2ODQgMzcuOTYwNSAzMS4xNDkyIDM3Ljk3NTFDMzEuMTI5IDM3Ljk5MDQgMzEuMDc4MyAzOC4wMTIyIDMwLjk2MDEgMzcuOTkyM0wzMC45NTk4IDM3Ljk5MjNDMzAuNzQ4OCAzNy45NTcyIDMwLjU0MDEgMzcuODI0NiAzMC4zMzI1IDM3LjYzOTFMMzAuMjYwMiAzNy41NzQ1TDMwLjE3MTYgMzcuNjEzOUMzMC4xNDkgMzcuNjI0IDMwLjEyNiAzNy42MzM3IDMwLjEwMTggMzcuNjQzOEwyOS45OTYgMzcuNjg3OEwzMC4wMTA3IDM3LjgwMTRDMzAuMDQ5NiAzOC4xMDQyIDMwLjA0MiAzOC40MDM0IDI5Ljk3NDggMzguNTgzOUMyOS45NDE2IDM4LjY3MzEgMjkuOTAzNyAzOC43MDc3IDI5Ljg3NiAzOC43MTkzQzI5Ljg1MTUgMzguNzI5NSAyOS43OTU3IDM4LjczOCAyOS42ODQ0IDM4LjY3NzdMMjkuNjg0MyAzOC42Nzc3QzI5LjQ0NTcgMzguNTQ4NCAyOS4yNjg5IDM4LjI3MjcgMjkuMTE3NCAzNy45NDQ5TDI5LjA3NzUgMzcuODU4NUwyOC45ODIzIDM3Ljg1NzhDMjguOTE2NSAzNy44NTc0IDI4Ljg1MiAzNy44NTQ5IDI4Ljc4OCAzNy44NDk4TDI4LjY3OTkgMzcuODQxM0wyOC42Mzc5IDM3Ljk0MTNDMjguMTczNiAzOS4wNDY5IDI3LjU1NzMgNDAuMDg3IDI2Ljg1MDEgNDAuODg4NEwyNi42ODA5IDQxLjA4MDFMMjYuOTMwOCA0MS4xMzQyTDMwLjQ5ODMgNDEuOTA2NkwzMS41OTk5IDQyLjk0NTlMMzAuMDMxNiA0My42ODY3TDI5LjQwNzIgNDIuNDA5NkwyOS4zNjQzIDQyLjMyMkwyOS4yNjY5IDQyLjMyNTZDMjguNjM2NiA0Mi4zNDg5IDI3LjY5MjYgNDIuMzgzMiAyNi44OTg3IDQyLjM5ODhDMjYuNTAxNSA0Mi40MDY3IDI2LjE0MzcgNDIuNDA5OCAyNS44ODIxIDQyLjQwNDVDMjUuNzUwOCA0Mi40MDE5IDI1LjY0NjkgNDIuMzk3MiAyNS41NzUzIDQyLjM5MDRDMjUuNTYyNCA0Mi4zODkyIDI1LjU1MTEgNDIuMzg3OSAyNS41NDEzIDQyLjM4NjdDMjUuNTI3MyA0Mi4zNTA4IDI1LjUwODQgNDIuMzAwOCAyNS40ODUxIDQyLjIzNzdDMjUuNDM3OCA0Mi4xMTAyIDI1LjM3MzIgNDEuOTMyIDI1LjI5NTQgNDEuNzE1NkMyNS4xMzk4IDQxLjI4MyAyNC45MzIyIDQwLjY5OTQgMjQuNzA3OSA0MC4wNjc2TDI0LjYzNjcgMzkuODY3MkwyNC40NzE4IDQwLjAwMTVDMjMuOTggNDAuNDAxOCAyMy40MjkzIDQwLjgxMzcgMjIuODE0OCA0MS4yMzQ3TDIyLjc1MTEgNDEuMjc4NEwyMi43NDk2IDQxLjM1NTVDMjIuNzI1NiA0Mi41ODQ4IDIyLjU2MDcgNDMuNjkyNiAyMi4zODEgNDQuNzA2MUMyMi4zMzc2IDQ0Ljk1MDcgMjIuMjkzMiA0NS4xOTA1IDIyLjI0OTcgNDUuNDI1NUMyMi4xMTM3IDQ2LjE2IDIxLjk4NjQgNDYuODQ3OSAyMS45MjU2IDQ3LjQ5MDFMMjEuOTIxNCA0Ny41MzRMMjEuOTQxNiA0Ny41NzMxQzIyLjEwODYgNDcuODk2NyAyMi4xOTExIDQ4LjIzMTIgMjIuMjQ1NiA0OC41NzY0QzIyLjI3MjIgNDguNzQ1MSAyMi4yOTE5IDQ4LjkxNDUgMjIuMzExOSA0OS4wODY5TDIyLjMxMzQgNDkuMUMyMi4zMjg0IDQ5LjIyODggMjIuMzQzNiA0OS4zNTkyIDIyLjM2MjEgNDkuNDg5N0wyMC43NzYgNDkuODA4NFpNNDIuMTQ3IDE4LjAwNDdMNDIuMTQ0NyAxOC4wMDcyTDQyLjA2OSAxNy44OTQzQzQyLjA2MDggMTcuODgyMSA0Mi4wNTUgMTcuODczNCA0Mi4wNDk4IDE3Ljg2NDhMNDIuMDQ5OSAxNy44NjQ3TDQyLjA0NzYgMTcuODYxMkM0MS45MDA0IDE3LjYzMDcgNDEuOTA0MSAxNy4yNDY1IDQyLjAzOTMgMTYuODE0QzQyLjE3MTggMTYuMzkgNDIuNDE3NyAxNS45NjQgNDIuNjg4NCAxNS42ODExTDQyLjY4ODYgMTUuNjgwOUM0Mi43NDgzIDE1LjYxODMgNDIuODQ5MyAxNS41NjgyIDQyLjk3MDEgMTUuNTI1MkM0My4wMjQ3IDE1LjUwNTkgNDMuMDc4NCAxNS40ODk1IDQzLjEyOTcgMTUuNDc0TDQzLjE0MDYgMTUuNDcwN0M0My4xNTkgMTUuNDY1MSA0My4xNzggMTUuNDU5MyA0My4xOTY4IDE1LjQ1MzNMNDQuODczOSAxNi45MjM0QzQ0Ljg1ODUgMTcuMDEwNCA0NC44NDQ1IDE3LjA4MzIgNDQuODI0OSAxNy4xNDgzQzQ0LjgwMDQgMTcuMjMwMSA0NC43NyAxNy4yODg0IDQ0LjcyNjcgMTcuMzMzOUw0NC43MjY1IDE3LjMzNEM0NC4zNTY1IDE3LjcyMjcgNDMuODc2NiAxOC4wMTUxIDQzLjQxNDkgMTguMTU0N0M0Mi45NDg1IDE4LjI5NTcgNDIuNTMwNSAxOC4yNzMzIDQyLjI1NiAxOC4wODFMNDIuMTQ3IDE4LjAwNDdaTTQwLjMyOTggMTkuMTc0Mkw0MC4yMjQxIDE4LjkwMzZDMzkuMjkxOCAxOS4wMTYzIDM4LjYwOCAxOC45ODU1IDM4LjA3NDUgMTguODcxOEwzNy44ODg4IDE4LjgzMjJMMzcuODkzMiAxOS4wMjJDMzcuOTAyMSAxOS40MDQyIDM3LjkyODEgMTkuODE4OSAzNy45OTY0IDIwLjIyMDhMMzguMDI3MyAyMC40MDE5TDM4LjE5ODYgMjAuMzM1NEMzOC44NzMxIDIwLjA3MzcgMzkuNTY4IDE5LjcyMzIgNDAuMzI5OCAxOS4xNzQyWiIgc3Ryb2tlPSJibGFjayIgc3Ryb2tlLXdpZHRoPSIwLjMiLz4KPC9nPgo8L2c+CjwvZz4KPGRlZnM+CjxsaW5lYXJHcmFkaWVudCBpZD0icGFpbnQxX2xpbmVhcl8yODY1XzIzMjE0IiB4MT0iMTMwLjc0OSIgeTE9IjQxLjM1OTQiIHgyPSIxMzAuNzQ5IiB5Mj0iMTI0LjA4OSIgZ3JhZGllbnRVbml0cz0idXNlclNwYWNlT25Vc2UiPgo8c3RvcCBvZmZzZXQ9IjAuMDcyOTE2NyIgc3RvcC1jb2xvcj0iI0ZCRkJGRCIvPgo8c3RvcCBvZmZzZXQ9IjAuMjQ0NzkyIiBzdG9wLWNvbG9yPSIjQzhENERBIi8+CjxzdG9wIG9mZnNldD0iMC40MzQ5NTciIHN0b3AtY29sb3I9IndoaXRlIi8+CjxzdG9wIG9mZnNldD0iMC41MzI2MjMiIHN0b3AtY29sb3I9IiNBRUMwQ0UiLz4KPHN0b3Agb2Zmc2V0PSIwLjY1ODY5MiIgc3RvcC1jb2xvcj0iI0UzRTlFRSIvPgo8c3RvcCBvZmZzZXQ9IjAuNzA4ODYzIiBzdG9wLWNvbG9yPSIjRkFGQkZDIi8+CjxzdG9wIG9mZnNldD0iMC44NjE0MTMiIHN0b3AtY29sb3I9IiNENkRGRTYiLz4KPHN0b3Agb2Zmc2V0PSIwLjkyMTg3NSIgc3RvcC1jb2xvcj0iI0I4QzlEMyIvPgo8L2xpbmVhckdyYWRpZW50Pgo8Y2xpcFBhdGggaWQ9ImNsaXAwXzI4NjVfMjMyMTQiPgo8cmVjdCB3aWR0aD0iNjAiIGhlaWdodD0iNjAiIHJ4PSIyMCIgZmlsbD0id2hpdGUiLz4KPC9jbGlwUGF0aD4KPC9kZWZzPgo8L3N2Zz4K']")
    private WebElement logoOfPlatinumSubscription;
    @FindBy(xpath = "//img[@src='data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNjAiIGhlaWdodD0iNDgiIHZpZXdCb3g9IjAgMCA2MCA0OCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0zNC43OTk2IDQ4TDI1LjQxMTIgNDIuNjI5MUwxOC40OTM1IDQ3LjAyMzVMMTIuNTY0IDQ0LjU4MjFMNS42NDYyMSA0NS41NTg3TDAgNDIuNDc5M0wxMC45MzY2IDI0LjU4OTJMMTYuMTg3NSAzMS4yNjIyTDI4LjE5MTUgMEwzOS42MzU0IDIyLjg3N0w0NS45NDA1IDEyLjg3MDdMNjAgNDIuNDcyOEw1Mi4wOTQgNDUuNTU4N0w0NC42ODIxIDQ0LjA5MzlMMzQuNzk5NiA0OFoiIGZpbGw9IiMwMDREOTkiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0yOC4yNzgxIDI3LjQzMzNMMjcuMTg0NSAyMS4wNDY4TDIyLjEzNzggMjMuNDI5NUwyOC40OTU1IDYuMzI3MTVMMzcuNDYyMyAyNS44OTY5TDMyLjcxMjEgMjMuODU5MkwzMC40MzI1IDIwLjc2NjhMMjguMjc4MSAyNy40MzMzWk00Ni4xMzI1IDI4LjE0OTRMNDQuNjUwMSAyNS43MDgxTDQxLjg1MDEgMjcuMjgzNUw0MS4xOTEzIDI1Ljk4MTVMNDUuNjM4NCAxOC4zNjQ1TDQ5LjI3NTIgMjYuNjY1MUw0Ny45NTc1IDI1LjY4ODVMNDYuMTMyNSAyOC4xNDk0Wk02LjUyMzQ0IDM2LjIwOUwxMS4xMzUzIDI4LjMzODJMMTUuNjU0OSAzNC44MTU5TDE0LjI1MTYgMzQuMDQ3N0wxMS4zNzI1IDM1LjE0MTRMOS4yNzczNiAzMy42NzAxTDYuNTIzNDQgMzYuMjA5WiIgZmlsbD0id2hpdGUiLz4KPC9zdmc+Cg==']")
    private WebElement logoOfVpnSubscription;
    @FindBy(xpath = "//div[@class = 'modal cancel-subscription']//p")
    private List<WebElement> descriptionTextOfCancelSubscriptionPopup;

    public SubscriptionsPage(WebDriver driver) {

        super(driver);
    }

    public SubscriptionsPage createGeneric() {

        return new SubscriptionsPage(getDriver());
    }

    @Step("Click the 'See All' link.")
    public ProductsPage clickSeeAllLink() {
        wait10ElementToBeVisible(seeAllLink);
        click(seeAllLink);
        return new ProductsPage (getDriver());
    }
    @Step("Click the 'See details' link.")
    public void clickSeeDetailsLink() {
        click(seeDetailsLink);
    }
    @Step("Click 'Go to catalogue' button")
    public ProductsPage clickButtonGoToCatalogue() {

        click(buttonGoToCatalogue);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'Unsubscribe' button")
    public SubscriptionsPage clickUnsubscribeButton() {
        click(buttonUnsubscribe);
        return new SubscriptionsPage  (getDriver());
    }
    @Step("Click 'Yes' button in the popup ")
    public SubscriptionsPage clickYesButtonInCancelPopup() {
        click(yesButtonInPopup);
        return this;
    }
    @Step("Wait to be visible success image")
    public SubscriptionsPage waitSuccessImage() {
        wait20ElementToBeVisible(successfulImage);
        wait10ElementToBeVisible(informationMessage);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Wait to be visible image in cancel subscription popup")
    public void waitVisibleImageInCancelSubscriptionPopup() {
        wait10ElementToBeVisible(imageOfCancelSubscription);
        new SubscriptionsPage(getDriver());
    }
    @Step("Wait until Unsubscribe button to be not clickable")
    public void waitUnsubscribeButtonTobeNotClickable() {
        wait10ElementToBeNotClickable(buttonUnsubscribe);
        new SubscriptionsPage(getDriver());
    }
    @Step("Wait to be visible error image")
    public SubscriptionsPage waitErrorImage() {
        wait20ElementToBeVisible(errorImage);
        wait10ElementToBeVisible(informationMessage);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Wait util to be visible main image on the /subscription page")
    public SubscriptionsPage waitToBeVisibleMainImage_SubscriptionPage() {

        wait10ElementToBeVisible(mainImageSubscriptionPage);
        return new SubscriptionsPage (getDriver());
    }
    public boolean mainImageIsDysplaed_SubscriptionPage() {
        return isElementDisplayed(mainImageSubscriptionPage);
    }


    @Step("Retrieve the description text of the cancel-subscription popup.")
    public List<String> getDescriptionTextOfCancelSubscriptionPopup() {

        return getTexts(descriptionTextOfCancelSubscriptionPopup);
    }
    @Step("Get text information message")
    public String getTextInformationMessage() {
        return getText(informationMessage);
    }
    @Step("Wait util to be visible logo of platinum subscription on the /subscription page")
    public SubscriptionsPage waitToBeVisibleLogoOfPlatinumSubscription() {

        wait10ElementToBeVisible(logoOfPlatinumSubscription);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Wait util to be visible logo of Vpn subscription on the /subscription page")
    public SubscriptionsPage waitToBeVisibleLogoOfVpnSubscription() {

        wait10ElementToBeVisible(logoOfVpnSubscription);
        return new SubscriptionsPage (getDriver());
    }
    public boolean logoOfPlatinumSubscriptionIsDysplaed(){
        return isElementDisplayed(logoOfPlatinumSubscription);
    }
    public boolean logoOfVpnSubscriptionIsDysplaed(){
        return isElementDisplayed(logoOfVpnSubscription);
    }
    public boolean imageOfCancelSubscriptionIsDysplaed(){
        return isElementDisplayed(imageOfCancelSubscription);
    }
    public boolean buttonUnsubscribeIsEnabled(){
        return buttonUnsubscribe.isEnabled();
    }

}
