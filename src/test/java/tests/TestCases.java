package tests;

import objects.Dress;
import objects.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.*;
import java.util.Properties;
import utils.Commons;


/**
 * The Test Class
 *
 * @author Alysson Pereira
 * @version 1.0
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases {

    protected BasePage basePage = new BasePage();
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected MyAccountPage myAccountPage;
    protected ProductPage productPage;
    protected CartSummaryPage cartSummaryPage;

    protected Properties properties = new Properties();

    public String url = "";

    public User userReal = new User();
    public User userFake = new User();
    public User userRealNewAccount = new User();

    public Dress dress1 = new Dress();
    public Dress dress2 = new Dress();

    @Before
    public void parametrizeUrl(){
        properties = Commons.loadProperties(properties);
        this.url = properties.getProperty("urlAccess");
    }

    @Before
    public void parametrizeData(){
        fakeParameters();
        realParameters();
        realNewAccountParameters();
    }

    @BeforeClass
    public static void start(){

        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        }
        else {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        }

    }

    @Test
    public void t1_createFakeAccount(){

        accessLoginPage();
        String validator = createAccount(userFake);
        Assert.assertNotEquals("ORDER HISTORY AND DETAILS\n" +
                "MY CREDIT SLIPS\n" +
                "MY ADDRESSES\n" +
                "MY PERSONAL INFORMATION\n" +
                "MY WISHLISTS", validator);
        closeNavigator();
    }

    @Test
    public void t2_createRealAccount(){

        accessLoginPage();
        String validator = createAccount(userRealNewAccount);
        Assert.assertEquals("ORDER HISTORY AND DETAILS\n" +
                "MY CREDIT SLIPS\n" +
                "MY ADDRESSES\n" +
                "MY PERSONAL INFORMATION\n" +
                "MY WISHLISTS", validator);
        closeNavigator();
    }

    @Test
    public void t3_realLogin(){

        accessLoginPage();
        String validator = executeLogin(userReal);
        Assert.assertEquals("ORDER HISTORY AND DETAILS\n" +
                "MY CREDIT SLIPS\n" +
                "MY ADDRESSES\n" +
                "MY PERSONAL INFORMATION\n" +
                "MY WISHLISTS", validator);
        closeNavigator();

    }

    @Test
    public void t4_fakeLogin(){

        accessLoginPage();
        String validator = executeLogin(userFake);
        Assert.assertNotEquals("ORDER HISTORY AND DETAILS\n" +
                "MY CREDIT SLIPS\n" +
                "MY ADDRESSES\n" +
                "MY PERSONAL INFORMATION\n" +
                "MY WISHLISTS", validator);
        closeNavigator();

    }

    @Test
    public void t5_buyValidatePrice(){

        accessLoginPage();
        boolean validator = addCartValidatePrice(userReal);

        Assert.assertTrue(validator);
        closeNavigator();
    }

    @Test
    public void t6_purchase(){

        accessLoginPage();
        String validator = addCartPurchase(userReal);

        Assert.assertEquals("Your order on My Store is complete.", validator);
        closeNavigator();
    }

    public void realParameters() {

        /**
         * Método responsável por carregar os dados relacionados ao Login Real
         * @param properties - Propriedades carregadas do arquivo properties
         * @param userReal - Usuário do qual os dados serão utilizados para cadastro
         * @param url - URL de acesso
         */

        properties = Commons.loadProperties(properties);
        userReal.setUser(
                properties.getProperty("login.emailAddress"),
                properties.getProperty("login.password"),
                properties.getProperty("account.firstName"),
                properties.getProperty("account.lastName"),
                Integer.parseInt(properties.getProperty("account.dayBirth")),
                Integer.parseInt(properties.getProperty("account.monthBirth")),
                Integer.parseInt(properties.getProperty("account.yearBirth")),
                properties.getProperty("account.company"),
                properties.getProperty("account.address1"),
                properties.getProperty("account.address2"),
                properties.getProperty("account.city"),
                properties.getProperty("account.state"),
                properties.getProperty("account.zipCode"),
                properties.getProperty("account.country"),
                properties.getProperty("account.homePhone"),
                properties.getProperty("account.mobilePhone"),
                properties.getProperty("account.addressAlias"));

        dress1.setDress(
                properties.getProperty("dress.color1"),
                properties.getProperty("dress.size1"));

        dress2.setDress(
                properties.getProperty("dress.color2"),
                properties.getProperty("dress.size2"));
    }

    public void fakeParameters() {

        /**
         * Método responsável por carregar os dados relacionados ao Login Fake
         * @param properties - Propriedades carregadas do arquivo properties
         * @param url - URL de acesso
         * @param user - Usuário para Login
         */

        properties = Commons.loadProperties(properties);
        userFake.setUser(
                properties.getProperty("login.emailAddressFake"),
                RandomStringUtils.randomAlphanumeric(4),
                properties.getProperty("account.firstNameFake"),
                properties.getProperty("account.lastNameFake"),
                Integer.parseInt(properties.getProperty("account.dayBirthFake")),
                Integer.parseInt(properties.getProperty("account.monthBirthFake")),
                Integer.parseInt(properties.getProperty("account.yearBirthFake")),
                properties.getProperty("account.companyFake"),
                properties.getProperty("account.address1Fake"),
                properties.getProperty("account.address2Fake"),
                properties.getProperty("account.cityFake"),
                properties.getProperty("account.stateFake"),
                properties.getProperty("account.zipCodeFake"),
                properties.getProperty("account.countryFake"),
                properties.getProperty("account.homePhoneFake"),
                properties.getProperty("account.mobilePhoneFake"),
                properties.getProperty("account.addressAliasFake"));

    }

    public void realNewAccountParameters() {

        /**
         * Método responsável por carregar os dados relacionados ao Login Real
         * @param properties - Propriedades carregadas do arquivo properties
         * @param userReal - Usuário do qual os dados serão utilizados para cadastro
         * @param url - URL de acesso
         */

        properties = Commons.loadProperties(properties);
        userRealNewAccount.setUser(
                RandomStringUtils.randomAlphanumeric(5) + properties.getProperty("login.emailDomain"),
                RandomStringUtils.randomAlphanumeric(8),
                properties.getProperty("account.firstName"),
                properties.getProperty("account.lastName"),
                Integer.parseInt(properties.getProperty("account.dayBirth")),
                Integer.parseInt(properties.getProperty("account.monthBirth")),
                Integer.parseInt(properties.getProperty("account.yearBirth")),
                properties.getProperty("account.company"),
                properties.getProperty("account.address1"),
                properties.getProperty("account.address2"),
                properties.getProperty("account.city"),
                properties.getProperty("account.state"),
                properties.getProperty("account.zipCode"),
                properties.getProperty("account.country"),
                properties.getProperty("account.homePhone"),
                properties.getProperty("account.mobilePhone"),
                properties.getProperty("account.addressAlias"));

    }

    private void accessLoginPage(){
        this.basePage.navigatePage(url);
    }

    private String createAccount(User user){
        this.loginPage = new LoginPage(this.basePage.getDriver());
        this.accountPage = loginPage.creatingAccount(user.getEmail());
        return accountPage.createDetailedAccount(user);
    }

    private String executeLogin (User user){
        this.loginPage = new LoginPage(this.basePage.getDriver());
        return loginPage.executeLogin(user.getEmail(), user.getPassword());
    }

    private boolean addCartValidatePrice(User user){

        boolean validator;

        this.loginPage = new LoginPage(this.basePage.getDriver());
        this.myAccountPage = loginPage.login(user.getEmail(), user.getPassword());
        this.productPage = myAccountPage.goShopping();
        this.cartSummaryPage = productPage.selectDresses(dress1, dress2);
        validator = cartSummaryPage.verifyPrice();

        return validator;
    }

    private String addCartPurchase(User user){

        this.loginPage = new LoginPage(this.basePage.getDriver());
        this.myAccountPage = loginPage.login(user.getEmail(), user.getPassword());
        this.productPage = myAccountPage.goShopping();
        this.cartSummaryPage = productPage.selectDresses(dress1, dress2);
        cartSummaryPage.calculatePrice();
        cartSummaryPage.purchase();
        return cartSummaryPage.payment();

    }

    private void closeNavigator() {
        this.basePage.closeNavigate();
    }


}
