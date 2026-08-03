package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.ProductsPageObjects;

public class ProductsPageEvents implements ProductsPageObjects {

    public void clickProductsButton() {
        BaseTest.driver.findElement(By.xpath(PRODUCTS_BUTTON)).click();
    }

    public void verifyAllProductsPage() {
        boolean isHeaderVisible = BaseTest.driver.findElement(By.xpath(ALL_PRODUCTS_HEADER)).isDisplayed();
        boolean isListVisible = BaseTest.driver.findElement(By.xpath(PRODUCTS_LIST)).isDisplayed();
        
        Assert.assertTrue(isHeaderVisible, "'ALL PRODUCTS' header is not visible.");
        Assert.assertTrue(isListVisible, "Products list is not visible.");
    }

    public void clickFirstProductViewButton() {
        BaseTest.driver.findElement(By.xpath(VIEW_FIRST_PRODUCT_BUTTON)).click();
    }

    public void verifyProductDetailsVisible() {
        boolean isNameVisible = BaseTest.driver.findElement(By.xpath(PRODUCT_NAME)).isDisplayed();
        boolean isCategoryVisible = BaseTest.driver.findElement(By.xpath(PRODUCT_CATEGORY)).isDisplayed();
        boolean isPriceVisible = BaseTest.driver.findElement(By.xpath(PRODUCT_PRICE)).isDisplayed();
        boolean isAvailabilityVisible = BaseTest.driver.findElement(By.xpath(PRODUCT_AVAILABILITY)).isDisplayed();
        boolean isConditionVisible = BaseTest.driver.findElement(By.xpath(PRODUCT_CONDITION)).isDisplayed();
        boolean isBrandVisible = BaseTest.driver.findElement(By.xpath(PRODUCT_BRAND)).isDisplayed();

        Assert.assertTrue(isNameVisible, "Product Name is not visible.");
        Assert.assertTrue(isCategoryVisible, "Product Category is not visible.");
        Assert.assertTrue(isPriceVisible, "Product Price is not visible.");
        Assert.assertTrue(isAvailabilityVisible, "Product Availability is not visible.");
        Assert.assertTrue(isConditionVisible, "Product Condition is not visible.");
        Assert.assertTrue(isBrandVisible, "Product Brand is not visible.");
    }

    public void searchProduct(String productName) {
        BaseTest.driver.findElement(By.id(SEARCH_INPUT)).sendKeys(productName);
        BaseTest.driver.findElement(By.id(SEARCH_BUTTON)).click();
    }

    public void verifySearchedProducts() {
        boolean isHeaderVisible = BaseTest.driver.findElement(By.xpath(SEARCHED_PRODUCTS_HEADER)).isDisplayed();
        int productsCount = BaseTest.driver.findElements(By.xpath(SEARCHED_PRODUCTS_LIST)).size();

        Assert.assertTrue(isHeaderVisible, "'SEARCHED PRODUCTS' header is not visible.");
        Assert.assertTrue(productsCount > 0, "No products were found for the search query.");
    }

