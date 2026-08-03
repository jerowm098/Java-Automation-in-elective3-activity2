package pageObjects;

public interface ProductsPageObjects {

    String PRODUCTS_BUTTON = "//a[@href='/products']";
    String ALL_PRODUCTS_HEADER = "//h2[contains(@class,'title') and contains(text(),'All Products')]";
    String PRODUCTS_LIST = "//div[@class='features_items']";
    String VIEW_FIRST_PRODUCT_BUTTON = "(//a[contains(text(),'View Product')])[1]";

    // Product Details Locators
    String PRODUCT_NAME = "//div[@class='product-information']/h2";
    String PRODUCT_CATEGORY = "//div[@class='product-information']/p[contains(text(),'Category')]";
    String PRODUCT_PRICE = "//div[@class='product-information']/span/span";
    String PRODUCT_AVAILABILITY = "//div[@class='product-information']/p[b[contains(text(),'Availability')]]";
    String PRODUCT_CONDITION = "//div[@class='product-information']/p[b[contains(text(),'Condition')]]";
    String PRODUCT_BRAND = "//div[@class='product-information']/p[b[contains(text(),'Brand')]]";

    String SEARCH_INPUT = "search_product";
    String SEARCH_BUTTON = "submit_search";
    String SEARCHED_PRODUCTS_HEADER = "//h2[contains(@class,'title') and contains(text(),'Searched Products')]";
    String SEARCHED_PRODUCTS_LIST = "//div[@class='features_items']//div[contains(@class,'col-sm-4')]";

    // TC12 Locators
    String FIRST_PRODUCT = "(//div[@class='single-products'])[1]";
    String FIRST_ADD_TO_CART_BTN = "(//a[contains(@class,'add-to-cart')])[1]";
    String CONTINUE_SHOPPING_BTN = "//button[contains(text(),'Continue Shopping')]";
    
    String SECOND_PRODUCT = "(//div[@class='single-products'])[2]";
    String SECOND_ADD_TO_CART_BTN = "(//a[contains(@class,'add-to-cart')])[3]";
    String VIEW_CART_MODAL_BTN = "//u[contains(text(),'View Cart')]";

    // Cart Page Elements Verification
    String CART_ROWS = "//tbody/tr";
    String CART_PRODUCT_PRICES = "//td[@class='cart_price']/p";
    String CART_PRODUCT_QUANTITIES = "//td[@class='cart_quantity']/button";
    String CART_PRODUCT_TOTALS = "//td[@class='cart_total']/p";

    // TC13 Locators
    String QUANTITY_INPUT = "quantity";
    String ADD_TO_CART_DETAIL_BTN = "//button[contains(@class,'cart')]";
    String CART_QUANTITY_VALUE = "//td[@class='cart_quantity']/button";

    // TC14 Locators
    String PROCEED_TO_CHECKOUT_BTN = "a.btn.btn-default.check_out";
    String REGISTER_LOGIN_MODAL_LINK = "//u[contains(text(),'Register / Login')]";
    String COMMENT_TEXT_AREA = "message";
    String PLACE_ORDER_BTN = "a[href='/payment']";
    
    // Payment Locators
    String NAME_ON_CARD_INPUT = "name_on_card";
    String CARD_NUMBER_INPUT = "card_number";
    String CVC_INPUT = "cvc";
    String EXPIRY_MONTH_INPUT = "expiry_month";
    String EXPIRY_YEAR_INPUT = "expiry_year";
    String PAY_AND_CONFIRM_BTN = "submit";
    String ORDER_PLACED_SUCCESS_MSG = "//*[contains(text(),'Order Placed!') or contains(text(),'Your order has been placed successfully!')]";

    String CART_DELETE_PRODUCT_BTN = "//a[@class='cart_quantity_delete']";
    String EMPTY_CART_MESSAGE = "//span[@id='empty_cart']";

    // Category Locators (Test Case 18)
    String CATEGORY_SIDEBAR = "//div[@class='left-sidebar']//h2[text()='Category']";
    String WOMEN_CATEGORY = "//a[@href='#Women']";
    String WOMEN_DRESS_LINK = "//div[@id='Women']//a[contains(@href, '/category_products/1')]"; // O Dress sub-category link
    String CATEGORY_TITLE_HEADER = "//h2[@class='title text-center']";
    String MEN_CATEGORY = "//a[@href='#Men']";
    String MEN_TSHIRTS_LINK = "//div[@id='Men']//a[contains(@href, '/category_products/3')]"; // Sub-category link under Men

    // Brand Locators (Test Case 19)
    String BRANDS_SIDEBAR = "//div[@class='brands_products']";
    String FIRST_BRAND_LINK = "//div[@class='brands-name']//ul/li[1]/a";
    String SECOND_BRAND_LINK = "//div[@class='brands-name']//ul/li[2]/a";
    String BRAND_PRODUCTS_HEADER = "//h2[@class='title text-center']";

    // Test Case 20 Locators
    String FIRST_PRODUCT_ADD_TO_CART = "(//a[contains(@class, 'add-to-cart')])[1]";
    String CONTINUE_SHOPPING_MODAL = "//button[text()='Continue Shopping']";
    String CART_BUTTON = "//a[@href='/view_cart']";
    String SIGNUP_LOGIN_NAV = "//a[@href='/login']";
    String LOGIN_EMAIL_INPUT = "//input[@data-qa='login-email']";
    String LOGIN_PASSWORD_INPUT = "//input[@data-qa='login-password']";
    String LOGIN_BUTTON = "//button[@data-qa='login-button']";
    String CART_PRODUCT_ITEM = "//tr[contains(@id, 'product-')]";

    // Test Case 21 Locators
    String FIRST_VIEW_PRODUCT_BUTTON = "(//a[contains(@href, '/product_details/')])[1]";
    String WRITE_YOUR_REVIEW_HEADER = "//a[text()='Write Your Review']";
    String REVIEW_NAME_INPUT = "//input[@id='name']";
    String REVIEW_EMAIL_INPUT = "//input[@id='email']";
    String REVIEW_TEXTAREA = "//textarea[@id='review']";
    String REVIEW_SUBMIT_BUTTON = "//button[@id='button-review']";
    String REVIEW_SUCCESS_MESSAGE = "//div[@id='review-section']//div[contains(@class, 'alert-success')]";

    // Test Case 22 Locators
    String RECOMMENDED_ITEMS_HEADER = "//h2[text()='recommended items']";
    String RECOMMENDED_ADD_TO_CART = "(//div[@id='recommended-item-carousel']//a[contains(@class, 'add-to-cart')])[1]";
    String VIEW_CART_MODAL_LINK = "//u[text()='View Cart']";

    // Test Case 23 Locators
    String CHECKOUT_DELIVERY_ADDRESS = "//ul[@id='address_delivery']//li[contains(@class, 'address_address1')]";
    String CHECKOUT_BILLING_ADDRESS = "//ul[@id='address_invoice']//li[contains(@class, 'address_address1')]";
}