    public void addFirstProductToCart() {
        WebElement btn1 = BaseTest.driver.findElement(By.xpath(FIRST_ADD_TO_CART_BTN));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn1);
        js.executeScript("arguments[0].click();", btn1);
    }

    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CONTINUE_SHOPPING_BTN))).click();
    }

    public void addSecondProductToCart() {
        WebElement btn2 = BaseTest.driver.findElement(By.xpath(SECOND_ADD_TO_CART_BTN));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn2);
        js.executeScript("arguments[0].click();", btn2);
    }

    public void clickModalViewCart() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIEW_CART_MODAL_BTN))).click();
    }

    public void verifyCartProductsAndDetails() {
        int rowCount = BaseTest.driver.findElements(By.xpath(CART_ROWS)).size();
        Assert.assertEquals(rowCount, 2, "Expected 2 products in cart, but found: " + rowCount);

        boolean pricesVisible = BaseTest.driver.findElements(By.xpath(CART_PRODUCT_PRICES)).size() == 2;
        boolean quantitiesVisible = BaseTest.driver.findElements(By.xpath(CART_PRODUCT_QUANTITIES)).size() == 2;
        boolean totalsVisible = BaseTest.driver.findElements(By.xpath(CART_PRODUCT_TOTALS)).size() == 2;

        Assert.assertTrue(pricesVisible, "Prices are not visible for both products.");
        Assert.assertTrue(quantitiesVisible, "Quantities are not visible for both products.");
        Assert.assertTrue(totalsVisible, "Total prices are not visible for both products.");
    }

    public void setProductQuantity(String quantity) {
        WebElement qtyInput = BaseTest.driver.findElement(By.id(QUANTITY_INPUT));
        qtyInput.clear();
        qtyInput.sendKeys(quantity);
    }

    public void clickAddToCartOnDetail() {
        BaseTest.driver.findElement(By.xpath(ADD_TO_CART_DETAIL_BTN)).click();
    }

    public void verifyExactQuantityInCart(String expectedQuantity) {
        WebElement qtyElement = BaseTest.driver.findElement(By.xpath(CART_QUANTITY_VALUE));
        String actualQuantity = qtyElement.getText();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Product quantity in cart does not match!");
    }

    public void clickProceedToCheckout() {
        WebElement btn = BaseTest.driver.findElement(By.cssSelector(PROCEED_TO_CHECKOUT_BTN));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn);
        js.executeScript("arguments[0].click();", btn);
    }

    public void clickRegisterLoginInModal() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REGISTER_LOGIN_MODAL_LINK))).click();
    }

    public void enterCommentAndPlaceOrder(String comment) {
        WebElement commentBox = BaseTest.driver.findElement(By.name(COMMENT_TEXT_AREA));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", commentBox);
        commentBox.sendKeys(comment);

        WebElement placeBtn = BaseTest.driver.findElement(By.cssSelector(PLACE_ORDER_BTN));
        js.executeScript("arguments[0].click();", placeBtn);
    }

    public void fillPaymentDetailsAndPay(String name, String cardNum, String cvc, String month, String year) {
        BaseTest.driver.findElement(By.name(NAME_ON_CARD_INPUT)).sendKeys(name);
        BaseTest.driver.findElement(By.name(CARD_NUMBER_INPUT)).sendKeys(cardNum);
        BaseTest.driver.findElement(By.name(CVC_INPUT)).sendKeys(cvc);
        BaseTest.driver.findElement(By.name(EXPIRY_MONTH_INPUT)).sendKeys(month);
        BaseTest.driver.findElement(By.name(EXPIRY_YEAR_INPUT)).sendKeys(year);

        WebElement payBtn = BaseTest.driver.findElement(By.id(PAY_AND_CONFIRM_BTN));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].click();", payBtn);
    }

    public void verifyOrderPlacedSuccess() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ORDER_PLACED_SUCCESS_MSG))).isDisplayed();
        Assert.assertTrue(isDisplayed, "Order success message was not displayed!");
    }

    public void clickRemoveProductFromCart() {
        BaseTest.driver.findElement(By.xpath(CART_DELETE_PRODUCT_BTN)).click();
    }

    public void verifyProductRemovedFromCart() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(1));
        boolean isRemoved = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CART_DELETE_PRODUCT_BTN)));
        
        Assert.assertTrue(isRemoved, "Product was not removed from cart!");
    }

    public void verifyCategoriesSidebarVisible() {
        boolean isVisible = BaseTest.driver.findElement(By.xpath(CATEGORY_SIDEBAR)).isDisplayed();
        Assert.assertTrue(isVisible, "Categories section on left sidebar is not visible.");
    }

    public void clickWomenCategory() {
        WebElement womenCat = BaseTest.driver.findElement(By.xpath(WOMEN_CATEGORY));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", womenCat);
        womenCat.click();
    }

    public void clickWomenSubCategory() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement subCat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(WOMEN_DRESS_LINK)));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", subCat);
        js.executeScript("arguments[0].click();", subCat);
    }

    public void verifyCategoryTitleText(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CATEGORY_TITLE_HEADER)));
        
        String actualTitle = header.getText().replaceAll("\\s+", " ").trim();
        String cleanedExpected = expectedTitle.replaceAll("\\s+", " ").trim();
        
        System.out.println("Cleaned Actual: [" + actualTitle + "]");
        System.out.println("Cleaned Expected: [" + cleanedExpected + "]");
        
        Assert.assertTrue(actualTitle.toLowerCase().contains(cleanedExpected.toLowerCase()), 
            "Expected header to contain: " + expectedTitle + " but found: " + actualTitle);
    }

    public void clickMenSubCategory() {
        WebElement menCat = BaseTest.driver.findElement(By.xpath(MEN_CATEGORY));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", menCat);
        js.executeScript("arguments[0].click();", menCat);

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement menSubCat = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MEN_TSHIRTS_LINK)));
        js.executeScript("arguments[0].click();", menSubCat);
    }

    public void verifyBrandsSidebarVisible() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement brandsSidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BRANDS_SIDEBAR)));
        Assert.assertTrue(brandsSidebar.isDisplayed(), "Brands sidebar is not visible.");
    }

    public void clickFirstBrand() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement brandLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_BRAND_LINK)));
        
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", brandLink);
        js.executeScript("arguments[0].click();", brandLink);
    }

    public void clickSecondBrand() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement brandLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SECOND_BRAND_LINK)));
        
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", brandLink);
        js.executeScript("arguments[0].click();", brandLink);
    }

    public void verifyBrandPageHeader() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BRAND_PRODUCTS_HEADER)));
        Assert.assertTrue(header.isDisplayed(), "Brand products page header is not displayed.");
    }

    public void addProductsToCartFromSearch() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_PRODUCT_ADD_TO_CART)));
        
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
        js.executeScript("arguments[0].click();", addBtn);
    }

    public void clickCartButton() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CART_BUTTON)));
        cartBtn.click();
    }

    public void loginToAccount(String email, String password) {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIGNUP_LOGIN_NAV))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_EMAIL_INPUT))).sendKeys(email);
        BaseTest.driver.findElement(By.xpath(LOGIN_PASSWORD_INPUT)).sendKeys(password);
        BaseTest.driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public void verifyCartProductsVisible() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_PRODUCT_ITEM)));
        Assert.assertTrue(cartItem.isDisplayed(), "Products are not visible in cart.");
    }

    public void verifyAllProductsPageTitle() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'title text-center')]")));
        Assert.assertTrue(title.isDisplayed(), "Not on All Products page.");
    }

    public void enterProductNameAndSearch(String productName) {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search_product']")));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", searchInput);
        searchInput.clear();
        searchInput.sendKeys(productName);
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit_search']")));
        js.executeScript("arguments[0].click();", searchBtn);
    }

    public void verifySearchedProductsVisible() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCHED_PRODUCTS_HEADER)));
        String headerText = header.getText().trim();
        Assert.assertTrue(headerText.equalsIgnoreCase("Searched Products"), "Searched Products header is not visible.");
    }

    public void clickFirstViewProduct() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement viewBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FIRST_VIEW_PRODUCT_BUTTON)));
        
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewBtn);
        js.executeScript("arguments[0].click();", viewBtn);
    }

    public void verifyWriteYourReviewVisible() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WRITE_YOUR_REVIEW_HEADER)));
        Assert.assertTrue(header.isDisplayed(), "'Write Your Review' header is not visible.");
    }

    public void enterReviewDetails(String name, String email, String reviewText) {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REVIEW_NAME_INPUT))).sendKeys(name);
        BaseTest.driver.findElement(By.xpath(REVIEW_EMAIL_INPUT)).sendKeys(email);
        BaseTest.driver.findElement(By.xpath(REVIEW_TEXTAREA)).sendKeys(reviewText);
    }

    public void clickReviewSubmitButton() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REVIEW_SUBMIT_BUTTON)));
        
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        js.executeScript("arguments[0].click();", submitBtn);
    }

    public void verifyReviewSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REVIEW_SUCCESS_MESSAGE)));
        Assert.assertTrue(successMsg.isDisplayed(), "Review success message is not visible.");
    }

    public void scrollToBottomAndVerifyRecommended() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        WebElement recommendedHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECOMMENDED_ITEMS_HEADER)));
        Assert.assertTrue(recommendedHeader.isDisplayed(), "'RECOMMENDED ITEMS' section is not visible.");
    }

    public void addRecommendedProductToCart() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RECOMMENDED_ADD_TO_CART)));
        
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
        js.executeScript("arguments[0].click();", addBtn);
    }

    public void clickViewCartFromModal() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        WebElement viewCartLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIEW_CART_MODAL_LINK)));
        viewCartLink.click();
    }

    public void verifyCheckoutAddressesMatch() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, java.time.Duration.ofSeconds(10));
        
        WebElement deliveryAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_DELIVERY_ADDRESS)));
        WebElement billingAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_BILLING_ADDRESS)));
        
        String deliveryText = deliveryAddress.getText().trim();
        String billingText = billingAddress.getText().trim();
        
        Assert.assertEquals(deliveryText, billingText, "Delivery address and billing address do not match!");
    }
}